app.controller('specificationController', function ($scope, $http,specificationService,$controller) {
    $controller("baseController",{$scope:$scope});

    $scope.findAll = function () {
        specificationService.findAll().success(function (res) {
            $scope.list = res;

        })

    }

    $scope.findPage=function(page,size){
        specificationService.findPage(page,size).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );

    }

    $scope.save = function () {
        specificationService.save($scope.specification).success(function (res) {
            if(res.success){
                alert(res.message);
                $scope.reloadList();
            }else {
                alert(res.message);
            }
        })

    }
    $scope.edit = function (id) {
        specificationService.edit(id).success(function (res) {
            $scope.specification = res;

        })

    }

    $scope.delete = function () {
        var result = confirm("确认要删除选中的条目吗？");
        if (result){
            specificationService.delete($scope.selectIds).success(function (res) {
                alert(res.message);
                if (res.success){
                    $scope.reloadList();
                }
            })
        }
    }

    $scope.specification = {spec:{},optionList:[]};
    $scope.insertRow = function () {
        $scope.specification.optionList.push({});
    }

    $scope.deleteRow = function (index) {
        $scope.specification.optionList.splice(index,1);
    }


})