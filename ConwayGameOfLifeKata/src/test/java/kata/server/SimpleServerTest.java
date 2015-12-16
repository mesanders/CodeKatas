package kata.server;

import kata.client.HttpClient;

public class SimpleServerTest implements Runnable {
	private volatile boolean running = true;
	private boolean initialized = false;
	private SimpleServer server;
	private long timestamp = Long.MAX_VALUE;

	public boolean isStarted() {
		if (server == null) { return false; }
		return server.isStarted();
	}

    public void terminate() {
    		server.stop();

    }

      public boolean State() {
        return server.State();
    }

    public String getState() {
    	if (server != null) { return server.getState(); } return "NULL";
    }


	public void run() {
		try {
			server = new SimpleServer();
			server.run(new String[] { } );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testConnectionToServer() {
		try {
			String response = HttpClient.sendGet("http://localhost:8080/index.html");
			assert(response.contains("Hello World"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
