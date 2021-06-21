<%-- 
    Document   : sign_up
    Created on : 20 juin 2021, 10:57:53
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/pages/header.jsp"></c:import>
    <body class="">
    <c:import url="/pages/nav.jsp"></c:import><!-- Header -->
        <header id="head" class="secondary"></header>

        <!-- container -->
        <div class="container">

            <ol class="breadcrumb">
                <li><a href="index.jsp">Accueil</a></li>
                <li class="active">Enregistrement</li>
            </ol>

            <div class="row">

                <!-- Article main content -->
                <article class="col-xs-12 maincontent">
                    <header class="page-header">
                        <h1 class="page-title">Enregistrement</h1>
                    </header>

                    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <h3 class="thin text-center">Créer un nouveau compte</h3>
                                <p class="text-center text-muted">Lorem ipsum dolor sit amet, <a href="connexion">Se connecter</a> adipisicing elit. Quo nulla quibusdam cum doloremque incidunt nemo sunt a tenetur omnis odio. </p>
                                <hr>

                                <form method="post" action="inscription" >
                                    <div class="top-margin">
                                        <label for="typeCompte">Je suis</label>
                                        <div class="form-control"><input type="radio" name="typeCompte" id="Entreprise" value="Entreprise" required><label for="Entreprise"> Une Entreprise</label>
                                            <input type="radio" name="typeCompte" id="Particulier" value="Particulier"><label for="Particulier"> Un Particulier</label></div>
                                    </div>
                                    <div class="top-margin">
                                        <label>Nom d'utilisateur</label>
                                        <input type="text" class="form-control" name="username">
                                    </div>
                                    <div class="top-margin">
                                        <label>Telephone <span class="text-danger">*</span></label>
                                        <input type="tel" class="form-control" name="telephone" maxlength="9" required >
                                    </div>
                                    <div class="top-margin">
                                        <label>E-Mail <span class="text-danger">*</span></label>
                                        <input type="email" class="form-control" name="email" required>
                                    </div>

                                    <div class="row top-margin">
                                        <div class="col-sm-6">
                                            <label>Mot de passe <span class="text-danger">*</span></label>
                                            <input type="password" class="form-control" name="password" required>
                                        </div>
                                        <div class="col-sm-6">
                                            <label>Confirmer Mot de passe <span class="text-danger">*</span></label>
                                            <input type="password" class="form-control" name="confirm" required>
                                        </div>
                                    </div>
                                    <div>
                                    <c:import url="/pages/adress_form.jsp"></c:import>
                                    </div>


                                    <hr>

                                    <div class="row">
                                        <div class="col-lg-7 col-sm-offset-1">
                                            <label class="checkbox">
                                                <input type="checkbox" required>J'ai lu et accepter <a href="page_terms.html">les termes et conditions</a>
                                            </label>
                                        </div>
                                        <div class="col-lg-4 text-right">
                                            <button class="btn btn-action" type="submit">S'enregistrer</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>

                    </div>

                </article>
                <!-- /Article -->

            </div>
        </div>
        <!-- /container -->


    <c:import url="/pages/footer.jsp"></c:import>
