<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Jost&amp;display=swap" rel="stylesheet">
    <link href="../static/css/index.css" rel="stylesheet">
    <title>YANAO.SHARING</title>
</head>
<body>
<div class="content">
    <header class="header">
        <button class="header-text" onclick="window.location.href = '/';">YANAO.SHARING</button>
        <button class="logo-btn" onclick="window.location.href = '/profile';">
            <img class="logo-image" src="../static/img/Profile.png">
        </button>
    </header>

    <div class="themes">
        <button class="theme1 theme" id="theme1" onclick="swipeMediaContent(this, 0)">Я АРЕНДУЮ</button>
        <button class="theme2 theme" id="theme2" onclick="swipeMediaContent(this, 1)">КОГДА</button>
        <button class="theme3 theme" id="theme3" onclick="swipeMediaContent(this, 2)">В КОМПАНИИ ИЗ</button>
    </div>

    <div class="main-container">
        <div class="main" id="main">
            <div class="main-elem selects">
                <div class="select1 select">
                    <span class="select1-text select-text">Спортзал</span>
                </div>
                <div class="select2 select">
                    <span class="select2-text select-text">Велосипед</span>
                </div>
                <div class="select3 select">
                    <span class="select3-text select-text">Самокат</span>
                </div>
            </div>
            <div class="main-elem">
                <div class="select1 select">
                    <span class="select1-text select-text">Спортзал</span>
                </div>
                <div class="select2 select">
                    <span class="select2-text select-text">Велосипед</span>
                </div>
                <div class="select3 select">
                    <span class="select3-text select-text">Самокат</span>
                </div>
            </div>
            <div class="main-elem">
                <div class="select1 select">
                    <span class="select1-text select-text">Спортзал</span>
                </div>
                <div class="select2 select">
                    <span class="select2-text select-text">Велосипед</span>
                </div>
                <div class="select3 select">
                    <span class="select3-text select-text">Самокат</span>
                </div>
            </div>
        </div>
    </div>

    <button class="btn-next" onclick="nextClick()">
        <span class="btn-next-text">Далее</span>
    </button>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    let numNum = 0;

    function moveMain(num) {
        let l2 = $(window).width() * num * (-1);
        console.log(l2);
        $("#main").css({left: l2});
    }

    function swipeMediaContent(button, num) {
        numNum = num;
        // change font for text
        $('.theme').each(function () {
            $(this).css("color", "rgba(217, 217, 217, 1)");
        });
        $(button).css("color", "rgba(43, 103, 246, 1)");
        // move content
        moveMain(num);
    }

    function nextClick() {
        numNum++;
        if (numNum > 2) {
            window.location.replace("/yanaosharing");
        } else {
            $('.theme').each(function () {
                $(this).css("color", "rgba(217, 217, 217, 1)");
            });
            $("#theme" + (numNum + 1)).css("color", "rgba(43, 103, 246, 1)");
            moveMain(numNum);
        }
    }
</script>
</body>
</html>