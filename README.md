## Objetivo

Parabéns, você passou para a segunda fase do processo seletivo da [MáximaTech](https://maximatech.com.br/) para desenvolvedor
Android.

## O que esperamos? 1.0 ;-)

* Um aplicativo Android que faça:

1. Splash
2. Menu principal
    * Rodapé: Ícone Nuvem para indicar conexão com a internet, Ícone Nuvem cortada para indicar que não tem conexão com a internet
	* No menu principal ao tocar na opção Clientes direcionar para a tela Dados do cliente
3. Dados do cliente
	* A seta da toolbar deve voltar para o menu principal
	* O botão Verificar status do cliente tem que exibir numa snackbar o status do cliente com a data e hora (tela 3.1)
	* O bottom navigation deve levar às telas de Histórico de pedidos, Alvarás ou Dados do Cliente
    * Snackbar de status
    * Histórico de pedidos
	    * O menu deve abrir a opção de legendas (tela 3.3)
	    * A pesquisa deve abrir o campo de pesquisa textual
	    * A seta da toolbar deve voltar para a tela anterior
	    * O bottom navigation deve levar às telas de Histórico de pedidos, Alvarás ou Dados do Cliente
    * Menu legendas
	    * O menu Legendas deve abrir o Dialog com as legendas (tela 3.4)
    * Dialog Legendas
	    * Botão Fechar deve fechar o Dialog
    * Alvarás
	    * A seta da toolbar deve voltar voltar para a tela anterior
	    * O bottom navigation deve levar às telas de Histórico de pedidos, Alvarás ou Dados do Cliente
4. Criação de Serviços em Background
	* Criar um serviço em background que notifica o usuário a cada duas horas. Ao clicar na notificação o aplicativo deverá ser aberto. As seguintes bibliotecas são recomendadas para este item: (AlarmManager, Service, Firebase Job Dispacher, WorkManager)
	

O aplicativo deverá:
* Reproduzir a interface definida no layout fornecido
* Consumir o json (clientes.json) para exibir os dados dos clientes
* Consumir o json (pedidos.json) para listagem de histórico de pedidos
* Rodar um service que interaja com a tela de *3.1 - Cadastro do cliente – Snackbar de status* e exiba o texto numa snackbar
* Manter a posição da lista depois que fizer transição de tela


Sugestões:
* Salvar os dados num banco de dados e recuperá-los em caso de falha de conexão
* Testes unitários e de interfaces

## Requisições  REST 2.0

A tela abaixo possui o botão **Verificar status do cliente** que é responsável por enviar uma requisição GET para o endpoint informado no item 4.0, para retornar o status do cliente. 

![Tela Service](https://github.com/talentosmaxima/Android/blob/master/Design/Screenshots/3.1%20-%20Cadastro%20do%20cliente%20%E2%80%93%20Snackbar%20de%20status.png)

Quando o usuário clicar no botão em questão deve-se consultar o status que está armazenado no arquivo json e retornar o texto **Data/Hora - Status cliente**, por exemplo, **10/09/2018 - Status ativo** 

Importante salientar que **tudo que você enviar será avaliado**

### Onde estão as coisas? 3.0

### Design 3.1

Todo material pertinente para reproduzir as telas está na pasta *./Design*, recomendamos dar uma olhada no arquivo *./Design/Protótipo maxApp.xd* para verificar dimensões, bordas, cores, estilos e tamanhos corretos.

<sub>*o Adobe XD é um app pago, mas tem versão free https://www.adobe.com/br/products/xd.html <sub>
	
### Arquivos de Design 3.2

[Arquivos Design](https://github.com/talentosmaxima/Android/blob/master/Design/Prot%C3%B3tipo-maxApp.pdf)

### JSON 4.0

Os jsons utlizados nessa avaliação estão contidos nos seguintes caminhos. 
 Clientes: Json/clientes.json 

Alternativamente um GET Request no seguinte endpoint

	URL : https://api.myjson.com/bins/1bo7qj
	
 Pedidos: Json/pedidos.json 

Alternativamente um GET Request no seguinte endpoint

	URL: https://api.myjson.com/bins/wjl97
    
## Instruções

Enviar para talentoshumanos@maximatech.com.br:
* Assunto "[Teste Desenvolvedor Android] - Nome do candidato"
* Link do código fonte no [github](https://github.com/) ou [gitlab](https://about.gitlab.com/)
* Executável

## O que vamos avaliar?

* Organização do projeto
* Utilização de padrões arquiteturais
* Clareza do código
* Escolha de estruturas e bibliotecas
* Ausência de crashs e bugs
* Detalhes de UI
* Linguagem de programação

## Dúvidas

Entre em contato com <talentoshumanos@maximatech.com.br>
