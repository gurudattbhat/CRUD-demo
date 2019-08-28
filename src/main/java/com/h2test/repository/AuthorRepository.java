package com.h2test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.h2test.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
