<%--
  Created by IntelliJ IDEA.
  User: sandy.n.hao
  Date: 2019-01-18
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh_CN" class="html-">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>what we can do</title>
    <style type="text/css">
        * {
            margin:0; padding:0;
            font-family: Arial, Helvetica, sans-serif;
        }
        body {
            background-image:url('/img/background.jpg');
            background-size: cover;
            font-size:13px;
        }
        div {
            display: flex;
            justify-content: center;
            height: 100%;
            align-items: center;
        }
        a {
            color: white;
            font-size: 30px;
            width:100px;
            text-align: center;
            text-decoration: none;
        }
        .cell {
            height: 100px;
            vertical-align: middle;
            display: flex;
            line-height: 40px;
            background-color: rgba(0,0,0,0.3);
            border-radius: 5px;
            box-shadow: 0 6px 10px rgba(0,0,0,0.3);
            margin: 10px;
            padding: 10px;
            width: 200px;
            align-items: center;
            justify-content: center;
        }
    </style>
</head>
<body>
<div>
    <div class="cell">
        <span><a href="/category/redirect?url=OpenAPI">OpenAPI</a></span>
    </div>
    <div class="cell">
        <span><a href="/category/redirect?url=Waiting">Waiting</a></span>
    </div>
</div>
</body>
</html>
