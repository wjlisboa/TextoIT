package com.textoit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.textoit.dto.MinMaxIntervalProducerDTO;
import com.textoit.services.WinnerService;

@RestController
@RequestMapping("/api/winner")
public class WinnerController {

	@Autowired
	private WinnerService service;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MinMaxIntervalProducerDTO> getMinMax() {
		return new ResponseEntity<>(this.service.getMinMax(), HttpStatus.OK);
	}
}
