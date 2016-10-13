<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>Une Personne en Plus</title>

<!-- importation de Bootstrap et de la feuille de style -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    
    <!-- importation des bean -->
<%@page import="nsis.bean.PersonBean"%>
<%@page import="nsis.bean.ErrorBean"%>
</head>
<body>
	<%
		// On vérifie l'existence d'information pour la création de la page
		if (request.getSession().getAttribute("person") == null) {
			//on affiche l'erreur si il y en a (si il y a un probleme SQL, si la personne est mineur ou si il manque des champs)
			ErrorBean currentErreur = (ErrorBean) request.getSession().getAttribute("erreur");
			out.print("<div class=\"container\"><header class=\"row\"><h1>ERREUR</h1></br>");
			out.print("<div class=\"row\"><nav class=\"col-lg-2\">   <div class=\"row\"><a href=\"index.html\">Retour à l'Acceuil</a><br/></div><div class=\"row\"><a href=\"FormulairePerson.html\" />Ajouter une personne</a><br/></div><div class=\"row\"><a href=\"FormulaireVille.html\"/>Visualiser une ville</a></div></nav><section class=\"col-lg-10\">");
			out.print(
					" <p>Vous n'avaez pas ajouté de personne... <a href=\"FormulairePerson.html\">ici</a> pour réessayer</p>");
			out.print(String.format("</br><p style=\"color:red\"> %s", currentErreur.getErreur()));
			out.print("</p>");
			out.print("</section></div><div/>");

		} else {
			// Validation de l'enregistrement de la personne
			PersonBean addedPerson = (PersonBean) request.getSession().getAttribute("person");
			out.print("<div class=\"container\"><header class=\"row\"><h1>ENREGISTREMENT REUSSI");
			out.print(
					"</h1></header><div class=\"row\"><nav class=\"col-lg-2\">   <div class=\"row\"><a href=\"index.html\">Retour à l'Acceuil</a><br/></div><div class=\"row\"><a href=\"FormulairePerson.html\" />Ajouter une personne</a><br/></div><div class=\"row\">_<a href=\"FormulaireVille.html\"/>Visualiser une ville</a></div></nav><section class=\"col-lg-10\"><p>");
			out.print(String.format("Bravo! vous avez ajouter la personne : %s", addedPerson.getFirstName(), " ",
					addedPerson.getLastName()));
			out.print("</p><br />");
			out.print("</section></div><div/>");

		}
	%>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>