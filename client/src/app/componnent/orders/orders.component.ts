import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Article } from 'src/app/moduls/article';
import { Order } from 'src/app/moduls/order';
import { ArticleService } from 'src/app/service/article.service';
import { OrderService } from 'src/app/service/order.service';
import { AjouteArticleComponent } from '../popup/ajoute-article/ajoute-article.component';
import { ChangeArticleComponent } from '../popup/change-article/change-article.component';
import { RequestStatusComponent } from '../popup/request-status/request-status.component';
@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
orders:Order[]=[]
articles:Article[]=[]


  constructor(private sendNotification:MatDialog,private orderService:OrderService, private articleService:ArticleService) {}





  ngOnInit(): void {
  this.getorders()
  this.articleService.getArticle().subscribe(data=>this.articles=data ,
  (err:HttpErrorResponse)=>this.sendNotification.open(RequestStatusComponent,{data:" Échec"}))

  }

  ajouterArticle(id_aticle:number){
    const order=this.orders.filter(order=>order.id==id_aticle).shift()
    this.sendNotification.open(AjouteArticleComponent,{data:{'articles':this.articles,'order':order}, height: '100%'
    })


  }






  getorders(){
    return this.orderService.getOrders().subscribe(data=>this.orders=data   ,
      (err:HttpErrorResponse)=>this.sendNotification.open(RequestStatusComponent,{data:" Échec"}))
  }


  modifierArticle(id_aticle:number){

    const order=this.orders.filter(order=>order.id==id_aticle).shift()
if(order && order.article.length>0){
  this.sendNotification.open(ChangeArticleComponent,{data:order, height: '100%'
})
}else{
  this.sendNotification.open(RequestStatusComponent,{data:"Vide"})

}


  }



}
