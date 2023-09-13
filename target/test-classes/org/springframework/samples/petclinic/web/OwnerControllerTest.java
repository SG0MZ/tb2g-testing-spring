package org.springframework.samples.petclinic.web;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

@SpringJUnitWebConfig(locations = {"classpath:spring/mvc-test-config.xml","classpath:mvc-core-config.xml"})
class OwnerControllerTest {

	@Autowired
	OwnerController ownerController;
	
	@Autowired
	ClinicService clinicService;
	
	@Test
	void tempTest() {
		
	}

}