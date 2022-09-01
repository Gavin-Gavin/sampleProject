package com.sample.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "song")
@NamedNativeQuery(name = "songsByPlaylistId", query = "select id, name, playlist_id, cover_url, created_on from song s where s.playlist_id = ?", resultClass = Song.class)
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "playlist_id")
    private long playlistId;

    private String name;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "cover_url")
    private String coverUrl;
}
