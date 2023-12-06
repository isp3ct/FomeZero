# Gerenciamento de doações Fome Zero.

Projeto dos alunos da UMC referente ao ODS (Objetivo de Desenvolvimento Sustentável), desenvolvido em JAVA com a utilização de JDBC. Destinado a pessoas que gostariam de realizar e receber doações.

## Instruções de Uso

1. **Baixar o arquivo:**
   - Após o download do arquivo, proceda com as seguintes etapas:

2. **Abrir a pasta do arquivo com o VsCode:**
   - Extraia o arquivo e abra a pasta correspondente usando o VsCode.

3. **Baixar a extensão necessária:**
   - Instale a extensão chamada Extension Pack for Java, cujo ID da extensão é: `vscjava.vscode-java-pack`.

4. **Inicializar e configurar o MySql:**
   - Inicialize o MySql e crie uma conexão com as seguintes configurações ou as configurações da sua máquina: 
     - Nome da conexão: `FomeZero`
     - Hostname: `127.0.0.1`
     - Porta: `3306`
     - Username: `root`
     - Senha: `root`

5. **Executar comandos no MySql:**
   - Utilize os comandos fornecidos no arquivo "Comandos BD Fomezero.txt" na pasta do projeto para configurar o banco de dados.

6. **Configurar o VsCode:**
   - No VsCode, na aba Explorer, procure por "JAVA PROJECTS" no canto inferior esquerdo.

7. **Adicionar bibliotecas de referência:**
   - Dentro de "JAVA PROJECTS", expanda a seção e localize "Referenced Libraries".
   - Clique no botão "+" para adicionar uma biblioteca.

8. **Selecionar o arquivo do conector JDBC:**
   - Na janela que abrir para selecionar o arquivo, navegue até a pasta onde está localizado o arquivo "mysql-connector-j-8.2.0".
   - O arquivo estará dentro da pasta `bin` no diretório do projeto, por exemplo: `Fome Zero\Doador\bin`.

9. **Verificação final:**
   - Certifique-se de ter seguido todos os passos anteriores, desde a instalação da extensão até a execução de todos os comandos no MySql.

10. **Iniciar o programa:**
    - Sempre inicie a execução pelo arquivo `MenuInicio.java` para o correto funcionamento do programa.

## Funcionalidades

- Cadastro de beneficiário e doador
- Envio de doação
- Visualização de ONG's

## Tecnologias Utilizadas

- Java
- MySql
- JDBC

## Banco De Dados

```sql
-- Criação do banco de dados "fomezero"
create database fomezero;

-- Selecionando o banco de dados "fomezero"
use fomezero;

-- Tabelas e inserções de exemplo (exemplo simplificado)
CREATE TABLE TIPOUSUARIO (
    IDTIPOUSUARIO INT PRIMARY KEY,
    DESCRICAO VARCHAR(255) NOT NULL,
    STATUS INT NOT NULL
);

Insert into TIPOUSUARIO (IDTIPOUSUARIO, DESCRICAO, STATUS) VALUES (1, 'DOADOR', 1), (2, 'BENEFICIARIO', 1);

CREATE TABLE USUARIO (
    IDUSUARIO INT AUTO_INCREMENT PRIMARY KEY,
    IDTIPOUSUARIO INT NOT NULL,
    NOME VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    DATANASCIMENTO DATE NOT NULL,
    CPF LONG NOT NULL,
    STATUS INT NOT NULL,
    FOREIGN KEY (IDTIPOUSUARIO) REFERENCES TIPOUSUARIO(IDTIPOUSUARIO)
);

-- Tabela "Produtos"
CREATE TABLE PRODUTOS (
    IDPRODUTOS INT AUTO_INCREMENT PRIMARY KEY,
    DESCRICAO VARCHAR(255) NOT NULL,
    STATUS INT NOT NULL    
);

INSERT INTO PRODUTOS (DESCRICAO, STATUS) VALUES ('5Kg Arroz', 1);
INSERT INTO PRODUTOS (DESCRICAO, STATUS) VALUES ('1Kg Feijão', 1);
INSERT INTO PRODUTOS (DESCRICAO, STATUS) VALUES ('1L Óleo', 1);
INSERT INTO PRODUTOS (DESCRICAO, STATUS) VALUES ('1u Sabonete', 1);
INSERT INTO PRODUTOS (DESCRICAO, STATUS) VALUES ('1Kg Sal Refinado', 1);

-- Tabela "DOACAO"
CREATE TABLE DOACAO (
    IDDOACAO INT AUTO_INCREMENT PRIMARY KEY,
    IDUSUARIO INT NOT NULL, 
    IDPRODUTOS INT NOT NULL,
    QTD INT NOT NULL,
    STATUS INT NOT NULL,
    FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO(IDUSUARIO),
    FOREIGN KEY (IDPRODUTOS) REFERENCES PRODUTOS(IDPRODUTOS)
);
