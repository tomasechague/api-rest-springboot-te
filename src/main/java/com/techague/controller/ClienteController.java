package com.techague.controller;

import com.techague.model.dto.ClienteDto;
import com.techague.model.entity.Cliente;
import com.techague.service.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/")
public class ClienteController {

    @Autowired
    private ICliente clienteService;

    @PostMapping("cliente")
    public ClienteDto create(@RequestBody ClienteDto clienteDto){
        Cliente clienteSave = clienteService.save(clienteDto);

        return ClienteDto.builder()
                .idCliente(clienteSave.getIdCliente())
                .nombre(clienteSave.getNombre())
                .apellido(clienteSave.getApellido())
                .fechaRegistro(clienteSave.getFechaRegistro())
                .correo(clienteSave.getCorreo())
                .build();
    }

    @PutMapping("cliente")
    public ClienteDto update(@RequestBody ClienteDto clienteDto){
        Cliente clienteSave = clienteService.save(clienteDto);

        return ClienteDto.builder()
                .idCliente(clienteSave.getIdCliente())
                .nombre(clienteSave.getNombre())
                .apellido(clienteSave.getApellido())
                .fechaRegistro(clienteSave.getFechaRegistro())
                .correo(clienteSave.getCorreo())
                .build();
    }

    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){

        Map<String, Object> response = new HashMap<>();

        try{
            Cliente cliente = clienteService.findByID(id);

            clienteService.delete(cliente);

            return new ResponseEntity<>(cliente, HttpStatus.NO_CONTENT);

        }catch (DataAccessException e){

            response.put("mensaje", e.getMessage());
            response.put("cliente", null);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("cliente/{id}")
    public ClienteDto showById(@PathVariable Integer id){
        Cliente cliente = clienteService.findByID(id);

        return ClienteDto.builder()
                .idCliente(cliente.getIdCliente())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .fechaRegistro(cliente.getFechaRegistro())
                .correo(cliente.getCorreo())
                .build();
    }
}
