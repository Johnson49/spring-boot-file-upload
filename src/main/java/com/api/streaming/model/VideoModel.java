package com.api.streaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "video")
@Data
@NoArgsConstructor
public class VideoModel{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(unique = true)
   private String nome;

   @Lob
   private byte[] dados;

   private String TipoDoArquivo;


public VideoModel(String nome, byte[] dados, String TipoDoArquivo) {
       this.nome = nome;
       this.dados = dados;
       this.TipoDoArquivo = TipoDoArquivo;
   }
}