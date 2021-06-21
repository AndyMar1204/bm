package com.andy.bana_mboka.servlets;

import com.andy.bana_mboka.config.DaoInit;
import com.andy.bana_mboka.dao.UserDao;
import com.andy.bana_mboka.forms.UserForm;
import com.andy.bana_mboka.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author Ir Andy
 */


@WebServlet(name = "Inscription", urlPatterns = {"/inscription"})
public class Inscription extends HttpServlet {
    private static final String  ATT_VUE = "/WEB-INF/sign_up.jsp";
    private String action;
    private User user;
    private UserForm form;
    private Session session;
    private UserDao udao;
    private static final String DAO = "dao";
    
    @Override
    public void init() throws ServletException {
        session = (Session) getServletContext().getAttribute(DaoInit.ATT_DAO_FACTORY);
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      this.getServletContext().getRequestDispatcher(ATT_VUE).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userSaver(req,resp);
    }
    void userSaver(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        form = new UserForm();
        user = form.userGetter(req);
        if (form.getErreur().isEmpty()) {
            resp.getWriter().println("Debut de sauvegarde");
            udao = new UserDao(session);
            try {
                udao.save(user);
                resp.getWriter().println("Sauvegarde reussi");
                resp.sendRedirect("accueil");
            } catch (Exception ex) {
                form.addError(DAO, "Echec d'enregistrement " + ex.getMessage());
                for (String s : form.getErreur().keySet()) {
                resp.getWriter().println(form.getErreur().get(s));
            }
            }
        } else {
            for (String s : form.getErreur().keySet()) {
                resp.getWriter().println(form.getErreur().get(s));
            }
        }
    }
}
