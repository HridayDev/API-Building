package Basic;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Server {

	private Tomcat tomcat;
	int port;

	public Server(int Port) {
		this.port = Port;
		System.out.println("\nAttempting To Make Tomcat Instance...");
		tomcat = new Tomcat();
		System.out.println("Tomcat Instance Made!");

		System.out.println("\nAttempting To Set Port " + port + " ...");
		tomcat.setPort(port);
		System.out.println("Port " + port + " Set!");
	}

	public void Start() {
		System.out.println("\nAttempting To Start The Server");
		try {
			tomcat.start();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
		System.out.println("Server Started And Ready! Serving On " + port + " ...");
	}

	public void addServlet(String contextName, String servletPath, String servletClassName) {
		System.out.println("\nAttempting To Make Servlet...");
		Context ctx = tomcat.addContext(contextName, System.getProperty("java.io.tmpdir"));
		Tomcat.addServlet(ctx, servletPath, servletClassName);
		ctx.addServletMappingDecoded(servletPath, servletClassName);
		System.out.println("Servlet " + contextName + servletPath + " Made!");
	}

}