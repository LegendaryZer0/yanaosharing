<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="https://maps.api.2gis.ru/2.0/loader.js?pkg=full&lazy=true"></script>
</head>
<body>
<!--Main-->
<main>
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

        <!— basic modal —>
        <div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Create organization</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <label for="nameOfOrg" class="col-sm-4 col-form-label">Name of organization</label>
                        <input id="nameOfOrg" class="input-group-text" type="text" name="Name of organization" required>
                        <label for="bodyOfOrg" class="col-sm-4 col-form-label">Description company</label>
                        <input id="bodyOfOrg" class="input-group-text" type="text" name="Description company" required>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </div>


</main>
<div id="map">
    <#--                <script>-->
    <#--                    let showMap = document.getElementById('showMap');-->
    <#--                    let xCor, yCor, nameOfOrg, descrOfOrg, allMarkers;-->

    <#--                    /*showMap.onclick = function () {*/-->
    <#--                        let container = document.createElement('div'),-->
    <#--                            mapBlock = document.getElementById('mapBlock'),-->
    <#--                            createMarker = document.getElementById('createMarker'),-->
    <#--                            addTextToMarker = document.getElementById('createok');-->

    <#--                        let flag;-->

    <#--                        container.style.width = '400px';-->
    <#--                        container.style.height = '600px';-->
    <#--                        mapBlock.appendChild(container);-->
    <#--                        mapBlock.style.position = 'relative';-->

    <#--                        DG.then(function () {-->
    <#--                            let map, marker, countOfMarkers;-->
    <#--                            getAllMarkers();-->

    <#--                            map = DG.map('map', {-->
    <#--                                center: [54.892, 52.317],-->
    <#--                                zoom: 13-->
    <#--                            });-->

    <#--                            for (let i = 0; i < allMarkers.length; i++) {-->
    <#--                                console.log(allMarkers[i].positionX + ' ' + allMarkers[i].positionY)-->
    <#--                                markeri = DG.marker([allMarkers[i].positionX, allMarkers[i].positionY]).addTo(map).bindLabel('push me');-->
    <#--                                markeri.bindPopup(allMarkers[i].nameOfOrganization + '\n' + allMarkers[i].description + '\n' + '<a class="btn btn-outline-info my-3 ml-3 mr-3" href="/showPointOfSale?pointOfSaleId=' + allMarkers[i].pointOfSaleId + '">Подробнее</a>');-->
    <#--                            }-->
    <#--                            createMarker.onclick = function () {-->
    <#--                                document.getElementById('createMarker').hidden = true;-->
    <#--                                document.getElementById('addnew').hidden = false;-->
    <#--                                document.getElementById('hid').onclick = function () {-->
    <#--                                    document.getElementById('addnew').hidden = true;-->
    <#--                                    document.getElementById('createMarker').hidden = false;-->
    <#--                                };-->

    <#--                                addTextToMarker.onclick = function () {-->
    <#--                                    flag = true;-->
    <#--                                    map.on('click', function (e) {-->
    <#--                                        if (flag) {-->
    <#--                                            nameOfOrg = $('#nameOfOrg').val();-->
    <#--                                            descrOfOrg = $('#descrOfOrg').val();-->

    <#--                                            document.getElementById('addnew').hidden = true;-->
    <#--                                            document.getElementById('createMarker').hidden = false;-->

    <#--                                            xCor = e.latlng.lat;-->
    <#--                                            yCor = e.latlng.lng;-->
    <#--                                            marker = DG.marker([xCor, yCor]).addTo(map).bindLabel('push me');-->
    <#--                                            marker.bindPopup(nameOfOrg + '\n' + descrOfOrg);-->
    <#--                                            flag = false;-->
    <#--                                            doAjaxPost();-->
    <#--                                        }-->
    <#--                                    });-->
    <#--                                }-->
    <#--                            }-->

    <#--                            DG.control.location({position: 'bottomright'}).addTo(map);-->
    <#--                            DG.control.scale().addTo(map);-->
    <#--                            DG.control.ruler({position: 'bottomleft'}).addTo(map);-->
    <#--                            DG.control.traffic().addTo(map);-->
    <#--                        });-->
    <#--                    /*}*/-->

    <#--                    function doAjaxPost() {-->
    <#--                        $('#err').remove();-->
    <#--                        $.ajax({-->
    <#--                            type: 'POST',-->
    <#--                            url: "/addMarker",-->
    <#--                            contentType: 'application/json',-->

    <#--                            data: JSON.stringify({-->
    <#--                                'xсor': xCor,-->
    <#--                                'yсor': yCor,-->
    <#--                                'nameOfOrg': nameOfOrg,-->
    <#--                                'descrOfOrg': descrOfOrg-->
    <#--                            }),-->
    <#--                            headers: {'X-CSRF-TOKEN': '${_csrf.token}'},-->
    <#--                            success: function (response) {-->
    <#--                                $('#nameOfOrg').val('');-->
    <#--                                $('#descrOfOrg').val('');-->
    <#--                            },-->
    <#--                            error: function (e) {-->
    <#--                                $('#des').append($('<h4 id="err">Что-то пошло не так</h4>'))-->
    <#--                                console.log(xCor + ' ' + yCor);-->
    <#--                            }-->
    <#--                        });-->
    <#--                    }-->

    <#--                    function getAllMarkers() {-->
    <#--                        $.ajax({-->
    <#--                            type: 'GET',-->
    <#--                            async: false,-->
    <#--                            url: '/getPoints',-->
    <#--                            success: function (response) {-->
    <#--                                allMarkers = response;-->
    <#--                            },-->
    <#--                            error: function (e) {-->
    <#--                                console.log(e);-->
    <#--                            }-->
    <#--                        });-->
    <#--                    }-->
    <#--                </script>-->
</div>
</body>
</html>




