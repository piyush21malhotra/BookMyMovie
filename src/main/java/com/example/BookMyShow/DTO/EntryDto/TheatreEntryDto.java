package com.example.BookMyShow.DTO.EntryDto;

import com.example.BookMyShow.Enums.TheatreType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreEntryDto {

    private String name;
    private String address;
    private String city;
    private TheatreType theatreType;
}
