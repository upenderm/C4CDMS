package com.c4networks.cdms.cdmsapi.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CDMS_CONTRACT_DETAILS")
public class ContractDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8630649794885689574L;

	/**
	 * 
	 */

	@Id
	@Column(name = "CONTRACT_ID")
	private String contractID;

	@Column(name = "CONTRACT_TITLE")
	private String contractTitle;

	@Column(name = "CONTRACT_DESC")
	private String contractDesc;

	@Column(name = "STATUS")
	private String contractStatus;

	@Column(name = "CONTRACT_START_DATE")
	private Date contractStartDate;

	@Column(name = "CONTRACT_END_DATE")
	private Date contractEndDate;

	@Column(name = "CONTRACT_RENEWAL_DATE")
	private Date contractRenewalDate;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "LAST_MODIFIED_BY")
	private String lastModifiedBy;

	@Column(name = "LAST_MODIFIED_DATE")
	private Date lastModifiedDate;

	@Column(name = "COMPANY_OID")
	private String companyOID;

	@Column(name = "TEMPLATE_ID")
	private String templateID;

}
