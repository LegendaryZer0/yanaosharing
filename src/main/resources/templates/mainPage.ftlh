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
<div class="map-container" id="map-container">
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
    <div class="main d-flex justify-content-start align-items-center" style="position: absolute">
        <#-- TODO better make ajax -->
        <#include "*/map.ftlh">
    </div>
</main>

<div class="list" id="list"></div>

<script>
    $("#flexSwitchCheckDefault").change(function () {
        if (this.checked) {
            $("#map-container").show();
            $("#list").hide();
        } else {
            $("#list").show();
            $("#map-container").hide();
        }
    });
</script>
</body>
</html>