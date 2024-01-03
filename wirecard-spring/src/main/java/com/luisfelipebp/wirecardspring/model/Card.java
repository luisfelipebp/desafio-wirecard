package com.luisfelipebp.wirecardspring.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @NotBlank(message = "Cartão de crédito deve conter um nome válido.")
    private String holder;

    @NotBlank(message = "Cartão de crédito deve conter um número válido.")
    private String number;

    @NotBlank(message = "Cartão de crédito deve conter uma date de expiração válida.")
    private String expirationCard;

    @NotBlank(message = "CVV deve ser válido.")
    private String CVV;

}
