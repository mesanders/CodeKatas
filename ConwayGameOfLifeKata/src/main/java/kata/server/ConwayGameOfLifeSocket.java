package kata.server;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

import kata.gameoflife.Grid;

@WebSocket
public class ConwayGameOfLifeSocket {
	private Session session;
	private Grid grid;
	private final static String DEFAULT_FILE = "../resources/second_ingest.txt";
	private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);	

	// Called when the socket connection with the browser is first established
	@OnWebSocketConnect
	public void handleConnect(Session session) {
		this.session = session;
		this.grid = new Grid();
		try { 
			grid.readGrid(DEFAULT_FILE);
		} catch (IOException ie) {
			ie.printStackTrace();
		}

		System.out.println("New session");
		send("Success - From the server.");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		executor.scheduleAtFixedRate( () -> { 
			grid.nextGenerationGrid();
			send(grid.stateToString()); 
		}, 0, 1, TimeUnit.SECONDS );
	}

	// Called when the connection is closed, may want to log the statusCode/Reason
	@OnWebSocketClose
	public void handleClose(int statusCode, String reason) {
		System.out.println(reason + " " + statusCode);
	}

	// Called when a message is received from the browser (e.g. WebSocket.send(message))
	@OnWebSocketMessage
	public void handleMessage(String message) {
		/* Example, check the name of the message, and if it is a begin message then set some kind of fixed rate
		   execution to help visualize conways game of life:
		   executor.scheduleAtFixedRate( () -> { send("MESSAGE"); },0, 1, TimeUnit.Seconds );
		   
		   There are multiple ways to handle this, we can do a fixed rate 
		*/

	}

	// Called if there is an error that needs to be handled.
	@OnWebSocketError
	public void handleError(Throwable error) {
		System.err.println("HandleError");
	}

	// This is a message handler that can send messages back to the session (Which is just a thread that we are messaging.)
	private void send(String message) {
		try {
			if (session.isOpen()) {
				session.getRemote().sendString(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}