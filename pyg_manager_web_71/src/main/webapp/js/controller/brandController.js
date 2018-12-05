app.controller('brandController', function ($scope, $http,brandService,$controller) {
    $controller("baseController",{$scope:$scope});

    $scope.findAll = function () {
        brandService.findAll().success(function (res) {
            $scope.list = res;

        })

    }

    $scope.findPage=function(page,size){
        brandService.findPage(page,size).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );

    }

    $scope.save = function () {
        if (null != $scope.brand.id){
            //是修改更新
            var result = confirm("确认保存修改吗?");
            if (result){
                brandService.save($scope.brand).success(function (res) {
                    if(res.success){
                        alert(res.message);
                        $scope.reloadList();
                    }else {
                        alert(res.message);
                    }
                })
            }
        }else {
            //是保存新建
            brandService.save($scope.brand).success(function (res) {
                if(res.success){
                    alert(res.message);
                    $scope.reloadList();
                }else {
                    alert(res.message);
                }
            })
        }
    }
    $scope.edit = function (id) {
        brandService.edit(id).success(function (res) {
            $scope.brand = res;

        })

    }

    $scope.delete = function () {
        var result = confirm("确认删除选中的数据吗？");
        if (result){
            brandService.delete($scope.selectIds).success(function (res) {
                alert(res.message);
                if (res.success){
                    $scope.reloadList();
                }
            })
        }
    }

})