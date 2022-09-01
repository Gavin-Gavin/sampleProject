package com.sample.demo.Repository;

import com.sample.demo.Model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    public Optional<Playlist> findByName(String name);

    @Query(value = "select name from song where playlist_id = ?", nativeQuery = true)
    public List<String> getSongsUsingNativeQuery(BigInteger playlistId);
}
