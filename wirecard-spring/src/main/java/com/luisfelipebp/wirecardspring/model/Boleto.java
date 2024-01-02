package com.luisfelipebp.wirecardspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Boleto {

    private String code;

    private LocalDate expirationBoleto;
}
