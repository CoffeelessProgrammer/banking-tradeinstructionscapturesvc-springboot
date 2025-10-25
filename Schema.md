# Data Models for Trade-Instructions-Capture-Svc

## Canonical
```mermaid
erDiagram
    direction LR

    account ||--o{ trade: requests

    account[Account] {
        BIGINT account_no PK
        TEXT platform_id FK
    }

    trade[Trade] {
        BIGINT trade_id PK
        BIGINT account_no FK
        TEXT security_id FK
        CHAR trade_type "B,S"
        VARCHAR(5) order_type "Market (M), Stop Loss (SL), Limit (L), Stop Limit (SL)"
        INTEGER quantity
        TIMESTAMP expiration
    }
```

## Trade Req.
```json
{
    "platform_id": "ACCT123456",
    "account_no": "1234567890",
    "security_id": "SPY",
    "trade_type": "Buy",
    "order_type": "Market",
    "quantity": 1024,
    "expiration": "2025-10-28T20:00:00Z"
}
```

## Platform Trade

```json
{
    "platform_id": "ACCT123",
    "trade": {
        "account": "****1234",
        "security": "SPY",
        "type": "B",
        "amount": 100000,
        "timestamp": "2025-08-04T21:15:33Z"
    }
}
```