package com.luisfelipebp.wirecardspring.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @NotBlank
    private String holder;

    @NotBlank
    private String number;

    @NotBlank
    private String expirationCard;

    @NotBlank
    private String CVV;

}
