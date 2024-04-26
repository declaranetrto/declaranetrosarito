/**
 * @(#)EnumFormaRecepcion.java 10/11/2019
 *
 * Copyright (C) 2019 Secretaria de la Funcion Publica (SFP).
 *
 * Todos los derechos reservados.
 */
package mx.gob.sfp.dgti.declaracion.enums.catalogos;

/**
 * Enum de catalogo de forma de recepcion
 * @author pavel.martinez
 * @since 10/11/2019
 */
public enum EnumFormaRecepcion {

    MONETARIO(1, "MONETARIO"),
    ESPECIE(2, "ESPECIE");

    private final Integer id;
    private final String descripcion;

    /**
     * Constructor con parametros
     * @param id
     * @param descripcion
     */
    EnumFormaRecepcion(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

}
