#language: pt
Funcionalidade: Realizar operações de Consulta utilizando REST-assured

  Cenário: Verificar o autor de uma publicação
    Dado que eu faça uma consulta na publicação número "1"
    Então o nome do autor da publicação deverá ser "typicode"

  Cenário: Verificar o autor de uma publicação
    Dado que eu faça uma consulta na lista de publicações
    Então alguma publicação deverá ser do autor "typicode"
