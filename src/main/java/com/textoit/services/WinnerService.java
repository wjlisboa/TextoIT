package com.textoit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.textoit.dto.IntervalProducerDTO;
import com.textoit.dto.MinMaxIntervalProducerDTO;
import com.textoit.entities.Winner;
import com.textoit.repositories.WinnerRepository;

@Service
public class WinnerService {

	@Autowired
	private WinnerRepository repository;
	
	@Transactional(readOnly = true)
	public MinMaxIntervalProducerDTO getMinMax() {
		
		//winners with more than 1 win
		List<Winner> winners = repository.getWinners();
		
		MinMaxIntervalProducerDTO result = new MinMaxIntervalProducerDTO();
		
		List<IntervalProducerDTO> min = new ArrayList<>();
		min.add(new IntervalProducerDTO("Producer 1",1,2008,2009));
		min.add(new IntervalProducerDTO("Producer 2",1,2018,2019));
		
		List<IntervalProducerDTO> max = new ArrayList<>();
		max.add(new IntervalProducerDTO("Producer 1",99,1900,1999));
		max.add(new IntervalProducerDTO("Producer 2",99,2000,2099));
		
		result.setMin(min);
		result.setMax(max);
		
		return result;
	}

}
