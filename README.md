PROCESSO SELETIVO
De acordo com as atividades propostas foram desenvolvidos dois projetos em Java, para facilitar os testes e como se trata de projetos simples não foi utilizado nenhum framework, os projetos foram criados em aplicações Java básicas, ambas possuem uma classe main para iniciar a aplicação, para mais detalhes foi criado um arquivo de instruções no próprio projeto com mais detalhes de como utiliza-los.

ABAIXO SEGUE AS INSTRUÇÕES ASSIM COMO NO README DOS PROJETOS

PROJETO CAMPANHAS
Para o exercício proposto foram expostos alguns serviços.

para os serviços de crud de clientes foi exposto na url http://localhost:8080/clientes Para os serviços de crud de campanhas foi exposto na url http://localhost:8080/campanhas Para os serviços de crud de times foi exposto na url http://localhost:8080/times A relação entre campanhas e clientes foi exposto a url http://localhost:8080/relacaocampanhas

Para a utilização destes serviços particularmente optei por utilizar a ferramenta Advanced REST client, mas fique a vontade para utilizar a que preferir, pelo método GET é possível retornar todas as campanhas que estão ativas ou seja as campanhas onde a data de termino seja superior a data atual, pelo método GET dos do serviço de times e de clientes e possível retornar todos os times e todas os clientes cadastrados no sistema, com o intuito de deixar a aplicação o mais autónoma possível os dados são criados em memória.

Para remover um dados basta mudar o método para DELETE inserir uma / e inserir o id do mesmo. Para alterar algum dado basta mudar o método para PUT inserir uma / e inserir o id do mesmo sem esquecer de enviar o dados completos através do body. Para inserir um novo dado mude o método para POST e enviar o conteúdo JSON.

O relacionamento entre cliente time e campanha é feito pelo id, uma campanha pode ter apenas um id referente ao cliente, quando a campanha passa a ter algum id de cliente cadastrado automaticamente ela para de aparecer na lista de campanhas pois ela não está mais disponível para outros clientes.

PROJETO VALIDAR TEXTO
Para testar a aplicação execute a classe Main deste projeto, caso queria testar com outro texto altere a entrada na mesma classe.
