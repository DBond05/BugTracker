import { Component, OnInit } from '@angular/core';
import { Bug } from 'src/app/model/bug';
import { BugserviceService } from 'src/app/services/bugservice.service';

@Component({
  selector: 'app-buglist',
  templateUrl: './buglist.component.html',
  styleUrls: ['./buglist.component.css']
})
export class BuglistComponent implements OnInit {
  bugs: Bug[] = [];
  constructor (private service: BugserviceService){}
ngOnInit(): void {
  let response = this.service.getBugs().subscribe((data:any)=>this.bugs=data);
  
}


}
