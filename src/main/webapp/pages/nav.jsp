<%-- 
    Document   : nav
    Created on : 20 juin 2021, 10:24:47
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Fixed navbar -->
<div class="navbar navbar-inverse navbar-fixed-top headroom">
    <div class="container">
        <div class="navbar-header">
            <!-- Button for smallest screens -->
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
            <a class="navbar-brand" href="accueil"><img src="Assets/images/logos.png" alt="Bana-Mboka Kinshasa"></a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav pull-right">
                <li class="active">
                    <a href="accueil">Accueil</a></li>
                <li><a href="about.jsp">A propos de Nous</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Services <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="entreprise.jsp">ENTREPRISES</a>
                        </li>
                        <li class="active"><a href="particulier.jsp">PARTICULIER</a></li>
                    </ul>
                </li>
                <li><a href="contact.jsp">Contact</a></li>
                <li>
                    <a class="btn" href="connexion"><span class="glyphicon glyphicon-user"></span> Connexion / Inscription</a>
                </li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</div>
