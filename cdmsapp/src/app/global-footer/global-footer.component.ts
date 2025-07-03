import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-global-footer',
  templateUrl: './global-footer.component.html',
  styleUrls: ['./global-footer.component.scss']
})
export class GlobalFooterComponent {

 author = ''

 public GlobalFooterComponent() {
 }

 ngOnInit(): void {
  this.author = 'Upender0209@gmail.com'
 }

}
