<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<html>
<head>
    <title>首页</title>
    <base href="<%=basePath%>">
</head>
<body>
    <center>
        <p><a href="addStudent.jsp">注册学生</a></p>
        <p><a href="findStudent.jsp">查询学生</a></p>
    </center>

</body>
</html>
