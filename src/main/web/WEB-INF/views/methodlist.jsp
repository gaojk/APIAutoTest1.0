<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>try u best</title>
    <link rel="icon" href="/img/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="/img/favicon.ico" type="image/x-icon">
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
        .mt20 {
            margin-top: 20px;
        }
        .ofh{
            overflow: hidden;
        }
        .input-box{
            position: fixed;
            right: 100px;
            top: 46%;
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
            margin: 10px;
        }
        .main-con{
            width: 800px;
            margin: 20px auto;
        }
        .box-con .box{
            width: 33.33%;
            float: left;
        }
        .box-con textarea{
            height: 200px;
            width: 90%;
            border: 1px solid green;
            padding: 10px;
        }
        .highLight{
            color: red;
            font-weight:bold;
            border:3px solid red !important;
        }
    </style>
    <script>

        //Json格式化
        var formatJson = function(json, options) {
            var reg = null,
                formatted = '',
                pad = 0,
                PADDING = '    '; // one can also use '\t' or a different number of spaces
            // optional settings
            options = options || {};
            // remove newline where '{' or '[' follows ':'
            options.newlineAfterColonIfBeforeBraceOrBracket = (options.newlineAfterColonIfBeforeBraceOrBracket === true) ? true : false;
            // use a space after a colon
            options.spaceAfterColon = (options.spaceAfterColon === false) ? false : true;
            // begin formatting...
            // make sure we start with the JSON as a string
            if (typeof json !== 'string') {
                json = JSON.stringify(json);
            }
            // parse and stringify in order to remove extra whitespace
            json = JSON.parse(json);
            json = JSON.stringify(json);
            // add newline before and after curly braces
            reg = /([\{\}])/g;
            json = json.replace(reg, '\r\n$1\r\n');
            // add newline before and after square brackets
            reg = /([\[\]])/g;
            json = json.replace(reg, '\r\n$1\r\n');
            // add newline after comma
            reg = /(\,)/g;
            json = json.replace(reg, '$1\r\n');
            // remove multiple newlines
            reg = /(\r\n\r\n)/g;
            json = json.replace(reg, '\r\n');
            // remove newlines before commas
            reg = /\r\n\,/g;
            json = json.replace(reg, ',');
            // optional formatting...
            if (!options.newlineAfterColonIfBeforeBraceOrBracket) {
                reg = /\:\r\n\{/g;
                json = json.replace(reg, ':{');
                reg = /\:\r\n\[/g;
                json = json.replace(reg, ':[');
            }
            if (options.spaceAfterColon) {
                reg = /\:/g;
                json = json.replace(reg, ': ');
            }
            $.each(json.split('\r\n'), function(index, node) {
                var i = 0,
                    indent = 0,
                    padding = '';
                if (node.match(/\{$/) || node.match(/\[$/)) {
                    indent = 1;
                } else if (node.match(/\}/) || node.match(/\]/)) {
                    if (pad !== 0) {
                        pad -= 1;
                    }
                } else {
                    indent = 0;
                }
                for (i = 0; i < pad; i++) {
                    padding += PADDING;
                }
                formatted += padding + node + '\r\n';
                pad += indent;
            });
            return formatted;
        };

        //base64加密
        ;(function($) {

            var b64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/",
                a256 = '',
                r64 = [256],
                r256 = [256],
                i = 0;

            var UTF8 = {

                /**
                 * Encode multi-byte Unicode string into utf-8 multiple single-byte characters
                 * (BMP / basic multilingual plane only)
                 *
                 * Chars in range U+0080 - U+07FF are encoded in 2 chars, U+0800 - U+FFFF in 3 chars
                 *
                 * @param {String} strUni Unicode string to be encoded as UTF-8
                 * @returns {String} encoded string
                 */
                encode: function(strUni) {
                    // use regular expressions & String.replace callback function for better efficiency
                    // than procedural approaches
                    var strUtf = strUni.replace(/[\u0080-\u07ff]/g, // U+0080 - U+07FF => 2 bytes 110yyyyy, 10zzzzzz
                        function(c) {
                            var cc = c.charCodeAt(0);
                            return String.fromCharCode(0xc0 | cc >> 6, 0x80 | cc & 0x3f);
                        })
                        .replace(/[\u0800-\uffff]/g, // U+0800 - U+FFFF => 3 bytes 1110xxxx, 10yyyyyy, 10zzzzzz
                            function(c) {
                                var cc = c.charCodeAt(0);
                                return String.fromCharCode(0xe0 | cc >> 12, 0x80 | cc >> 6 & 0x3F, 0x80 | cc & 0x3f);
                            });
                    return strUtf;
                },

                /**
                 * Decode utf-8 encoded string back into multi-byte Unicode characters
                 *
                 * @param {String} strUtf UTF-8 string to be decoded back to Unicode
                 * @returns {String} decoded string
                 */
                decode: function(strUtf) {
                    // note: decode 3-byte chars first as decoded 2-byte strings could appear to be 3-byte char!
                    var strUni = strUtf.replace(/[\u00e0-\u00ef][\u0080-\u00bf][\u0080-\u00bf]/g, // 3-byte chars
                        function(c) { // (note parentheses for precence)
                            var cc = ((c.charCodeAt(0) & 0x0f) << 12) | ((c.charCodeAt(1) & 0x3f) << 6) | (c.charCodeAt(2) & 0x3f);
                            return String.fromCharCode(cc);
                        })
                        .replace(/[\u00c0-\u00df][\u0080-\u00bf]/g, // 2-byte chars
                            function(c) { // (note parentheses for precence)
                                var cc = (c.charCodeAt(0) & 0x1f) << 6 | c.charCodeAt(1) & 0x3f;
                                return String.fromCharCode(cc);
                            });
                    return strUni;
                }
            };

            while(i < 256) {
                var c = String.fromCharCode(i);
                a256 += c;
                r256[i] = i;
                r64[i] = b64.indexOf(c);
                ++i;
            }

            function code(s, discard, alpha, beta, w1, w2) {
                s = String(s);
                var buffer = 0,
                    i = 0,
                    length = s.length,
                    result = '',
                    bitsInBuffer = 0;

                while(i < length) {
                    var c = s.charCodeAt(i);
                    c = c < 256 ? alpha[c] : -1;

                    buffer = (buffer << w1) + c;
                    bitsInBuffer += w1;

                    while(bitsInBuffer >= w2) {
                        bitsInBuffer -= w2;
                        var tmp = buffer >> bitsInBuffer;
                        result += beta.charAt(tmp);
                        buffer ^= tmp << bitsInBuffer;
                    }
                    ++i;
                }
                if(!discard && bitsInBuffer > 0) result += beta.charAt(buffer << (w2 - bitsInBuffer));
                return result;
            }

            var Plugin = $.base64 = function(dir, input, encode) {
                return input ? Plugin[dir](input, encode) : dir ? null : this;
            };

            Plugin.btoa = Plugin.encode = function(plain, utf8encode) {
                plain = Plugin.raw === false || Plugin.utf8encode || utf8encode ? UTF8.encode(plain) : plain;
                plain = code(plain, false, r256, b64, 8, 6);
                return plain + '===='.slice((plain.length % 4) || 4);
            };

            Plugin.atob = Plugin.decode = function(coded, utf8decode) {
                coded = coded.replace(/[^A-Za-z0-9\+\/\=]/g, "");
                coded = String(coded).split('=');
                var i = coded.length;
                do {--i;
                    coded[i] = code(coded[i], true, r64, a256, 6, 8);
                } while (i > 0);
                coded = coded.join('');
                return Plugin.raw === false || Plugin.utf8decode || utf8decode ? UTF8.decode(coded) : coded;
            };
        }(jQuery));

        //页面加载时直接格式化testcase文本框数据
        $(function(){
            $("textarea[id^='testcases_']").each(function(index){
                // console.log($(this).text());
                var formatJsonString = $(this).text()==''?'':formatJson($(this).text());
                $(this).text(formatJsonString);
            });
        });

        //判断是否是Json串
        function isJSON(str) {
            if (typeof str == 'string') {
                try {
                    var obj=JSON.parse(str);
                    if(typeof obj == 'object' && obj ){
                        return true;
                    }else{
                        return false;
                    }

                } catch(e) {
                    console.log('error：'+str+'!!!'+e);
                    return false;
                }
            }
            return false;
        }

        //运行
        function run()
        {

            if($('#env').val() == "0" )
            {
                alert("请选择运行环境");
                return false;
            }


            if($('#port').val() == "0" && $('#env').val() == "QA")
            {
                alert("请选择端口");
                return false;

            }

            if($('#appid').val() == "0")
            {
                alert("请选择供应商");
                return false;
            }

            if($("input[name='selectedmethod']:checked").length==0){
                alert("请勾选要运行的API");
                return false;
            }

            var selectedmethodlist = [];
            $("input[name='selectedmethod']:checked").each(function(i){
                selectedmethodlist[i] =$(this).val();
            });

            $.ajax({
                url:"/method/action/run",
                type:"POST",
                data: {
                    "selectedmethod":selectedmethodlist,
                    "env":$('#env').val(),
                    "port":$('#port').val(),
                    "appid":$('#appid').val()
                },
                dataType:"json",
                success:function(data)
                {
                    for(key in data){
                        if(isJSON(data[key])){
                            var jsonFormat = formatJson(data[key]);
                            $('#results_'+key).text(jsonFormat)
                        }
                        else {
                            $('#results_'+key).text(data[key])
                        }
                    }
                },
                error:function(data)
                {
                    for(key in data){
                        $('#results_'+key).val('运行失败，请检查入参。')
                    }
                }
            });
        }

        //保存
        function save()
        {
            if($("input[name='selectedmethod']:checked").length==0){
                alert("请勾选要保存的API");
                return false;
            }

            var selectedcaselist = [];
            $("input[name='selectedmethod']:checked").each(function(i){
                var tmp = {};
                tmp.id=$(this).val();
                var param= $('#testcases_'+$(this).val()).val();
                tmp.param=param.replace(/[\ \r\n]/g,"");
                if(!isJSON(tmp.param)){
                    $('#testcases_'+$(this).val()).addClass('highLight');
                }else{
                    selectedcaselist.push($.base64.encode(JSON.stringify(tmp),'utf-8'));
                }

            });

            $.ajax({
                url:"/method/action/save",
                type:"POST",
                data: {
                    "selectedcase":selectedcaselist
                },
                dataType:"json",
                beforeSend:function(xhr)
                {
                    if(selectedcaselist.length==0){
                        alert("所勾选的API无可执行用例，请输入并保存用例！")
                        return false;
                    }
                    return true;
                },
                success:function(data)
                {
                    for(key in data){
                        var jsonFormat = formatJson(data[key]);
                        $('#testcases_'+key).val(jsonFormat);
                    }
                },
                error:function(data)
                {
                    for(key in data){
                        $('#results_'+key).val('运行失败，请检查入参。')
                    }
                }
            });
        }

    </script>
</head>
<body>
<form  action="/method" method="post" class="main-con">
    <div class="box-con ofh">
        <div class="box">
            <label>环境：</label>
            <select id="env">
                <option value="0">--请选择--</option>
                <option value="QA">QA</option>
                <option value="PRE">PRE</option>
                <option value="PRDTEST">PRDTEST</option>
            </select>
        </div>
        <div class="box">
            <label>端口：</label>
            <select id="port">
                <option value="0">--请选择--</option>
                <option value="8000">8000</option>
                <option value="8001">8001</option>
                <option value="8003">8003</option>
                <option value="8005">8005</option>
            </select>
        </div>
        <div class="box">
            <label>供应商：</label>
            <select id="appid">
                <option value="0">--请选择--</option>
                <c:choose>
                    <c:when test="${empty requestScope.apps  || fn:length(requestScope.apps) == 0}">
                        请联系管理员初始化App。
                    </c:when>
                    <c:otherwise>
                        <c:forEach items="${requestScope.apps}" var="item3">
                            <option value="${item3.sysno}">${item3.supplier}</option>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </select>
        </div>
    </div>
    <div>
        <c:choose>
            <c:when test="${empty requestScope.methods  || fn:length(requestScope.methods) == 0}">
                <div class="mt20">
                    请联系管理员初始化OpenAPI方法。
                </div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${requestScope.methods}" var="item1">
                    <div class="box-con mt20 ofh">

                        <!--加载复选框与方法名-->
                        <div class="box">
                            <input type="checkbox" name="selectedmethod" value="${item1.sysno}">
                            ${item1.method}
                        </div>

                        <!--加载case-->
                        <div class="box">
                            <c:choose>
                                <c:when test="${empty requestScope.testcases  || fn:length(testcases[item1.sysno]) == 0}">
                                    <textarea id="testcases_${item1.sysno}" name="testcases"></textarea>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${testcases[item1.sysno]}" var="item2">
                                        <textarea id="testcases_${item1.sysno}" name="testcases">${item2.content}</textarea>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </div>

                        <!--加载result-->
                        <div class="box">
                            <textarea id="results_${item1.sysno}" name="results">运行结果</textarea>
                        </div>

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