'use strict';

app.controller('listaPoiController', function($scope, $http, RestSrv, SERVICE_PATH) {
	$scope.listaPoi = [];

	RestSrv.find(SERVICE_PATH.URL, function(data) {
		$scope.listaPoi = data;
	});

});

app.controller('cadastroPoiController', function($scope, $http, RestSrv, ngNotify, SERVICE_PATH) {
	$scope.poi = {};

	$scope.cadastrar = function() {
		RestSrv.add(SERVICE_PATH.URL, $scope.poi, function(newPoi) {
			ngNotify.set('Poi \'' + newPoi.nome + '\' cadastrado com sucesso.', 'success');
		});
	}

});

app.controller('proximoPoiController', function($scope, $http, RestSrv, ngNotify, SERVICE_PATH) {

	$scope.filtro = {};
	


	$scope.buscarProximos = function() {
		$scope.listaPoi = [];
		var url = SERVICE_PATH.URL + '/proximos?' +
	      'd='+ $scope.filtro.d +
	      '&x='+ $scope.filtro.x +
	      '&y='+ $scope.filtro.y ;		
		
		RestSrv.find(url, function(data) {
			if(data.length > 0){
				$scope.listaPoi = data;
			}else{
				ngNotify.set('Não foi encontrado pontos de interesse nas proximidades de: ' + $scope.filtro.d + ' metros.' , 'info');
			}
		});
	}

});
