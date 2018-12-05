app.service("specificationService",function ($http) {
    this.findAll = function () {
        return $http.get('../specification/findAll');
    }
    this.findPage = function (page,size) {
        return $http.get('../specification/findPage/'+page+'/'+size);
    }
    this.save = function (specification) {
        return $http.post("../specification/save", specification);
    }
    this.edit = function (id) {
        return $http.get("../specification/edit/"+id);
    }
    this.delete = function (selectIds) {
        return $http.get("../specification/delete/"+selectIds)
    }

})