// Customer.java
package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.enums.Membership;

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
@Table(name="customers")
public class Customer extends BaseEntity {
    
    @Enumerated(EnumType.STRING)
    private Membership membership;
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate membershipEnd;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    @Column
    private boolean paymentStatus;
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate membershipStart;
    
//    @OneToOne(mappedBy = "user") // Adjusted mapping for One-to-One relationship with Payment
//    private Payment payment;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Payment> payments;
}
