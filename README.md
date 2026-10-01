# Sistema Restaurante API

API REST para gerenciamento de um restaurante, desenvolvida como projeto educacional e de portfólio.

## Tecnologias
Java 17, Spring Boot, Spring Data JPA, PostgreSQL, Maven, Docker e REST API.

## Funcionalidades
- Cadastro de mesas
- Cadastro de clientes
- Cadastro de categorias e pratos
- Controle de disponibilidade de pratos
- Criação de pedidos
- Itens de pedido
- Cálculo automático do total
- Status do pedido

## Endpoints
- GET/POST /api/customers
- GET/POST /api/tables
- GET/POST /api/categories
- GET/POST /api/dishes
- GET/POST /api/orders
- PATCH /api/orders/{id}/status

## Execução
```bash
docker compose up --build
```

API: http://localhost:8080

**Autor:** Luis Fillipe Backer Faria  
**GitHub:** https://github.com/lfillipebf-ai
