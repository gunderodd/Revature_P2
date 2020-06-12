// export class Order {
//     id: number;
//     createdAt: string;
//     status: string;
// }
// Most likely the code above can be disregarded

import { OrderProduct } from './order-product';
import { User } from './user';

export class Order {
  orderProductList: OrderProduct[];
  orderId: number;
  user: User;
  status: string;
  createdAt: Date;
}

