package Basic;

public class Main {
	
	private static int port = 8080;
	
	public static void main(String[] args) {
		Server server = new Server(port);
		server.Start();server.addServlet("", "/hi", "Basic.ServletIndex");
	}

}
