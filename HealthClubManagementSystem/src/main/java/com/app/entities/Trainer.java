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
    @JoinColumn
    private User trainer;

    @Column
    private String expertise;

}
