package com.c4networks.cdms.cdmsapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.c4networks.cdms.cdmsapi.entity.ContractDetails;

@Repository
public interface ContractDocumentsRepository extends JpaRepository<ContractDetails, String> {

	public Optional<ContractDetails> findByContractID(String id);

	@Query("select cd from ContractDetails cd where cd.companyOID = :companyOID")
	public List<ContractDetails> findAllContractsByCompanyOId(String companyOID);

}
