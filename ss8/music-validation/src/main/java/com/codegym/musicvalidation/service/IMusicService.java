package com.codegym.musicvalidation.service;

import com.codegym.musicvalidation.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMusicService {
    Page<Music> getAllMusic(String name, Pageable pageable);

    Music saveMusic(Music music);

    Music findMusicById(Long id);
}
