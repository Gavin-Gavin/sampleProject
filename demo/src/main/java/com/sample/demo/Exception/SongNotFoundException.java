package com.sample.demo.Exception;

public class SongNotFoundException extends RuntimeException {
    public SongNotFoundException(final Long id) {
        super(String.format("song with id '%s' not found", id));
    }
}
