package com.textoit.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MinMaxIntervalProducerDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<IntervalProducerDTO> min;
	
	private List<IntervalProducerDTO> max;
}
