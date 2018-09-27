<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--jquery-->
        <script src="/sweepFaceOL/view/js/vendor/jquery-3.2.1.min.js"></script>
        <title>Insert title here</title>
    </head>

    <body>
        <form id="register">
            姓名: <input type="text" name="name" /><br/>
            性別: <input name="sex" type="radio" checked="checked" value=1>男 <input name="sex" type="radio" value=0 />女<br/>
            電話: <input type="text" name="tel" /><br/>
            地址: <input type="text" name="addr" /><br/>
            年齡: <input type="number" name="age" /><br/>
        </form>
         <button id="commit">提交</button>
    </body>
    <script>
          $("#commit").click(function(){
                var form=$("#register").serialize();
                console.log(form);
                $.ajax({
                    url:"/startSSM/user/add",
                    method:'post',
                    dataType:'json',
                    data:form,
                    success:function(data){
                        alert("添加成功")
                        document.getElementById("register").reset();
                    },
                    error:function(data,status,e){
                        console.log(e)
                        alert("添加失敗")
                    }
                })                
          })
    </script>
      
    </html>