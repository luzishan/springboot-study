package com.rabbitmq.consumer;

import com.rabbitmq.client.*;

import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者
 *
 * @author lzs
 * @version 1.0
 * @date 2021/1/15 10:59
 */
@RestController
public class ConsumerController01 {

    private static final String QUEUENAME = "helloworld";

    public static void main(String[] args) throws IOException, TimeoutException {

        ConnectionFactory factory = new ConnectionFactory();
        //设置MabbitMQ所在服务器的ip和端口
        factory.setHost("81.68.99.151");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        /**
         * 声明队列，如果Rabbit中没有此队列将自动创建
         * param1:队列名称
         * param2:是否持久化
         * param3:队列是否独占此连接
         * param4:队列不再使用时是否自动删除此队列
         * param5:队列参数
         */
        channel.queueDeclare(QUEUENAME, true, false, false, null);
        //定义消费方法
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //交换机
                String exchange = envelope.getExchange();
                //路由key
                String routingKey = envelope.getRoutingKey();
                //消息id
                long deliveryTag = envelope.getDeliveryTag();
                //消息内容
                String msg = new String(body,"utf-8");
                System.out.println("receive message.." + msg);
            }
        };
        /**
         * 监听队列String queue, boolean autoAck,Consumer callback
         * 参数明细
         * 1、队列名称
         * 2、是否自动回复，设置为true为表示消息接收到自动向mq回复接收到了，mq接收到回复会删除消息，设置为false则需要手动回复
         * 3、消费消息的方法，消费者接收到消息后调用此方法
         */
        channel.basicConsume(QUEUENAME, true, consumer);
    }
}
