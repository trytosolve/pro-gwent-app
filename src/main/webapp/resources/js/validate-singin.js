function validate() {
    var userName = document.getElementById("userName");
    var userPassword = document.getElementById("userPassword");

    event.preventDefault();

    if(!userName.value) {
        userName.style.border = "10px solid red"
        return false
    }
    if(!userPassword.value) {
        userPassword.style.border = "10px solid red"
        return false
    }
    return true;
}