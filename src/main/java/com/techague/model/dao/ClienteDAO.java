package com.techague.model.dao;

import com.techague.model.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDAO extends CrudRepository<Cliente,Integer> {
}
