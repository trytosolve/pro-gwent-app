$(function() {
    $("form[name='singin']").validate({
        rules: {
            login: "required",
            password: "required",
        },
        messages: {
            login: "Please enter your login",
            password: {
                required: "Please enter your password",
            },
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});
