package com.appdirect.web;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.appdirect.dto.ApiResponse;
import com.appdirect.web.controller.ApiIntegrationController;


/**
 * @author saurav Test cas for ApiIntegrationController
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiIntegrationControllerTest {

	@Autowired
	ApiIntegrationController apiIntegrationController;
	
	
	/**
	 * Test case for validating null case in end point
	 */
	@Test
	public void testNullCase() {
		ApiResponse apiresponse = apiIntegrationController.handleEvent(null, null, null, null);
		Assert.assertEquals(false, apiresponse.getSuccess());
	}

}
