import { Injectable } from '@angular/core';
import { Session } from '../common/session';

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  private session: Session = {
    appID: 'CDMS'
  }
  // get userName():string{
  //   return this.session.userName
  // }
  // set userName(userName: string){
  //   this.session.userName = userName
  // }
}
