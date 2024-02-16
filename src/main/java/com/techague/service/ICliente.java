package com.techague.service;

import com.techague.model.dto.ClienteDto;
import com.techague.model.entity.Cliente;

public interface ICliente {

    Cliente save(ClienteDto cliente);

    Cliente findByID(Integer id);

    void delete(Cliente cliente);
}
