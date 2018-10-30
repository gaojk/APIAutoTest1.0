<%--
  Created by IntelliJ IDEA.
  User: sandy.n.hao
  Date: 2018/9/25
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<style type="text/css">
    body{
        /*font-family: "Times New Roman", Times, serif;*/
        /*font-size: 18px;*/
        /*color: #000000;*/

        font: 18px/1.5 Tahoma,Helvetica,Arial,'宋体',sans-serif;
    }

    .demo{
        position: absolute;
        width: 200px;
        height: 200px;
        border: 1px solid red;
    }

    p{
        position: absolute;
        width: 150px;
        top: 50%;
        left:50%;
        transform: translate(-50%,-50%);
        border: none;
    }

    a:link {color: black ; text-decoration:none;}
    a:active {color: red; }
    a:visited {color:gray;text-decoration:none;}
    a:hover {color: red; text-decoration:underline;}
</style>
<html>
<head>
    <title>方法列表</title>
</head>
<body>
    <div id="resource">
            <c:choose>
                <c:when test="${empty sessionScope.user.resourceList || fn:length(sessionScope.user.resourceList) == 0}">
                    该用户无可用业务域。
                </c:when>
                <c:otherwise>
                    <p>
                        <c:forEach items="${sessionScope.user.resourceList}" var="item">
                            <a href="/resource/get_methods_by_id?resourceId=${item.sysno}"> ${item.name}</a><br>
                        </c:forEach>
                    </p>
                </c:otherwise>
            </c:choose>
    </div>
</body>
</html>
