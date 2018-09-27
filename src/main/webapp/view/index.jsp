<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
            <!--jquery-->
        <script src="/sweepFaceOL/view/js/vendor/jquery-3.2.1.min.js"></script>
    </head>

    <body>
        <p>${message}</p>
        <button id="register">添加用戶</button>
    </body>

    </html>
    <script>
        $("#register").click(function(){
            location.href="/startSSM/user/register"
        })
    </script>