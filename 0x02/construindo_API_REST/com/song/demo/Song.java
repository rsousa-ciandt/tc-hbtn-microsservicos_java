package com.song.demo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Song {
    private Integer id;
    private String nome;
    private String album;
    private String artista;
    private String anoLancamento;
}
