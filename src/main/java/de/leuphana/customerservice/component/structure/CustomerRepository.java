package de.leuphana.customerservice.component.structure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, UUID> {


    public Optional<Customer> findFirstByUserName(String userName);
}