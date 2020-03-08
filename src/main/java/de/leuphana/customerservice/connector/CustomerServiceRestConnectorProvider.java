package de.leuphana.customerservice.connector;


import de.leuphana.customerservice.component.behaviour.CustomerService;
import de.leuphana.customerservice.component.structure.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerServiceRestConnectorProvider {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/")
    public Customer getCustomerByUsername(@RequestParam("username") String username) {
        return customerService.getCustomerByUsername(username);
    }
}
