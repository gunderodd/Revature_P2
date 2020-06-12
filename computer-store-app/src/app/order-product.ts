import { Order } from './order';
import { Product } from './product';

export class OrderProduct {
  order: Order;
  product: Product;
  quantity: number;
}