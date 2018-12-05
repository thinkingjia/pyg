<%--
  Created by IntelliJ IDEA.
  User: 上好佳
  Date: 2018/11/27
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>2双向绑定</title>
    <script src="../../plugins/angularjs/angular.min.js"></script>
</head>
<body ng-app>
    姓名<input type="text" ng-model="username"/>
    <br/>
    您输入的姓名是{{username}}

</body>
</html>
