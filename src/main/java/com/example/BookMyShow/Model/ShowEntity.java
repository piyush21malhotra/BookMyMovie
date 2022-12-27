package com.example.BookMyShow.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.*;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(value = {AuditingEntityListener.class})
@Builder
@Table(name = "shows")
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "show_date", columnDefinition = "DATE", nullable = false)
    private LocalDate showDate;
    @Column(name = "show_time", columnDefinition = "TIME", nullable = false)
    private LocalTime showTime;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    List<TicketEntity> ticketEntityList;

    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.MERGE)
    @JsonIgnore
    List<ShowSeatsEntity> showSeatsEntityList;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    MovieEntity movieEntity;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    TheatreEntity theatreEntity;
}
