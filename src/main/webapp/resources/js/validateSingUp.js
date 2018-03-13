function validateSingUpForm() {
    var userLogin = document.getElementById("userLogin");
    var userPass = document.getElementById("userPass");
    var confirmPass = document.getElementById("confirmPass");
    var email = document.getElementById("email");
    var validationErrorMassage = document.getElementById("validationErrorMassage");
    validationErrorMassage.innerHTML="";

    if(!userLogin.value) {
        userLogin.setAttribute("class","form_input_error")
        return false
    }
    if(!userPass.value) {
        userPass.setAttribute("class","form_input_error")
        return false
    }
    if(!confirmPass.value) {
        confirmPass.setAttribute("class","form_input_error")
        return false
    }
    if(!email.value) {
        email.setAttribute("class","form_input_error")
        return false
    }
    if(userLogin.value.length<2 || userLogin.value.length>16) {
        validationErrorMassage.innerHTML='Name size must be between 2 and 16'
        validationErrorMassage.style.color = "red"
        return false
    }
    return true;
}