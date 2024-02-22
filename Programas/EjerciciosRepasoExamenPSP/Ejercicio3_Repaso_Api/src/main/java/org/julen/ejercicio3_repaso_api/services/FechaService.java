package org.julen.ejercicio3_repaso_api.services;

import org.julen.ejercicio3_repaso_api.models.Fecha;

import java.util.Set;

/**
 * Esta es una interfaz para el servicio FechaService.
 * Declara tres métodos: fechaActual, fechaMasDias y cambiarFechaLocal.
 */
public interface FechaService {

    /**
     * Se espera que este método devuelva la fecha actual.
     * @return Objeto Fecha que representa la fecha actual.
     */
    Fecha fechaActual();

    /**
     * Se espera que este método devuelva la fecha después del número de días especificado.
     * @param dias El número de días a añadir a la fecha actual.
     * @return Objeto Fecha que representa la fecha después del número de días especificado.
     */
    Fecha fechaMasDias(int dias);

    /**
     * Se espera que este método cambie la fecha local a la fecha especificada.
     * @param fecha Objeto Fecha a utilizar para cambiar la fecha local.
     */
    void cambiarFechaLocal(Fecha fecha);
}