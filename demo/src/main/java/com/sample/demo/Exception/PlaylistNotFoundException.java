package com.sample.demo.Exception;

public class PlaylistNotFoundException extends RuntimeException {
    public PlaylistNotFoundException(final Long id) {
        super(String.format("playlist with id '%s' not found", id));
    }

}
