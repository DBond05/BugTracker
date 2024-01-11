import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bug } from 'src/app/model/bug';
import { BugserviceService } from 'src/app/services/bugservice.service';
import { LocalStorageService } from 'src/app/services/local-storage.service';

@Component({
  selector: 'app-bugdetails',
  templateUrl: './bugdetails.component.html',
  styleUrls: ['./bugdetails.component.css']
})
export class BugdetailsComponent implements OnInit {


  bug!: Bug;
  constructor(private service: BugserviceService, 
    private route: ActivatedRoute,
    private router: Router,
    private storage: LocalStorageService){}

  
  ngOnInit(): void {
    this.route.paramMap.subscribe(
      () => { this.handleBugDetails();}
    );
  }
  handleBugDetails() {
   const theBugId: number = +this.route.snapshot.paramMap.get('id')! ;
   this.service.getBug(theBugId).subscribe(
     (data) =>{
      this.bug = data;
    }
   )
   
  }
  storeBug() {
    this.storage.setItem(
      "storedBug", this.bug
    );
    }

    deleteBug() {
      let bugId = this.bug.id;
      this.service.deleteBug(bugId).subscribe(
        {
          next: () =>{
            alert('Delete successful');
            this.router.navigateByUrl("/buglist");
            
          },
          error: (err: { message: any; }) => {
            alert(`There was an error:  ${err.message}`)
          }
        }
      )
      }
}
