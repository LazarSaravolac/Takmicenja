var app = angular.module("Lazar", ["ngRoute"]);

app.controller("ctrl", function($scope){
	$scope.message = "Hello JWD 30!";
});

app.controller("partizanCtrl", function($scope, $http, $location){
	 $scope.igraci=[{ime:"Vladimir",prezime:"Stojkovic",pozicija:"golman"},{ime:"Luka",prezime:"Curkovic",pozicija:"Desni bek"},{ime:"Nemanja",prezime:"Miletic",pozicija:"Levi bek"}
	 ,{ime:"Strahinja",prezime:"Bosnjak",pozicija:"stoper"},{ime:"Danilo",prezime:"Pantic",pozicija:"Levo krilo"},{ime:"Marko",prezime:"Jankovic",pozicija:"Desno krilo"},{ime:"Leandre",prezime:"Tavamba",pozicija:"napadac"}
	 ,{ime:"Sasa",prezime:"Ilic",pozicija:"centralni"},{ime:"Strahinja",prezime:"Jevtovic",pozicija:"ofanzivni"},{ime:"Nemanja",prezime:"Matic",pozicija:"centralni"},{ime:"Vladislav",prezime:"Djilas",pozicija:"napadac"}];
});

app.controller("czCtrl", function($scope, $http, $location){
	 $scope.igraci=[{ime:"Nemanja",prezime:"Supic",pozicija:"golman"},{ime:"Luka",prezime:"Maric",pozicija:"Desni bek"},{ime:"Nemanja",prezime:"Aleksic",pozicija:"Levi bek"}
	 ,{ime:"Matija",prezime:"Bosnjak",pozicija:"stoper"},{ime:"Nenad",prezime:"Milijas",pozicija:"Levo krilo"},{ime:"Marko",prezime:"Markovic",pozicija:"Desno krilo"},{ime:"Mali",prezime:"Boaci",pozicija:"napadac"}
	 ,{ime:"Sasa",prezime:"Maric",pozicija:"centralni"},{ime:"Strahinja",prezime:"Jevtovic",pozicija:"ofanzivni"},{ime:"Nemanja",prezime:"Matic",pozicija:"centralni"},{ime:"Nemanja",prezime:"Radonjic",pozicija:"napadac"}];
});







app.controller("ucesnikCtrl", function($scope, $http, $location){
	
	var baseUrl = "/api/ucesnici";
    var baseUrlTakmicenja = "/api/takmicenja";
	$scope.otvori=false;
	$scope.otvoriNaziv=false;
    $scope.ucesnici=[];
    $scope.ucesnici1=[];
    $scope.takmicenja=[];
    $scope.novUcesnik={};
    $scope.novUcesnik.odigranoSusreta=0;
    $scope.novUcesnik.brojBodova=0;
    $scope.page=0;
    $scope.totalPages=0;
    
    $scope.trazeniUcesnik={};
    
    $scope.odigraj={};
    $scope.odigrajUcesnici=[];
    
    $scope.pobednik="";
    $scope.proba="";
    
    $scope.probavanje=false;
    $scope.ucesnici[1]="";
    
    $scope.pokazi=false;
   
    var getUcesnici = function(){
    	var config = {params: {}};

        config.params.page = $scope.page;

        if($scope.trazeniUcesnik.idTakmicenje != ""){
            config.params.idTakmicenje = $scope.trazeniUcesnik.idTakmicenje;
        }

        if($scope.trazeniUcesnik.naziv != ""){
            config.params.naziv = $scope.trazeniUcesnik.naziv;
        }

        


       

        $http.get(baseUrl,config)
            .then(
            	function success(res){
            		$scope.ucesnici = res.data;
            		$scope.totalPages = res.headers('totalPages');
            		$scope.pobednik=res.headers('ucesnikBrate');
            		$scope.proba=res.headers('proba');
            		console.log($scope.ucesnici);
            	},
            	function error(res){
            		alert("Neuspesno dobavljanje ucesnika!");
            	}
            );
        
        
    };
    
    getUcesnici();
    
    var getTakmicenja = function(){

        

        $http.get(baseUrlTakmicenja)
            .then(
            	function success(res){
            		$scope.takmicenja = res.data;
            		
            	},
            	function error(res){
            		alert("Neuspesno dobavljanje ucesnika!");
            	}
            );
    };
    getTakmicenja();
    
    
    $scope.trazi=function(){
    	$scope.page=0;
    	getUcesnici();
    	$scope.otvori=true;
    	$scope.otvoriNaziv=true;
    }
    
    
    
    $scope.dodaj = function(){
        $http.post(baseUrl, $scope.novUcesnik)
            .then(
            	function success(res){
            		getUcesnici();
            		
            		
            	},
            	function error(res){
            		alert("Neuspesno dodavanje!");
            	}
            );
    };
    
    $scope.obrisi = function(id){
        $http.delete(baseUrl + "/" + id).then(
            function success(data){
            	getUcesnici();
            },
            function error(data){
                alert("Neuspesno brisanje!");
            }
        );
    }
    
    $scope.izmeni = function(id){
        $location.path('/ucesnici/edit/' + id);
    }
    
    $scope.nazad = function(){
        if($scope.page > 0) {
            $scope.page = $scope.page - 1;
            getUcesnici();
        }
    };

    $scope.napred = function(){
        if($scope.page < $scope.totalPages - 1){
            $scope.page = $scope.page + 1;
            getUcesnici();
        }
    };
    
    var getUcesnici1 = function(){
    	var config1 = {params: {}};


        if($scope.trazeniUcesnik.idTakmicenje != ""){
            config1.params.idTakmicenje = $scope.trazeniUcesnik.idTakmicenje;
        }


        $http.get(baseUrl,config1)
            .then(
            	function success(res){
            		$scope.ucesnici1 = res.data;
            	
            	},
            	function error(res){
            		alert("Neuspesno dobavljanje ucesnika!");
            	}
            );
        
        
    };
    
    $scope.predji=function(){
    	$scope.pokazi=!$scope.pokazi;
//    	 $location.path('/ucesnici/odigraj/');
    	 console.log($scope.trazeniUcesnik.idTakmicenje);
    	 getUcesnici();
    	 console.log($scope.ucesnici);
    }
    
   
    


    
    
    $scope.odigraj=function(u1,u2,ishod){
    	var promise=$http.put(baseUrl + "/" + u1 + "/" + u2 + "/" +  ishod);
		promise.then(
				function uspeh(res){
					$scope.ucesnici=res.data;
					getUcesnici();
					$location.path('/ucesnici');
					
				},
				function greska(){
					alert("greska");
				
				}
		);
    }
});











app.controller("editUcesnikCtrl", function($scope, $http , $routeParams,$location){
	 $scope.novUcesnikE={};
	 var baseUrl = "/api/ucesnici";

	  

	    var getStariU= function(){

	        $http.get(baseUrl + "/" + $routeParams.id)
	            .then(
	            	function success(res){
	            		$scope.novUcesnikE = res.data;
	            	},
	            	function error(data){
	            		alert("Neušpesno dobavljanje ucesnika.");
	            	}
	            );

	    }
	    getStariU();
	
	    $scope.izmeni = function(){
	        $http.put(baseUrl + "/" + $scope.novUcesnikE.id, $scope.novUcesnikE)
	            .then(
	        		function success(data){
	        			alert("Uspešno izmenjen ucesnik!");
	        			$location.path("/");
	        		},
	        		function error(data){
	        			alert("Neuspešna izmena ucesnik.");
	        		}
	            );
	    }
});


app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		
		.when('/', {
			templateUrl : '/app/html/partial/ucesnik.html'
		})
		.when('/cz', {
			templateUrl : '/app/html/partial/cz.html'
		})
		.when('/ucesnici/edit/:id', {
			templateUrl : '/app/html/partial/edit-ucesnici.html'
		})
		.when('/partizan', {
			templateUrl : '/app/html/partial/partizan.html'
		})
		.when('/ucesnici/odigraj/', {
			templateUrl : '/app/html/partial/odigrajMec.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);
