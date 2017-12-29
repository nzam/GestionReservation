
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.AbonneSessionBeanLocal;

/**
 *
 * @author jules
 */
@WebServlet(urlPatterns = {"/Menu"})
public class Menu extends HttpServlet {

    @EJB
    AbonneSessionBeanLocal abonneSessionBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        
        String jspClient = null;
        String act = request.getParameter("action");
        if ((act == null) || (act.equals("null"))) {
            jspClient = "/index.jsp";
            doActionCreerAbonne(request, response);
            System.out.println("\n\n"
                + "-----------------------------------Sans action en params-----------------------------------\n\n");
        }
        /*else if (act.equals("insererF")) {
            jspClient = "/Choix.jsp";
            doActionCreerAbonne(request, response);
        }*/
        else{
            jspClient = "/ajouterAbonne.jsp";            
        }

        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Menu</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Menu at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doActionCreerAbonne(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String message = "";
        System.out.println("\n\n"
                + "-----------------------------------Dans doActionCreerAbonne --------------------------------\n\n");
        if (nom.trim().isEmpty() || prenom.trim().isEmpty()) {
            message = "Erreur ‐ Vous n'avez pas rempli tous les champs obligatoires. "
                    + "<br /> <a href=\"CreerFournisseur.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un fournisseur.";
        }
        else{
            abonneSessionBean.creerAbonne(nom, prenom);
        }
        request.setAttribute("message", message);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
