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

<main class="my-3 ml-3 ms-3">
    <div>
        ${pointOfSale.nameOfOrganization}
    </div>
    <div>
        Sport inv:
        <#list pointOfSale.sportInventoryList as sportInventory>
            <div class="col-8 limited" style="float: left !important;">
            </div>
        </#list>
    </div>
    <div>
        ${pointOfSale.description}
    </div>
</main>
</body>
</html>