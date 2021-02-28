#Projeto gestaotreinamento - Tecnologias necessárias e Uso do sistema

Este documento tem por finalidade informar quais são as tecnologias necessárias para que o sistema funcione
e como você deve utilizar o sistema para cumprir os requisitos obrigatórios.

1. Tecnologias necessárias
Para que o sistema funcione, será necessário:
a) baixar o JDK do Java na versão 11
b) utilizar o navegador Google Chrome para os testes automatizados na versão 88
c) baixar ChromeDriver compatível com a versão 88 do Google Chrome para os testes automatizados. Para isso, baixe
   pelo site oficial https://sites.google.com/a/chromium.org/chromedriver/downloads e clique no link
   ChromeDriver 88.0.4324.96 para baixar em uma versão compatível com a versão 88 do navegador Chrome.
   Descompacte e coloque este arquivo neste diretório do seu computador (se Windows): C:\Users\User\Drivers\chromedriver.exe

Cabe salientar que foi utilizada a IDE Spring Tool Suite 4 para o desenvolvimento da aplicação e dos testes automatizados 
e o banco de dados PostgreSQL 9.5 para a persistência de dados. Não se esqueça de dar o nome do banco de dados de
'gestaotreinamento', ter como username 'postgres' e como password 'admin'.


2. Uso do sistema

O sistema de gerenciamento de pessoal por salas foi feito com a seguinte lógica:
- você terá que cadastrar, NO MÍNIMO duas salas para poder cadastrar pessoas;
- como diz o sistema, temos dois espaços distintos para o café, então eles serão cadastrados pelo sistema;
- após cadastrar as salas que estarão no sistema, você precisará clicar no link para cadastro de usuário para ser
  direcionado à página para cadastro de usuários;
- você precisará cadastrar, NO MÍNIMO, dois usuários por sala no sistema, e para isso, basta inserir nome e sobrenome 
  e clicar no botão "Cadastrar" e o sistema irá cadastrar o usuário;
- por fim, após cadastrar todas as salas e a quantidade de usuários que você quer, clique no link para listar quem
  está cadastrado e nesta página, clique no link "DISTRIBUIR PESSOAL POR SALAS" para que o pessoal seja distribuído
  pelas salas.

  Obs.: se for cadastrar mais salas ou mais pessoas, será necessário que você acesse à página que lista cadastrados
	para clicar no botão "DISTRIBUIR PESSOAL POR SALAS" novamente para que seja atualizada a localização de todos.


a) para cadastrar uma sala
- ao subir o projeto, clique no link que estará na página;
- insira o nome da sala no primeiro campo de entrada;
- clique no botão "CADASTRAR";
- conforme você for cadastrando salas, acima será exibida uma mensagem de validação dizendo que a sala foi cadastrada
  e abaixo aparecerão todas as salas que você já cadastrou no sistema contendo id e nome da sala.

OBS.: se você não cadastrar pelo menos duas salas, você será redirecionado à primeira página com uma mensagem dizendo
      que você precisa cadastrar pelo menos duas salas. 

b) para pesquisar por uma sala
- ao subir o projeto, clique no link que estará na página;
- insira o nome exato da sala no segundo campo de entrada;
- clique no botão BUSCAR";
- desta forma, caso exista o nome da sala que você digitou, a(s) sala(s) aparecerá(ão) no final da página.

c) sobre o botão "APAGAR TUDO"
- este botão tem por finalidade apagar todos os registros de salas e pessoal do banco de dados. Ele foi criado apenas 
  para facilitar os testes de quem for avaliar o sistema

d) para cadastrar um usuário
- ao subir o projeto, clique no link que estará na página;
- clique no link disponível no segundo tópico;
- insira o nome e o sobrenome que você deseja cadastrar e clique no botão "CADASTRAR";
- conforme você for cadastrando pessoas, será exibido abaixo uma mensagem de validação dizendo que a pessoa foi cadastrada

OBS.: é necessário que você cadastre pelo menos duas pessoas por quantidade total de salas, ou seja, se você cadastrou
	2 salas, você precisará de pelo menos 4 usuários cadastrados, e se há 3 salas, 6 usuários, se 4 salas, 8 usuários,...


e) para distribuir o pessoal pelas salas
- ao subir o projeto, clique no link que estará na página;
- clique no link disponível no segundo tópico;
- clique no link disponível no terceiro tópico;
- clique no botão "DISTRIBUIR PESSOAL POR SALAS" e a distribuição dos usuários será feita pelas salas, sendo exibido, de
  forma específica, qual o id do usuário, seu nome, sobrenome e em quais locais de café/salas estarão em cada etapa.

OBS.: vale notar que, ao você ser direcionado para esta página, você já terá disponível todos os usuários listados e
	em quais salas e local de café eles estarão em cada período no final da página. Caso algum usuário não esteja 
	cadastrado em um dos locais de café ou salas, basta clicar no botão "DISTRIBUIR PESSOAL POR SALAS" e será 
	feita uma nova distribuição.

f) para pesquisar por um nome
- ao subir o projeto, clique no link que estará na página;
- clique no link disponível no segundo tópico;
- clique no link disponível no terceiro tópico;
- insira o primeiro nome da pessoa no campo de entrada;
- clique no botão BUSCAR";
- desta forma, caso exista o nome da pessoa que você digitou, ela(s) aparecerá(ão) no final da página.