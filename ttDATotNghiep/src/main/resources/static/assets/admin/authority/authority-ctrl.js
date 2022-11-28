app.controller("authority-ctrl", function($scope, $http, $location) {
	$scope.roles=[];
	$scope.admins=[];
	$scope.authorities=[];
	$scope.form={};

$scope.initialize=function(){

	//load all roles
	$http.get("/rest/roles").then(resp => {
		$scope.roles = resp.data;
	})

	//load cust staffs and directors(administrators)
	$http.get("/rest/accounts?admin=true").then(resp => {
		$scope.admins = resp.data;
	})


	// các quyền load dữ liệu authorites of staff and directors
	$http.get("/rest/authorities?admin=true").then(resp => {
		$scope.authorities = resp.data;
	}).catch(error => {
		$location.path("/unauthorized");
	})
	// tìm thấy thì nó check lên
	$scope.authority_of=function(acc,role){
		if($scope.authorities){
			return $scope.authorities.find(ur => ur.account.username == acc.username && ur.role.id==role.id);
			
		}
	}
	$scope.authority_changed=function(acc,role){
		
		var authority =$scope.authority_of(acc,role);
		if(authority){// đã cấp quyền => thu hồi quyền (xóa)
		$scope.revoke_authority(authority);	
		}else{//chưa đc cấp quyền => cấp quyền( thêm  mới)
			authority = {account:acc,role:role};
			$scope.gran_authority(authority);
		}
	}
	}
	// thêm mới authority =gran_authority
	
	$scope.gran_authority = function(authority){
		$http.post(`/rest/authorities`,authority).then(resp =>{
			$scope.authorities.push(resp.data)
			alert("Cấp quyền sủ dụng thành công");
		}).catch(error =>{
			alert("Cấp quyền sữ dụng thất bại");
			console.log("Error",error);
		})
	}
	// xóa authority = revo_keauthority
	$scope.revoke_authority = function(authority){
		$http.delete(`/rest/authorities/${authority.id}`).then(resp=>{
			var index=$scope.authorities.findIndex(a => a.id==authority.id);
			$scope.authorities.splice(index,1);
			alert("Thu hồi quyền sữ sụng thành công");
		}).catch(error =>{
			alert("Thu hồi quyền sữ dụng thất bại");
			console.log("Error",error);
		})
		
	}
	//hiển thị lên form
	 // ràng buộc duwx liệu  =ng-model="form.name"
	$scope.edit = function(item){
		$scope.form=angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show')
	}
		// thêm tài khoản mới
	$scope.create =function(){
		var item =angular.copy($scope.form);
		$http.post(`/rest/accounts`,item).then(resp =>{
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm mới tài khoản thành công!")
		}).catch(error =>{
			alert("Lỗi thêm mới sản phẩm!");
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
		return Math.ceil(1.0*$scope.authorities.admins.length/this.size);
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
	
	$scope.initialize();
	
}
);
