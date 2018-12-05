 //控制层 
app.controller('itemCatController' ,function($scope,$controller   ,itemCatService){	
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		itemCatService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		itemCatService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		itemCatService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=itemCatService.update( $scope.entity ); //修改  
		}else{
            //$scope.entity.parentId = $scope.parentId;
			serviceObject=itemCatService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
                    $scope.reloadList();//重新加载
					//$scope.findByParentId($scope.parentId);
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		itemCatService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		itemCatService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

	$scope.findByParentId = function (parentId) {
        itemCatService.findByParentId(parentId).success(function (res) {
			$scope.itemCatList = res;
        })
		
    }

    $scope.parentItemShow = '顶级分类';//新增界面，上级分类变量
    //定义两个变量，分别保存一级目录和二级目录的对象
    $scope.item_01 = {};
    $scope.item_02 = {};

    //$scope.parentId = 0;//设定默认parentId

    //二级或三级目录查询
	$scope.grade = 1;//记录当前级别，默认1级
    $scope.selectNext = function (item) {
		if (1 == $scope.grade){
            //1.如果grade=1,默认一级分类，item_01 = {},item_02 = {}
            $scope.item_01 = {};
            $scope.item_02 = {};
            $scope.parentItemShow = '顶级分类';
           // $scope.parentId = 0;
		}else if (2 == $scope.grade){
            //2.如果grade=2,默认二级分类，item_01 = item,item_02 = {}
            $scope.item_01 = item;
            $scope.item_02 = {};
            $scope.parentItemShow = $scope.item_01.name;
            //$scope.parentId = item_01.id;
        }else if (3 == $scope.grade){
            //3.如果grade=3,默认三级分类，iitem_02 = item
            $scope.item_02 = item;
            $scope.parentItemShow = $scope.item_01.name + ">>" + $scope.item_02.name;
            //$scope.parentId = item_02.id;
        }
        itemCatService.findByParentId(item.id).success(function (res) {
            $scope.itemCatList = res;
        })

    }
    $scope.setGrade = function (grade) {
    	$scope.grade = grade;

    }

    //类型模板下拉框
    $scope.typeIdList = {data:[]};
    $scope.findtypeIdList = function (res) {
        itemCatService.findAll().success(function (res) {
            $scope.typeIdList.data = res;

        })
    }
    
});	
