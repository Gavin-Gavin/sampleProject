package com.sample.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Column(name = "created_on")
    private Date createdOn;

    @ElementCollection(targetClass = java.util.List.class)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
    private List<Song> songs;
}
