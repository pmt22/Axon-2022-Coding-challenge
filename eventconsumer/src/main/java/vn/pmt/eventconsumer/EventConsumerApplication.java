package vn.pmt.eventconsumer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EventConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventConsumerApplication.class, args);
    }

    @Bean
    public Queue eventQueue() {
        return new Queue("events", false);
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter,
                                                    Queue queue) {
        var container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueues(queue);
        container.setMessageListener(messageListenerAdapter);
        return container;
    }

    @Bean
    public MessageListenerAdapter messageListenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receive");
    }
}
