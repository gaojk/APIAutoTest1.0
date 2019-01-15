<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<form  action="/method/excute_methods" method="post">
    <table>
        <tr>
            <td><label>环境：</label></td>
            <td>
                <select name="env">
                    <option>--请选择--</option>
                    <option value="test" selected="selected">QA</option>
                    <option value="demo">PRDtest</option>
                    <option value="online">PRD</option>
               </select>
            </td>
            <td><label>端口：</label></td>
            <td>
                <select name="port">
                    <option>--请选择--</option>
                    <option value="8000" selected="selected">8000</option>
                    <option value="8001">8001</option>
                    <option value="8003">8003</option>
                    <option value="8005">8005</option>
                </select>
            </td>
        </tr>

        <c:choose>
            <c:when test="${empty requestScope.methods  || fn:length(requestScope.methods) == 0}">
                方法列表为空！！！
            </c:when>
            <c:otherwise>
                    <c:forEach items="${requestScope.methods}" var="item">
                        <tr>
                            <td><input type="checkbox" name="selectmethod" value="${item.sysno}"></td>
                            <td>${item.method}</td>
                            <c:forEach items="${requestScope.testcases['${item.sysno}']}" var="case">
                                <td>${case.content}</td>
                            </c:forEach>
                            <td colspan="4"><button class="blue" type="submit">保存</button></td>
                            <td colspan="4"><button class="blue" type="submit">运行</button></td>
                            <td colspan="2"><textarea rows="3" cols="20">运行结果</textarea></td>
                        </tr>
                    </c:forEach>
            </c:otherwise>
        </c:choose>
        <tr>
            <td colspan="4"><button class="blue" type="submit">批量运行</button></td>
        </tr>
    </table>
</form>
</body>
</html>