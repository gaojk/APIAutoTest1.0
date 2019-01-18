<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>登录</title>
    <style type="text/css">
        * { margin:0; padding:0;}
        p {
            color: white;
            font-family: Arial, Helvetica, sans-serif;
            font-size: 50px;
            vertical-align:middle;
            width:100%;
        }
        body {
            font-family:Arial, Helvetica, sans-serif;
            background-image:url('/img/background.jpg');
            font-size:13px;
        }
        .Verticalcenter{
            width: 670px;
            height: 350px;
            margin: 0 auto;
        }
        .Horizontalcenter{
            width: 270px;
            height: 150px;
            position: fixed;
            left: 50%;
            top: 50%;
            margin: -75px 0 0 -135px;
        }
        .bn{
            width:140px;
            height:30px;
            border:0;
            display:block;
            font-size:18px;
            background-color: transparent;
            color:white;
            font-family:Arial, Helvetica, sans-serif;
            font-weight:bolder;
        }
        .in{
            height:37px;
            border:0;
            color: white;
            background-color: white;
            width:236px;
            margin:4px 28px;
            padding-left:10px;
            font-size:16pt;
            font-family:Arial, Helvetica, sans-serif;
        }
    </style>
</head>
<body>
<p><span>Test Better</span></p>
<div class="Verticalcenter">
    <div class="Horizontalcenter">
        <form action="/user/login" method="post">
            <table>
                <tr>
                    <td><label for="username">账号：</label></td>
                    <td><input class="in" type="text" id="username" name="login_username" /></td>
                </tr>
                <tr>
                    <td><label for="pwd">密码：</label></td>
                    <td><input class="in" type="password" id="pwd" name="login_pwd" /></td>
                </tr>
                <tr>
                    <td>
                    <input class="bn" type="submit" value="登录"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>