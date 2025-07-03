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
@Table(name = "CDMS_TEMPLATE_DETAILS")
public class TemplateDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3099501153172765589L;

	/**
	 * 
	 */

	@Id
	@Column(name = "TEMPLATE_ID")
	private String templateID;

	@Column(name = "TEMPLATE_NAME")
	private String templateName;

	@Column(name = "TEMPLATE_DESC")
	private String templateDesc;

	@Column(name = "TEMPLATE_IMAGE_PATH")
	private String templateImagePath;

}
