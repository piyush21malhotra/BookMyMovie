package com.example.BookMyShow.DTO.ResponseDto;

import com.sun.istack.NotNull;
import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MovieResponseDto {

    @NotNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private LocalDate releaseDate;

}
