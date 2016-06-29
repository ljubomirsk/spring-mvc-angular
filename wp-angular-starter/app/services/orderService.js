'use strict'
WPAngularStarter.factory('OrderService', ['$http', function($http){
	return {
		createOrder: function(data){
			return $http.post('/api/create/order',data)
			.then(
				function(response){
					return response.data;
				},
				function(error){
					console.log(error);
				}
			)
		},

		getAllOrders: function(){
			return $http.get('/api/list/order').then(
				function(response){
					return response.data;
				},
				function(error){
					console.log(error);
				}
			)
		},

		getOrder: function(id) {
			return $http.get('/api/order/' + id).then(
				function (response) {
					return response.data;
				},
				function (error) {
					console.log(error);
				}
			)
		},

		update: function(id){
			return $http.post('/api/order/update/' + id).then(
				function(response){
					return response.data;
				},
				function(error){
					console.log(error);
				}
			)
		}
	}
}]);