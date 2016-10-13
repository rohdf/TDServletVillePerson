//exception lancée quand on essaye d'inscrire une personne dans la base de donnée avec des champs manquants.
package nsis.exception;

public class EmptyException extends Exception {
	 private static final long serialVersionUID = 1L;
     public EmptyException(String message){
        super(message);
     }
}
