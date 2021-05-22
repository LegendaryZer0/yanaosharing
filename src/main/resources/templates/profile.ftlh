<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><@spring.message code="profile.title" /></title>
    <link rel="icon" href="${rc.getContextPath()}/static/img/favicon.ico">
    <script type="text/javascript" src="${rc.getContextPath()}/static/js/jquery.min.js"></script>
    <script type="text/javascript" src="${rc.getContextPath()}/static/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${rc.getContextPath()}/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="${rc.getContextPath()}/static/css/style.css">
</head>

<body>
<div class="container">
    <div class="row">
        <h1>Привет, ${user.getName()}</h1>
        <h3>Ты на аккаунте ${user.getEmail()}</h3>

        <li class="nav-item">
            <a class="nav-link"
               href="${rc.getContextPath()}/yanaosharing">Перейти к заказу</a>
        </li>
    </div>
</div>

</body>
</html>