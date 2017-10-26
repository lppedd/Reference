$(document).ready(function () {
    $(".nojs").removeClass("nojs");
    $(".more").click(function () {
        $($(this).attr("data-target")).toggle();
        $(this).text($(this).text() === '+' ? '-' : '+');
    });

    $('.paragraph h1, h2, h3, h4, h5, h6').hover(
        function () {
            $(this).find('.bookmark').removeClass('hidden');
        },
        function () {
            $(this).find('.bookmark').addClass('hidden');
        }
    )
});
