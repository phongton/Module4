package com.codegym.musicvalidation.service.impl;

import com.codegym.musicvalidation.model.Music;
import com.codegym.musicvalidation.repository.IMusicRepository;
import com.codegym.musicvalidation.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;


    @Override
    public Page<Music> getAllMusic(String name, Pageable pageable) {
        return musicRepository.findAllByNameSongContaining(name, pageable);
    }

    @Override
    public Music saveMusic(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public Music findMusicById(Long id) {
        return musicRepository.findById(id).orElse(null);
    }
}
