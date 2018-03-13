//TODO что такое Up?
function validateUp() {
    var userLogin = document.getElementById("userLogin");
    var userPass = document.getElementById("userPass");
    var confirmPass = document.getElementById("confirmPass");
    var email = document.getElementById("email");
    //TODO странное название для елемента. В нем нету JSa :)
    var errorJS = document.getElementById("errorJS");
    errorJS.innerHTML="";

    if(!userLogin.value) {
        //TODO так не делается. Ты делаешь css class типа error и добавляешь класс к елементу, а не стили. Что если завтра мне скажут перекрасить в фиолетовый? как я догадаюсь что ты стили в javascript хуячишь?)
        userLogin.style.border = "2px solid red"
        return false
    }
    if(!userPass.value) {
        userPass.style.border = "2px solid red"
        return false
    }
    if(!confirmPass.value) {
        confirmPass.style.border = "2px solid red"
        return false
    }
    if(!email.value) {
        email.style.border = "2px solid red"
        return false
    }
    if(userLogin.value.length<2 || userLogin.value.length>16) {
        errorJS.innerHTML='Name size must be between 2 and 16'
        errorJS.style.color = "red"
        return false
    }
    return true;
}