package com.muktai.publish;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.muktai.model.Product;

@Component
public class Publisher 
{
	@Autowired
	private KafkaTemplate<String,Product> kafkaTemplate;
	
	@Value("${my.kafka.topic.name}")
	private String topicName;
	
	private Logger logger=LoggerFactory.getLogger(Publisher.class);
	
	public void sendProds(List<Product> products) {
		// TODO Auto-generated method stub
		logger.info("List of products:{}", products);
		for (Product product : products) 
		{
			kafkaTemplate.send(topicName,product);
		}
	}

	public void sendOneProd(Product p1) {
		// TODO Auto-generated method stub
		logger.info("One Product:{}", p1);
		kafkaTemplate.send(topicName,p1);
	}

}
