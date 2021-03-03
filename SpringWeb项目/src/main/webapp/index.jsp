<%--
  Created by IntelliJ IDEA.
  User: 黄飞龙
  Date: 2021/3/2
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <form action="register" method="get">
        <table>
            <tr>
                <td>学生姓名</td>
                <td>
                    <input type="text" name="name" id="name"/>
                </td>
            </tr>
            <tr>
                <td>学生邮箱</td>
                <td>
                    <input type="email" name="email" id="email"/>
                </td>
            </tr>
            <tr>
                <td>学生年龄</td>
                <td>
                    <input type="text" name="age" id="age"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="注册">
                </td>
                <td>
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>


</body>
</html>
