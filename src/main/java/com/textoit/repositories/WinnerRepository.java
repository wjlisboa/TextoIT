package com.textoit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.textoit.entities.Winner;

public interface WinnerRepository extends JpaRepository<Winner, Long> {

}
