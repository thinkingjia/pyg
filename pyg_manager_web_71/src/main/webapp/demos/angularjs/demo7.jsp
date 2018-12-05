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
    <title>循环数组指令</title>
    <script src="../../plugins/angularjs/angular.min.js"></script>
    <script>

        var app = angular.module('testApp',[]);
        app.controller('myController', function ($scope) {
           $scope.testArr = ['马蓉','宝宝','宋哲'];

        })
    </script>
</head>
<body ng-app="testApp" ng-controller="myController" >
    <ul>
        <li ng-repeat="name in testArr">
            {{name}}
        </li>
    </ul>


</body>
</html>
