package com.c4networks.cdms.cdmsapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c4networks.cdms.cdmsapi.entity.CompanyDetails;
import com.c4networks.cdms.cdmsapi.entity.ContractDetails;
import com.c4networks.cdms.cdmsapi.exceptions.CDMSGenericExceptions;
import com.c4networks.cdms.cdmsapi.exceptions.DataAlreadyExistsException;
import com.c4networks.cdms.cdmsapi.repository.CompanyDetailsRepository;
import com.c4networks.cdms.cdmsapi.repository.ContractDocumentsRepository;

@Service
public class ContractDocumentsService {

	@Autowired
	private ContractDocumentsRepository contractDocsRepo;

	@Autowired
	private CompanyDetailsRepository companyDtlsRepository;

	public ContractDetails getContractDetailsById(String contractID) {
		ContractDetails contractDetails = null;
		Optional<ContractDetails> contractsOpt = contractDocsRepo.findByContractID(contractID);
		if (contractsOpt.isPresent()) {
			contractDetails = contractsOpt.get();
		}
		return contractDetails;
	}

	public List<ContractDetails> getAllAvailableContractsForCompany(String companyOID) {
		List<ContractDetails> contractsList = new ArrayList<>();
		Optional<CompanyDetails> companyDtlsOpt = companyDtlsRepository.findByCompanyOID(companyOID);
		if (companyDtlsOpt.isPresent()) {
			contractsList = contractDocsRepo.findAllContractsByCompanyOId(companyOID);
			contractsList.sort((ContractDetails d1, ContractDetails d2) -> d1.getLastModifiedDate().compareTo(d2.getLastModifiedDate()));
		}
		if (contractsList.isEmpty()) {
			return new ArrayList<ContractDetails>();
		}
		return contractsList;
	}

	public ContractDetails saveContractDetails(ContractDetails contractDetails) throws DataAlreadyExistsException, CDMSGenericExceptions {

		boolean existsById = false;
		if (!contractDetails.getContractID().isEmpty()) {
			existsById = contractDocsRepo.existsById(contractDetails.getContractID());
		}
		if (existsById) {
			throw new DataAlreadyExistsException();
		}
		try {
			contractDetails = contractDocsRepo.save(contractDetails);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CDMSGenericExceptions();
		}
		return contractDetails;
	}

}
