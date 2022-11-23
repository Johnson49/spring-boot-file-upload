package com.api.streaming;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
    private String NomeDoArquivo;
    private String downloadURL;
    private String TipoDoArquivo;
    private long tamanhoDoArquivo;
}