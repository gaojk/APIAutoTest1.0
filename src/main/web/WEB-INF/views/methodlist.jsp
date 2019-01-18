<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
        a {
            color: white;
            font-size: 30px;
            width:100px;
            text-align: center;
        }
        .input-box{
            width: 100%;
            height: auto;
            margin-bottom: 20px;
            text-align: center;
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
    <script>
        function run()
        {
            var selectedmethodlist = {};

            $("input[name='selectedmethod']:checked").each(function(i){
                selectedmethodlist[i] =$(this).val();
                });

            $.ajax({
                    url:"/method/action/run",
                    type:"POST",
                    data: {
                        "selectedmethod":selectedmethodlist,
                        "env":$('#env').val(),
                        "port":$('#port').val()
                    },
                    dataType:"text",
                    success:function(data)
                    {
                        $('#results').val(data)

                    },
                    error:function()
                    {
                        $('#results').val('运行失败，请检查入参。')
                    }
            });


        }

        function save()
        {

        }
    </script>
</head>
<body>
<form  action="/method" method="post">
    <div>
        <div><label>环境：</label></div>
        <div>
            <select id="env">
                <option>--请选择--</option>
                <option value="QA" selected="selected">QA</option>
                <option value="PRDtest">PRDtest</option>
                <option value="PRD">PRD</option>
            </select>
        </div>
        <div><label>端口：</label></div>
        <div>
            <select id="port">
                <option>--请选择--</option>
                <option value="8000" selected="selected">8000</option>
                <option value="8001">8001</option>
                <option value="8003">8003</option>
                <option value="8005">8005</option>
            </select>
        </div>
    </div>
    <div>
        <c:choose>
            <c:when test="${empty requestScope.methods  || fn:length(requestScope.methods) == 0}">
                请联系管理员初始化OpenAPI方法。
            </c:when>
            <c:otherwise>
                <c:forEach items="${requestScope.methods}" var="item1">
                    <div>
                        <!--加载复选框-->
                        <div><input type="checkbox" name="selectedmethod" value="${item1.sysno}"></div>
                        <!--加载方法名-->
                        <div>${item1.method}</div>
                        <!--加载数据与结果-->
                        <c:forEach items="${testcases[item1.sysno]}" var="item2">
                            <div><textarea id="testcases" name="testcases">${item2.content}</textarea></div>
                            <div><textarea id="results" name="results">运行结果</textarea></div>
                        </c:forEach>
                    </div>
                </c:forEach>
            </c:otherwise>
        </c:choose>
        <div class="input-box">
            <div><input class="btn" type="button" value="save" onclick="save()"/></div>
            <div><input class="btn" type="button" value="run" onclick="run()"/></div>
        </div>
    </div>
</form>
</body>
</html>