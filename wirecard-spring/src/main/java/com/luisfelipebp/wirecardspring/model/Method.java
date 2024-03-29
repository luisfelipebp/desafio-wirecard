package com.luisfelipebp.wirecardspring.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.luisfelipebp.wirecardspring.model.enums.MethodPayment;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Method {

    @Enumerated(EnumType.STRING)
    private MethodPayment method;

    @Embedded
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Valid
    private Card card;

    @Embedded
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boleto boleto;
}
