import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/service/order.service';
import { ArticleService } from 'src/app/service/article.service';
import { Article } from 'src/app/moduls/article';
import { Order } from 'src/app/moduls/order';
import { environment } from 'src/environments/environment';
import { MatDialog } from '@angular/material/dialog';
import { RequestStatusComponent } from '../popup/request-status/request-status.component';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.css']
})
export class ArticlesComponent implements OnInit {
  articles: Article[] = []
  order: Order={
    id: 0,
    reference: '',
    date: '',
    article: []
  }
  apiUrl=environment.apiUrl;

  constructor(private articleService: ArticleService,private sendNotification: MatDialog,private orderService:OrderService) { }


  ngOnInit(): void {
    this.getArticles()
  }



addOrder(idArticle:number){
const article=this.articles.filter(article=>article.id==idArticle)

this.order.article=article
this.orderService.createOrder(this.order).subscribe(

  data=>this.sendNotification.open(RequestStatusComponent,{data:"Demande Enregistrer"}),
  (err:HttpErrorResponse)=>this.sendNotification.open(RequestStatusComponent,{data:" Échec"})
)





  }

  getArticles() {
    this.articleService.getArticle().subscribe(data => this.articles = data,(err:HttpErrorResponse)=>this.sendNotification.open(RequestStatusComponent,{data:"Échec"}))

  }


}
