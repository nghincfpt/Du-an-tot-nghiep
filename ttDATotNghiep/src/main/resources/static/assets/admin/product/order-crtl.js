// khai báo một module có tên là "orders-app" và có một module khác là "orders-app.controllers" như một phụ thuộc.
angular.module("orders-app", ["orders-app.controllers"]);

// khai báo một module có tên là "orders-app.controllers"
angular
	.module("orders-app.controllers", [])
	// khai báo một controller có tên là "orders-ctrl"
	.controller("orders-ctrl", function($scope, $http) {

		// hàm khởi tạo, gọi API để load dữ liệu đơn hàng và trạng thái đơn hàng
		$scope.initialize = function() {

			$http.get("/rest/orders").then(resp => {
				// lưu dữ liệu đơn hàng vào biến orders trong scope của controller
				$scope.orders = resp.data;
			});
			$http.get("/rest/status").then(resp => {
				// lưu dữ liệu trạng thái đơn hàng vào biến status trong scope của controller
				$scope.status = resp.data;
			});
		}

		// khởi đầu hàm khởi tạo
		$scope.initialize();

		// xóa form
		$scope.reset = function() {
			$scope.form = {};
		}

		// hiển thị dữ liệu lên form
		$scope.editOrder = function(order) {
			// copy dữ liệu đơn hàng vào biến form trong scope của controller
			$scope.form = angular.copy(order);
			// chuyển sang tab đầu tiên trong form
			$(".nav-tabs a:eq(0)").tab('show')
		}
		// cập nhật đơn hàng
		
		$scope.update = function() {
			var order = angular.copy($scope.form);
			$http.put(`/rest/orders/${order.id}`, order).then(resp => {
				var index = $scope.orders.findIndex(p => p.id == order.id);

				$scope.orders[index] = order;
				alert("cập nhật  sản phẩm thành công!")
			}).catch(error => {
				alert("cập nhật sản phẩm thất bại");
				console.log("Error", error);
			});

		}
		// thêm sản phẩm mới
		$scope.create = function() {
			var order = angular.copy($scope.form);
			$http.post(`/rest/orders`, order).then(resp => {
				$scope.orders.push(resp.data);
				$scope.reset();
				alert("Thêm mới sản phẩm thành công!")
			}).catch(error => {
				alert("Lỗi thêm mới sản phẩm!");
				console.log("Error", error);
			});

		}

		// xóa sản phẩm
		$scope.delete = function(order) {
			//var item =angular.copy($scope.form);
			console.log(order);
			console.log('----------');
			$http.delete(`/rest/orders/${order.id}`).then(resp => {
				var index = $scope.orders.findIndex(p => p.id == order.id);
				// dùng SPICE để xóa sản phẩm
				$scope.orders.splice(index, 1);
				$scope.reset();
				alert("xóa sản phẩm thành công!")
			}).catch(error => {
				alert("xóa sản phẩm thất bại");
				console.log("Error", error);
			});

		}

	});