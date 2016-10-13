//Servlet appellée lors de l'appui sur le bouton créer de la page "Ajouter une personne" (FormulairePerson.html)
package nsis.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nsis.bean.ErrorBean;

import nsis.bean.PersonBean;
import nsis.bo.Person;
import nsis.dao.PersonDAO;
import nsis.exception.EmptyException;
import nsis.exception.MineurException;
import nsis.service.ConfigurationService;


public class LoginServlet extends HttpServlet {
	
	public String messageErreur;
	private static final long serialVersionUID = 1L;

	//Constructeur par défaut.
	public LoginServlet() {
		super();
	}

	
	@Override
	//methode doGet hérité de la classe mère HttpServlet.
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * si l'utilisateur tape l'adresse de la servlet directement dans la
		 * barre d'adresse, il est renvoyé sur la page d'accueil !
		 */
		response.sendRedirect("index.html");
	}

	@Override
	//methode doPost hérité de la classe mère HttpServlet. C'est cette méthode qui est appellé lors du clique sur le bouton "créer" du formulaire "FormulairePerson
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// on récupère les valeurs des champs du formulaire de la page FormulairePerson
		try {
			String lastName = request.getParameter("lastName");
			String firstName = request.getParameter("firstName");
			String emails = request.getParameter("emails");
			String phone = request.getParameter("phone");
			String city = request.getParameter("city");
			String an = request.getParameter("an");
			String mois = request.getParameter("mois");
			String jour = request.getParameter("jour");

			// on vérifie que tous les champs ont bien été remplis.
			//le champ city n'est pas vérifié car venant d'un menu déroulant il ne peut être ni null, ni faux (à moins d'une erreur du développeur).
			if (!firstName.isEmpty() && !lastName.isEmpty() && !emails.isEmpty() && !phone.isEmpty() && an != null && jour != null && mois != null) {
				
				//transformation du champs city (String) en integer
				int id_city = Integer.parseInt(city);
				
				//Conversion des champs an, jour et mois en un type calendar
				Calendar date = new GregorianCalendar(Integer.parseInt(an), Integer.parseInt(mois) - 1, Integer.parseInt(jour));
				
				
				
				ConfigurationService conServ = new ConfigurationService(
						"/home/lgolvan/Java/workspace/Servers/Tomcat v8.0 Server at localhost (2)-config/config.properties");
				//création d'une instance de Person
				Person p = new Person();
				p.setFirstName(firstName);
				p.setLastName(lastName);
				p.setEmail(emails);
				p.setPhone(phone);
				p.setId_city(id_city);
				p.setDate(date);

				//appel du DAO
				PersonDAO persdao = new PersonDAO();
				//Création d'une personne correspondant aux paramètres dans la base de donnée SQL.
				persdao.createPerson(p);
				// on crée un objet UserBean pour transfere les information vers la session.
				PersonBean addedPerson = new PersonBean(p);

				// on stocke le bean dans la session courante.
				request.getSession().setAttribute("person", addedPerson);
				
				RequestDispatcher rd = request.getRequestDispatcher("AddPerson.jsp");
				rd.forward(request, response);
				
			} else {
				// erreur envoyée si un des champs est incomplet
				throw new EmptyException(
						"Les informations sont incomplètes, nous ne pouvons enregistrer la personne...");
			}
			
		} catch (MineurException e) {
			//récupération d'un message d'erreur si une personne est trop jeune pour entrer dans la base de donnée.
			//(la limite est 18 ans)
			messageErreur = e.getMessage();
			ErrorBean currentErreur = new ErrorBean();
			currentErreur.setErreur(messageErreur);
			request.getSession().setAttribute("erreur", currentErreur);
			RequestDispatcher rd = request.getRequestDispatcher("AddPerson.jsp");
			rd.forward(request, response);
			
			
			
		} catch (SQLException e) {
			//récupération du message d'erreur si il y a un problème au niveau de la base de donnée
			messageErreur = e.getMessage();
			ErrorBean currentErreur = new ErrorBean();
			currentErreur.setErreur(messageErreur);
			request.getSession().setAttribute("erreur", currentErreur);
			RequestDispatcher rd = request.getRequestDispatcher("AddPerson.jsp");
			rd.forward(request, response);
			
			
			
		} catch (EmptyException e) {
			//récupération du message d'erreur si il manque des champs d'information
			messageErreur = e.getMessage();
			ErrorBean currentErreur = new ErrorBean();
			currentErreur.setErreur(messageErreur);
			request.getSession().setAttribute("erreur", currentErreur);
			RequestDispatcher rd = request.getRequestDispatcher("AddPerson.jsp");
			rd.forward(request, response);
		}

	}

}
