package com.codegym.musicvalidation.dto;

import com.codegym.musicvalidation.model.Category;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicDTO {
    private Long id;
    @NotBlank(message = "Không được phép để trống")
    @Size(max = 800)
    @Pattern(regexp = "^[\\p{L}0-9\\s]*$", message = "Tên bài hát không được chứa kí tự đặc biêt")
    private String nameSong;
    @NotBlank(message = "Không được phép để trống")
    @Size(max = 300)
    @Pattern(regexp = "^[\\p{L}0-9\\s,]*$", message = "Tên ca sĩ không được chứa kí tự đặc biêt")
    private String artist;
    private Category category;

    public MusicDTO() {
    }
}
