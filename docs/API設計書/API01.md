# API01 ユーザー作成

## 処理概要

本APIは、新しいユーザーを作成するAPIです。

## エンドポイント

```bash
POST /api/user
```

## リクエスト
- メソッド: `POST`
- Content-Type: `application/json`
- リクエストボディ
```json
{
  "user_name": "string",        
  "email": "string",           
  "password": "string",        
  "first_name": "string",       
  "last_name": "string"    
}
```

## 処理シーケンス

```mermaid
sequenceDiagram
    participant クライアント
    participant サーバー
    participant 会員情報サービス
    participant DB
    クライアント->>+サーバー: ユーザー作成APIを呼び出し
    サーバー->>+会員情報サービス: 新規会員情報を送信
    会員情報サービス-->>-サーバー: 会員IDを返却
    サーバー->>DB: ユーザー情報を登録
    サーバー->>-クライアント: 結果を返却
```
