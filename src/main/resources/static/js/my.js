function validateForm() {
    var x = document.forms["logInTo"]["username"].value;
    if (x == null || x == "") {
        alert("账号必须填写");
        return false;
    }
    var d = document.forms["logInTo"]["password"].value;
    if (d == null || d == "") {
        alert("密码必须填写");
        return false;
    }
}
