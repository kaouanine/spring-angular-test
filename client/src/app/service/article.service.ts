import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { Article } from '../moduls/article';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
private apiUrl=environment.apiUrl;

  constructor(private http: HttpClient) { }

  getArticle(){
    return this.http.get<Article[]>(`${this.apiUrl}/articles`)

  }
  addArticle(data:FormData){


return this.http.post(`${this.apiUrl}/articles`,data,{
  reportProgress: true,
  responseType: 'json'
})
  }
}
