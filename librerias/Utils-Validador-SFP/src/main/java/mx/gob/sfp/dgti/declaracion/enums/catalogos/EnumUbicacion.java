/**
 * @(#)EnumUbicacion.java 03/10/2019
 *
 * Copyright (C) 2019 Secretaria de la Funcion Publica (SFP).
 *
 * Todos los derechos reservados.
 */
package mx.gob.sfp.dgti.declaracion.enums.catalogos;

/**
 * Enum para el Tipo de domicilio
 *
 * @author Pavel Alexei Martinez Regalado
 * @since 12/09/2019
 */
public enum EnumUbicacion {

    MEXICO(1, "MÉXICO"),
    EXTRANJERO(2, "EXTRANJERO");

	private final Integer id;
	private final String descripcion;

    /**
     * Constructor
     * @param id
     */
    EnumUbicacion(Integer id, String descripcion) {
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
