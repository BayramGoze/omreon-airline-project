package com.bayramgoze.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bayramgoze.entites.Ticket;

@Repository //bunun bir repository sınıfı oldugunu gösterir.

public interface TicketRepository extends JpaRepository<Ticket, Long> {
		Optional<Ticket> findByPnrNumber(String pnrNumber);	
    }