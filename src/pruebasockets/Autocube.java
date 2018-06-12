
package pruebasockets;

import java.net.*;
import java.io.*;
import com.google.gson.*;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Autocube{

    /*
     * Variables de conexion
     */
    private static final int PUERTO = 20460;
    
    private static final String IP = "127.0.0.1";
    
    private Socket so;
    /*
     * Comandos que se enviaran a autocube
     */
    private static final String COMMAND_MEASURE = "{\"command\":\"measure\"}";
    
    private static final String COMMAND_DISCONNECT = 
            "{\"command\":\"disconnect\"}";
    
    private static final String COMMAND_VALIDATE = "{\"command\":\"validate\"}";
    
    Gson gson = new Gson();
    
    /*
     * Bytes para enviar y recibir informacion
     */
    
    byte[] lectura; 
    
    byte[] coneccion;
    
    /*
     *  funcion que obtendra los datos
     */

   public String  leerBulto() {
       //Dato que se retornara
       String datoleer = "";
             
       try {
           /*
            * Se le envia el comando a autocube paraque empiece a leer
            */
           so.getOutputStream().write(COMMAND_MEASURE.getBytes());
           /*
            * Se utiliza la funciona para recibir datos
            */
           datoleer = recibirDatos();
           
           /*
            * Se envia el comando validate para que la aplicacion sepa que 
            * obtuvimos la informacion
            */
           so.getOutputStream().write(COMMAND_VALIDATE.getBytes());
           
       } catch(SocketException e) {
           /*
            * Catch para controlar errore en el excepcion
            */
           System.out.println("Error" + e.getMessage());
           /*
            * Catch para controlar errores de punteros nulos
            */
       } catch(NullPointerException e) {
           
           System.out.println("Algun tipo de dato es nulo" + e.getMessage());
           /*
            * Catch para controlar errores de datos
            */
       } catch(IllegalStateException e) {
           
           System.out.println("Error con los datos"+ e.getMessage());
           /*
            * Catch para controlar Errores generales
            */
       } catch(IOException e) {
           
           System.out.println("Error" + e.getMessage());
           
       }
       
       /*
        * retornar el byte parseado a String que obtendremos de autocube
        */
       return datoleer;
              
   }
    
   /*
    * Funcion que crea la  conexion 
    */
   public String conectarAutocube() {
       
       /*
        * Variable String que nos indicara que estamos conectados
        */
       String datoconec = "";
       
       try {
           /*
            * Inicializamos el socket ocn puerto e ip
            */
           so = new Socket(IP,PUERTO);
           
           datoconec = recibirConeccion();
           
           /*
            * Excepction de errores
            */
       } catch(SocketTimeoutException s) {
           System.out.println("Socket timed out!" + s.getMessage());
       } catch(IOException e) {
           datoconec = "Error al conectar " +  e.getMessage();
       } 
       return datoconec;
   }
   
   
   public String recibirConeccion() {
       
       /*
        * Variable String que nos indicara que estamos conectados
        */
       String datoconec = "";
       
        try {
            /*
             * Metodos de coneccion
             */
            coneccion = new byte[so.getInputStream().available()];
            
            so.getInputStream().read(coneccion);
            
            datoconec = new String(coneccion);
            
            /*
             * Repetir la funcion  hasta esperar respuesta del servidor si no estamos conectados
             */
            if(datoconec.isEmpty()) {
                recibirConeccion();
            }
        } catch (IOException ex) {
            
            Logger.getLogger(Autocube.class.getName()).
                                                    log(Level.SEVERE, null, ex);
            
        }
       
       datoconec = new String(coneccion);
       
       return datoconec;
   }
   
   /*
    * Funcion que recibira los datos para ser añadidos a la clase
    */
   public String recibirDatos() throws IOException {
        
        String datoleer = "";
        
        int bytesEstimados = 0;
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        while(bytesEstimados <= 0 || 
                    timestamp.getNanos() + 5000 == System.currentTimeMillis()) {
            bytesEstimados = so.getInputStream().available();
            
            if(bytesEstimados > 0) {
                lectura = new byte[bytesEstimados];
                
                so.getInputStream().read(lectura);
                
                datoleer = new String(lectura);
            } else if(timestamp.getNanos() + 5000 == System.currentTimeMillis()) {
                return datoleer;
            }
        }
        
        return datoleer;
   }
   
   
   /*
    * Funcion  que cerrara la conexion
    */
   
   public void desconectarAutocube() {
       try {
           enviarDesconeccion();
           
           if(so.isClosed() == false)
           {
               so.close();
           }
           
           System.out.println("Cerrando Conexion...");
       } catch(IOException e) {
           System.out.println("Error al cerrar " + e.getMessage());
       }
   }
   /*
    * Funcion para desconectar
    */
   public void enviarDesconeccion() {
         try {
             
             so.getOutputStream().write(COMMAND_DISCONNECT.getBytes());
             
         } catch (IOException ex) {
             
             System.out.println("Error al enviar" + ex);
             
         }
   }
   

     

}
