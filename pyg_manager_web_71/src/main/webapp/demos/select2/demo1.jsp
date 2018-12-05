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
    <title>多选下拉框</title>
    <link rel="stylesheet" href="../../plugins/select2/select2.css" />
    <link rel="stylesheet" href="../../plugins/select2/select2-bootstrap.css"/>
    <script src="../../plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="../../plugins/angularjs/angular.min.js"></script>
    <script src="../../plugins/select2/select2.min.js"></script>
    <script>
        var app = angular.module('pyg',[]);
        app.controller('myController', function($scope){
            $scope.brandList = {data:[{id:1,  text:'联想'},{id:2, text:'中兴'}]};
        })
    </script>
    <script src="../../plugins/select2/angular-select2.js"></script>

</head>
<body ng-app="pyg" ng-controller="myController">
<input select2 select2-model="entity.brandIds" config="brandList"  multiple  style="width:200px" type="text" class="form-control" placeholder="选择品牌（可多选）"/>
</body>
</html>
