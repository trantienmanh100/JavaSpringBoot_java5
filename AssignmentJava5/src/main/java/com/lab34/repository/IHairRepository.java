package com.lab34.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lab34.entities.Hair;
import com.lab34.entities.HairType;



public interface IHairRepository extends JpaRepository<Hair, Integer> {
	Page<Hair> findByNameLike(String name,Pageable pageable);
	
	@Query("Select hair from Hair hair where hair.type =:type")
	Page<Hair> findByType(@Param("type") HairType type,Pageable pageable);
	
}

