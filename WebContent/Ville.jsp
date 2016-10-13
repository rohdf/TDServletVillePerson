<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Une Ville</title>

<!-- Bootstrap -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Import de CityBean et ErrorBean -->
<%@page import="nsis.bean.CityBean"%>
<%@page import="nsis.bean.ErrorBean"%>
</head>
<body>
<!-- code java integré au html -->
	<%
		//on commence par verifier qu'on nous envoi bien des information pour créer la page (il s'agit d'un système de débug)
		if (request.getSession().getAttribute("cityPerson") == null) {
			//on appel le bean
			ErrorBean currentErreur = (ErrorBean) request.getSession().getAttribute("erreur");
			//on fait la mise en page
			out.print(
					"  <div class=\"container\"><header class=\"row\"><h1 style=\"color:red\">ERREUR</h1></header><div class=\"row\"><nav class=\"col-lg-2\">   <div class=\"row\"><a href=\"index.html\">Retour à l'Acceuil</a><br/></div><div class=\"row\"><a href=\"FormulairePerson.html\" />Ajouter une personne</a><br/></div><div class=\"row\"><a href=\"FormulaireVille.html\"/>Visualiser une ville</a></div></nav><section class=\"col-lg-10\">Il y a un Bug...");
			//on écrit l'erreur
			out.print(String.format("</br><p style=\"color:red\"> %s", currentErreur.getErreur()));
			out.print("</p></section></div></header><div/>");
			
		} else {
			
			//On appel le bean
			CityBean cityPerson = (CityBean) request.getSession().getAttribute("cityPerson");
			//Si la ville n'a pas d'habitant
			if (cityPerson.PersonListEmpty() == true) {
				out.print("<div class=\"container\"><header class=\"row\"><h1>");
				out.print(String.format(cityPerson.getName()));
				out.print(
						"</h1></header><div class=\"row\"><nav class=\"col-lg-2\">   <div class=\"row\"><a href=\"index.html\">Retour à l'Acceuil</a><br/></div><div class=\"row\"><a href=\"FormulairePerson.html\" />Ajouter une personne</a><br/></div><div class=\"row\">_<a href=\"FormulaireVille.html\"/>Visualiser une ville</a></div></nav><section class=\"col-lg-10\">");
				out.print("<p>");
				out.print(String.format(cityPerson.getName()));
				out.print(" ne possède aucun habitant...");
				out.print("</p></section></div><div/>");
				//Si la ville n'a qu'un seul habitant
			} else if (cityPerson.getListSize() == 1) {
				out.print("<div class=\"container\"><header class=\"row\"><h1>");
				out.print(String.format(cityPerson.getName()));
				//Cette horrible string code le menu exactement comme dans les autres pages...
				out.print(
						"</h1></header><div class=\"row\"><nav class=\"col-lg-2\">   <div class=\"row\"><a href=\"index.html\">Retour à l'Acceuil</a><br/></div><div class=\"row\"><a href=\"FormulairePerson.html\" />Ajouter une personne</a><br/></div><div class=\"row\">_<a href=\"FormulaireVille.html\"/>Visualiser une ville</a></div></nav><section class=\"col-lg-10\">");
				out.print("<p>voici l'unique habitant de la ville de");
				out.print(String.format(cityPerson.getName()));
				//on fait un tableau des personnes
				out.print("</p><table>");
				out.print("<tr><td><p style=\"color:#2E2E2E\">");
				out.print(String.format(cityPerson.getPersonFirstName(0)));
				out.print("</td><td>");
				out.print(String.format(cityPerson.getPersonLastName(0)));
				out.print("</td><td>");
				out.print(String.format(cityPerson.getPersonDate(0)));
				out.print("</td><td>");
				out.print(String.format(cityPerson.getPersonPhone(0)));
				out.print("</td><td>");
				out.print(String.format(cityPerson.getPersonEmail(0)));

				out.print("</p></td></tr>");
				out.print("</table>");
				out.print("</section></div><div/>");
				//Si la ville a plus d'un habitant
			} else {
				out.print("<div class=\"container\"><header class=\"row\"><h1>");
				out.print(String.format(cityPerson.getName()));
				//Cette horrible string code le menu exactement comme dans les autres pages...
				out.print(
						"</h1></header><div class=\"row\"><nav class=\"col-lg-2\">   <div class=\"row\"><a href=\"index.html\">Retour à l'Acceuil</a><br/></div><div class=\"row\"><a href=\"FormulairePerson.html\" />Ajouter une personne</a><br/></div><div class=\"row\">_<a href=\"FormulaireVille.html\"/>Visualiser une ville</a></div></nav><section class=\"col-lg-10\">");
				out.print("<p>voici les habitants de la ville de :");
				out.print(String.format(cityPerson.getName()));
				out.print("</p><br />");
				int i = 0;
				//on fait un tableau des personnes
				out.print("<table>");
				//on génere une ligne par iteration.
				while (i < cityPerson.getListSize()) {

					out.print("<tr><td><p style=\"color:#2E2E2E\">");
					out.print(String.format(cityPerson.getPersonFirstName(i)));
					out.print("</td><td>");
					out.print(String.format(cityPerson.getPersonLastName(i)));
					out.print("</td><td>");
					out.print(String.format(cityPerson.getPersonDate(i)));
					out.print("</td><td>");
					out.print(String.format(cityPerson.getPersonPhone(i)));
					out.print("</td><td>");
					out.print(String.format(cityPerson.getPersonEmail(i)));
					out.print("</p></td></tr>");
					i++;
				}
				out.print("</table>");
				out.print("</section></div><div/>");
			}

		}
	%>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>