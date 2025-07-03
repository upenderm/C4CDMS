package com.c4networks.cdms.cdmsapi.entity;

import java.io.Serializable;

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
@Table(name = "C4_PRODUCT_DETAILS")
public class ProductDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3863820686168595910L;

	/**
	 * 
	 */

	@Id
	@Column(name = "PRODUCT_ID")
	private String productID;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "PRODUCT_DESC")
	private String productDescription;

	@Column(name = "PRODUCT_PATH")
	private String productPath;

}
