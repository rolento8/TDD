package org.example.model;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EjercicioTest {

   @Test
   void instanciaEjercicio_todosLosCamposBien() {
        Ejercicio miEjercicio = Ejercicio.instance(
                "Press banca",
                3,
                12,
                100,
                180);
        assertNotNull(miEjercicio);
        assertNotNull(miEjercicio.toString());
        assertEquals("Press banca", miEjercicio.getNombre());
        assertEquals(3, miEjercicio.getSeries());
        assertEquals(12, miEjercicio.getRepeticiones());
        assertEquals(100, miEjercicio.getKilos());
        assertEquals(180, miEjercicio.getDescanso());
    }

    @Test
    void instanciaEjercicio_nombreNull() {
        assertThrows(ExceptionEjercicioNombreNull.class, () -> Ejercicio.instance(
                null,
                3,
                12,
                100,
                180));
    }

    @Test
    void instanciaEjercicio_nombreVacio() {
        assertThrows(ExceptionEjercicioNombreVacio.class, () -> Ejercicio.instance(
                "",
                3,
                12,
                100,
                180));
    }

    @Test
    void instanciaEjercicio_seriesNegativas() {
        assertThrows(ExceptionEjercicioSeriesNegativas.class, () -> Ejercicio.instance(
                "Press banca",
                -3,
                12,
                100,
                180));
    }

    @Test
    void instanciaEjercicio_repeticionesNegativas() {
        assertThrows(ExceptionEjercicioRepeticionesNegativas.class, () -> Ejercicio.instance(
                "Press banca",
                3,
                -12,
                100,
                180));
    }

    @Test
    void instanciaEjercicio_kilosNegativos() {
        assertThrows(ExceptionEjercicioKilosNegativos.class, () -> Ejercicio.instance(
                "Press banca",
                3,
                12,
                -100,
                180));
    }

    @Test
    void instanciaEjercicio_DescansoNegativo() {
        assertThrows(ExceptionEjercicioDescansoNegativo.class, () -> Ejercicio.instance(
                "Press banca",
                3,
                12,
                100,
                -180));
    }
}
