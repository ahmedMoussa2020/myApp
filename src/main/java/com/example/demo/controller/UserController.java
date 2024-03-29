package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//it tells the spring this class is a Controller and will process user requests.
@RestController 

//This annotation maps requests to handlers in this case it will served /user parameter
@RequestMapping("/user") 					
public class UserController {

//This variable will be used from the UserController methods to print out the Controllers's information in the console
	final Logger logger = LoggerFactory.getLogger(this.getClass());

// This annotation tells Spring that the testController method will handle
// requests. ln this case, requests with the /user/test parameter will be served
// by the UserController's testController() method.
@GetMapping("/test")
public String testController() {

		logger.debug("The testController() method was invoked!");
		return "The FeedApp application is up and running";
	}

}
