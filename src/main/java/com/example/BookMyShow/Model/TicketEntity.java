package com.example.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.*;

@Entity
@EntityListeners(value = { AuditingEntityListener.class })
@Table(name = "tickets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "allotted_seat", nullable = false)
    private String allottedSeats;
    @Column(name = "amount", nullable = false)
    private double amount;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at")
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    UserEntity user;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    ShowEntity showEntity;

    @OneToMany(mappedBy = "ticketEntity",cascade = CascadeType.ALL)
    @JsonIgnore
    List<ShowSeatsEntity> showSeatsEntityList;
}
