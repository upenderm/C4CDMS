export class ContractDocument {
    contractID?: string;
    contractTitle?: string;
    contractDesc?: string;
    contractStatus?: string;
    contractStartDate?: string;
    contractEndDate?: string;
    contractRenewalDate?: string;
    createdBy?: string;
    createdDate?: string;
    lastModifiedBy?: string;
    lastModifiedDate?: string;
    companyOID?: string;
    templateID?: string
    constructor(id: string, title: string){
        this.contractID = id,
        this.contractTitle = title
    }
}
