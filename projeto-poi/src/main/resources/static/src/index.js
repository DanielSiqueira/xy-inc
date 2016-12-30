'use strict';

var app = angular
  .module('myapp', [
    'ngRoute','ngNotify'
  ])
  .constant('SERVICE_PATH', {
    'URL': 'http://localhost:8080/poi'
  });

// Definindo Rotas
app.config(function($routeProvider, $locationProvider) {
  
  $routeProvider
    .when('/', {
      templateUrl: 'src/pages/listaPoi.html',
      controller: 'listaPoiController'
    })
    .when('/proximos', {
      templateUrl: 'src/pages/proximo.html',
      controller: 'proximoPoiController'
    })
    .when('/cadastro', {
      templateUrl: 'src/pages/cadastro.html',
      controller: 'cadastroPoiController'
    })
    .otherwise({
      redirectTo: '/'
    });
    
}).run(function($rootScope, ngNotify) {
    $rootScope.url = 'http://localhost:8080/poi';

    ngNotify.config({
      theme: 'pastel'
    });
});
