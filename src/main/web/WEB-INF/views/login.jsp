<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh_CN" class="html-">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>login</title>
    <link rel="icon" href="/img/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon">
    <style type="text/css">
        * {
            margin:0; padding:0;
            font-family: Arial, Helvetica, sans-serif;
        }
        /*修复chrome 自动填充input背景*/
        input:-webkit-autofill {
            -webkit-box-shadow: 0 0 0 50px #fff inset;
        }
        body {
            background-image:url('/img/background.jpg');
            background-size: cover;
            font-size:13px;
        }
        .Verticalcenter{
            width: 500px;
            height: 300px;
            position: absolute;
            left: 50%;
            top:50%;
            margin-top: -150px;
            margin-left: -250px;
            background-color: rgba(0,0,0,0.3);
            border-radius: 5px;
            box-shadow: 0 6px 10px rgba(0,0,0,0.3);
        }
        .Verticalcenter>p {
            color: white;
            font-size: 40px;
            width:100%;
            text-align: center;
            line-height: 70px;
            margin-top: 20px;
        }
        .Verticalcenter .Horizontalcenter{
            width: 100%;
            height: auto;
            margin-top: 20px;
        }
        .input-box{
            width: 100%;
            height: auto;
            margin-bottom: 20px;
            text-align: center;
        }
        .input-box label,.input-box .input{
            display: inline-block;
            vertical-align: top;
        }
        .input-box label{
            width: 60px;
            line-height: 30px;
            color: #ffffff;
            font-size: 14px;
            text-align: left;
            margin-right: 10px;
        }
        .input-box .input{
            width: 240px;
            height: 30px;
            line-height: 28px;
            border: 1px solid #f5f5f5;
            background-color: #fff;
            padding-left: 10px;
            font-size: 14px;
            color: #333;
        }
        .input-box .btn{
            display: inline-block;
            vertical-align: top;
            width: 100px;
            line-height: 30px;
            text-align: center;
            border-radius: 3px;
            color: #333;
            font-size: 14px;
            border: none;
        }
    </style>
</head>
<body>
<body>
<div class="Verticalcenter">
    <p><span>Test Better</span></p>
    <div class="Horizontalcenter">
        <form action="/user/login" method="post">
            <div class="input-box">
                <label for="username">Username：</label>
                <input class="input" type="text" id="username" name="login_username" />
            </div>
            <div class="input-box">
                <label for="pwd">Password：</label>
                <input class="input" type="password" id="pwd" name="login_pwd" />
            </div>
            <div class="input-box">
                <input class="btn" type="submit" value="Sign in"/>
            </div>
        </form>
    </div>
</div>
</body>
</body>
</html>