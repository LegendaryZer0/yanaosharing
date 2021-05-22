<#import "/spring.ftl" as spring />
<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Map</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Jost:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="<@spring.url '/css/easy.css'/>">
    <link rel="stylesheet" href="http://ajax.aspnetcdn.com/ajax/jquery.ui/1.10.3/themes/sunny/jquery-ui.css">
</head>
<body>
<nav class="navbar navbar-light upper">
    <div class="container-fluid">
        <h1>YAMAO.SHARING</h1>
    </div>
</nav>
<div class="main d-flex justify-content-start align-items-center">
    <form class="ms-5 shadow-lg p-3 mb-5 bg-body rounded filter">
        <div class="form-switch row mb-3 mx-3 align-items-center" style="height: 5%; padding: 0;">
            <div class="d-flex col-md-12 col-lg-6"><label class="form-check-label" for="flexSwitchCheckDefault">Карта</label></div>
            <div class="d-flex justify-content-md-center justify-content-lg-end col-md-12 col-lg-6"><input
                        class="form-check-input" type="checkbox" id="flexSwitchCheckDefault"
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
            <div class="col-6 selector"><label id="priceAmount" class="form-check-label d-flex align-items-center justify-content-end"></label>
            </div>
            <div class="col-12" id="priceSlider">
                <div id="slider-range-max"></div>
                <input id="price" type="hidden" name="price">
            </div>
        </div>

        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="<@spring.url '/js/jquery-ui.js'/>"></script>
<script src="<@spring.url '/js/jquery-ui-touch.js'/>"></script>
<script src="<@spring.url '/js/map.js'/>"></script>
</body>
</html>