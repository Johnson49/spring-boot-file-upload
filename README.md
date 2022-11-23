# Upload e download de arquivos com Spring Boot 

API REST feita em Spring Boot permite enviar e baixar arquivos.

Configurações prévias

Para executar esse projeto, é necessário que seu sistema contenha a seguinte instalação:

1. JDK versão 17 ou superior.

|Método|Rota| Funcionalidade| Acesso |
|:-------:|:-----:|:------:|:------:|
|POST | /file/upload | Upload do arquivo.| Público |
|GET |  /file/all | Obtém os dados de todos os arquivos| Público |
|GET | /file/{id} | Baixa o arquivo especificado. | Público |
