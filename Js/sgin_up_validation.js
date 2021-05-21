function validate(){
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    var number = document.getElementById("number").value;
    var password = document.getElementById("password").value;
    var conform_password = document.getElementById("conform_password").value;
    var check_box = document.getElementById("check_box");
    var n = password.localeCompare(conform_password);
    
    return name_validate(),email_validate(),number_validate(),password_validate(),conform_password_validate(),check_box_validate(),all();


    function all(){
        if(!(name.length < 5)&&!(isNEmail(email))&&!(isNaN(number) || number.length != 10)&&!(password.length < 5 || !$("#password").val())&&!(n != 0 || !$("#conform_password").val())&&!(!($("#check_box").is(":checked")))){
        return true;
    }
    else
        return false;
    }


    function name_validate(){
        if(name.length < 5){
            $("#name_error_message").slideDown("fast");
            $("#nameIcon").attr("class", "fas fa-exclamation-circle");
            $("#nameIcon").show();
            document.getElementById("nameIcon").style.color = "#e74c3c";
            document.getElementById("name").style.border = "2.3px solid #e74c3c";
        }
        else{
            $("#name_error_message").slideUp("fast");
            $("#nameIcon").attr("class", "fas fa-check-circle");
            $("#nameIcon").show();
            document.getElementById("nameIcon").style.color = "rgb(42, 171, 97)";           document.getElementById("name").style.border = "2.3px solid rgb(42, 171, 97)";
        }
    return false;
    }

    function email_validate(){
        if(isNEmail(email)){
            $("#email_error_message").slideDown("fast");
            $("#emailIcon").attr("class", "fas fa-exclamation-circle");
            $("#emailIcon").show();
            document.getElementById("emailIcon").style.color = "#e74c3c";
            document.getElementById("email").style.border = "2.3px solid #e74c3c";
        }
        else{
            $("#email_error_message").slideUp("fast");
            $("#emailIcon").attr("class", "fas fa-check-circle");
            $("#emailIcon").show();
            document.getElementById("emailIcon").style.color = "rgb(42, 171, 97)";           document.getElementById("email").style.border = "2.3px solid rgb(42, 171, 97)";
        }
        return false;
    }
    
    function number_validate(){
        if(isNaN(number) || number.length != 10){
            $("#number_error_message").slideDown("fast");
            $("#numberIcon").attr("class", "fas fa-exclamation-circle");
            $("#numberIcon").show();
            document.getElementById("numberIcon").style.color = "#e74c3c";
            document.getElementById("number").style.border = "2.3px solid #e74c3c";
        }
        else{
            $("#number_error_message").slideUp("fast");
            $("#numberIcon").attr("class", "fas fa-check-circle");
            $("#numberIcon").show();
            document.getElementById("numberIcon").style.color = "rgb(42, 171, 97)";           document.getElementById("number").style.border = "2.3px solid rgb(42, 171, 97)";
        }
        return false;
    }
    
    function password_validate(){
        if(password.length < 5 || !$("#password").val()){
            $("#password_error_message").slideDown("fast");
            $("#passwordIcon").attr("class", "fas fa-exclamation-circle");
            $("#passwordIcon").show();
            document.getElementById("passwordIcon").style.color = "#e74c3c";
            document.getElementById("password").style.border = "2.3px solid #e74c3c";
        }

        else{
            $("#password_error_message").slideUp("fast");
            $("#passwordIcon").attr("class", "fas fa-check-circle");
            $("#passwordIcon").show();
            document.getElementById("passwordIcon").style.color = "rgb(42, 171, 97)";           document.getElementById("password").style.border = "2.3px solid rgb(42, 171, 97)";
        }
        return false;
    }
    
    function conform_password_validate(){
        if(n != 0 || !$("#conform_password").val()){
            $("#conform_password_error_message").slideDown("fast");
            $("#conform_passwordIcon").attr("class", "fas fa-exclamation-circle");
            $("#conform_passwordIcon").show();
            document.getElementById("conform_passwordIcon").style.color = "#e74c3c";
            document.getElementById("conform_password").style.border = "2.3px solid #e74c3c";
        }
        else{
            $("#conform_password_error_message").slideUp("fast");
            $("#conform_passwordIcon").attr("class", "fas fa-check-circle");
            $("#conform_passwordIcon").show();
            document.getElementById("conform_passwordIcon").style.color = "rgb(42, 171, 97)";           document.getElementById("conform_password").style.border = "2.3px solid rgb(42, 171, 97)";
        }
        return false;
    }

    function check_box_validate(){
    if(!($("#check_box").is(":checked"))){
        $("#check_box_error_message").slideDown("fast");
        $("#check_boxIcon").attr("class", "fas fa-exclamation-circle");
        $("#check_boxIcon").show();
        document.getElementById("check_boxIcon").style.color = "#e74c3c";
        document.getElementById("check_box").style.border = "2.3px solid #e74c3c";
    }
    else{
        $("#check_box_error_message").slideUp("fast");
        $("#check_boxIcon").attr("class", "fas fa-check-circle");
        $("#check_boxIcon").show();
        document.getElementById("check_boxIcon").style.color = "rgb(42, 171, 97)";           document.getElementById("check_box").style.border = "2.3px solid rgb(42, 171, 97)";
    }
    return false;
    }

}

function isNEmail(email) {
  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  return !regex.test(email);
}
