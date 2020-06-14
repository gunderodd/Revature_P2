import { User } from './user';

export class Order {
  orderId: number;
  user: User;
  status: string;
  createdAt: Date;
}

