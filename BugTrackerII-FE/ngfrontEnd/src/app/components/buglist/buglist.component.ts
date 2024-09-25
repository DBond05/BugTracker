import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Bug } from 'src/app/model/bug';
import { BugserviceService } from 'src/app/services/bugservice.service';

@Component({
  selector: 'app-buglist',
  templateUrl: './buglist.component.html',
  styleUrls: ['./buglist.component.css']
})
export class BuglistComponent implements OnInit {
  bugs: Bug[] = [];
  //filteredBugs: Bug[] = [];
  _filterValue: string= '';
  isSearch: boolean = false;

  //pagination variables
  currentPage: number = 0;
pageSize: number = 10;
totalElements: number=0;
totalPages: number=0;
sortField: string = 'id';
asc: boolean = true;

  constructor (private service: BugserviceService, private route:ActivatedRoute){}
ngOnInit(): void {
  this.route.paramMap.subscribe(()=> {
    this.handleListBugs();
  })
  

  
}

handleListBugs(){
  this.isSearch = this.route.snapshot.paramMap.has('keyword');
  if(this.isSearch){
    this.handleSearch();
  }
  else{
   this.getBugsPaginated();
  }
}

handleSearch() {
 const key: string =this.route.snapshot.paramMap.get('keyword')!;
 this.service.searchBugsPaginated(key, this.currentPage, this.pageSize)
 .subscribe((data: any)=> {
  this.bugs = data.content;
  this.totalElements = data.totalElements;
  this.totalPages = data.totalPages;
});
}
getBugsPaginated(){
  this.service.getBugsPaginated(this.currentPage, this.pageSize,this.sortField, this.asc)
  .subscribe((data: any)=> {
    this.bugs = data.content;
    this.totalElements = data.totalElements;
    this.totalPages = data.totalPages;
  });
}

//pagination navigation
goToNextPage(){
  if(this.currentPage< this.totalPages -1){
    this.currentPage++;
    this.handleListBugs();
  }
}
goToPreviousPage(){
  if(this.currentPage > 0){
    this.currentPage --;
    this.handleListBugs();
  }
}
goToPage(page: number){
  if(page>= 0&& page < this.totalPages){
    this.currentPage= page;
    this.handleListBugs();
  }
}

updatePageSize(size: number) {
  this.pageSize = size;
  this.currentPage = 0; // Reset to first page
  this.handleListBugs();
}
}
