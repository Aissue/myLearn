<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ajax请求数据并渲染到页面</title>
    <style type="text/css">
        #test{
            width: 100%;
            padding: 2px;
            height: 1000px;
            border: 1px solid gainsboro;
            border-radius: 8px;
        }
        .inner {
            display: inline-block;
            padding: 20px;
            border: 1px solid gainsboro;
            text-align: center;
            margin-left: 20px;
            margin-bottom: 20px;
            border-radius: 8px;
        }
        .inner:hover{
            border: 1px solid deeppink;
        }
        .inner:hover h3{
            color: deeppink;
        }
        .inner img {
            width: 200px;
            height: 200px;
            font-size: 0;
        }

        h3,
        span {
            font-size: 20px;
        }
    </style>
</head>
<body>
    <div>
        <button onclick="copyText()">Click Me!</button>
    </div>
    <div id="test">

    </div>
</body>
</html>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript">
    function copyText(){
        $.ajax({
            type: "POST",
            url: "http://192.168.248.130/lua/a",
            data:{"id":1},
            //headers:{'username':'aissue','token':'1234567890'},
            beforeSend: function (xhr) {
                xhr.setRequestHeader("token", "1234567890");
                xhr.setRequestHeader("username", "aissue1");
            },
            success: function(res) {
                console.log(res);
                console.log(typeof(res));
                var str = '<h3>' + '返回数据：' + res + '</h3>';
                $("#test").append(str);
            }
        });
    }
    $(function() {

    });
</script>