package nsis.bean;


//Classe bean renvoyant le message d'erreur à la page HTML
public class ErrorBean {
	public String erreur;
	
	public ErrorBean(){
		this.erreur= "inconnue";
	}
	
	public String getErreur(){
		return erreur;
	}
	
	public void setErreur(String erreur){
		this.erreur=erreur;
	}

}