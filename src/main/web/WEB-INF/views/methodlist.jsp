<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css">

        body{
            font: 18px/1.5 Tahoma,Helvetica,Arial,'宋体',sans-serif;
        }
        /* Normal white Button as seen on Google.com*/
        button {
            color: #444444;
            background: #F3F3F3;
            border: 1px #DADADA solid;
            padding: 5px 10px;
            border-radius: 2px;
            font-weight: bold;
            font-size: 9pt;
            outline: none;
        }

        button:hover {
            border: 1px #C6C6C6 solid;
            box-shadow: 1px 1px 1px #EAEAEA;
            color: #333333;
            background: #F7F7F7;
        }

        button:active {
            box-shadow: inset 1px 1px 1px #DFDFDF;
        }

        /* Blue button as seen on translate.google.com*/
        button.blue {
            color: white;
            background: #4C8FFB;
            border: 1px #3079ED solid;
            box-shadow: inset 0 1px 0 #80B0FB;
        }

        button.blue:hover {
            border: 1px #2F5BB7 solid;
            box-shadow: 0 1px 1px #EAEAEA, inset 0 1px 0 #5A94F1;
            background: #3F83F1;
        }

        button.blue:active {
            box-shadow: inset 0 2px 5px #2370FE;
        }

        /* Orange button as seen on blogger.com*/
        button.orange {
            color: white;
            border: 1px solid #FB8F3D;
            background: -webkit-linear-gradient(top, #FDA251, #FB8F3D);
            background: -moz-linear-gradient(top, #FDA251, #FB8F3D);
            background: -ms-linear-gradient(top, #FDA251, #FB8F3D);
        }

        button.orange:hover {
            border: 1px solid #EB5200;
            background: -webkit-linear-gradient(top, #FD924C, #F9760B);
            background: -moz-linear-gradient(top, #FD924C, #F9760B);
            background: -ms-linear-gradient(top, #FD924C, #F9760B);
            box-shadow: 0 1px #EFEFEF;
        }

        button.orange:active {
            box-shadow: inset 0 1px 1px rgba(0,0,0,0.3);
        }

        /* Red Google Button as seen on drive.google.com */
        button.red {
            background: -webkit-linear-gradient(top, #DD4B39, #D14836);
            background: -moz-linear-gradient(top, #DD4B39, #D14836);
            background: -ms-linear-gradient(top, #DD4B39, #D14836);
            border: 1px solid #DD4B39;
            color: white;
            text-shadow: 0 1px 0 #C04131;
        }

        button.red:hover {
            background: -webkit-linear-gradient(top, #DD4B39, #C53727);
            background: -moz-linear-gradient(top, #DD4B39, #C53727);
            background: -ms-linear-gradient(top, #DD4B39, #C53727);
            border: 1px solid #AF301F;
        }

        button.red:active {
            box-shadow: inset 0 1px 1px rgba(0,0,0,0.2);
            background: -webkit-linear-gradient(top, #D74736, #AD2719);
            background: -moz-linear-gradient(top, #D74736, #AD2719);
            background: -ms-linear-gradient(top, #D74736, #AD2719);
        }

        select {
            /*Chrome和Firefox里面的边框是不一样的，所以复写了一下*/
            border: solid 1px #000;

            /*很关键：将默认的select选择框样式清除*/
            appearance:none;
            -moz-appearance:none;
            -webkit-appearance:none;

            /*在选择框的最右侧中间显示小箭头图片*/
            background: url("https://raw.githubusercontent.com/ourjs/static/gh-pages/2015/arrow.png") no-repeat scroll right center transparent;


            /*为下拉小箭头留出一点位置，避免被文字覆盖*/
            padding-right: 14px;
        }
        /*清除ie的默认选择框样式清除，隐藏下拉箭头*/
        select::-ms-expand { display: none; }
    </style>
</head>
<body>
<form  action="/methods/excute_methods" method="post">
    <table>
        <tr>
            <td><label>环境：</label></td>
            <td>
                <select name="environment">
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
                            <%--<td><input type="checkbox" name="selectmethod" value="${item.sysno}@@${item.methodParams}"></td>--%>
                            <td><input type="checkbox" name="selectmethod" value="${item.sysno}></td>
                            <td>${item.method}</td>
                            <%--<td colspan="2"><textarea rows="3" cols="20">${item.methodParams}</textarea></td>--%>
                        </tr>
                    </c:forEach>
            </c:otherwise>
        </c:choose>
        <tr>
            <td colspan="4"><button class="blue" type="submit">运行</button></td>
        </tr>
    </table>
</form>
</body>
</html>