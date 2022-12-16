package com.electricity.system;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.electricity.system.controller.CustomerRestController;

import com.electricity.system.entity.Customer;



@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class CustomerRestControllerTest extends AbtractTest{

	@Autowired
	private MockMvc mvc;
	
	
	@InjectMocks
	private CustomerRestController controllerUnderTest;
	
	@Before
    public void setup() {

        // this must be called for the @Mock annotations above to be processed
        // and for the mock service to be injected into the controller under
        // test.
        MockitoAnnotations.initMocks(this);

        this.mvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();
        
	}
        
       
 	     
 	     
 	   

	@Test
	public void addCustomer() throws Exception {
	   String uri = "/customers";
	  // Product product = new Product();
	   
	   //Rate rate=new Rate();
	   Customer customer=new Customer();
	   customer.setName("mysha");
	   customer.setMeter(5236);
	   customer.setBoard("Bihar");
	   customer.setMetertype("2kw");
	   customer.setEmail("mysha@mail.com");
	   customer.setContact("1234567890");
	   customer.setConntype("domestic");
	   customer.setRole("ROLE_USER");
	   //rate.setRid(185);
	  
   
	   String inputJson = super.mapToJson(customer);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(201, status);
	   String content = mvcResult.getResponse().getContentAsString();
	
	   assertEquals(content,"Customer created successsfully");
	}
	
}
