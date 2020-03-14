package de.leuphana.customerservice.component.behaviour;

import de.leuphana.customerservice.component.structure.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CustomerService.class})
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;


    @Test
    public void getCustomerByUsername() {
        Customer customer = customerService.getCustomerByUsername("customer1");
        assertNotNull(customer);

    }


}