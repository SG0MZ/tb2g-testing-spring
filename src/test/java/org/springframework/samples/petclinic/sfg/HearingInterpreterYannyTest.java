package org.springframework.samples.petclinic.sfg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.BaseConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseConfig.class, YannyConfig.class})
class HearingInterpreterYannyTest {

	@Autowired
	HearingInterpreter hearingInterpreter;
	
	@Test
	void whaIheard() {
		String word = hearingInterpreter.whatIheard();
		
		assertEquals("Yanny",word);
	}

}
