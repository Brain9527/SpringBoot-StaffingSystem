function validateForm() {
    var x = document.forms["logInTo"]["username"].value;
    if (x == null || x == "") {
        alert("姓必须填写");
        return false;
    }
}