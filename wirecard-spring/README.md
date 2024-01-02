# Projeto de Processamento de Pagamentos             #

Este projeto oferece uma API para processamento de pagamentos, com endpoints que permitem criar e consultar pagamentos, clientes e compradores.

## Endpoints Disponíveis

### Endpoint `/payment`

#### GET `/payment`

- Retorna todos os pagamentos registrados.

#### POST `/payment`

- Cria um novo pagamento no sistema.

#### Formato da Requisição

{
  "amount": 100.00,
  "method": {
    "method": "CARD",
    "card": {
        "holder": "Felipe",
        "number": "4532756279624064",
        "expirationCard": "12/2025",
        "cvv": "123"
    }
  },
  "client_id": 1,
  "buyer": {
        "name": "Luis",
        "email": "luis@gmail.com",
        "cpf": "12345678911"
    }
}

ou

{
  "amount": 100.00,
  "method": {
    "method": "BOLETO"
  },
  "client_id": 1,
  "buyer": {
        "name": "Luis",
        "email": "luis@gmail.com",
        "cpf": "1232341214"
    }
}

### Endpoint `/client`

#### GET `/client`

- Retorna todos os clientes registrados.

### Endpoint `/buyer`

#### GET `/buyer`

- Retorna todos os compradores registrados.

## Considerações Importantes

- A rota `/payment` oferece métodos GET e POST para consultar e criar pagamentos, respectivamente.
- As requisições POST para `/payment` devem seguir o formato indicado para criar um novo pagamento.
- Os endpoints `/client` e `/buyer` oferecem métodos GET para consultar todos os clientes e compradores registrados no sistema.
