package com.example.BookMyShow.Model;

import com.example.BookMyShow.Enums.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "theaters")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TheatreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "city", nullable = false)
    private String city;

    @OneToMany(mappedBy = "theatreEntity" ,cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowEntity> showEntityList;

    TheatreType theatreType;

    @OneToMany(mappedBy = "theatreEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    List<TheatreSeatEntity> theatreSeatEntityList;

}
