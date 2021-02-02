package com.textoit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntervalProducerDTO {

	private String producer;
	private Integer interval;
	private Integer previousWin;
	private Integer followingWin;
}
