package org.julen.ejercicio3_repaso_api.services;

import org.julen.ejercicio3_repaso_api.models.Fecha;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

/**
 * Esta es una clase de servicio que implementa la interfaz FechaService.
 * Utiliza la anotación @Service de Spring para indicar que es una clase de servicio.
 */
@Service
public class FechaServiceImpl implements FechaService{

    // Fecha actual
    LocalDate ahora = LocalDate.now();

    /**
     * Este método devuelve la fecha actual.
     * @return Objeto Fecha que representa la fecha actual.
     */
    @Override
    public Fecha fechaActual() {

        Fecha fecha = new Fecha(ahora.getDayOfMonth(), ahora.getMonthValue(), ahora.getYear());

        return fecha;
    }

    /**
     * Este método devuelve la fecha después del número de días especificado.
     * @param dias El número de días a añadir a la fecha actual.
     * @return Objeto Fecha que representa la fecha después del número de días especificado.
     */
    @Override
    public Fecha fechaMasDias(int dias) {

        Fecha fecha = new Fecha(ahora.getDayOfMonth() , ahora.getMonthValue(), ahora.getYear());

            if (fecha.getDay()+dias > 30){
                if (fecha.getMonth()+1 > 12){
                    fecha.setYear(fecha.getYear()+1);
                    fecha.setMonth(1);
                    fecha.setDay(dias - (30 - fecha.getDay()));
                }else{
                    fecha.setMonth(fecha.getMonth() + 1);
                    fecha.setDay(dias - (30 - fecha.getDay()));
                }
            }else{
                fecha.setDay(fecha.getDay()+dias);
            }

        return fecha;
    }

    /**
     * Este método no está implementado.
     * @param fecha Objeto Fecha a utilizar para cambiar la fecha local.
     */
    @Override
    public void cambiarFechaLocal(Fecha fecha) {

    }


}