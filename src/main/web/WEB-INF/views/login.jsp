<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>登录</title>
    <style type="text/css">
        .Verticalcenter{width: 670px; height: 350px; margin: 0 auto;}
        .Horizontalcenter{width: 270px; height: 150px; position: fixed; left: 50%; top: 50%; margin: -75px 0 0 -135px;}
    </style>
</head>
<body>
<div class="Verticalcenter">
    <div class="Horizontalcenter">
        <form action="/user/login" method="post">
            <table>
                <tr>
                    <td><label for="txtname">账号：</label></td>
                    <td><input type="text" id="txtname" name="login_username" /></td>
                </tr>
                <tr>
                    <td><label for="txtpwd">密码：</label></td>
                    <td><input type="password" id="txtpwd" name="login_pwd" /></td>
                </tr>
                <tr>
                    <td colspan=2>
                        <input type="submit" value="登录" style="left: 50%"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>