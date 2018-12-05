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
    <title>内置服务</title>
    <script src="../../plugins/angularjs/angular.min.js"></script>
    <script>

        var app = angular.module('testApp',[]);
        app.controller('myController', function ($scope, $http) {
           $http.get('./test.json').success(function (res) {

               $scope.testArr = res;
           });

        })
    </script>
</head>
<body ng-app="testApp" ng-controller="myController" >
    <table>
        <thead>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>数学</th>
            <th>语文</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="people in testArr">
            <td>{{$index+1}}</td>
            <td>{{people.name}}</td>
            <td>{{people.shuxue}}</td>
            <td>{{people.yuwen}}</td>
        </tr>
        </tbody>
    </table>


</body>
</html>
