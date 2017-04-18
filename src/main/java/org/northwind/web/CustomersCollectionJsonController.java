package org.northwind.web;
import java.util.Collection;

import javax.validation.Valid;

import org.northwind.domain.Customer;
import org.northwind.service.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import io.springlets.data.domain.GlobalSearch;

/**
 * = CustomersCollectionJsonController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Customer.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
@RestController
@RequestMapping(value = "/api/customers", name = "CustomersCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomersCollectionJsonController {

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
    public CustomersCollectionJsonController(CustomerService customerService) {
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

    @GetMapping(name = "list")
    public ResponseEntity<Page<Customer>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<Customer> customers = getCustomerService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(customers);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(CustomersCollectionJsonController.class).list(null, null)).build().encode();
    }

    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody Customer customer, BindingResult result) {
        if (customer.getId() != null || customer.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        Customer newCustomer = getCustomerService().save(customer);
        UriComponents showURI = CustomersItemJsonController.showURI(newCustomer);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<Customer> customers, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getCustomerService().save(customers);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<Customer> customers, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getCustomerService().save(customers);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        getCustomerService().delete(ids);
        return ResponseEntity.ok().build();
    }
}