import { OrderProduct } from './order-product';
import { User } from './user';

export class Order {
  orderProductList: OrderProduct[];
  orderId: number;
  user: User;
  status: string;
  createdAt: Date;
}