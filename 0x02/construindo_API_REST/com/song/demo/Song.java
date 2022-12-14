package com.song.demo;

import java.util.Objects;

public class Song {
    private Integer id;
    private String nome;
    private String album;
    private String artista;
    private String anoLancamento;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) && Objects.equals(nome, song.nome) && Objects.equals(album, song.album) && Objects.equals(artista, song.artista) && Objects.equals(anoLancamento, song.anoLancamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, album, artista, anoLancamento);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return String.format("%d - %s - %s - %s - %s", id, nome, artista, album, anoLancamento)
    }
}
