package com.c4networks.cdms.cdmsapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c4networks.cdms.cdmsapi.entity.ContractDetails;
import com.c4networks.cdms.cdmsapi.exceptions.CDMSGenericExceptions;
import com.c4networks.cdms.cdmsapi.exceptions.DataAlreadyExistsException;
import com.c4networks.cdms.cdmsapi.service.ContractDocumentsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/contractDocs")
public class ContractDocumentsController {

	@Autowired
	private ContractDocumentsService contractDocumentsService;

	@GetMapping(value = "/allAvailableContracts", produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin("*")
	public ResponseEntity<List<ContractDetails>> getAvailableContractsByCompanyOID(@RequestHeader("companyOID") String companyOID) {
		HttpHeaders headers = new HttpHeaders();
		if (companyOID == null) {
			new ResponseEntity<>(Optional.empty(), headers, HttpStatus.BAD_REQUEST);
		}

		headers.add("c4cookie", "dummy value");
		List<ContractDetails> allContracts = contractDocumentsService.getAllAvailableContractsForCompany(companyOID);
		return new ResponseEntity<>(allContracts, HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveContractDetails", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveContractDetails(@RequestBody ContractDetails contractDetails, @RequestHeader("companyOID") String companyOID) {
		String result = "";
		HttpHeaders headers = new HttpHeaders();
		if (contractDetails == null || companyOID == null) {
			new ResponseEntity<>(Optional.empty(), headers, HttpStatus.BAD_REQUEST);
		}

		headers.add("c4cookie", "dummy value");
		
		try {
			contractDetails = contractDocumentsService.saveContractDetails(contractDetails);
		} catch (DataAlreadyExistsException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.toString(), headers, HttpStatus.OK);
		} catch (CDMSGenericExceptions e) {
			return new ResponseEntity<>(e.toString(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			result = objectMapper.writeValueAsString(contractDetails);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(e.toString(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(result, headers, HttpStatus.CREATED);
	}

}
