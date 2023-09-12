package org.springframework.samples.petclinic.sfg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.BaseConfig;
import org.springframework.sfg.LaurelConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseConfig.class, LaurelConfig.class})
class HearingInterpreterTest {

	@Autowired
	HearingInterpreter hearingInterpreter;
	
//	@Before
//	public void setUp() throws Exception {
//		hearingInterpreter = new HearingInterpreter(new LaurelWordProducer());
//	}
	
	@Test
	public void whatIheard() {
		String word = hearingInterpreter.whatIheard();
		assertEquals("Laurel",word);
	}

}
