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

@WebServlet(name = "etudiant", value = "/etudiant")
public class etudiantServelet extends HttpServlet {
  public void doPost(HttpServletRequest request, HttpServletResponse response) {

    Etudiant etudiant = new Etudiant();

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

    try {
      context = new InitialContext(jndiProperties);

      EtudiantEjb etudiantEjb;
      etudiantEjb = (EtudiantEjb) context
          .lookup("ejb:/demoSIMEjb-1.0-SNAPSHOT/EtudiantEjb!ma.fstt.ejb.EtudiantEjb");
      etudiantEjb.addEtudiant(etudiant);

    } catch (NamingException e) {
      e.printStackTrace();
    }

  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) {
    Properties jndiProperties = new Properties();
    jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
    jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
    jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
    jndiProperties.put("jboss.naming.client.ejb.context", true);
    Context context;

    try {
      context = new InitialContext(jndiProperties);

      EtudiantEjb etudiantEjb = (EtudiantEjb) context
          .lookup("ejb:/demoSIMEjb-1.0-SNAPSHOT/EtudiantEjb!ma.fstt.ejb.EtudiantEjb");

      request.setAttribute("etudiants", etudiantEjb.getAllEtudiants());
      request.getRequestDispatcher("etudiants.jsp").forward(request, response);

    } catch (NamingException e) {
      e.printStackTrace();
    } catch (ServletException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
