//Servlet appellée lors de l'appui sur le bouton visualiser de la page Visualiser une Ville (FormulaireVille.html)
package nsis.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nsis.bean.CityBean;
import nsis.bean.ErrorBean;
import nsis.bo.City;
import nsis.bo.Person;
import nsis.dao.CityDAO;
import nsis.dao.PersonDAO;
import nsis.service.ConfigurationService;


public class VilleServlet extends HttpServlet {
	public String messageErreur;
	private static final long serialVersionUID = 1L;

	//constructeur
	public VilleServlet() {
		super();
	}

	@Override
	//methode doPost lors du clique sur le bouton "visualiser" du formulaire FormulaireVille 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// on récupère la ville à afficher
		try {
			String city = request.getParameter("city");
			//on transforme city en integer
			int id_city = Integer.parseInt(city);

			ConfigurationService conServ = new ConfigurationService(
					"/home/lgolvan/Java/workspace/Servers/Tomcat v8.0 Server at localhost (2)-config/config.properties");
			//appel du DAO (pour la classe City)
			CityDAO citydao = new CityDAO();
			//récupération de la ville dans la base de donnée
			City c = citydao.getCity(id_city);

			//création d'un bean pour envoyer les informations à la session
			CityBean cityPerson = new CityBean(c);
			
			//appel du DAO (pour la classe Person cette fois)
			PersonDAO personDAO = new PersonDAO();
			
			//récupération de la liste des habitants de la ville
			List<Person> personList = personDAO.selectByCityId(id_city);
			//ajout de la liste au bean
			cityPerson.setList(personList);

			// on stocke le bean dans la session courante.
			request.getSession().setAttribute("cityPerson", cityPerson);

			RequestDispatcher rd = request.getRequestDispatcher("Ville.jsp");
			rd.forward(request, response);

		} catch (SQLException e) {
			//envoi d'erreur dans le cas d'un probleme avec la base de donnée
			messageErreur = e.getMessage();
			ErrorBean currentErreur = new ErrorBean();
			currentErreur.setErreur(messageErreur);
			request.getSession().setAttribute("erreur", currentErreur);
			RequestDispatcher rd = request.getRequestDispatcher("Ville.jsp");
			rd.forward(request, response);
		}

	}

}
