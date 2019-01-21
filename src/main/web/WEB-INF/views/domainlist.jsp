<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
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
<html lang="zh_CN" class="html-">
<head>
    <title>U domain</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
    <div id="resource">
            <c:choose>
                <c:when test="${empty sessionScope.user.domainList || fn:length(sessionScope.user.domainList) == 0}">
                    该用户无可用业务域。
                </c:when>
                <c:otherwise>
                        <c:forEach items="${sessionScope.user.domainList}" var="item">
                            <div class="cell">
                                <a href="/domain/get_methods_bydomainid?domainId=${item.sysno}">${item.desc}</a>
                            </div>
                        </c:forEach>
                </c:otherwise>
            </c:choose>
    </div>
</body>
</html>
