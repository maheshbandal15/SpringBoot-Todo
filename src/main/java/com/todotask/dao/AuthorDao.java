package com.todotask.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.todotask.model.Author;

public interface AuthorDao extends CrudRepository<Author, Serializable>{

}
