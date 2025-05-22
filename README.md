# ECモールプロジェクト
このプロジェクトは、Spring Boot を使用して構築されたECモールアプリケーションです。

## 環境構築

### GraalVMのインストール
```bash
sdk install java 21.0.7-graal
```

### WebアプリケーションをNative buildする
```bash
./gradlew nativeCompile
````

コンパイルが成功したら実行する。
```bash
./build/native/nativeCompile/ec-mall
```
