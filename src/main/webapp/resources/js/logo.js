function animationHover(element, animation){
    element = $(element);
    element.hover(
        function() {
            element.addClass('animated ' + animation);
        },
        function(){
            window.setTimeout( function(){
                element.removeClass('animated ' + animation);
            }, 1000);
        });
}

$(document).ready(function(){
    $('#logo').each(function() {
        animationHover(this, 'rubberBand');
    });
});
