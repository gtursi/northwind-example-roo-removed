package org.northwind.web;
import javax.validation.Valid;

import org.northwind.domain.Customer;
import org.northwind.service.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import io.springlets.web.NotFoundException;

/**
 * = CustomersItemJsonController
 TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/api/customers/{customer}", name = "CustomersItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomersItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerService customerService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerService
     */
    @Autowired
    public CustomersItemJsonController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerService
     */
    public CustomerService getCustomerService() {
        return customerService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerService
     */
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ModelAttribute
    public Customer getCustomer(@PathVariable("customer") Long id) {
        Customer customer = customerService.findOne(id);
        if (customer == null) {
            throw new NotFoundException(String.format("Customer with identifier '%s' not found", id));
        }
        return customer;
    }

    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Customer customer) {
        return ResponseEntity.ok(customer);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @return UriComponents
     */
    public static UriComponents showURI(Customer customer) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(CustomersItemJsonController.class).show(customer)).buildAndExpand(customer.getId()).encode();
    }

    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Customer storedCustomer, @Valid @RequestBody Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        customer.setId(storedCustomer.getId());
        getCustomerService().save(customer);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Customer customer) {
        getCustomerService().delete(customer);
        return ResponseEntity.ok().build();
    }
}
