package org.example.model;

import org.example.exceptions.*;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CuotaTest {

    @Test
    void instanciaCuota_todosLosCaposBien(){
        Cuota miCuota = Cuota.instance(
                12,
                2026,
                35000.00);

        assertNotNull(miCuota);
        assertNotNull(miCuota.toString());
        assertEquals(12, miCuota.getMes());
        assertEquals(2026, miCuota.getAnio());
        assertEquals(35000.00, miCuota.getMonto());
        assertEquals(false, miCuota.isPagada());
    }

    @Test
    void instanciaCuota_mesValido(){
        assertThrows(ExceptionCuotaMesInvalido.class, () -> Cuota.instance(
                13,
                2026,
                35000.00));
    }

    @Test
    void instanciaCuota_mesValido1(){
        assertThrows(ExceptionCuotaMesInvalido.class, () -> Cuota.instance(
                -12,
                2026,
                35000.00));
    }

    @Test
    void instanciaCuota_anioValido(){
        assertThrows(ExceptionCuotaAnioInvalido.class, () -> Cuota.instance(
                12,
                2030,
                35000.00));
    }

    @Test
    void instanciaCuota_anioValido1(){
        assertThrows(ExceptionCuotaAnioInvalido.class, () -> Cuota.instance(
                12,
                1998,
                35000.00));
    }

    @Test
    void instanciaCuota_montoValido(){
        assertThrows(ExceptionCuotaMontoInvalido.class, () -> Cuota.instance(
                12,
                2026,
                0));
    }
    @Test
    void instanciaCuota_montoValido1(){
        assertThrows(ExceptionCuotaMontoInvalido.class, () -> Cuota.instance(
                12,
                2026,
                -35000.00));
    }
}
