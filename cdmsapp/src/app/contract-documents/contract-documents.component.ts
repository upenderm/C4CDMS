import { Component, OnInit } from '@angular/core';
import { ContractsService } from '../services/contracts.service';
import { SessionService } from '../services/session.service';
import { Observable } from 'rxjs';
import { ContractDocument } from '../common/contract-document';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import {MatButtonModule} from '@angular/material/button';


@Component({
  selector: 'app-contract-documents',
  templateUrl: './contract-documents.component.html',
  styleUrls: ['./contract-documents.component.scss'],
})
export class ContractDocumentsComponent implements OnInit {


  contractsList: ContractDocument[] = [];
  public errorMsg: any;
  constructor(
    private router: Router,
    private contractsService: ContractsService,
    sessionService: SessionService,
    private cookieService: CookieService
  ) {
    console.log('In constructor of ContractDocumentsComponent')
  }

  ngOnInit(): void {
    console.log('In ngOnInit of ContractDocumentsComponent')
    this.getAllContractsList()
  }

  getAllContractsList() {
    const companyOID = this.cookieService.get('C4TOKEN')
    console.log('>>>>------C4TOKEN-------->>>'+this.cookieService.get('C4TOKEN'))
    this.contractsService.getListOfAvailableContracts(companyOID).subscribe({
      next: (data) => {
        console.log(data)
        this.contractsList = data
        // this.router.navigate(['/contract-documents'])
      },
      error: (err) => {
        console.error(err)
        this.errorMsg = 'Oops!... Something went wrong on our side'
      },
      complete: () => {
        console.info('complete')
      }
    }
    );
  }

}
