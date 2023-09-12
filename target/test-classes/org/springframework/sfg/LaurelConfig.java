package org.springframework.sfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.sfg.LaurelWordProducer;
import org.springframework.samples.petclinic.sfg.WordProducer;

@Configuration
public class LaurelConfig {
	
	@Bean
	LaurelWordProducer laurelWordProducer(WordProducer wordProducer) {
		return new LaurelWordProducer();
	}
}
