angular.module("manufactures-app", ["manufactures-app.controllers"]);
 
angular 
.module("manufactures-app.controllers", [])
.controller("manufactures-ctrl",function($scope,$http){
	


	$scope.Manus=[];
	$scope.form={};
	
	$scope.initialize=function(){
	// load nha san xuat
	//goi toi rest manufactureController
	$http.get("/rest/manufacture").then(resp =>{
		$scope.Manus=resp.data;
		$scope.Manus.forEach(manu =>{
			manu.createDate = new Date(manu.createDate) // chuyển dữ liệu ngày tháng về javascrip
		})
	});
	
	
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
		$scope.edit = function(manu){
		$scope.form=angular.copy(manu);
		$(".nav-tabs a:eq(0)").tab('show')
	}
	// thêm nha san xuat
	$scope.create =function(){
		var manu =angular.copy($scope.form);
		$http.post(`/rest/manufacture`,manu).then(resp =>{
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.cates.push(resp.data);
			$scope.reset();
			alert("Thêm mới nhà sản xuất thành công!")
		}).catch(error =>{
			alert("Lỗi thêm mới nhà sản xuất!");
			console.log("Error",error);
		});
		
	}
	// cập nhap nha san xuat
	$scope.update=function(){
		var manu =angular.copy($scope.form);
		$http.put(`/rest/manufacture/${manu.id}`,manu).then(resp =>{
			var index =$scope.Manus.findIndex(c => c.id ==manu.id);
			 
			 $scope.Manus[index]=manu;
			alert("cập nhật nhà sản xuất thành công!")
		}).catch(error =>{
			alert("cập nhật nhà sản xuất thất bại");
			console.log("Error",error);
		});
		
	}
	// xóa nha san xuat
	$scope.delete=function(manu){
		//var item =angular.copy($scope.form);
		console.log(manu);
		console.log('----------');
		$http.delete(`/rest/manufacture/${manu.id}`).then(resp =>{
			var index =$scope.Manus.findIndex(p => p.id ==manu.id);
			  // dùng SPICE để xóa sản phẩm
			 $scope.Manus.splice(index,1);
			$scope.reset();
			alert("xóa nhà sản xuất thành công!")
		}).catch(error =>{
			alert("xóa nhà sản xuất thất bại");
			console.log("Error",error);
		});
		
	}
	
	
	// phan trang 
	$scope.pager={
		page:0,
		size:10,
		get Manus(){
			var start=this.page*this.size;
		return $scope.Manus.slice(start,start+this.size);
		},
		get count(){
		return Math.ceil(1.0*$scope.Manus.length/this.size);
		
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
}});