import { Injectable } from '@angular/core';
import { Bug } from '../model/bug';
import { Observable, map } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BugserviceService {
 private url = "http://localhost:9191/api/bugs";
 constructor(private httpClient: HttpClient){}


public getBugs(){
  return this.httpClient.get<GetResponseBugs>(this.url);
}
  
}
interface GetResponseBugs{
  _embedded:{
    bugs: Bug[];
  }
}
