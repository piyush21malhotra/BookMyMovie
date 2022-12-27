package com.example.BookMyShow.DTO.ResponseDto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDto {

    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String mobile;

}
