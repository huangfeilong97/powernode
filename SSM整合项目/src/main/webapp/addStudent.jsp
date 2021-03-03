<%--
  Created by IntelliJ IDEA.
  User: 黄飞龙
  Date: 2021/3/3
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>添加学生</title>
    <base href="<%=basePath%>">
    <%--<script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").click(function add() {

                $.ajax({
                    url:"student/addStudent",
                    type:"get",
                    data:{
                        name:$("#name").val(),
                        email:$("#email").val(),
                        age:$("#age").val()

                    },
                    dataType:"json",
                    success:function (data) {

                    }
                })
            })
        })

    </script>--%>
</head>
<body>
    <p>注册学生</p>
    <form action="student/addStudent">
        <table>
            <tr>
                <td>学生姓名:</td>
                <td>
                    <input type="text" name="name" id="name">
                </td>
            </tr>
            <tr>
                <td>学生邮箱:</td>
                <td>
                    <input type="email" name="email" id="email">
                </td>
            </tr>
            <tr>
                <td>学生年龄:</td>
                <td>
                    <input type="text" name="age" id="age">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" id="btn" value="注册">
                </td>
            </tr>
        </table>
    </form>


</body>
</html>
