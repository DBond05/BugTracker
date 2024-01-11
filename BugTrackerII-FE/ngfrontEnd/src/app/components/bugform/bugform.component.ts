import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl,FormGroup,ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { timestamp } from 'rxjs';
import { Bug } from 'src/app/model/bug';
import { BugserviceService } from 'src/app/services/bugservice.service';
import { LocalStorageService } from 'src/app/services/local-storage.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-bugform',
  templateUrl: './bugform.component.html',
  styleUrls: ['./bugform.component.css']
})
export class BugformComponent implements OnInit {

  bugFormGroup: FormGroup = this.formBuilder.group({});
  
  storedBug= Bug.putBug(0,"","","","",false,"" );
  constructor (private formBuilder: FormBuilder,
    private router: Router,
     private service: BugserviceService,
     private storage: LocalStorageService,
     private location: Location){}

ngOnInit(): void {
this.prefill();
  this.bugFormGroup = this.formBuilder.group({
    bug: this.formBuilder.group({
      projectName: new FormControl(),
      description: new FormControl(),
      issue: new FormControl(),
      troubleShooting: new FormControl(),
      resolved: new FormControl(),
      resolution: new FormControl(),

    })

  })
  
}

get projectName() {return this.bugFormGroup.get('bug.projectName');}
get description() {return this.bugFormGroup.get('bug.description');}
get issue() {return this.bugFormGroup.get('bug.issueType');}
get troubleShooting(){return this.bugFormGroup.get('bug.troubleShooting');}
get resolved(){return this.bugFormGroup.get('bug.resolved');}
get resolution(){return this.bugFormGroup.get('bug.resolution');}

onSubmit(){
  
    this.service.saveBug(this.storedBug).subscribe(
    {
      next:response =>{
        alert(`Bug has been saved`);
        this.router.navigateByUrl("\buglist");
      },
      error: err =>{
        alert(`Error has occurred: ${err.message}`);
        this.router.navigateByUrl("\buglist");
      }
      
    }
   );

  console.log(this.storedBug);
  const bug = this.bugFormGroup.controls['bug'].value;
  if(bug.troubleShooting==null || bug.troubleShooting==""){
    bug.troubleShooting='none';
  }
}

clearForm(){
  this.bugFormGroup.reset();
  console.log("works");
}

prefill(){
  
 if(this.storage.getItem("storedBug")!=null && Object.keys(this.storage.getItem("storedBug")).length!=0 ){
  this.storedBug= this.storage.getItem("storedBug")
 }
  console.log("stored bug = " +JSON.stringify(this.storedBug));
  this.storage.clear();
}
back() {
  this.location.back();
  }


}
