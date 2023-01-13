import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Article } from 'src/app/moduls/article';
import { ArticleService } from 'src/app/service/article.service';
import { RequestStatusComponent } from '../popup/request-status/request-status.component';
@Component({
  selector: 'app-addarticle',
  templateUrl: './addarticle.component.html',
  styleUrls: ['./addarticle.component.css']
})
export class AddarticleComponent implements OnInit {
  image!: File;
  currentFile?: File;

  article: Article = {
    id: 0,
    name: '',
    price: 0,
    picture: ''
  };
  constructor(private articleService: ArticleService, private sendNotification: MatDialog) { }

  ngOnInit(): void {
  }

  onImageChange(event: any) {
    this.currentFile = event.target.files[0];
    console.log(this.image)
  }


  onClickSubmit(articleform: any) {
    this.article.name = articleform.value.title
    this.article.price = articleform.value.price

    const formData = new FormData();
    formData.append('article', new Blob([JSON.stringify(this.article)], { type: 'application/json' }))
    if (this.currentFile != undefined) {
      formData.append('image', this.currentFile)

      this.articleService.addArticle(formData).subscribe(
        data => {
          this.sendNotification.open(RequestStatusComponent, { data: "Demande Enregistrer" }

        )},
        (err: HttpErrorResponse) => this.sendNotification.open(RequestStatusComponent, { data: " Échec" })
      )
    }

  }
}
