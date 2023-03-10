package com.example.BookMyShow.Model;


import lombok.*;
import java.util.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "mobile", nullable = false)
    private String mobile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    List<TicketEntity> tickets;
}
