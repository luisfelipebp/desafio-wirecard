package com.luisfelipebp.wirecardspring.service.validator;

import com.luisfelipebp.wirecardspring.model.Boleto;
import com.luisfelipebp.wirecardspring.model.DTO.PaymentDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Random;

@Service
public class ValidatorPayment {

    public void validatorCard(PaymentDTO paymentDTO){
        int tamanhoNumero = 48;
        Random random = new Random();
        StringBuilder numeroAleatorio = new StringBuilder();
        for (int i = 0; i < tamanhoNumero; i++) {
            int digito = random.nextInt(10);
            numeroAleatorio.append(digito);
        }
        String numeroAleatorioString = numeroAleatorio.toString();
        Boleto boleto = new Boleto(numeroAleatorioString, LocalDate.now().plusDays(3));
        paymentDTO.method().setBoleto(boleto);
    }

    public void validatorBoleto(PaymentDTO paymentDTO) throws Exception {
        if(!isValidNumberCreditCard(paymentDTO.method().getCard().getNumber())){
            throw new Exception("Cartão de crédito inválido");
        }
        if(!isValidDateCreditCard(paymentDTO.method().getCard().getExpirationCard())){
            throw new Exception("Data do cartão inválida");
        }
    }

    private boolean isValidNumberCreditCard(String number) {
        number = number.replaceAll(" ","");
        if (number.length() < 13 || number.length() > 19) {
            return false;
        }

        int sum = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = number.charAt(i) - '0';
            if (i % 2 == 0) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
        }

        return sum % 10 == 0;
    }

    private boolean isValidDateCreditCard(String date){
        String[] monthYear = date.split("/");
        int year = Integer.parseInt(monthYear[1]);
        int month = Integer.parseInt(monthYear[0]);

        YearMonth yearMonth = YearMonth.of(year, month);
        int lastDayOfMonth = yearMonth.lengthOfMonth();
        LocalDate dateCard = LocalDate.of(year, month, lastDayOfMonth);
        LocalDate validDate = LocalDate.now().plusMonths(13);
        return dateCard.isAfter(validDate);
    }
}
