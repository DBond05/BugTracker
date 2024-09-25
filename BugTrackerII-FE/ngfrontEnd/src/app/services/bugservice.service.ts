import { Injectable } from '@angular/core';
import { Bug } from '../model/bug';
import { Observable, map } from 'rxjs';
import { HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BugserviceService {
  
 
 private url = "http://localhost:9191/api/bugs";
 constructor(private httpClient: HttpClient){}


// public getBugs(){
//   return this.httpClient.get<GetResponseBugs>(this.url);
// }



  // Get bugs with pagination and sorting
  getBugsPaginated(page: number, size: number, sortField: string, asc: boolean): Observable<any> {
    const params = new HttpParams()
      .set('page', page.toString())
      .set('size', size.toString())
      .set('sortField', sortField)
      .set('asc', asc.toString());

    return this.httpClient.get<any>(this.url, { params });
  }

  //get specific bug by ID
public getBug(theBugId: number) {
  return this.httpClient.get<Bug>(`${this.url}/${theBugId}`);
}
//save new bug or update bug
saveBug(storedBug: Bug): Observable <any> {
  //create new bug
   if(storedBug.id === 0 || storedBug.id=== null){
  return this.httpClient.post<Bug>(this.url, storedBug);
  } else {
    //update bug with ID
    return this.httpClient.put<Bug>(`${this.url}/${storedBug.id}`, storedBug);
  }
}
  //Delete a bug
deleteBug(bugId: number):Observable<any> {
 return this.httpClient.delete<Bug>(`${this.url}/${bugId}`);
}

// searchBugs(value: string): Observable<Bug[]>{
//   return this.httpClient.get<Bug[]>(
//    `${this.url}/search?keyword=${value}`

//     );
// }
// }


// interface GetResponseBugs{
//   _embedded:{
//     bugs: Bug[];
//   }

//Search for bug with pagination
searchBugsPaginated(value: string, page: number, size: number): Observable<any> {
  const params = new HttpParams()
    .set('keyword', value)
    .set('page', page.toString())
    .set('size', size.toString());

  return this.httpClient.get<any>(`${this.url}/search`, { params });
}

}
