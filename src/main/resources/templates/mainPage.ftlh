<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Main page</title>
    <script src="https://maps.api.2gis.ru/2.0/loader.js?pkg=full&lazy=true"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstr.." rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
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
<nav class="navbar navbar-light upper">
    <div class="container-fluid d-flex justify-content-between align-items-center">
        <h1 class="ms-3">YANAO.SHARING</h1>
        <!— Кнопка перехода в профиль —>
        <button type="button" class="me-3 btn btn-primary btn-circle"></button>
    </div>
</nav>

<main>
    <div class="main">
        <div class="row mt-5">
            <div class="col-12 col-lg-4">
                <a data-bs-toggle="collapse" href="#collapse1" role="button" aria-expanded="false"
                   aria-controls="collapse1">
                    Я АРЕНДУЮ
                </a>
                <div class="collapse" id="collapse1">
                    <input type="checkbox" class="btn-check" id="btn-check-outlined" autocomplete="off">
                    <label class="btn btn-outline-primary" for="btn-check-outlined">Велосипед</label><br>
                </div>
            </div>
            <div class="col-12 col-lg-4">
                <a data-bs-toggle="collapse" href="#collapse2" role="button" aria-expanded="false"
                   aria-controls="collapse2">
                    КОГДА
                </a>
                <div class="collapse" id="collapse2">

                </div>
            </div>
            <div class="col-12 col-lg-4">
                <a data-bs-toggle="collapse" href="#collapse3" role="button" aria-expanded="false"
                   aria-controls="collapse3">
                    В КОМПАНИИ ИЗ
                </a>
                <div class="collapse" id="collapse3">

                </div>

                <div class="2GisMap" id="showMapForRent">
                    <input id="createMarker" type="button" value="Создать маркер"/> <%--data-toggle="modal"
                    data-target="#basicModal"--%>
                    <div id="location">
                        ORG:
                    </div>

                    <div id="map" style="width:500px; height:400px">
                        <input id="createMap" type="button" value="Показать карту"/>
                        <div id="mapBlock"></div>

                        <script>
                            var createButton = document.getElementById('createMap');

                            createButton.onclick = function () {
                                var container = document.createElement('div'),
                                    mapBlock = document.getElementById('mapBlock'),
                                    createMarker = document.getElementById('createMarker'),
                                    locationInfo = document.getElementById('location');
                                let xCor, yCor, nameOfOrg, descrOfOrg;
                                let flag;

                                container.id = 'map';
                                container.style.width = '100%';
                                container.style.height = '400px';
                                mapBlock.appendChild(container);

                                DG.then(function () {
                                        var map, marker;
                                        map = DG.map('map', {
                                            center: [54.892, 52.317],
                                            zoom: 13
                                        });
                                        createMarker.onclick = function () {
                                            flag = true;
                                            map.on('click', function (e) {
                                                if (flag) {
                                                    /*nameOfOrg = document.getElementById('nameOfOrg');
                                                    descrOfOrg = document.getElementById('bodyOfOrg');
                                                    locationInfo.innerHTML = nameOfOrg + descrOfOrg;*/
                                                    xCor = e.latlng.lat;
                                                    yCor = e.latlng.lng;
                                                    marker = DG.marker([xCor, yCor]).addTo(map).bindLabel('А так я петушок');
                                                    marker.bindPopup('Я Рифдар!');
                                                    flag = false;
                                                }
                                            });
                                        }

                                        DG.control.location({position: 'bottomright'}).addTo(map);
                                        DG.control.scale().addTo(map);
                                        DG.control.ruler({position: 'bottomleft'}).addTo(map);
                                        DG.control.traffic().addTo(map);

                                    }
                                )
                                ;


                            }
                        </script>
                    </div>

                </div>
            </div>
        </div>
    </div>
</main>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstra.."
        Container mieten in M&#252;nchen | abc Container
        Container mieten in München | abc Container
        abc-container.com

        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</body>
</html>