import { Buyer } from './../models/buyer';
import { Card } from './../models/card';
import { PaymentMethod } from './../models/payment-method';
import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { PaymentData } from '../models/payment-data';

@Injectable({
  providedIn: 'root',
})
export class ApiPaymentService {
  url = 'http://localhost:8080/payment';

  constructor(private httpClient: HttpClient) {}

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
  };

  getPayments(): Observable<PaymentData[]> {
    return this.httpClient
      .get<PaymentData[]>(this.url)
      .pipe(retry(2), catchError(this.handleError));
  }

  postPayment(payment: Partial<PaymentData>): Observable<PaymentData[]> {
    return this.httpClient
      .post<PaymentData[]>(this.url, JSON.stringify(payment), this.httpOptions)
      .pipe(retry(2), catchError(this.handleError));
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro ocorreu no lado do client
      errorMessage = error.error.message;
    } else {
      // Erro ocorreu no lado do servidor
      errorMessage =
        `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }
}
