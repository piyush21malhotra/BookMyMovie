package com.example.BookMyShow.DTO.ResponseDto;

import com.example.BookMyShow.Enums.TheatreType;
import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreResponseDto {

    @NotNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String address;
    @NonNull
    private String city;
    @NonNull
    TheatreType theatreType;

}
