<%-- 
    Document   : sign_in
    Created on : 20 juin 2021, 11:04:50
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
                <li>
                    <a href="index.jsp">Accueil</a>
                </li>
                <li class="active">Connexion</li>
            </ol>

            <div class="row">

                <!-- Article main content -->
                <article class="col-xs-12 maincontent">
                    <header class="page-header">
                        <h1 class="page-title">Se connecter</h1>
                    </header>

                    <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <h3 class="thin text-center">Se connecter à votre compte</h3>
                                <p class="text-center text-muted">Lorem ipsum dolor sit amet, <a href="inscription">S'enregistrer</a> adipisicing elit. Quo nulla quibusdam cum doloremque incidunt nemo sunt a tenetur omnis odio. </p>
                                <hr>

                                <form action="connexion" method="post">

                                    <div class="top-margin">
                                        <label>Telephone : <span class="text-danger">*</span> +243</label>
                                        <input type="tel" class="form-control" name="telephone" maxlength="9">
                                    </div>
                                    <div class="top-margin">
                                        <label>Mot de passe <span class="text-danger">*</span></label>
                                        <input type="password" class="form-control" name="password">
                                    </div>

                                    <hr>

                                    <div class="row">
                                        <div class="col-lg-8">
                                            <b><a href="">Mot de passe oublié ?</a></b>
                                        </div>
                                        <div class="col-lg-4 text-right">
                                            <button class="btn btn-action" type="submit">Se connecter</button>
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
