//Exception lancé lorsqu'on essaye de rentrer une personne mineur dans la base SQL

package nsis.exception;

public class MineurException extends Exception {
	 private static final long serialVersionUID = 1L;
     public MineurException(String message){
        super(message);
     }
}
