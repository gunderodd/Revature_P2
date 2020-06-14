import { User } from './user';

export class Order {
  id: number;
  user: User;
  status: string;
  createdAt: Date;
}

