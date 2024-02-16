package com.techague.model.payload;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MensajeReponse implements Serializable {

    private String mensaje;
    private Object object;
}
