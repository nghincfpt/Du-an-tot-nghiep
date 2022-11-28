app.controller("product-ctrl",function($scope,$http){
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
	$scope.edit = function(cate){
		$scope.form=angular.copy(cate);
		$(".nav-tabs a:eq(0)").tab('show')
	}
	// thêm sản phẩm mới
	$scope.create =function(){
		var cate =angular.copy($scope.form);
		$http.post(`/rest/categories`,cate).then(resp =>{
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.cates.push(resp.data);
			$scope.reset();
			alert("Thêm mới loại sản phẩm thành công!")
		}).catch(error =>{
			alert("Lỗi thêm mới loại sản phẩm!");
			console.log("Error",error);
		});
		
	}
	// cập nhật sản phẩm
	$scope.update=function(){
		var cate =angular.copy($scope.form);
		$http.put(`/rest/categories/${cate.id}`,cate).then(resp =>{
			var index =$scope.cates.findIndex(c => c.id ==cate.id);
			 
			 $scope.cates[index]=cate;
			alert("cập nhật thành công!")
		}).catch(error =>{
			alert("cập nhật thất bại");
			console.log("Error",error);
		});
		
	}
	// xóa sản phẩm
	$scope.delete=function(cate){
		//var item =angular.copy($scope.form);
		console.log(cate);
		console.log('----------');
		$http.delete(`/rest/categories/${cate.id}`).then(resp =>{
			var index =$scope.cates.findIndex(p => p.id ==cate.id);
			  // dùng SPICE để xóa sản phẩm
			 $scope.cates.splice(index,1);
			$scope.reset();
			alert("xóa sản phẩm thành công!")
		}).catch(error =>{
			alert("xóa sản phẩm thất bại");
			console.log("Error",error);
		});
		
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