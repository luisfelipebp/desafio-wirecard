import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { CommonModule } from '@angular/common';
import {
  FormControl,
  Validators,
  FormsModule,
  ReactiveFormsModule,
  NgForm,
  FormBuilder,
} from '@angular/forms';
import { PaymentData } from '../models/payment-data';
import { ApiPaymentService } from '../services/api-payment.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'form-component',
  templateUrl: './form.component.html',
  styleUrl: './form.component.css',
  standalone: true,
  imports: [
    MatButtonModule,
    MatSelectModule,
    MatInputModule,
    MatFormFieldModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ],
})
export class FormComponent {
  selectedPaymentMethod: string = 'BOLETO';
  responsePayment = '';
  responseExpiration = '';

  paymentData = {} as PaymentData;
  paymentsData: PaymentData[] | undefined;

  name: any = new FormControl('', [
    Validators.required,
    Validators.minLength(3),
  ]);
  email: any = new FormControl('', [Validators.required, Validators.email]);
  cpf: any = new FormControl('', [Validators.required, Validators.min(11)]);
  amount: any = new FormControl('', [Validators.required]);
  paymentMethod: any = new FormControl('', [Validators.required]);
  cardHolder: any = new FormControl('', [Validators.required]);
  cardNumber: any = new FormControl('', [Validators.required]);
  cardExpiration: any = new FormControl('', [Validators.required]);
  cardCvv: any = new FormControl('', [Validators.required]);

  constructor(
    private ApiPaymentService: ApiPaymentService,
    private snackBar: MatSnackBar
  ) {}

  getPayments() {
    this.ApiPaymentService.getPayments().subscribe(
      (paymentsDatas: PaymentData[]) => {
        this.paymentsData = paymentsDatas;
      }
    );
  }

  onSubmit() {
    if (this.paymentMethod.value == 'CARD') {
      this.paymentData = {
        amount: this.amount.value,
        method: {
          method: this.paymentMethod.value,
          card: {
            holder: this.cardHolder.value,
            number: this.cardNumber.value,
            expirationCard: this.cardExpiration.value,
            cvv: this.cardCvv.value,
          },
        },
        client_id: 1,
        buyer: {
          name: this.name.value,
          email: this.email.value,
          cpf: this.cpf.value,
        },
      };
    }
    if (this.paymentMethod.value == 'BOLETO') {
      this.paymentData = {
        amount: this.amount.value,
        method: {
          method: this.paymentMethod.value,
        },
        client_id: 1,
        buyer: {
          name: this.name.value,
          email: this.email.value,
          cpf: this.cpf.value,
        },
      };
    }
    this.postPayments();
  }

  postPayments() {
    this.ApiPaymentService.postPayment(this.paymentData).subscribe(
      (response: any) => {
        if (response.method && response.method.boleto) {
          this.responsePayment =
            'Código do boleto: ' + response.method.boleto.code;
          this.responseExpiration =
            'Expiração do boleto: ' + response.method.boleto.expirationBoleto;
        } else if (response.method && response.method.card) {
          this.responsePayment = 'Compra aprovada!';
        }
        this.openSnackBar('Pagamento realizado com sucesso!');
      }
    );
  }

  getErrorMessage() {
    if (this.cpf.hasError('minlength')) {
      return 'Digite um CPF válido';
    }
    return 'Campo obrigatório';
  }

  openSnackBar(message: string) {
    this.snackBar.open(message, '', {
      duration: 3000,
    });
  }
}
