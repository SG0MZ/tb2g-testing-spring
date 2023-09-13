package org.springframework.samples.petclinic.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.mockito.BDDMockito.*;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
@SpringJUnitWebConfig(locations = {"classpath:spring/mvc-test-config.xml","classpath:mvc-core-config.xml"})
class OwnerControllerTest {

	@Autowired
	OwnerController ownerController;
	
	@Autowired
	ClinicService clinicService;
	
	MockMvc mockMvc;
	
	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;
	
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
	}
	
	@AfterEach
	void tearDown() {
		reset(clinicService);
	}
	
	@Test
	void testReturnListOfOwners() throws Exception {
		given(clinicService.findOwnerByLastName("")).willReturn(Lists.newArrayList(new Owner(), new Owner()));
		
		mockMvc.perform(get("/owners"))
			.andExpect(status().isOk())
			.andExpect(view().name("owners/ownersList"));
		
		then(clinicService).should().findOwnerByLastName(stringArgumentCaptor.capture());
		
		assertThat(stringArgumentCaptor.getValue()).isEqualToIgnoringCase("");
	}
	
	@Test
	void testFindOwnerOneResult() throws Exception {
		
		Owner justOne = new Owner();
		justOne.setId(1);
		final String findJustOne = "FindJustOne";
		
		given(clinicService.findOwnerByLastName(findJustOne)).willReturn(Lists.newArrayList(justOne));
		
		mockMvc.perform(get("/owners")
				.param("lastName","FindJustOne"))
			.andExpect(status().isOk())
			.andExpect(view().name("redirect/owners/1"));
		
		then(clinicService).should().findOwnerByLastName(anyString());
		
	}
	
	@Test
	void testFindByNameNotFound() throws Exception {
		mockMvc.perform(get("owners")
			.param("lastName","Dont Find ME"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/findOwners"));
	}
	
	@Test
	void initCreationFormTest() throws Exception {
		mockMvc.perform(get("/owners/new"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("owner"))
			.andExpect(view().name("owners/createOrUpdateOwnerForm"));
	}

}
