<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<form  action="/method/operate_methods" method="post">
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
                    <c:forEach items="${requestScope.methods}" var="item1">
                        <tr>
                            <td><input type="checkbox" name="selectedmethod[]" value="${item1.sysno}"></td>
                            <td>${item1.method}</td>
                                <c:forEach items="${testcases[item1.sysno]}" var="item2">
                                    <td colspan="4"><textarea rows="3" cols="20" name="testcases">${item2.content}</textarea></td>
                                    <td colspan="4"><textarea rows="3" cols="20" name="results">运行结果</textarea></td>
                                </c:forEach>
                        </tr>
                    </c:forEach>
            </c:otherwise>
        </c:choose>
        <tr>
            <%--<td colspan="4"><input class="blue" type="submit" name="action" value="save"/></td>--%>
            <%--<td colspan="4"><input class="blue" type="submit" name="action" value="run"/></td>--%>
            <a href="/method/action/save}">save</a><br>
            <a href="/method/action/run}">run</a><br>
        </tr>
    </table>
</form>
</body>
</html>