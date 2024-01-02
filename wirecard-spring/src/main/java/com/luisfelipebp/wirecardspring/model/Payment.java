package com.luisfelipebp.wirecardspring.model;

import com.luisfelipebp.wirecardspring.model.DTO.PaymentDTO;
import com.luisfelipebp.wirecardspring.model.enums.MethodPayment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "payment")
public class Payment {

    public Payment(Long id, double amount, MethodPayment type){
        this.id = id;
        this.amount = amount;
    }

    public Payment(PaymentDTO paymentDTO){
        this.id = paymentDTO.id();
        this.amount = paymentDTO.amount();
        this.method = paymentDTO.method();
        this.buyer = paymentDTO.buyer();
        this.client_id = paymentDTO.client_id();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double amount;

    @Embedded
    private Method method;

    @OneToOne(cascade = {CascadeType.PERSIST},fetch= FetchType.EAGER)
    private Buyer buyer;

    private Long client_id;
}

