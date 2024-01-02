package com.luisfelipebp.wirecardspring.model.DTO;

import com.luisfelipebp.wirecardspring.model.Buyer;
import com.luisfelipebp.wirecardspring.model.Method;
import com.luisfelipebp.wirecardspring.model.enums.MethodPayment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record PaymentDTO(Long id, @NotBlank double amount, @NotBlank MethodPayment type, @NotBlank Method method, @NotBlank Buyer buyer, @NotBlank Long client_id){
}
