package com.sample.demo.Repository;

import com.sample.demo.Model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SongsRepository extends JpaRepository<Song, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Song s where s.playlistId = ?1")
    public void deleteSongsByPlaylistId(Long playlistId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("delete from Song s where s.playlistId = ?1 and s.id = ?2")
    public void deleteSongByPlaylistIdAndId(Long playlistId, Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Song s set s.playlistId = ?2 where s.id = ?1")
    public int updatePlaylist(Long songId, Long playlistId);

    @Query("select s from Song s where s.playlistId = ?1")
    public List<Song> getSongs(Long playlistId);
}
