package com.luisfelipebp.wirecardspring.service;

import com.luisfelipebp.wirecardspring.model.DTO.PaymentDTO;
import com.luisfelipebp.wirecardspring.model.Payment;
import com.luisfelipebp.wirecardspring.model.enums.MethodPayment;
import com.luisfelipebp.wirecardspring.repository.PaymentRepository;
import com.luisfelipebp.wirecardspring.service.validator.ValidatorPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ValidatorPayment validatorPayment;

    public List<Payment> findAllPayments(){
        return paymentRepository.findAll();
    }

    public Payment finishPayment(PaymentDTO paymentDTO) throws Exception {
        if(paymentDTO.method().getMethod().equals(MethodPayment.BOLETO)){
            validatorPayment.validatorCard(paymentDTO);
        }

        if(paymentDTO.method().getMethod().equals(MethodPayment.CARD)){
           validatorPayment.validatorBoleto(paymentDTO);
        }

        Payment newPayment = new Payment(paymentDTO);
        return paymentRepository.save(newPayment);
    }

}
