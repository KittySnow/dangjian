$(function(){
	create_code();
//	$("#logBtn").on('click',function(){
//		
//	})
        $("#userName").focus(function(){
            $(this).next().text("");
            $("#logBtn").removeAttr("disabled").css('background-color','#5466da');

        });
        $("#userName").blur(function(){
            if( $(this).val() == "")
            {
                $(this).next().html("账号不能为空！");
                $(this).next().css("display","block");
                $("#logBtn").attr('disabled', true).css('background-color','dimgrey');
            }

        });
        /*密码输入框失去焦点*/
        $("#passWord").focus(function(){
	        $(this).next().text("");
	        $("#logBtn").removeAttr("disabled").css('background-color','#5466da');

        });
        $("#passWord").blur(function(){
            if($(this).val() == ""){
                $(this).next().html("密码不能为空！");
                $(this).next().css("display","block");
                $("#logBtn").attr('disabled', true).css('background-color','dimgrey');
                
            }
        });
        /*验证码输入框失去焦点*/
        $("#keySafe").focus(function(){
            $(this).parent().next().text("");
            $("#logBtn").removeAttr("disabled").css('background-color','#5466da');

        });
        $("#keySafe").blur(function(){
            var code1=$('#keySafe').val().toLowerCase();
            var code2=$(".yzm .phoKey").text().toLowerCase();
            if(code1!=code2)
            {
                $(this).parent().next().html("验证码输入错误!!!");
                $(this).next().next().css("display","block");
                $("#logBtn").attr('disabled', true).css('background-color','dimgrey');
            }
        })
        
        //点击提交按钮
        $("#logBtn").click(function(){
    	var userName=$("#userName").val();
    	var pass=$("#passWord").val();
    	var keysafe=$("#keySafe").val();
    	if(userName=="" || pass=="" ||keysafe==""){
    		$("#logBtn").attr('disabled', true).css('background-color','dimgrey');
    	}
    	else{
			$.ajax({
			    url:'../ad/login.do',
			    type:'POST',
			    data:{loginMail:userName,loginPasswd:pass}
			}).done(function(data){
				if(data.success == true){
					window.location.href="../admin/index.html";
					sessionStorage.setItem('sessionStatus',data.success);
					sessionStorage.setItem('userName',userName);
				}else{
					var subStr = data.msg.substring(0,14);
					if(subStr == "邮箱、密码不匹配，无法登录！")	{
						$(".errorPrompting").text(" ").text(data.msg);
					} else if(subStr =="账号已被锁定，请3小时后再尝"){
						$(".errorPrompting").text(" ").text(data.msg);
						$("#userName").attr('disabled', true);
						$("#passWord").attr('disabled', true);
						$("#keySafe").attr('disabled', true);
						$("#logBtn").attr('disabled', true).css('background-color','dimgrey');
					} else{
						$(".errorPrompting").text(" ").text(data.msg);
					}
				}
			})
    	}
    })
})

//生成验证码的函数
function create_code() {
    function shuffle() {
        var arr = ['1', 'r', 'Q', '4', 'S', '6', 'w', 'u', 'D', 'I', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', '2', 's', 't', '8', 'v', '7', 'x', 'y', 'z', 'A', 'B', 'C', '9', 'E', 'F', 'G', 'H', '0', 'J', 'K', 'L', 'M', 'N', 'O', 'P', '3', 'R',
            '5', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
        return arr.sort(function () {
            return (Math.random() - .5);
            console.log(arr);
        });
           console.log(arr);
    };
    shuffle();
    function show_code() {
        var ar1 = '';
        var code = shuffle();
        for (var i = 0; i < 6; i++) {
            ar1 += code[i];
        }

        $(".yzm .phoKey").text(ar1);
    };
    show_code();
    $(".yzm .phoKey").click(function () {
        show_code();
    });
}
/*检验邮箱*/
function isEmail(str){ 
var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
return reg.test(str); 
} 


