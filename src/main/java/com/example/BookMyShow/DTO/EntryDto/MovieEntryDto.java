package com.example.BookMyShow.DTO.EntryDto;

import com.sun.istack.NotNull;
import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MovieEntryDto {

    private String name;
    @NotNull
    private LocalDate releaseDate;

}
