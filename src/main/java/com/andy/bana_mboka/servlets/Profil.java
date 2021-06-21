package com.andy.bana_mboka.servlets;

import com.andy.bana_mboka.forms.FormException;
import com.andy.bana_mboka.forms.Outils;
import com.andy.bana_mboka.model.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ir Andy
 */


@WebServlet(name = "Profil", urlPatterns = {"/profil"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class Profil extends HttpServlet {
    private static final String VUE = "/WEB-INF/profil.jsp";
    private User user;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = (User)req.getSession().getAttribute(Connexion.ATT_USER);
        if(user==null){
            resp.sendRedirect("accueil");
            return;
        }
        this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action==null){
            resp.sendRedirect("accueil");
        }else if(action.matches("Modifier")){
            user = (User)req.getSession().getAttribute(Connexion.ATT_USER);
            
                try {
                    Outils.fileUploader(req, resp, "profil");
                } catch (Exception ex) {
                    Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
    }
    
}
