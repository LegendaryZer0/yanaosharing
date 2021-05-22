<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Main page</title>
    <script src="https://maps.api.2gis.ru/2.0/loader.js?pkg=full&lazy=true"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css"
          integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
    <style>
        .upper {
            height: 5vh;
        }

        .upper h1 {
            font-family: Jost, sans-serif;
            font-style: normal;
            font-weight: bold;
            font-size: 36px;
            line-height: 52px;
            color: #2B67F6;
        }

        .btn-circle {
            width: 70px;
            height: 70px;
            padding: 10px 16px;
            border-radius: 35px;
            font-size: 12px;
            text-align: center;
        }

        .main {
            height: 95vh;
        }

        .main a {
            font-family: Jost, sans-serif;
            font-style: normal;
            font-weight: bold;
            font-size: 72px;
            line-height: 104px;
            text-decoration: none;
        }

        .text-active {
            color: #2B67F6;
        }

        .text-non-active {
            color: #D9D9D9;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-light upper md-3">
    <div class="container-fluid d-flex justify-content-between align-items-center">
        <h1 class="ms-3">YANAO.SHARING</h1>
        <!— Кнопка перехода в профиль —>
        <button type="button" class="me-3 btn btn-primary btn-circle"></button>
    </div>

</nav>

<!--Main-->
<main class="my-3 mt-3">
    <div style="position: relative">
        <input id="createMarker" type="button" value="Создать маркер"/>
        <input id="showMap" type="button" value="Показать карту"/>
        <div id="location" class="ml-3 mt-3" style="width: 100%; height: 80%; position: relative">
            <div id="map" style="width:64%; height:50%">
                <div id="mapBlock"></div>
                <script>
                    let showMap = document.getElementById('showMap');
                    let xCor, yCor, nameOfOrg, descrOfOrg, allMarkers;

                    showMap.onclick = function () {
                        let container = document.createElement('div'),
                            mapBlock = document.getElementById('mapBlock'),
                            createMarker = document.getElementById('createMarker'),
                            addTextToMarker = document.getElementById('createok');

                        let flag;

                        container.style.width = '400px';
                        container.style.height = '600px';
                        mapBlock.appendChild(container);
                        mapBlock.style.position = 'relative';

                        DG.then(function () {
                                let map, marker, countOfMarkers;
                                getAllMarkers();

                                map = DG.map('map', {
                                    center: [54.892, 52.317],
                                    zoom: 13
                                });

                                for (let i = 0; i < allMarkers.length; i++) {
                                    console.log(allMarkers[i].positionX + ' ' + allMarkers[i].positionY)
                                    markeri = DG.marker([allMarkers[i].positionX, allMarkers[i].positionY]).addTo(map).bindLabel('push me');
                                    markeri.bindPopup(allMarkers[i].nameOfOrganization + '\n' + allMarkers[i].description + '\n' + '<a class="btn btn-outline-info my-3 ml-3 mr-3" href="/showPointOfSale?pointOfSaleId=' + allMarkers[i].pointOfSaleId + '">Подробнее</a>');
                                }
                                createMarker.onclick = function () {

                                    document.getElementById('createMarker').hidden = true;
                                    document.getElementById('addnew').hidden = false;
                                    document.getElementById('hid').onclick = function () {
                                        document.getElementById('addnew').hidden = true;
                                        document.getElementById('createMarker').hidden = false;
                                    };

                                    addTextToMarker.onclick = function () {
                                        flag = true;
                                        map.on('click', function (e) {
                                            if (flag) {
                                                nameOfOrg = $('#nameOfOrg').val();
                                                descrOfOrg = $('#descrOfOrg').val();

                                                document.getElementById('addnew').hidden = true;
                                                document.getElementById('createMarker').hidden = false;

                                                xCor = e.latlng.lat;
                                                yCor = e.latlng.lng;
                                                marker = DG.marker([xCor, yCor]).addTo(map).bindLabel('push me');
                                                marker.bindPopup(nameOfOrg + '\n' + descrOfOrg);
                                                flag = false;
                                                doAjaxPost();
                                            }
                                        });

                                    }


                                }


                                DG.control.location({position: 'bottomright'}).addTo(map);
                                DG.control.scale().addTo(map);
                                DG.control.ruler({position: 'bottomleft'}).addTo(map);
                                DG.control.traffic().addTo(map);

                            }
                        )
                        ;


                    }

                    function doAjaxPost() {
                        $('#err').remove();
                        $.ajax({
                            type: 'POST',
                            url: "/addMarker",
                            contentType: 'application/json',

                            data: JSON.stringify({
                                'xсor': xCor,
                                'yсor': yCor,
                                'nameOfOrg': nameOfOrg,
                                'descrOfOrg': descrOfOrg

                            }),
                            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},
                            success: function (response) {
                                $('#nameOfOrg').val('');
                                $('#descrOfOrg').val('');
                            },
                            error: function (e) {

                                $('#des').append($('<h4 id="err">Что-то пошло не так</h4>'))
                                console.log(xCor + ' ' + yCor);
                            }
                        });
                    }

                    function getAllMarkers() {
                        $.ajax({
                            type: 'GET',
                            async: false,
                            url: '/getPoints',
                            success: function (response) {
                                allMarkers = response;
                            },
                            error: function (e) {
                                console.log(e);
                            }
                        });
                    }


                </script>

            </div>


            <!-- Modal window -->
            <div id="addnew" class="ml-3 mt-3 mr-3" hidden style="background-color: lightgray; position: absolute">
                <div class="form-group s ml-3 mt-3">
                    <label for="nameOfOrgHelp">Введите заголовок:</label>
                    <input style="width: 350px" type="text" class="form-control" id="nameOfOrg"
                           aria-describedby="emailHelp">
                    <small id="nameOfOrgHelp" class="form-text text-muted">от 3 до 50 символов</small>
                </div>
                <div id="des" class="form-group s ml-3 mt-3 mr-3">
                    <label for="descrOfOrgHelp">Введите описание:</label>
                    <textarea style="width: 350px" class="form-control" id="descrOfOrg" rows="3"></textarea>
                    <small id="descrOfOrgHelp" class="form-text text-muted">от 1 до 255 символов</small>
                </div>
                <input style="margin-left: 150px" type="button" class="btn btn-light" id="hid" value="Скрыть">
                <input style="margin-left: 30px" type="button" class="btn btn-primary mb-2" id="createok"
                       value="Создать">
            </div>
        </div>
    </div>

    <div class="main d-flex justify-content-start align-items-center" style="position: absolute">
        <form method="get" action="/filter" class="ms-5 shadow-lg p-3 mb-5 bg-body rounded filter">
            <div class="form-switch row mb-3 mx-3 align-items-center" style="height: 5%; padding: 0;">
                <div class="d-flex col-md-12 col-lg-6"><label class="form-check-label"
                                                              for="flexSwitchCheckDefault">Карта</label></div>
                <div class="d-flex justify-content-md-center justify-content-lg-end col-md-12 col-lg-6"><input
                            class="form-check-input" type="checkbox" checked id="flexSwitchCheckDefault"
                            style="width: 60px; height: 28px;"></div>
            </div>
            <div class="mx-3 row mb-3 justify-content-center" style="height: 20%;">
                <div class="h-25 col-12"><label class="form-check-label">Тип</label></div>
                <div class="h-75 row justify-content-between col-12">
                    <div class="col-6 d-flex justify-content-center align-items-center selector">
                        <input type="checkbox" class="btn-check" id="btncheck1" autocomplete="off">
                        <label class="btn btn-outline-primary" for="btncheck1">Спортзал</label>
                    </div>
                    <div class="col-6 d-flex justify-content-center align-items-center selector">
                        <input type="checkbox" class="btn-check" id="btncheck2" autocomplete="off">
                        <label class="btn btn-outline-primary" for="btncheck2">Самокат</label>
                    </div>
                    <div class="col-6 d-flex justify-content-center align-items-center selector">
                        <input type="checkbox" class="btn-check" id="btncheck3" autocomplete="off">
                        <label class="btn btn-outline-primary" for="btncheck3">Велосипед</label>
                    </div>
                    <div class="col-6 d-flex justify-content-center align-items-center selector">
                        <input type="button" class="btn-check" id="btncheck4" data-bs-toggle="modal"
                               data-bs-target="#exampleModal" autocomplete="off">
                        <label class="btn btn-outline-primary" for="btncheck4">...</label>
                    </div>
                </div>
            </div>
            <div class="row mb-3 mx-3 align-items-start" style="height: 10%; padding: 0;">
                <div class="col-6"><label class="form-check-label">Цена</label></div>
                <div class="col-6 selector"><label id="priceAmount"
                                                   class="form-check-label d-flex align-items-center justify-content-end"></label>
                </div>
                <div class="col-12" id="priceSlider">
                    <div id="slider-range-max"></div>
                    <input id="price" type="hidden" name="price">
                </div>
            </div>
            <div class="row mb-3 mx-3 align-items-center" style="height: 10%; padding: 0;">
                <div class="col-6"><label class="form-check-label">Дата и время</label></div>
                <div class="col-6 d-flex justify-content-start">
                    <input class="btn btn-outline-dark" type="datetime-local" name="date-time">
                </div>
            </div>
            <div class="mx-3 align-items-end row justify-content-between" style="height: 45%">
                <button type="button" class="final-button col-md-12 col-lg-5 btn btn-outline-dark" style="height: 15%;">
                    Отменить
                </button>
                <button type="submit" class="final-button col-md-12 col-lg-5 btn btn-primary" style="height: 15%;">
                    Применить
                </button>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Выбрать...</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="col-12 d-flex justify-content-center align-items-start selector">
                                <input type="checkbox" class="btn-check" id="btncheck5" autocomplete="off">
                                <label class="btn btn-outline-primary" for="btncheck5">Скутер</label>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Закрыть</button>
                            <button type="button" class="btn btn-primary">Сохранить</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Modal -->

        </form>
    </div>


</main>
</body>
</html>