package com.sample.demo.Service;

import com.sample.demo.Exception.PlaylistNotFoundException;
import com.sample.demo.Exception.SongNotFoundException;
import com.sample.demo.Model.Playlist;
import com.sample.demo.Model.Song;
import com.sample.demo.Repository.PlaylistRepository;
import com.sample.demo.Repository.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlaylistService {

    private PlaylistRepository playlistRepo;

    private SongsRepository songsRepo;

    @Autowired
    public PlaylistService(PlaylistRepository playlistRepo, SongsRepository songsRepo) {
        this.playlistRepo = playlistRepo;
        this.songsRepo = songsRepo;
    }

    public List<Playlist> getAllPlaylists() {
        return playlistRepo.findAll();
    }

    public Playlist getPlaylistById(Long palylistId) {
        return playlistRepo.findById(palylistId).orElseThrow(() -> new PlaylistNotFoundException(palylistId));
    }

    public List<Song> getAllSongs() {
        return songsRepo.findAll();
    }

    public List<Song> getSongsByPlaylistId(Long playlistId) {
        return songsRepo.getSongs(playlistId);
    }

    public Song getSongById(Long id) {
        return songsRepo.findById(id).orElseThrow(() -> new SongNotFoundException(id));
    }

    public Playlist createPlaylist(String name) {
        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist.setCreatedOn(new Date());
        return playlistRepo.save(playlist);
    }

    public void deletePlaylist(Long playlistId) {
        playlistRepo.deleteById(playlistId);
    }

    public Song addSongToPlaylist(Long playlistId, Song song) {
        Playlist playlist = playlistRepo.findById(playlistId).orElseThrow(() -> new PlaylistNotFoundException(playlistId));
        song.setPlaylistId(playlist.getId());
        song.setCreatedOn(new Date());
        return songsRepo.save(song);
    }

    public boolean moveSong(Long songId, Long toPlaylistId) {
        return 1 == songsRepo.updatePlaylist(songId, toPlaylistId);
    }

    public void deleteSong(Long songId, Long playlistId) {
        songsRepo.deleteSongByPlaylistIdAndId(playlistId, songId);
    }

    public void deleteSongsByPlaylistId(Long playlistId) {
        songsRepo.deleteSongsByPlaylistId(playlistId);
    }



}
