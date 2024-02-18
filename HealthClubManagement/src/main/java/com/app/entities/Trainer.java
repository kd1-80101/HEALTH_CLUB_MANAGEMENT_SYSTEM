package com.app.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
