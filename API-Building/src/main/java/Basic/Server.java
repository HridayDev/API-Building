package Basic;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Server {

	private Tomcat tomcat;

	public Server(int port) {
		tomcat = new Tomcat();
		tomcat.setPort(port);
		try {
			tomcat.start();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
		tomcat.getServer().await();

	}

	public void addServlet(String contexName, String servletPath, String servletClassName) {
		tomcat.addServlet(contexName, servletPath, servletClassName);
	}

}
