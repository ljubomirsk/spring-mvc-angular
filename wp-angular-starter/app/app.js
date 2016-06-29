'use strict';
var WPAngularStarter = angular.module('wp-angular-starter', [ 'ui.router', 'ngResource', 'pascalprecht.translate', 'smart-table', 'mgcrea.ngStrap', 'toastr', 'angular-loading-bar', 'ui.select', 'ngQuickDate'])

.config(function($stateProvider, $urlRouterProvider){
	$stateProvider
	.state('pizza-order',{
		url: '/order',
		templateUrl: 'views/order.html'
	})
	.state('pizza-type-admin',{
		url: '/pizzas',
		templateUrl: 'views/pizza.html'
	})
	.state('order-admin', {
		url: '/list/orders',
		templateUrl: 'views/list-orders.html'
	})
	.state('update-pizza', {
		url: '/pizza/update/:pizzaId',
		templateUrl: 'views/pizza-update.html'
	})
		.state('update-order', {
			url:'/order/update/:orderId',
			templateUrl: 'views/edit-order.html'
		})
	.state('viewOrder',{
		url: '/order/view/:orderId',
		templateUrl: 'views/view-order.html'
	})

	$urlRouterProvider.otherwise('/order');
});

