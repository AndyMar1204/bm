package com.andy.bana_mboka.servlets;

import com.andy.bana_mboka.config.DaoInit;
import com.andy.bana_mboka.dao.FichierDao;
import com.andy.bana_mboka.forms.FichierForm;
import com.andy.bana_mboka.forms.FormException;
import com.andy.bana_mboka.model.Fichier;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author Ir Andy
 */
@WebServlet(name = "Uploader", urlPatterns = {"/uploader"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class Uploader extends HttpServlet {
    Session session;
    FichierDao dao;
    public static final String VUE = "/WEB-INF/uploader.jsp";

    @Override
    public void init() throws ServletException {
        session = (Session) getServletContext().getAttribute(DaoInit.ATT_DAO_FACTORY);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Fichier fichier;
            FichierForm form = new FichierForm();
            resp.getWriter().println(FichierForm.timeGetter());
            Random rd = new Random();
           // return;
            fichier = form.fichierUploader(req, "file-".concat(String.valueOf(rd.nextLong())));
            dao= new FichierDao(session);
            try {
                dao.save(fichier);
            } catch (Exception ex) {
                //Logger.getLogger(Uploader.class.getName()).log(Level.SEVERE, null, ex);
                resp.getWriter().println("Echec d'enregistrement dans la bd... " + fichier.getNom());
            }
            resp.getWriter().println("Telechargement fini " + fichier.getNom());
        } catch (FormException ex) {
            resp.getWriter().println("Erreur survenue " + ex.getMessage());
        }

    }
}
