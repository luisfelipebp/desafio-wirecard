package com.luisfelipebp.wirecardspring.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "buyer")
@Validated
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Usuário deve conter um nome.")
    private String name;

    private String email;

    @NotBlank(message = "Usuário deve conter um cpf válido.")
    @Size(min = 11, max = 11, message = "Cpf inválido.")
    private String cpf;

}
