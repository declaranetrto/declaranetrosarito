package mx.gob.sfp.dgti.util;

/**
 * Clase con las constantes generales para el proyecto
 * @author Miriam Sanchez Sánchez programador07 
 * @since 07/02/2019
 */
public class Constantes {

	// Mensajes
	public static final String MESSAGE_KEY_ERROR = "La key es erronea";

	// Headers
	public static final String HEADER_CONTENT_TYPE = "Content-Type";
	public static final String HEADER_CONTENT_APPLICATION_JSON = "application/json; charset=utf-8";
	public static final String TOKEN_BEARER_KEY = "Bearer ";
	public static final String HEADER_AUTHORIZATION_KEY = "Authorization";
	public static final String HEADER_DOMINIO = "dominio"; // DEL FRONT   
	public static final String HEADER_ORIGIN = "origin"; //DEL CLIENTE
	public static final String HEADER_ORIGINS = "origins"; //PARA LA LIBRERÍA
	public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
	public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
	public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
	public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
	public static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
	public static final String HEADER_ACCESS_CONTROL_ALLOW_ORIGIN = "*";
	public static final String HEADER_ACCESS_CONTROL_ALLOW_CREDENTIALS = "true";
	public static final String HEADER_ACCESS_CONTROL_ALLOW_METHODS = "POST, GET, OPTIONS, DELETE";
	public static final String HEADER_ACCESS_CONTROL_ALLOW_HEADERS = "dominio, authorization,content-type";
	public static final String CACHE_CONTROL = "Cache-Control";
	public static final String PRAGMA = "Pragma";
	public static final String HEADER_PRAGMA = "no-cache";
	public static final String HEADER_CACHE_CONTROL = "no-store";
	public static final String X_REQUESTED_WITH = "x-requested-with";
	public static final String ACCEPT = "accept";
	public static final String X_PINGARUNER = "X-PINGARUNER";
	public static final String TEXT_HTML = "text/html";
	public static final String EMPTY = "";
	// *
	public static final String EMAIL = "email";
	public static final String CURP = "curp";
        public static final String ID_TELEGRAM = "idTelegram";
	public static final String RFC = "rfc";
        public static final String NOMBRE = "nombre";
	public static final String RENAPO_CURP = "renapoCurp";
	public static final String DATA = "data";
	public static final Object OBJNULL = null;
	public static final String SECRETKEY = "secretkey";
	public static final String ID = "id";
	public static final Integer TOKEN_24HR = Integer.parseInt(System.getenv("TIEMPO_24HR") == null ? "84600" : System.getenv("TIEMPO_24HR"));
	
	public static final String CONFIG_HOST = "host";
	public static final String CONFIG_PORT = "port";
	public static final String CONFIG_DATABASE = "database";
	public static final String CONFIG_USERNAME = "username";
	public static final String CONFIG_PSW = "password";
	public static final String MAX_POOL_SIZE = "maxPoolSize";
	public static final String MAX_POOL_SIZE_VALUE = "10";
	public static final String IP_DATABASE_HOST = "IP_DATABASE_HOST";
	public static final String IP_DATABASE_PORT = "IP_DATABASE_PORT";
	public static final String IP_DATABASE_NAME = "IP_DATABASE_NAME";
	public static final String IP_DATABASE_USERNAME = "IP_DATABASE_USERNAME";
	public static final String IP_DATABASE_PSW = "IP_DATABASE_PASSWORD";
	public static final String IP_SERVER_PORT = "IP_SERVER_PORT";
	
	public static final Integer ACTIVO = 1;
	public static final Integer INACTIVO = 0;
	
	// PROCESOS PARA GUARDAR EN LA BITACORA
	public static final Integer LOGIN_APLICACION = 0;
	public static final Integer VINCULACION = 1;
	public static final Integer LOGIN_USUARIO = 2;
	public static final Integer ACCESO = 3;
	public static final Integer DESVINCULACION = 4;
	public static final Integer REGISTRO_USUARIO = 5;
	public static final Integer REGISTRO_APLICACION = 6;
	public static final Integer RECUPERAR_PWD = 7;
	
	public static final String PROPERTIES = "ip_registro.properties";

	// Códigos de estatus de validado de curps en RENAPO
	public static final Integer RENAPO_ESTATUS_NO_VALIDADO = 0;
	public static final Integer RENAPO_ESTATUS_VALIDADO = 1;
	public static final Integer RENAPO_ESTATUS_NO_EXISTE = 2;
	public static final Integer RENAPO_ESTATUS_INCONSISTENTE = 3;
	
	public static final String INPUT = "{\"query\":\"query {renapoCurp(curp: \\\"%s\\\") {curp} }\"}";
	
	public static final String VALIDA_CURP_MENSAJE_NO_EXITOSO = "La CURP no se encuentra en la base de datos";
	public static final String PARAMETRO_ESTATUS_VALIDADO_RENAPO = "estatus";
	public static final String VALIDA_CURP_ESTATUS_NO_EXITOSO = "NO EXITOSO";
	public static final String VALIDA_CURP_ESTATUS_EXITOSO = "EXITOSO";
	
	public static final String ADDRESS = "validar-curp-con-renapo";
	public static final String 	ADDRESS_EMAIL = "enviar-email";
	
	public static final String IP_DOMINIO_FRONT = "IP_DOMINIO_FRONT";
	public static final String IP_DOMINIO_IDENTIDAD = "IP_DOMINIO_IDENTIDAD";
	
	public static final String REGEX_PARA_CORREO = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
	public static final String REGEX_PARA_CURP = "^([A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d])(\\d)$";
	
	public static final Integer LONGITUD_CURP = 18;
	public static final Integer LONGITUD_RFC = 13;

}
