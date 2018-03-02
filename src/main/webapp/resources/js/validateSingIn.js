function validateIn() {
    var userLogin = document.getElementById("userLogin");
    var userPass = document.getElementById("userPass");
    var errorJS = document.getElementById("errorJS");
    errorJS.innerHTML="";

    if(!userLogin.value) {
        userLogin.style.border = "2px solid red"
        return false
    }
    if(!userPass.value) {
        userPass.style.border = "2px solid red"
        return false
    }
    if(userLogin.value.length<2 || userLogin.value.length>16) {
        errorJS.innerHTML='Name size must be between 2 and 16'
        errorJS.style.color = "red"
        return false
    }
    return true;
}