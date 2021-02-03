package com.textoit.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.textoit.entities.Winner;

public interface WinnerRepository extends JpaRepository<Winner, Long> {
	
	@Query(value = "from Winner where nameProducer in (select nameProducer from Winner group by nameProducer having count(0) > 1) order by nameProducer, year")
	List<Winner> getWinners();

}
