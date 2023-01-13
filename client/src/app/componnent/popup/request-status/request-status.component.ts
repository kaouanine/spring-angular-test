import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-request-status',
  templateUrl: './request-status.component.html',
  styleUrls: ['./request-status.component.css']
})
export class RequestStatusComponent implements OnInit {
status!:string
  constructor(@Inject(MAT_DIALOG_DATA) public data: any ,private sendNotification:MatDialog) {
  this.status=data
   }

  ngOnInit(): void {
  }
 hideModale(){
  console.log('fdsgdg')
  this.sendNotification.closeAll()


 }
}
