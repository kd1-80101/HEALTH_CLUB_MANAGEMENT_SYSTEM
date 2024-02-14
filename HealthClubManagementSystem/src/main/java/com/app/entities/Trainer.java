package com.app.entities;
import javax.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "trainers")
public class Trainer extends BaseEntity {

    @OneToOne
    @MapsId // Map the userId as the primary key of Trainer
    @JoinColumn(name = "user_id")
    private User userId;

    @Column
    private String expertise;

}
