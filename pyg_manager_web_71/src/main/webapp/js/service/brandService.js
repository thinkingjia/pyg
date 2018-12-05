app.service("brandService",function ($http) {
    this.findAll = function () {
        return $http.get('../brand/findAll');
    }
    this.findPage = function (page,size) {
        return $http.get('../brand/findPage/'+page+'/'+size);
    }
    this.save = function (brand) {
        return $http.post("../brand/save", brand);
    }
    this.edit = function (id) {
        return $http.get("../brand/edit/"+id);
    }
    this.delete = function (selectIds) {
        return $http.get("../brand/delete/"+selectIds)
    }

})