package com.sample.demo.Controller;

import com.sample.demo.Model.Playlist;
import com.sample.demo.Model.Song;
import com.sample.demo.Service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistRestController {

    public PlaylistService playlistService;

    @Autowired
    public PlaylistRestController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/")
    public String root() {
        return "Application is successfully running!";
    }

    @GetMapping("/all")
    public List<Playlist> getAllPlaylists() {
        return playlistService.getAllPlaylists();
    }

    @GetMapping("/{id}")
    public Playlist getPlaylistById(@PathVariable("id") Long playlistId) {
        return playlistService.getPlaylistById(playlistId);
    }

    @PostMapping("/{name}")
    public Playlist createPlaylist(@PathVariable("name") String playlistName) {
        return playlistService.createPlaylist(playlistName);
    }

    @DeleteMapping("/{id}")
    public void deletePlaylist(@PathVariable("id") Long playlistId) {
        playlistService.deletePlaylist(playlistId);
    }

    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        return playlistService.getAllSongs();
    }

    @GetMapping("/songs/{id}")
    public Song getSongById(@PathVariable("id") Long id) {
        return playlistService.getSongById(id);
    }

    @GetMapping("/{id}/songs")
    public List<Song> getSongsByPlaylistId(@PathVariable("id") Long playlistId) {
        return playlistService.getSongsByPlaylistId(playlistId);
    }

    @DeleteMapping("/{id}/songs")
    public void deleteSongsByplaylistId(@PathVariable("id") Long playlistId) {
        playlistService.deleteSongsByPlaylistId(playlistId);
    }

    @PostMapping("/{id}/add")
    public Song addSongToPlaylist(@PathVariable("id") Long playlistId, @RequestBody Song song) {
        return playlistService.addSongToPlaylist(playlistId, song);
    }

    @PutMapping("/songs/{id}/{playlistId}")
    public boolean moveSongToOtherPlaylist(@PathVariable("id") Long songId, @PathVariable("playlistId") Long playlistId) {
        return playlistService.moveSong(songId, playlistId);
    }

    @DeleteMapping("{id}/songs/{songId}")
    public void deleteSongById(@PathVariable("id") Long playlistId, @PathVariable("songId") Long songId) {
        playlistService.deleteSong(songId, playlistId);
    }

}
