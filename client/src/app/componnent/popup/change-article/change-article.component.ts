import { Component, Inject, OnInit, Output } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { EventEmitter } from '@angular/core';
import { OrderService } from 'src/app/service/order.service';
import { Article } from 'src/app/moduls/article';
import { Order } from 'src/app/moduls/order';
import { RequestStatusComponent } from '../request-status/request-status.component';
import { HttpErrorResponse } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-change-article',
  templateUrl: './change-article.component.html',
  styleUrls: ['./change-article.component.css']
})
export class ChangeArticleComponent implements OnInit {
  articles:Article[]=[]
  order: Order={
    id: 0,
    reference: '',
    date: '',
    article: []
  }
  newOrder: Order ={
    id: 0,
    reference: '',
    date: '',
    article: []
  }

  apiUrl=environment.apiUrl;

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,private sendNotification:MatDialog,private orderService :OrderService) {
    this.order=data
    this.articles= data.article
  }




  ngOnInit(): void {
  }




  deleteArticle(idArticle:number){
    this.newOrder.article=this.order.article.filter(article=>article.id!=idArticle)
    this.sendNotification.closeAll()
    this.orderService.changeOrder(this.order.id,this.newOrder).subscribe(
      ()=>{this.order.article=this.newOrder.article
      this.sendNotification.open(RequestStatusComponent,{data:"Success"}
    )
    },
    )


  }



}
