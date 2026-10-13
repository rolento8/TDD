package org.example.model;

import org.example.exceptions.*;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SocioTest {

    @Test
    public void instanciaSocio_todosLosCamposBien() {
        Socio miSocio = Socio.instance(
                "Marcelo",
                "Rodriguez",
                "40857963",
                LocalDate.of(1998, 7, 15),
                Genero.M,
                1.78,
                91.2);

        assertNotNull(miSocio);
        assertNotNull(miSocio.toString());
        assertEquals("Marcelo", miSocio.getNombre());
        assertEquals("Rodriguez", miSocio.getApellido());
        assertEquals("35847524", miSocio.getDni());
        assertEquals(LocalDate.of(1998, 7, 15), miSocio.getFechaNacimiento());
        assertEquals(Genero.M, miSocio.getGenero());
        assertEquals(1.81, miSocio.getAltura());
        assertEquals(86.6, miSocio.getPeso());
    }

    @Test
    void instanciaSocio_nombreNull(){
        assertThrows(ExceptionSocioNombreNull.class, () -> Socio.instance(null,
                "Rodriguez",
                "35847524",
                LocalDate.of(1998, 7, 15),
                Genero.M,
                1.81,
                86.6));
    }

    @Test
    void instanciaSocio_nombreVacio(){
        assertThrows(ExceptionSocioNombreVacio.class, () -> Socio.instance("",
                "Rodriguez",
                "35847524",
                LocalDate.of(1998, 7, 15),
                Genero.M,
                1.81,
                86.6));
    }

    @Test
    void instanciaSocio_apellidoNull(){
        assertThrows(ExceptionSocioApellidoNull.class, () -> Socio.instance("Marcelo",
                null,
                "35847524",
                LocalDate.of(1998, 7, 15),
                Genero.M,
                1.81,
                86.6));
    }

    @Test
    void instanciaSocio_apellidoVacio(){
        assertThrows(ExceptionSocioApellidoVacio.class, () -> Socio.instance("Marcelo",
                "",
                "35847524",
                LocalDate.of(1998, 7, 15),
                Genero.M,
                1.81,
                86.6));
    }

    @Test
    void instanciaSocio_fechaNacimientoValida(){
        assertThrows(ExceptionSocioFechaInvalida.class, () -> Socio.instance("Marcelo",
                "Rodriguez",
                "35847524",
                LocalDate.of(2027, 7, 15),
                Genero.M,
                1.81,
                86.6));
    }

    @Test
    void instanciaSocio_DNIValido() {
        assertThrows(ExceptionSocioDNIInvalido.class, () -> Socio.instance("Marcelo",
                "Rodriguez",
                "35847",
                LocalDate.of(1998, 7, 15),
                Genero.M,
                1.81,
                86.6));
    }

    @Test
    void instanciaSocio_DNIValido1() {
        assertThrows(ExceptionSocioDNIInvalido.class, () -> Socio.instance("Marcelo",
                "Rodriguez",
                "-35847524",
                LocalDate.of(1998, 7, 15),
                Genero.M,
                1.81,
                86.6));
    }

    @Test
    void instanciaSocio_alturaValida() {
        assertThrows(ExceptionSocioAlturaInvalida.class, () -> Socio.instance("Marcelo",
                "Rodriguez",
                "35847524",
                LocalDate.of(1998, 7, 15),
                Genero.M,
                2.81,
                86.6));
    }

    @Test
    void instanciaSocio_alturaValida1() {
        assertThrows(ExceptionSocioAlturaInvalida.class, () -> Socio.instance("Marcelo",
                "Rodriguez",
                "35847524",
                LocalDate.of(1998, 7, 15),
                Genero.M,
                -1.81,
                86.6));
    }

    @Test
    void instanciaSocio_pesoValido() {
        assertThrows(ExceptionSocioPesoInvalido.class, () -> Socio.instance("Marcelo",
                "Rodriguez",
                "35847524",
                LocalDate.of(1998, 7, 15),
                Genero.M,
                1.81,
                36.6));
    }

    @Test
    void instanciaSocio_pesoValido1() {
        assertThrows(ExceptionSocioPesoInvalido.class, () -> Socio.instance("Marcelo",
                "Rodriguez",
                "35847524",
                LocalDate.of(1998, 7, 15),
                Genero.M,
                1.81,
                -86.6));
    }

    @Test
    void instanciaSocio_generoValido() {
        assertThrows(ExceptionSocioGeneroInvalido.class, () -> Socio.instance("Marcelo",
                "Rodriguez",
                "35847524",
                LocalDate.of(1998, 7, 15),
                null,
                2.81,
                36.6));
    }
}
