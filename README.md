# Spring Boot Project: E-Commerce API  

Este projeto é uma aplicação desenvolvida com **Java** e **Spring Boot** que implementa um sistema de e-commerce. Ele inclui funcionalidades para gerenciar produtos, categorias, pedidos, pagamentos e usuários, com suporte para operações CRUD e tratamento de exceções.  

---

## 🚀 Tecnologias Utilizadas  

- **Java**  
- **Spring Boot**  
- **Apache Tomcat**  
- **Maven** (gerenciamento de dependências e build)  
- **JPA** (persistência de dados e mapeamento objeto-relacional)  
- **Hibernate** (implementação da interface JPA)  
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

4. **JPA e Hibernate**:  
   - **JPA**: Fornece a abstração para persistência de dados e mapeamento objeto-relacional (ORM).  
   - **Hibernate**: Responsável por implementar a interface JPA e gerenciar as operações de banco de dados.  

5. **CRUD (Create, Retrieve, Update, Delete)**:  
   - Operações completas para todas as entidades.  

6. **Tratamento de Exceções**:  
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
```

---

### Sobre o Desenvolvedor

Este projeto foi desenvolvido por [Gustavo Pereira Brum](https://www.linkedin.com/in/gustavo-pereira-brum-42671b241/), estudante de Engenharia de Software, entusiasta de Java e apaixonado por desenvolvimento backend.  
