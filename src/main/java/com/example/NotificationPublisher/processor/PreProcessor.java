package com.example.NotificationPublisher.processor;

import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.example.NotificationPublisher.exception.NotificationPublisherException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PreProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		log.info("In [Preprocessor.process]");
		log.info("STARTED PROCESSING MESSAGE : {} AT TIME: {}", exchange.getExchangeId(), new Date().toString());

		Object messageBody = exchange.getIn().getBody();
		if (messageBody == null) {
			log.warn("Message body is null , unexpected condition . Nothing to do.");

			throw new NotificationPublisherException(NotificationPublisherException.EXCEPTION_DATA_NOT_FOUND,
					"Message body is null , Unexpected Condition");
		}

		log.info("Message Body :" + (String) messageBody);
		exchange.getIn().setBody(messageBody);

	}

}
