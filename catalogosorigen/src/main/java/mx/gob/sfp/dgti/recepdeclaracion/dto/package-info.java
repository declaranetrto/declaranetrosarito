/**
 * Indica que contiene clases que necesitan ser generadas / procesadas.
 * Por medio de la etiqueta :
 *
 * @DataObject(generateConverter = true)
 *
 * Se declara que se van a generar convertidores para los objetos.
 *
 * Si la clase extiende de otra clase se debe de marcar inheritConverter = true para que
 * los convertidores extiendan a clases padres.
 *
 * Se agregan funciones de toJson() y constructor Objeto(JsonObject) para que los objetos
 * puedan ser recibidos y enviados en los proxys de Vert.x.
 *
 * @author
 * @since 17/07/2019
 *
 */
@ModuleGen(name = "dto", groupPackage = "mx.gob.sfp.dgti.recepdeclaracion.dto")

package mx.gob.sfp.dgti.recepdeclaracion.dto;

import io.vertx.codegen.annotations.ModuleGen;