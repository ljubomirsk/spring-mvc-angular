'use strict'
WPAngularStarter.controller('OrderController', [ '$scope', 'PizzaService', 'OrderService',  '$stateParams' , function($scope, PizzaService, OrderService, $stateParams){
	angular.extend($scope,{
		order: { pizza: {} },
		pizzaTypes: undefined,

		init: function(){
			//GET all pizza types from database and store them in $scope.pizzaTypes.

			PizzaService.getAllPizzaTypes().then(
				function(data){
					$scope.pizzaTypes = angular.copy(data);
				},
				function(error){
					$scope.err = error;
				}
			)
		},

		update: function(){
			//Call server to update the pizza type with the new type.

			OrderService.update($scope.order.id).then(
				function(data){
					var x;
					for(x in $scope.rowCollection)
						if(x.id === data.id){
							x.approve = data.approve;
							break;
						}
					$state.go('order-admin');
				},
				function(error){
					$scope.err = error;
				}
			)
		},

		findAll: function(){
			//Take all orders from database.
			$scope.rowCollection = [];
			OrderService.getAllOrders().then(
				function(data){
					$scope.rowCollection = angular.copy(data);
				},
				function(error){
					$scope.err = error;
				}
			)
			$scope.displayedCollection = [].concat($scope.rowCollection);
		},

		getOrder: function(){
			//Get order by id and store it in $scope.order.

			var id = $stateParams.orderId;
			OrderService.getOrder(id).then(
				function(data){
					$scope.order = angular.copy(data);
				},
				function(error){
					$scope.err = error;
				}
			)
		},

		findOrder: function(){
			//Get pizza type by id and store the response object in $scope.pizza.

			var id = $stateParams.orderId;
			OrderService.getOrder(id).then(
				function(data){
					$scope.order = data;
				},
				function(error){
					$scope.err = error;
				}
			)
		},

		create: function(){
			//Call server to create and store the order in database and display the notification of the newly created item.

			$scope.getPizzaType($scope.order.pizza.type, function(data){
				$scope.order.pizza = angular.copy(data);
				OrderService.createOrder($scope.order).then(
					function(data){
						$scope.err = "Order with order id "+data.orderId+" has been created.";
						$scope.order={pizza: {} }
					},
					function(error){
						$scope.err = error;
					}
				)
			});
		},

		getPizzaType: function(id, cb){
			//Send request to get the pizza type object and send it back by callback.
			
			PizzaService.getPizzaType(id).then(
				function(data){
					cb(data);
				},
				function(error){
					$scope.err = error;
				}
			)
		}
	});

}]);