'use strict'
WPAngularStarter.factory('PizzaService', ['$http', function($http){
	return {
		getAllPizzaTypes: function(){
			return $http.get('/api/list/pizza')
			.then(
				function(response){
					return response.data;
				},
				function(error){
					console.log(error);
				}
			)
		},

		getPizzaType: function(id){
			return $http.get('/api/pizza/' + id).then(
				function(response){
					return response.data;
				},
				function(error){
					console.log(error);
				}
			)
		},

		createPizzaType: function(data){
			return $http.post('/api/pizza/create', data).then(
				function(response){
					return response.data;
				},
				function(error){
					console.log(error);
				}
			)
		},

		deletePizza: function(id){
			return $http.delete('/api/pizza/delete/' + id).then(
				function(response){
					return response;
				},
				function(error){
					console.log(error);
				}
			)
		},

		updatePizzaType: function(data){
			return $http.post('/api/update/pizza/', data).then(
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