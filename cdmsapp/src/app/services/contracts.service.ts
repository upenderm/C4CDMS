import { ErrorHandler, Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { ContractDocument } from '../common/contract-document';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { CookieService } from 'ngx-cookie-service';

@Injectable({
  providedIn: 'root'
})
export class ContractsService {

  contractsList: ContractDocument[] = [];
  private cmsAPITarget: string = 'http://localhost:8082/cdmsapi/';
  private allAvailableContractsPath: string = "contractDocs/allAvailableContracts";

  constructor(
    private http: HttpClient,
    private cookieService: CookieService
  ) { }

  getListOfAvailableContracts(companyOID: string): Observable<any> {
    this.cookieService.get('C4Token')
    return this.http.get(this.cmsAPITarget + this.allAvailableContractsPath, {
      headers: this.createAuthorizationHeader(companyOID)
    })
  }

  private createAuthorizationHeader(companyOID: string): HttpHeaders {
    return new HttpHeaders()
      .set('Content-Type', 'application/json')
      .set('Accept', 'application/json')
      .set('Access-Control-Allow-Headers', 'Content-Type')
      .set('companyOID', companyOID)
  }

}
