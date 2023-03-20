#language: pt
Funcionalidade: Realizar operações utilizando REST-assured

  Cenário: Consultar o autor de uma publicação
    Dado que eu faça uma operação do tipo GET na publicação número "1"
    Então o nome do autor da publicação deverá ser "typicode"

  Cenário: Consultar um autor em uma lista de publicações
    Dado que eu faça uma operação do tipo GET no endpoint "/posts"
    Então alguma publicação deverá ser do autor "typicode"

  Cenário: Criar uma nova publicação
    Dado que eu faça uma operação do tipo POST no endpoint de publicações
    Então o nome do autor da nova publicação deverá ser "Fernanda Müller Baldi"

  Cenário: Criar um novo perfil
    Dado que eu faça uma operação do tipo POST no endpoint "/profiles/{profileId}/profile" com o body
    | name      | profileId |
    | Fernanda  | 2         |
    Então o nome do novo perfil deverá ser "Fernanda"


