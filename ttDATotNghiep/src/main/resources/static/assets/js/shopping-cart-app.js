const app= angular.module("shopping-cart-app",[]);

app.controller("shopping-cart-ctrl",function($scope,$http){

	
	/*
	*  quản lý dỏ hàng
	*/
	
	$scope.cart={
	items:[],
	//thêm vaod giỏ hàng
	add(id){
		 var item = this.items.find(item => item.id == id);
		 if(item){
			item.qty++;
			this.saveToLocalStorage();
		}else{
			$http.get(`/rest/products/${id}`).then(resp =>{
				resp.data.qty = 1 ;
				this.items.push(resp.data);
				this.saveToLocalStorage();
			})
		}
	},
	// xóa sản phẩm khỏi giỏ hàng
	remove(id){
		var index=this.items.findIndex(item => item.id ==id);
		 this.items.splice(index,1);
		 this.saveToLocalStorage();
		 	},
	//xóa sạch các mặt hàng trong giỏ
	clear(){
		this.items=[]
		this.saveToLocalStorage();
		
	},
	//tính thành tiền của 1 sản phẩm
	amt_of(item){},
	// tính tổng số lượng các mặt hàng trong gỏi
	get count(){
		return this.items
		.map(item => item.qty) // map để lấy quantity
		.reduce((total,qty)=>total +=qty,0);//reduce tính tổng
	},
	// tổng thành tiền các mặt hàng trong giỏ
	get amount(){
		return this.items
		.map(item => item.qty*item.price)
		.reduce((total,qty)=>total +=qty,0);
	},
	//lưu giỏ hàng vào local storege
	saveToLocalStorage(){
		//dùng json lưu xuống cho tên là cart
		var json = JSON.stringify(angular.copy(this.items));
		localStorage.setItem("cart",json);
	},
	//đọc giỏ hàng từ local storage
	loadFromLocalStorage(){
		var json=localStorage.getItem("cart");// độc lại trong locastore nếu có 
		this.items = json ? JSON.parse(json):[];// chuyển sảng ison và gián vào item
		
	}
	}
	$scope.cart.loadFromLocalStorage();
	
	 //  form đặt hàng
	$scope.order={
		createDate: new Date(),
		status:"",
		address:"",
		account:{username:$("#username").text()},
	   get	orderDetails(){
			return $scope.cart.items.map(item =>{
				return {
					product:{id:item.id},
					price:item.price,
					quantity :item.qty
				}
			});
		},
		purchase(){
			var order =angular.copy(this);
			// thực hiện đặt hàng
			console.log(order);
			$http.post("/rest/orders",order).then(resp => {
			alert(" Đặt hàng thành công!");
			$scope.cart.clear();
			location.href="/order/detail/" +resp.data.id;
		}).catch(error => {
			alert(" đặt hàng lỗi")
			
			console.log(error)
		})
		}
		}
		})
	
	
