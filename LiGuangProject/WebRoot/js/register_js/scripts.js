
jQuery(document).ready(function() {

    /*
        Background slideshow
    */
    $.backstretch([
      "images/register_page/backgrounds/1.jpg"
    , "images/register_page/backgrounds/2.jpg"
    , "images/register_page/backgrounds/3.jpg"
    ], {duration: 3000, fade: 750});

    /*
        Tooltips
    */
    $('.links a.home').tooltip();
    $('.links a.blog').tooltip();

    /*
        Form validation
    */
    $('.register form').submit(function(){
        $(this).find("label[for='email']").html('Email');
        $(this).find("label[for='password']").html('Password');
        $(this).find("label[for='phone']").html('Phone');
        $(this).find("label[for='repassword']").html('ReEnterPassword');
        ////
        var email = $(this).find('input#email').val();
        var password = $(this).find('input#password').val();
        var phone = $(this).find('input#phone').val();
        var repassword = $(this).find('input#repassword').val();
       
        
        if(phone.length!=11)
        {
            $(this).find("label[for='phone']").append("<span style='display:none' class='red'> -请输入有效的手机号码！</span>");
        	$(this).find("label[for='phone'] span").fadeIn('medium');
            return false;
        }
        
        var myreg = /^(((1[0-9][0-9]{1})|159|153)+\d{8})$/;
        if(!myreg.test(phone))
        {
        	$(this).find("label[for='phone']").append("<span style='display:none' class='red'> -请输入有效的手机号码！</span>");
        	$(this).find("label[for='phone'] span").fadeIn('medium');
            return false;
        }
       /* if(email == '') {
            $(this).find("label[for='email']").append("<span style='display:none' class='red'> - Please enter a valid email.</span>");
            $(this).find("label[for='email'] span").fadeIn('medium');
            return false;
        }
        
        if (email.indexOf("@", 0) == -1) {
            $(this).find("label[for='email']").append("<span style='display:none' class='red'> - 电子邮件格式不正确，必须包含@符号！</span>");
            $(this).find("label[for='email'] span").fadeIn('medium');
            return false;
        }
        if (email.indexOf(".", 0) == -1) {
            $(this).find("label[for='email']").append("<span style='display:none' class='red'> - 电子邮件格式不正确，必须包含.符号!</span>");
            $(this).find("label[for='email'] span").fadeIn('medium');
            return false;
        }
        if (email.indexOf(".", 0)-email.indexOf("@", 0) == 1) {
            div.innerHTML = "邮件格式不对。@和.不可以挨着！";
            document.form1.text5.select();
            return false;
        }
        if (email.indexOf("@", 0) > mail.indexOf(".", 0)) {
            div.innerHTML = "电子邮件格式不正确，@符号必须在.之前";
            document.form1.text5.select();
            return false;
        } */
        if(password == '') {
            $(this).find("label[for='password']").append("<span style='display:none' class='red'> - Please enter a valid password.</span>");
            $(this).find("label[for='password'] span").fadeIn('medium');
            return false;
        }
        if(repassword == '') {
        	$(this).find("label[for='password']").append("<span style='display:none' class='red'> - Please enter password again.</span>");
        	$(this).find("label[for='password'] span").fadeIn('medium');
        	return false;
        }
        if(repassword != password) {
        	$(this).find("label[for='password']").append("<span style='display:none' class='red'> -输入密码和确认密码不一致.</span>");
        	$(this).find("label[for='password'] span").fadeIn('medium');
        	return false;
        }
        if(repassword == '')
        {
        	$(this).find("label[for='phone']").append("<span style='display:none' class='red'> -请输入手机号.</span>");
        	$(this).find("label[for='phone'] span").fadeIn('medium');
           return false;
        }    
        
    });


});


