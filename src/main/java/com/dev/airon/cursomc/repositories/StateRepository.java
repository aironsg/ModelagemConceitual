package com.dev.airon.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.airon.cursomc.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

}
