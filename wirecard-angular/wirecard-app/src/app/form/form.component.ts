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
} from '@angular/forms';
import { PaymentData } from '../models/payment-data';
import { ApiPaymentService } from '../services/api-payment.service';
import { NgxMaskDirective, provideNgxMask } from 'ngx-mask';

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
  selectedPaymentMethod: string = 'boleto';
  // cardHolderName: string = '';

  paymentData = {} as PaymentData;
  paymentsData: PaymentData[] | undefined;

  name: any = new FormControl('', [
    Validators.required,
    Validators.minLength(3),
  ]);
  email: any = new FormControl('', [Validators.required, Validators.email]);
  cpf: any = new FormControl('', [Validators.required, Validators.min(11)]);
  amount: any = new FormControl('');
  paymentMethod: any = new FormControl('');
  cardHolder: any = new FormControl('');
  cardNumber: any = new FormControl('');
  cardExpiration: any = new FormControl('');
  cardCvv: any = new FormControl('');

  constructor(private ApiPaymentService: ApiPaymentService) {}

  getPayments() {
    this.ApiPaymentService.getPayments().subscribe(
      (paymentsDatas: PaymentData[]) => {
        this.paymentsData = paymentsDatas;
      }
    );
  }

  onSubmit() {
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
    this.postPayments();
  }

  postPayments() {
    this.ApiPaymentService.postPayment(this.paymentData).subscribe(() => {
      console.log('sucesso');
    });
  }

  getErrorMessage() {
    if (this.cpf.hasError('minlength')) {
      return 'Digite um CPF válido';
    }
    return 'Campo obrigatório';
  }

  cleanForm(form: NgForm) {
    console.log('foi');
    this.getPayments();
    form.resetForm();
    this.paymentData = {} as PaymentData;
  }
}
