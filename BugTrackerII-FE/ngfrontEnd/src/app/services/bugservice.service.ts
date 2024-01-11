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
public getBug(theBugId: number) {
  return this.httpClient.get<Bug>(`${this.url}/${theBugId}`);
}

saveBug(storedBug: Bug): Observable <any> {
  //create new bug
  if(storedBug.id === 0 || storedBug.id=== null){
    let post = Bug.postBug(storedBug.projectName, storedBug.issueType, storedBug.description,
    storedBug.troubleShooting, storedBug.resolved, storedBug.resolution);
  return this.httpClient.post<Bug>(this.url, post);
  } else {
    //update bug with ID
    return this.httpClient.put<Bug>(this.url, storedBug);
  }
}
  
deleteBug(bugId: number):Observable<any> {
 return this.httpClient.delete<Bug>(`${this.url}/${bugId}`);
}
}
interface GetResponseBugs{
  _embedded:{
    bugs: Bug[];
  }
}
