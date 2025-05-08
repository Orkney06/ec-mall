# API02 ユーザー更新

## 処理概要

本APIは、ユーザー情報を更新するAPIです。

## エンドポイント

```bash
POST /api/user/:id
```

## リクエスト
- メソッド: `PUT`
- Content-Type: `application/json`
- リクエストボディ
```json
{
  "user_id": "string",
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
    クライアント->>+サーバー: ユーザー更新APIを呼び出し
    サーバー->>+会員情報サービス: 会員情情報を更新
    会員情報サービス-->>-サーバー: 変更した会員IDを返却
    サーバー->>-クライアント: 結果を返却
```