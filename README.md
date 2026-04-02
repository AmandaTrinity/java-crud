# Cadastro de Usuários (Java CRUD)

API REST simples para cadastro, consulta, atualização e remoção de usuários usando **Spring Boot**, **Spring Data JPA** e **H2 em memória**.

## ✨ Tecnologias

- ☕ Java 21
- 🍃 Spring Boot 3.5
- 🌐 Spring Web
- 🗄️ Spring Data JPA
- 🧪 H2 Database (in-memory)
- 🧰 Maven
- 🪶 Lombok

---

## 📁 Estrutura do projeto

```text
src/main/java/com/java/cadastro_usuario
├── business
│   └── UsuarioService.java
├── controller
│   └── UsuarioController.java
└── infrastructure
		├── entities
		│   └── Usuario.java
		└── repository
				└── UsuarioRepository.java
```

---

## 🚀 Como rodar o projeto

### Pré-requisitos

- Java 21+
- Maven 3.9+ (ou usar `./mvnw`)

### Executando

```bash
./mvnw spring-boot:run
```

Aplicação sobe por padrão em:

👉 `http://localhost:8080`

---

## 🧠 Banco de dados H2

Este projeto usa banco em memória (`jdbc:h2:mem:usuarios`).

- Console H2: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:usuarios`
- User: `sa`
- Password: _(vazio)_

> Como é em memória, os dados são perdidos ao reiniciar a aplicação.

---

## 📬 Endpoints da API

Base path: `/usuario`

### 1) Criar usuário

**POST** `/usuario`

```json
{
  "email": "ana@email.com",
  "nome": "Ana"
}
```

---

### 2) Listar usuários

**GET** `/usuario`

Exemplo cURL:

```bash
curl "http://localhost:8080/usuario"
```

---

### 3) Buscar usuário por e-mail

**GET** `/usuario/buscar?email=ana@email.com`

Exemplo cURL:

```bash
curl "http://localhost:8080/usuario/buscar?email=ana@email.com"
```

---

### 4) Atualizar usuário por ID

**PUT** `/usuario?id=1`

```json
{
  "email": "ana.novo@email.com",
  "nome": "Ana Silva"
}
```

---

### 5) Deletar usuário por e-mail

**DELETE** `/usuario?email=ana.novo@email.com`

Exemplo cURL:

```bash
curl -X DELETE "http://localhost:8080/usuario?email=ana.novo@email.com"
```

---

## 📌 Observações

- A API está usando a entidade diretamente no controller (didático/simples).
- Em produção, o ideal é usar DTOs, validação e tratamento global de exceções.

---

Feito para praticar CRUD com Spring Boot.
