package com.luisfelipebp.wirecardspring.controller;

import com.luisfelipebp.wirecardspring.model.DTO.PaymentDTO;
import com.luisfelipebp.wirecardspring.model.Payment;
import com.luisfelipebp.wirecardspring.service.PaymentService;
import jakarta.validation.Valid;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:4200/")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> findAllPayments(){
        return ResponseEntity.ok().body(paymentService.findAllPayments());
    }

    @PostMapping
    public ResponseEntity<Payment> finishPayment(@RequestBody @Valid PaymentDTO paymentDTO) throws Exception {
        return ResponseEntity.ok().body(paymentService.finishPayment(paymentDTO));
    }


}
