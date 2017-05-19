function appController($scope, $http) {

  $scope.pessoa = {
    nome: "",
    rg: "",
    cpf: ""
  };

  $scope.salvar = function() {

      $http({

        method: 'POST',
        url: 'http://localhost:8001/api/cadastro/manterpessoa/' + $scope.pessoa.nome + '/' + $scope.pessoa.rg + '/' + $scope.pessoa.cpf,

        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }

      }).then(function(result) {
        alert('Salvo com sucesso!!');
      }, function(error) {
        alert(error);
      });

      $scope.reset();

    },

    $scope.reset = function() {
      $scope.pessoa = {
        nome: "",
        rg: "",
        cpf: ""
      };
    }

}
