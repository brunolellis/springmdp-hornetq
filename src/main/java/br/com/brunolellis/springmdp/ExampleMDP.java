package br.com.brunolellis.springmdp;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component("exampleMDP")
public class ExampleMDP implements MessageListener {
	
	public void onMessage(final Message msg) {
//		if (Math.random() > 0.95)
		
			try {
				System.out.println("Received " + ((TextMessage) msg).getText());
				
				
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
