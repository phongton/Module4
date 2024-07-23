package com.codegym.musicvalidation.repository;

import com.codegym.musicvalidation.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMusicRepository extends JpaRepository<Music, Long> {
    Page<Music> findAllByNameSongContaining(String name, Pageable pageable);

}
