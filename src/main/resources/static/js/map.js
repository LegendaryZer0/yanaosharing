$(document).ready(function () {
    let minPrice = 100, maxPrice = 1000;

    $("#slider-range-max").slider({
        range: "max",
        min: minPrice,
        max: maxPrice,
        value: minPrice,
        slide: function (event, ui) {
            $("#priceAmount").html(ui.value + "₽ - " + maxPrice + "₽");
            $("#price").val(ui.value);
        }
    });
});