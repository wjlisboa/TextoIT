package com.textoit.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

		// winners with more than 1 win
		List<Winner> winners = repository.getWinners();

		// All interval for each winner
		List<IntervalProducerDTO> intervalForWinner = getIntervalForWinner(winners);
		
		intervalForWinner.sort(Comparator.comparing(IntervalProducerDTO::getInterval));
		int intervalMin = intervalForWinner.get(0).getInterval();
		int intervalMax = intervalForWinner.get(intervalForWinner.size() - 1).getInterval();

		MinMaxIntervalProducerDTO result = new MinMaxIntervalProducerDTO();
		result.setMin(intervalForWinner.stream().filter(d -> d.getInterval().equals(intervalMin)).collect(Collectors.toList()));
		result.setMax(intervalForWinner.stream().filter(d -> d.getInterval().equals(intervalMax)).collect(Collectors.toList()));

		return result;
	}


	private List<IntervalProducerDTO> getIntervalForWinner(List<Winner> winners) {
		List<IntervalProducerDTO> intervalForProducer = new ArrayList<>();
		int interval;
		IntervalProducerDTO intervalProducer;
		for (int i = 0; i < winners.size() - 1; i++) {
			if (winners.get(i).getNameProducer().equals(winners.get(i + 1).getNameProducer())) {
				interval = winners.get(i + 1).getYear() - winners.get(i).getYear();
				intervalProducer = new IntervalProducerDTO(winners.get(i).getNameProducer(), interval,
						winners.get(i).getYear(), winners.get(i + 1).getYear());
				intervalForProducer.add(intervalProducer);
			}
		}
		return intervalForProducer;
	}

}
