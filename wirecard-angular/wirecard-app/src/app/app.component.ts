import { PaymentData } from './models/payment-data';
import { ApiPaymentService } from './services/api-payment.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'Desafio wirecard backend';

  constructor() {}
}
