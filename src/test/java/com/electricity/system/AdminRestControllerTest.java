package com.electricity.system;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;

import java.util.Date;


import com.electricity.system.controller.AdminRestController;
import com.electricity.system.entity.Bill;
import com.electricity.system.entity.Consumption;
import com.electricity.system.entity.Customer;
import com.electricity.system.entity.Rate;
import com.electricity.system.repo.RateRepo;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class AdminRestControllerTest extends AbtractTest{
	 
	
	
    @Autowired
	private MockMvc mvc;
	
	 @InjectMocks
	    AdminRestController controllerUnderTest;
	 
	 @Before
	    public void setup() {

	        // this must be called for the @Mock annotations above to be processed
	        // and for the mock service to be injected into the controller under
	        // test.
	        MockitoAnnotations.initMocks(this);

	        this.mvc = MockMvcBuilders.standaloneSetup(controllerUnderTest).build();

	    }
	
	/*@Test
	   public void getCustomersList() throws Exception {
	      String uri = "/viewcustomers";
	     // String keyword;
//	      
//	        Customer customer =new Customer();
//	        List<Customer> list=new ArrayList<>();
//	        list.add(customer);
		      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		    	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		    	      
		    	      int status = mvcResult.getResponse().getStatus();
		    	      assertEquals(200, status);
		    	      String content = mvcResult.getResponse().getContentAsString();
		    	      Customer[] customer = super.mapFromJson(content, Customer[].class);
		    	      assertTrue(customer.length > 0);
	      
	     
	     
	   }*/
	
	@Test
	   public void createBill() throws Exception {
	      String uri = "/addbill";
	     // Product product = new Product();
	      
	      Bill bill=new Bill();
	      int m=bill.getMeter();
	      if(m!=0) {
	    	  bill.setEnergy(15);
	    	  String d="2022-06-23";
	    	  Date date=new SimpleDateFormat("yyyy-mm-dd").parse(d); 
	    	  bill.setDate((java.sql.Date) date);
	    	   String inputJson = super.mapToJson(bill);
	 	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	 	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	 	         .content(inputJson)).andReturn();
	 	      
	 	      int status = mvcResult.getResponse().getStatus();
	 	      assertEquals(201, status);
	 	      String content = mvcResult.getResponse().getContentAsString();
	 	      assertEquals(content, "Product is created successfully");
	      }
	     // product.setId("3");	      product.setName("Ginger");
	   
	   }
	@Test
	   public void getEnergyList() throws Exception {
	      String uri = "/viewenergy";
	     // String keyword;
//	      
//	        Customer customer =new Customer();
//	        List<Customer> list=new ArrayList<>();
//	        list.add(customer);
		      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		    	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		    	      
		    	      int status = mvcResult.getResponse().getStatus();
		    	      assertEquals(200, status);
		    	      String content = mvcResult.getResponse().getContentAsString();
		    	      Consumption[] energy = super.mapFromJson(content, Consumption[].class);
		    	      assertTrue(energy.length > 0);
	      
	     
	     
	   }
	
	@Test
	   public void getBillsList() throws Exception {
	      String uri = "/viewbills";
	     // String keyword;
//	      
//	        Customer customer =new Customer();
//	        List<Customer> list=new ArrayList<>();
//	        list.add(customer);
		      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		    	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		    	      
		    	      int status = mvcResult.getResponse().getStatus();
		    	      assertEquals(200, status);
		    	      String content = mvcResult.getResponse().getContentAsString();
		    	      Bill[] bill = super.mapFromJson(content, Bill[].class);
		    	      assertTrue(bill.length > 0);
	      
	     
	     
	   }
	
	@Test
	   public void getCustomersList() throws Exception {
	      String uri = "/viewcustomers";
	     // String keyword;
//	      
//	        Customer customer =new Customer();
//	        List<Customer> list=new ArrayList<>();
//	        list.add(customer);
		      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		    	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		    	      
		    	      int status = mvcResult.getResponse().getStatus();
		    	      assertEquals(200, status);
		    	      String content = mvcResult.getResponse().getContentAsString();
		    	      Customer[] customer = super.mapFromJson(content, Customer[].class);
		    	      assertTrue(customer.length > 0);
	      
	     
	     
	   }
	
	@Test
	public void addRate() throws Exception {
	   String uri = "/addrates";
	  // Product product = new Product();
	   
	   Rate rate=new Rate();
	   //rate.setRid(185);
	   rate.setBoard("Goa");
	   rate.setConntype("domestic");
	   rate.setMetertype("2kw");
	   rate.setPrice(10.11);
   
	   String inputJson = super.mapToJson(rate);
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
	   
	   int status = mvcResult.getResponse().getStatus();
	   assertEquals(201, status);
	   String content = mvcResult.getResponse().getContentAsString();
	 
	   assertEquals(content,"Rates added successsfully");
	}
	
	   @Test
	   public void deleterate()throws Exception {
	      String uri = "/deleterate/197";
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Rates deleted successsfully");
	   }

}
