package kata.server;

import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

public class ConwaySocketServlet extends WebSocketServlet {
	@Override
	public void configure(WebSocketServletFactory factory) {
		factory.register(ConwayGameOfLifeSocket.class);
	}
}