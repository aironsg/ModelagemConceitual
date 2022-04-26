package com.dev.airon.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.airon.cursomc.domain.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>{

}
