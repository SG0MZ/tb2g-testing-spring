package org.springframework.samples.petclinic.sfg.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
class HearingInterpreterLaurelTest {

	@Autowired
	HearingInterpreter hearingInterpreter;
	
	@Test
	void whatIheard() {
		String word = hearingInterpreter.whatIheard();
		
		assertEquals("Laurel", word);
	}

}
