package com.techague.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ClienteDto implements Serializable {

    private Integer idCliente;

    private String nombre;

    private String apellido;

    private String correo;

    private Date fechaRegistro;
}
