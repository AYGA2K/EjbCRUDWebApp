package ma.fstt.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstt.ejb.EtudiantEjb;
import ma.fstt.entity.Etudiant;

/**
 * updateEtudiant
 */
@WebServlet(name = "updateetudiant", value = "/updatetudiant")
public class updateEtudiantServelt extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    String etudiantId = request.getParameter("id");
    if (etudiantId != null) {
      Long id = Long.parseLong(etudiantId);
      Properties jndiProperties = new Properties();
      jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
      jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
      jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
      jndiProperties.put("jboss.naming.client.ejb.context", true);
      Context context;

      EtudiantEjb etudiantEjb;
      try {
        context = new InitialContext(jndiProperties);
        etudiantEjb = (EtudiantEjb) context
            .lookup("ejb:/demoSIMEjb-1.0-SNAPSHOT/EtudiantEjb!ma.fstt.ejb.EtudiantEjb");

        Etudiant etudiant = etudiantEjb.getEtudiant(id);
        request.setAttribute("etudiant", etudiant);

      } catch (NamingException e) {
        e.printStackTrace();
      }

      try {
        request.getRequestDispatcher("updateEtudiant.jsp").forward(request, response);
      } catch (ServletException | IOException e) {
        e.printStackTrace();
      }
    }

  }

  public void doPost(HttpServletRequest request, HttpServletResponse response) {

    Etudiant etudiant = new Etudiant();
    etudiant.setId_etudiant(Long.parseLong(request.getParameter("id")));
    etudiant.setNom(request.getParameter("nom"));
    etudiant.setPrenom(request.getParameter("prenom"));
    etudiant.setAdresse(request.getParameter("adresse"));
    etudiant.setCne(request.getParameter("cne"));
    etudiant.setNiveau(request.getParameter("niveau"));
    Properties jndiProperties = new Properties();
    jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
    jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
    jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
    jndiProperties.put("jboss.naming.client.ejb.context", true);
    Context context;

    EtudiantEjb etudiantEjb;
    try {
      context = new InitialContext(jndiProperties);
      etudiantEjb = (EtudiantEjb) context
          .lookup("ejb:/demoSIMEjb-1.0-SNAPSHOT/EtudiantEjb!ma.fstt.ejb.EtudiantEjb");
      etudiantEjb.updateEtudiant(etudiant);
    } catch (NamingException e) {
      e.printStackTrace();
    }

    try {
      response.sendRedirect("index.jsp");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
