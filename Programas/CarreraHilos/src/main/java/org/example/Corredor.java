package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Corredor {
    private String simbolo;
    private int velocidadBase;
    private int valorTurbo;
    private int probabilidadChocar;

}
