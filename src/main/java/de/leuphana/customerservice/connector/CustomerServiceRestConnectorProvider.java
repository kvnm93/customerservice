package de.leuphana.customerservice.connector;


import de.leuphana.customerservice.component.behaviour.CustomerService;
import de.leuphana.customerservice.component.structure.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CustomerServiceRestConnectorProvider {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/")
    public Customer getCustomerByUsername(@RequestParam("username") String username) {
        return customerService.getCustomerByUsername(username);
    }

    @GetMapping("/customer/")
    public Customer getCustomerByCustomerId(@RequestParam("customerId") UUID customerId) {
        return customerService.getCustomerByCustomerId(customerId);
    }
}
