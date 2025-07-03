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
@Table(name = "C4_COMPANY_DETAILS")
public class CompanyDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2585911798592081317L;

	/**
	 * 
	 */

	@Id
	@Column(name = "COMPANY_OID")
	private String companyOID;

	@Column(name = "COMPANY_ID")
	private String companyID;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "COMPANY_DESC")
	private String companyDesc;

	@Column(name = "REGISTERED_NUMBER")
	private String registeredNumber;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "MOBILE2")
	private String mobile2;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	private String addressLine2;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE1")
	private String state;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "ZIPCODE")
	private String zipCode;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "LAST_MODIFIED_BY")
	private String lastModifiedBy;

	@Column(name = "LAST_MODIFIED_DATE")
	private Date lastModifiedDate;

	@Column(name = "PRODUCT_ID")
	private String productID;

}
