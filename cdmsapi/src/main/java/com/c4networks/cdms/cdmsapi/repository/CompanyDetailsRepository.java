package com.c4networks.cdms.cdmsapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.c4networks.cdms.cdmsapi.entity.CompanyDetails;

public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, String> {

	@Query("select cd from CompanyDetails cd where cd.companyOID = :companyOID")
	public Optional<CompanyDetails> findByCompanyOID(String companyOID);

}
