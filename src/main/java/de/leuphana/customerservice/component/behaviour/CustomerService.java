package de.leuphana.customerservice.component.behaviour;

import de.leuphana.customerservice.component.structure.Address;
import de.leuphana.customerservice.component.structure.AddressRepository;
import de.leuphana.customerservice.component.structure.Customer;
import de.leuphana.customerservice.component.structure.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.Optional;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"de.leuphana"})
@EntityScan( basePackages = {"de.leuphana"})
@EnableJpaRepositories(basePackages = "de.leuphana.customerservice.component.structure")
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    /**
     *  Initial creation of Database entries
     */
    @PostConstruct
    public void initDb() {
        Customer customer1 = new Customer();
        Address address1 = new Address();
        address1.setCity("Hamburg");
        address1.setStreet("Testweg 1");
        address1.setZip(22234);

        customer1.setPassword("1234");
        customer1.setUserName("customer1");

        Customer customer2 = new Customer();
        Address address2 = new Address();
        address2.setCity("Hamburg");
        address2.setStreet("Testweg 2");
        address2.setZip(22234);

        customer2.setPassword("1234");
        customer2.setUserName("customer2");

        address1 = addressRepository.save(address1);
        address2 = addressRepository.save(address2);

        customer1 = customerRepository.save(customer1);
        customer2 = customerRepository.save(customer2);

        customer1.setAddress(address1);
        customer2.setAddress(address2);

        addressRepository.save(address1);
        addressRepository.save(address2);
        customerRepository.save(customer1);
        customerRepository.save(customer2);

    }

    public Customer getCustomerByUsername(String userName) {
        Optional<Customer> opt = customerRepository.findFirstByUserName(userName);

        if (!opt.isPresent()) {
            throw new IllegalStateException();
        }

        return opt.get();
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerService.class);
    }
}
