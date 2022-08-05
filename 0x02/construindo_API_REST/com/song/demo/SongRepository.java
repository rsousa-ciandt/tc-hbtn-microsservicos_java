package com.techcamps.song;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        Optional<Song> optionalSong = list.stream().filter(s -> s.getId().equals(id)).findFirst();

        if (optionalSong.isEmpty()) {
            return null;
        }

        return optionalSong.get();
    }

    public void addSong(Song s) {
        this.list.add(s);
    }

    public void updateSong(Song s) {
        Song song = this.getSongById(s.getId());

        if (song != null) {
            song.setId(s.getId());
            song.setNome(s.getNome());
            song.setAlbum(s.getAlbum());
            song.setArtista(s.getArtista());
            song.setAnoLancamento(s.getAnoLancamento());
        }
    }

    public void removeSong(Song s) {
        Song song = this.getSongById(s.getId());

        if (song != null) {
            this.list.remove(song);
        }
    }
}
