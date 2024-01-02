import { Boleto } from './boleto';
import { Card } from './card';

export interface PaymentMethod {
  method: string;
  card?: Card;
  boleto?: Boleto;
}
