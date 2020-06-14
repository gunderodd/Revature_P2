import { OrderProduct } from './order-product';

export class Product {
    orderProductList: OrderProduct[];
    productId: number;
    name: string;
    description: string;
    price: number;
    stock: number;
    url: string;
}