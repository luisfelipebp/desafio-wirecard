package com.luisfelipebp.wirecardspring.model.DTO;

import com.luisfelipebp.wirecardspring.model.Buyer;
import com.luisfelipebp.wirecardspring.model.Method;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PaymentDTO(Long id, @NotNull @Min(1) double amount, @Valid Method method, @Valid Buyer buyer, @NotNull Long client_id){
}
