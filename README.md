# 📦 Serviço de envio de emails usando AWS Simple Email Service (SES)

Este projeto é uma aplicação Java que realiza o envio de e-mails com base em entradas fornecidas pelo usuário, utilizando o AWS SES (Simple Email Service) para garantir o envio automatizado, seguro e escalável.

## Funcionalidades

- Envio de email a partir da entrada contendo destinatario, assunto e corpo do email
- Estrutura modular e escalável, seguindo boas práticas de organização de código.
- Utilização de variáveis de ambiente para gerenciamento seguro de credenciais.

## Tecnologias Utilizadas
- Java 21+
- Maven
- AWS SDK for Java – Integração com o Amazon SES
- Docker (opcional)

## Estrutura do Projeto

```
qr-code-generator/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── emailSender/
│   │   │       ├── adapters/
│   │   │       ├── application/
│   │   │       ├── controllers/
│   │   │       ├── core/
│   │   │       │   └── dto/
│   │   │       │   └── exceptions/
│   │   │       ├── infra/
│   │   │       │   └── ses/
│   │   └── resources/
│   └── test/
├── .env
├── Dockerfile
├── pom.xml
└── README.md

```

## Configuração

Antes de executar o projeto, configure as credenciais da AWS. Você pode fazer isso via variáveis de ambiente ou um arquivo `.env`.

Exemplo `.env`:

```env
ACCESS_KEY_ID=your_access_key
SECRET_KEY=your_secret_key

```
Por não se tratar de informação confidencial, a region  foi injetada no `application.properties` enquanto as informações confidenciais são recuperadas de variáveis de ambiente.
```env
application.email.source=juarezgcjr@gmail.com
accessKeyId=${ACCESS_KEY_ID}
secretKey=${SECRET_KEY}
region=us-east-1
```


## Executando o Projeto

### Usando Maven

```bash
mvn clean package
java -jar target/emailSender.jar
```

### Usando Docker

```bash
docker build -t emailSender:1.0 .
docker run --env-file .env emailSender:1.0
```

## Exemplo de Funcionamento

1. O usuário fornece uma entrada com destinatário, assunto e corpo do e-mail.
2. A aplicação envia a solicitação para o Amazon SES.
3. Se o envio for bem-sucedido, uma mensagem de sucesso é exibida.
4. Em caso de falha, uma mensagem de erro informativa é retornada.

## Licença

Distribuído sob a licença MIT. Veja o arquivo `LICENSE` para mais informações.
