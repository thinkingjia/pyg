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
    <title>循环对象数组指令</title>
    <script src="../../plugins/angularjs/angular.min.js"></script>
    <script>

        var app = angular.module('testApp',[]);
        app.controller('myController', function ($scope) {
           $scope.testArr = [
               {id:'001', name:'马蓉', telphone:'13838389438'},
               {id:'002', name:'宝宝', telphone:'18888888888'},
               {id:'003', name:'宋吉吉', telphone:'13838389438'},
           ];

        })
    </script>
</head>
<body ng-app="testApp" ng-controller="myController" >
    <table>
        <thead>
        <tr>
            <th>编号</th>
            <th>主键</th>
            <th>姓名</th>
            <th>电话</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="people in testArr">
            <td>{{$index+1}}</td>
            <td>{{people.id}}</td>
            <td>{{people.name}}</td>
            <td>{{people.telphone}}</td>
        </tr>
        </tbody>
    </table>


</body>
</html>
