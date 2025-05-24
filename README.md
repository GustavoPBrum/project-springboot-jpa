# Spring Boot Project: E-Commerce API  

Este projeto é uma aplicação desenvolvida com **Java** e **Spring Boot** que implementa um sistema de e-commerce. Ele inclui funcionalidades para gerenciar produtos, categorias, pedidos, pagamentos e usuários, com suporte para operações CRUD e tratamento de exceções.  

---

## 🚀 Tecnologias Utilizadas  

- **Java**  
- **Spring Boot**  
- **Apache Tomcat**  
- **Maven** (gerenciamento de dependências e build)  
- **H2 Database** (banco de dados em memória para testes)  
- **PostgreSQL** (banco de dados em produção)  
- **Postman** (testes de requisições HTTP)  
- **Heroku** (deploy em produção)  

---

## 🛠️ Funcionalidades  

1. **Modelo de Domínio**:  
   - Produto (*Entity*)  
   - Categoria (*Entity*)  
   - Pedido (*Entity*)  
   - ItemProduto (*Entity*)  
   - Pagamento (*Entity*)  
   - Usuário (*Entity*)  
   - OrdemStatus (*Enum*)  

2. **Estrutura de Camadas Lógicas**:  
   - **Application**  
   - **Camada Resource**: Controladores REST  
   - **Camada Service**: Regras de negócio  
   - **Camada Repository**: Interface com o banco de dados  

3. **Banco de Dados**:  
   - **H2 Database**: Banco de dados em memória para testes, configurado automaticamente (não é necessário baixar nada).  
   - **PostgreSQL**: Banco de dados em produção.  

4. **CRUD (Create, Retrieve, Update, Delete)**:  
   - Operações completas para todas as entidades.  

5. **Tratamento de Exceções**:  
   - Gerenciamento e padronização de erros para garantir uma API consistente e confiável.  

---

## 🛠️ Estrutura do Projeto  

A aplicação segue a estrutura organizada abaixo, para facilitar a manutenção e escalabilidade:  

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── estudandobackend/
│   │           └── course/
│   │               ├── config/
│   │               ├── entities/
│   │               ├── repositories/
│   │               ├── resources/
│   │               └── services/
│   └── resources/
│       ├── application.properties
│       └── data.sql
└── test/
    └── java/
        └── com/
            └── estudandobackend/
                └── course/
