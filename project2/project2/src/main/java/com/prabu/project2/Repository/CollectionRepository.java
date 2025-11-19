package com.prabu.project2.Repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prabu.project2.entities.Collection;

@Repository
public interface CollectionRepository extends JpaRepository<Collection,Integer>{

	Optional<Collection> findByDate(LocalDate now);
}
