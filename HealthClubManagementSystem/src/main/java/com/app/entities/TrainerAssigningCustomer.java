package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="trainer_AssignTo_Customer")
public class TrainerAssigningCustomer extends BaseEntity {
    
    @ManyToOne
    @JoinColumn(name="trainer_id")
    private Trainer trainer;
    
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    
}
