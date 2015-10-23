# Plataforma de desenvolvimento #
O sistema será desenvolvido em Java, em sua JDK 1.8 e na JEE 7.0, utilizando servidor Glassfish 4.1, banco de dados Posgres e deverá ser todo Web multinavegador compatível com HTML 5.0.

O ambiente de desenvolvimento é o Netbeans 8.0.2.

## Plataforma móvel de referência ##
O SDK para Android será utilizado para as aplicações de coleta de dados e de suporte a operações.

O dispositivo de referência para Android tem tela de tamanho mínimo de 4", 512RAM, câmera com flash com no mínimo 5MB, GPS com aGPS, geotag, acesso 3G, 4GB memória interna e roda versão 4.1+.

# Banco de dados #
O banco de dados será criado automaticamente na instalação da aplicação, devendo para isso ser indicado o servidor Posgres e as credenciais de superusuário.

O script executado deverá criar o banco de dados, popular as tabelas e criar os usuários predefinidos.

O banco de dados será criado com o nome **obraesperta**.

Será criado o usuário **obraespertasu**, cuja senha inicial é homônima, **obraespertasu**, que será proprietário do banco de dados.

O script de instalação deverá permitir em versões futuras a personalização das senhas no momento da instalação.

# Aplicação #
  1. todas as entidades devem ser temporais
    1. nenhum registro deverá ser editado/deletado.  Cada edição deverá gerar um novo registro que se tornará ativo, desativando seu antecessor.
    1. para fluxos, um lançamento errado/indevido deverá ser corrigido por meio de lançamento retificador adequado.
  1. o ERP deverá, em versões futuras, suportar diferentes provedores de banco de dados além do Postgre, sendo prioritários, nessa ordem, o MySQL e o Oracle.
  1. o ERP deverá, em versões futuras, suportar diferentes servidores de aplicação além do Glassfish, sendo prioritário o jBoss.
  1. o ERP deverá possuir todo o seu código documentado em JAVADOC.
  1. o ERP deverá implementar geração de log por meio da biblioteca log4J.
  1. o ERP deverá implementar casos de teste por meio da biblioteca JUnit.
  1. o ERP implementará sua segurança por meio da biblioteca Apache Shiro.
  1. o ERP deverá, em versões futuras, suportar a autenticação integrada com LDAP, certificado digital, Google e Facebook.
  1. o ERP deverá suportar internacionalização em todo o seu escopo.
  1. o ERP deverá, em versões futuras, suportar o armazenamento na nuvem.
  1. os relatórios e consultas deverão ser exportáveis para formatos intercambiáveis abertos: Oasis, PDF e CSV.
  1. o ERP deverá, em versões futuras, suportar a assinatura digital de documentos quando for necessário.
  1. o ERP deverá, em versões futuras, suportar a escrituração fiscal e emissão de documentos fiscais eletrônicos (eNF), conforme definidos pelos órgãos competentes (nas esferas federal, estadual e municipal).

# Funcionais #
  1. O ERP deverá adotar as boas práticas de acessibilidade, sendo validado pelo www.dasilva.org.br.
  1. O ERP deverá adotar as boas práticas de design de interfaces (consulte o título Interface no tópico Guidelines)

# Árvore de versionamento #

Definir a linha principal de desenvolvimento do Obra Esperta.

O desenvolvimento será conduzido como um projeto para versões a serem desenvolvidas pelos próximos 3 anos.

Cada versão será um subprojeto do projeto principal.

Muitos dos recursos ainda não foram devidamente priorizados.

A primeira etapa do projeto é a enumeração de recursos.

Após essa fase os recursos serão agrupados em domínios e priorizados.

Após essa etapa os recursos serão distribuídos por versões ao longo da timeline do projeto.

As versões maiores serão disponibilizadas a cada 6 meses.


## Versão 1.0 ##
**Data prevista alfa:**
**Data prevista beta:**
**Data prevista release:**
Essa versão tem o foco nos processos internos, cujos usuários são os colaboradores e gestores da unidade.
  1. Cadastro de clientes
  1. Cadastro de colaboradores
  1. Cadastro de campanhas de marketing
  1. Cadastro de solicitações
  1. Contas a pagar
  1. Contas a receber
### Arquitetura ###
#### Caleum Stella ####
A biblioteca Caleum Stella será utilizada para prover validação de CPF, CNPJ, IE, geração de boletos bancários e escrita de números por extenso.
#### Primefaces ####
A biblioteca Primefaces será utilizada para prover componentes e infraestrutura JSF para aplicação provendo componentes ricos que melhoram a experiência do usuário.
#### Knu ####
A biblioteca Knu será utilizada para buscar dados das bases da SRF referentes a pessoas físicas e jurídicas, além de buscar endereços por meio do CEP utilizando-se de webservice dos Correios.
Todos os cadastros deverão ser otimizados buscando-se as informações das bases confiáveis existentes com o intuito de otimizar a entrada e mantê-la consistente.
#### Apache Shiro ####
A biblioteca Apache Shiro será utilizada para prover a segurança do ERP e nesta versão utilizará a integração com LDAP para fins de autenticação.
#### Banco de dados ####
O servidor de banco de dados dessa versão será o Postgres 9.3.
#### Servidor de aplicação ####
O servidor de aplicação dessa versão será o Glassfish 4.1.
#### Arquitetura ####
#### Cliente ####
Serão suportados os navegadores web Firefox 35+, Opera 26+ e Chrome 39+ nesta versão.  Esses navegadores e versões são os mais aderentes ao HTML 5, conforme consulta ao site [HTML5 Test](https://html5test.com/results/desktop.html) em 17/02/2015.
#### Funcionalidades ####
##### Imprescindíveis #####
##### Desejáveis #####
##### Supérfluas #####


## Versão 2.0 ##
**Data prevista alfa:**
**Data prevista beta:**
**Data prevista release:**

Essa versão começa a integrar serviços para o cliente que serão disponibilizados no portal da unidade
  1. Lançamento de solicitações estruturadas online
  1. Encaminhamento de solicitações online
  1. Pagamento online

## Versão 3.0 ##
**Data prevista alfa:**
**Data prevista beta:**
**Data prevista release:**

Essa versão integra os processos da unidade com serviços de suporte oferecidos por terceiros
  1. Integração com o cadastro de CEP's dos correios
  1. Integração com o Google Agenda
  1. Integração com o Google Maps

## Versão 4.0 ##
**Data prevista alfa:**
**Data prevista beta:**
**Data prevista release:**

Essa versão integra os serviços disponíveis na plataforma Android
  1. Pagamento mobile
  1. Pré-orçamento mobile
  1. Rastreamento mobile

## Versão 5.0 ##
**Data prevista alfa:**
**Data prevista beta:**
**Data prevista release:**

Essa versão expande os serviços internos existentes
  1. Comissionamento
  1. Folha de pagamento
  1. Controle de frequencia
  1. DRE

## Versão 6.0 ##
**Data prevista alfa:**
**Data prevista beta:**
**Data prevista release:**

Essa versão expande os serviços internos existentes
  1. Importação de itens de nota fiscal no inventário de bens permanentes e de consumo via XML
  1. Controle de locação de ferramentas
  1. Controle de estoque de almoxarifado