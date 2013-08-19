package br.com.brunolellis.springmdp.test;

import java.util.Hashtable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ProducerMain {

	public static void main(String[] args) throws Exception {
		Connection connection = null;

		InitialContext context = null;
		try {
			Hashtable<String, String> env = new Hashtable<String, String>();
//			env.put(Context.PROVIDER_URL, "jnp://10.202.70.121:1099");
			env.put(Context.PROVIDER_URL, "jnp://10.202.22.54:1099");
			
			env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			
			context = new InitialContext(env);
			
			Queue queue = (Queue) context.lookup("/queue/exampleQueue");
			ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("/ConnectionFactory");
			connection = connectionFactory.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			connection.start();

			MessageProducer producer = session.createProducer(queue);

			final int numMessages = 5000;

			for (int i = 0; i < numMessages; i++) {
				TextMessage message = session.createTextMessage("This is text message " + i);
				producer.send(message);

				System.out.println("Sent message: " + message.getText());

			}

		} finally {
			if (connection != null) {
				connection.close();
			}

			if (context != null) {
				context.close();
			}

		}

	}

}
