import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Article } from 'src/app/moduls/article';
import { Order } from 'src/app/moduls/order';
import { OrderService } from 'src/app/service/order.service';
import { environment } from 'src/environments/environment';
import { RequestStatusComponent } from '../request-status/request-status.component';

@Component({
  selector: 'app-ajoute-article',
  templateUrl: './ajoute-article.component.html',
  styleUrls: ['./ajoute-article.component.css']
})
export class AjouteArticleComponent implements OnInit {

  articles:Article[]=[]
  order!: Order;
  apiUrl=environment.apiUrl;


  constructor(@Inject(MAT_DIALOG_DATA) public data: any,private sendNotification:MatDialog,private orderService :OrderService) {
        this.articles=data.articles
       this.order=data.order

  }

  ngOnInit(): void {
  }



  checkArticles(idArticle:number):boolean{
    return this.order.article.some(element => { if (element.id === idArticle) {  return true } else {  return false }
    });
  }


  ajouteArticle(idArticle:number){
    const order=this.articles.filter(article=>article.id==idArticle).shift()

    if(order && !this.checkArticles(idArticle) ){
    this.order.article.push(order)
    this.orderService.changeOrder(this.order.id,this.order).subscribe(()=>{this.sendNotification.open(RequestStatusComponent, { data: "Demande Enregistrer" })},
    (err:HttpErrorResponse)=>this.sendNotification.open(RequestStatusComponent,{data:" Échec"}))
  }else{
    this.sendNotification.open(RequestStatusComponent,{data:"Article Existe Déjà"
    })
  }

  }



}
