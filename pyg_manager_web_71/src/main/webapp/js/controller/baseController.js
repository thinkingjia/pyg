app.controller("baseController",function ($scope,$http) {

    // 分页控件配置
    // currentPage：当前页；totalItems：总记录数；itemsPerPage：每页记录数；perPageOptions：分页选项；onChange：当页码变更后自动触发的方法
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };

    //重新加载列表 数据
    $scope.reloadList = function () {
        //切换页码
        $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }

    //在数组中把复选框选中的信息添加或删除
    $scope.selectIds = [];
    $scope.selectOption = function ($event,id) {
        if ($event.target.checked){
            $scope.selectIds.push(id);
        }else {
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index,1);
        }
    }
    //将json串中指定的key的值取出，并拼接成字符串返回
    $scope.jsonToString = function (jsonStr,key) {
        var jsonArr = JSON.parse(jsonStr);
        var tempArr = new Array();
        for(var i=0;i<jsonArr.length;i++){
            tempArr.push(jsonArr[i][key]);
        }
        return tempArr.join(',');
    }


})