<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Main page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstr.." rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
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
        <h1 class="ms-3">YAMAO.SHARING</h1>
        <!— Кнопка перехода в профиль —>
        <button type="button" class="me-3 btn btn-primary btn-circle"></button>
    </div>
</nav>
<div class="main">
    <div class="row mt-5">
        <div class="col-12 col-lg-4">
            <a data-bs-toggle="collapse" href="#collapse1" role="button" aria-expanded="false" aria-controls="collapse1">
                Я АРЕНДУЮ
            </a>
            <div class="collapse" id="collapse1">
                <input type="checkbox" class="btn-check" id="btn-check-outlined" autocomplete="off">
                <label class="btn btn-outline-primary" for="btn-check-outlined">Велосипед</label><br>
            </div>
        </div>
        <div class="col-12 col-lg-4">
            <a data-bs-toggle="collapse" href="#collapse2" role="button" aria-expanded="false" aria-controls="collapse2">
                КОГДА
            </a>
            <div class="collapse" id="collapse2">

            </div>
        </div>
        <div class="col-12 col-lg-4">
            <a data-bs-toggle="collapse" href="#collapse3" role="button" aria-expanded="false" aria-controls="collapse3">
                В КОМПАНИИ ИЗ
            </a>
            <div class="collapse" id="collapse3">

            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstra.." integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</body>
</html>