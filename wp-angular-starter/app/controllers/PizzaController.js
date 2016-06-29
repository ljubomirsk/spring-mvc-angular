'use strict'
WPAngularStarter.controller('PizzaController',['$scope', 'PizzaService', '$stateParams', '$state',  function($scope, PizzaService, $stateParams, $state){
	angular.extend($scope,{
		rowCollection: [],
		pizza: {},
		show: false,

		init: function(){
			//Get all pizza types from database and put them in smart table.

			PizzaService.getAllPizzaTypes().then(
				function(data){
					$scope.rowCollection = angular.copy(data);
				},
				function(error){
					$scope.err = error;
				}
			)
			 $scope.displayedCollection = [].concat($scope.rowCollection);
		},

		findPizza: function(){
			//Get pizza type by id and store the response object in $scope.pizza.

			var id = $stateParams.pizzaId;
			PizzaService.getPizzaType(id).then(
				function(data){
					$scope.pizza = data;
				},
				function(error){
					$scope.err = error;
				}
			)
		},

		displayAddType: function(){
			//Toggle the displaying of the last row for adding a new pizza type.

			$scope.show = !$scope.show;
		},

		create: function(){
			//Send post request to the server with the new pizza's type name and the response data add it to the table.

			PizzaService.createPizzaType($scope.pizza).then(
				function(data){
					$scope.rowCollection.push(data);
					$scope.pizza = {};
				},
				function(error){
					console.log(error);
					$scope.err = error;
				}
			)
		},

		update: function(){
			//Call server to update the pizza type with the new type.

			PizzaService.updatePizzaType($scope.pizza).then(
				function(data){
					var x;
					for(x in $scope.rowCollection)
						if(x.id === data.id){
							x.type = data.type; 
							break;
						}
					$state.go('pizza-type-admin');
				},
				function(error){
					$scope.err = error;
				}
			)
		},

		removePizza: function(row){
			//Call server with pizza id to delete that pizza type from database and after remove the item from the table.

			PizzaService.deletePizza(row.id).then(
				function(data){
					var index = $scope.rowCollection.indexOf(row);
					if(index !== -1)
						$scope.rowCollection.splice(index,1);
				},
				function(error){
					$scope.err = error;
				}
			)
		}

	});
}]);