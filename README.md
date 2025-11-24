# CRUD  
Estudando sobre CRUD — Projeto feito por **Guilherme Marrafon**.
---
## 🎯 Objetivo  
Este projeto tem como finalidade prática implementar operações básicas de **Create**, **Read**, **Update** e **Delete (CRUD)** em Java, como forma de estudar e consolidar conceitos de lógica, programação orientada a objetos, persistência de dados e integração com banco de dados.
---
## 🧱 Tecnologias utilizadas  
- Java (21)  
- Maven (gerenciador de dependências)  
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Validation 
---
## ✅ Funcionalidades implementadas  
O projeto cobre todas as operações essenciais de um CRUD completo:
---
🔹 **Create**
Inserção de novos registros no banco de dados através de requisição POST. 

🔹 **Read**
Listagem de todos os registros
Consulta individual por ID
Paginação configurada para otimizar buscas em grandes volumes.

🔹 **Update**
Atualização de registros existentes usando requisições PUT.

🔹 **Delete**
Remoção de registros de forma segura, incluindo tratamento para IDs inexistentes.

---
🧩 Estrutura lógica da aplicação
controller  →  service  →  repository  →  database
        DTOs e Entities organizam as entradas e saídas de dados
---
🗄️ Banco de dados
http://localhost:8080/h2-console
---

### Testar no Postman  
[![Postman](https://img.shields.io/badge/Postman-Test%20Endpoint-orange?logo=postman)](http://localhost:8080/clients)

