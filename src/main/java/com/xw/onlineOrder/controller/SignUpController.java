package com.xw.onlineOrder.controller;

import com.xw.onlineOrder.entity.Customer;
import com.xw.onlineOrder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SignUpController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void signUp(@RequestBody Customer customer) {

        customerService.signUp(customer);
    }

//    public void signUp(@RequestBody Customer customer, HttpServletResponse response) {
//        System.out.println(customer.getEmail());
//
//        // business logic
//        try {
//
//        } catch (Exception e) {
//            response.setStatus(500);
//            // response.getWriter().
//        }
//    }
}
