import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Order } from '../moduls/order';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor( private http:HttpClient) { }
  private apiUrl=environment.apiUrl;



createOrder(order:Order){

  return this.http.post(`${this.apiUrl}/orders`,order)

}

  getOrders(){

   return this.http.get<Order[]>(`${this.apiUrl}/orders`)
  }



 changeOrder(idOrder:number,newOrder:Order){

    return this.http.put(`${this.apiUrl}/orders/`+idOrder,newOrder)
 }



}

