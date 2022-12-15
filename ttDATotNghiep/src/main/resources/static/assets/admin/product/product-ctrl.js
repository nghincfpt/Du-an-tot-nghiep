angular.module("product-app", ["product-app.controllers"]);
 
angular 
.module("product-app.controllers", [])
.controller("product-ctrl",function($scope,$http){
	

	$scope.items=[];
	$scope.cates=[];
	$scope.form={};
	
	$scope.initialize=function(){
	// load product
	$http.get("/rest/products").then(resp =>{
		$scope.items=resp.data;
		$scope.items.forEach(item =>{
			item.createDate = new Date(item.createDate) // chuyển dữ liệu ngày tháng về javascrip
		})
	});
	//load category
	
	$http.get("/rest/categories").then(resp =>{
		$scope.cates=resp.data;
		
	});
	}
	
	// khởi đầu
	$scope.initialize();
	
	//xóa form
	$scope.reset=function(){
			$scope.form={
				createDate :new Date(),
				images:'cloud-upload.jpg',
				available:true,
				
			};
	}
	
	//hiển thị lên form
	 // ràng buộc duwx liệu  =ng-model="form.name"
	$scope.edit = function(item){
		$scope.form=angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
	}
	// thêm sản phẩm mới
	$scope.create =function(){
		var item =angular.copy($scope.form);
		$http.post(`/rest/products`,item).then(resp =>{
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm mới sản phẩm thành công!")
		}).catch(error =>{
			alert("Lỗi thêm mới sản phẩm!");
			console.log("Error",error);
		});
		
	}
	// cập nhật sản phẩm
	$scope.update=function(){
		var item =angular.copy($scope.form);
		$http.put(`/rest/products/${item.id}`,item).then(resp =>{
			var index =$scope.items.findIndex(p => p.id ==item.id);
			 
			 $scope.items[index]=item;
			alert("cập nhật  sản phẩm thành công!")
		}).catch(error =>{
			alert("cập nhật sản phẩm thất bại");
			console.log("Error",error);
		});
		
	}
	// xóa sản phẩm
	$scope.delete=function(item){
		//var item =angular.copy($scope.form);
		console.log(item);
		console.log('----------');
		$http.delete(`/rest/products/${item.id}`).then(resp =>{
			var index =$scope.items.findIndex(p => p.id ==item.id);
			  // dùng SPICE để xóa sản phẩm
			 $scope.items.splice(index,1);
			$scope.reset();
			alert("xóa sản phẩm thành công!")
		}).catch(error =>{
			alert("xóa sản phẩm thất bại");
			console.log("Error",error);
		});
		
	}
	//upload hình
	$scope.imageChanged= function(files){
		
		var data= new FormData();
		data.append('file',files[0]);
		$http.post('/rest/upload/images',data,{
			transformRequest:angular.identity,
			headers:{'Content-Type':undefined}
			// upload thành công thì thế vào data đó
	   	}).then(resp =>{
		$scope.form.image = resp.data.name;
	}).catch(error =>{
			alert(" lỗi upload hình ảnh");
			console.log("Error",error);
		})
	}
	
	
	
	$scope.pager={
		page:0,
		size:10,
		get items(){
			var start=this.page*this.size;
		return $scope.items.slice(start,start+this.size);
		},
		get count(){
		return Math.ceil(1.0*$scope.items.length/this.size);
		
	},
	
	first(){
		this.page=0;
	},
	prev(){
		this.page--;
		if(this.page <0){
			this.last();
		}
	},
	next(){
		this.page++;
		if(this.page >= this.count){
			this.first();
		}
	},
	last(){
		this.page = this.count -1;
	}
	}
	
});