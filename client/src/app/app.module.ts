import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatDialogModule } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { ArticlesComponent } from './componnent/articles/articles.component';
import { NavbarComponent } from './componnent/navbar/navbar.component';
import { Routes ,RouterModule} from '@angular/router';
import { OrdersComponent } from './componnent/orders/orders.component';
import { AddarticleComponent } from './componnent/addarticle/addarticle.component';
import { ChangeArticleComponent } from './componnent/popup/change-article/change-article.component';
import { AjouteArticleComponent } from './componnent/popup/ajoute-article/ajoute-article.component';
import { RequestStatusComponent } from './componnent/popup/request-status/request-status.component';

const route:Routes =[
{path:'articles',component: ArticlesComponent},
{path:'orders',component: OrdersComponent},
{path:'addarticle',component: AddarticleComponent},
{path:'**',redirectTo:'/articles'}

]


@NgModule({
  declarations: [
    AppComponent,
    ArticlesComponent,
    NavbarComponent,
    OrdersComponent,
    AddarticleComponent,
    ChangeArticleComponent,
    AjouteArticleComponent,
    RequestStatusComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatDialogModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(route),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
