import { Buyer } from './buyer';
import { PaymentMethod } from './payment-method';

export interface PaymentData {
  amount: number;
  method: PaymentMethod;
  client_id: number;
  buyer: Buyer;
}
