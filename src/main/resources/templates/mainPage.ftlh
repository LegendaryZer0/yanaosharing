<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Main page</title>
    <script src="https://maps.api.2gis.ru/2.0/loader.js?pkg=full<#--&lazy=true-->"></script>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css"
          integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">

    <link href="https://fonts.googleapis.com/css?family=Jost&amp;display=swap" rel="stylesheet">
    <link href="../static/css/mainPage.css" rel="stylesheet">
</head>
<body style="overflow: hidden; position: relative;">
<div class="map-container">
    <div id="map"></div>
    <script type="text/javascript">
        $(document).ready(function () {
            let map;

            DG.then(function () {
                map = DG.map('map', {
                    center: [66.55, 66.63],
                    zoom: 13,
                    zoomControl: false,
                    fullscreenControl: false,
                });
            });
        });
    </script>
</div>
<header class="header">
    <#--    <#include "*/footer.ftl">-->
    <button class="header-text" onclick="window.location.href = '/';">YANAO.SHARING</button>
    <button class="logo-btn" onclick="window.location.href = '/profile';">
        <img class="logo-image" src="../static/img/Profile.png">
    </button>
</header>
<main class="main-container">
    <#--<div class="content">
        <!-- Modal window &ndash;&gt;
        <div id="addNew" class="modal" hidden style="background-color: lightgray; position: absolute">
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
    </div>-->

    <div class="main d-flex justify-content-start align-items-center" style="position: absolute">
        <#-- TODO better make ajax -->
        <#include "*/map.ftlh">
    </div>
</main>
</body>
</html>