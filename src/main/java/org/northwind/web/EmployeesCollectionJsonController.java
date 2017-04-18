package org.northwind.web;
import java.util.Collection;

import javax.validation.Valid;

import org.northwind.domain.Employee;
import org.northwind.service.api.EmployeeService;
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
 * = EmployeesCollectionJsonController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Employee.class, pathPrefix = "/api", type = ControllerType.COLLECTION)
@RooJSON
@RestController
@RequestMapping(value = "/api/employees", name = "EmployeesCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeesCollectionJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private EmployeeService employeeService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param employeeService
     */
    @Autowired
    public EmployeesCollectionJsonController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return EmployeeService
     */
    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employeeService
     */
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<Employee>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<Employee> employees = getEmployeeService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(employees);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(EmployeesCollectionJsonController.class).list(null, null)).build().encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody Employee employee, BindingResult result) {
        if (employee.getId() != null || employee.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        Employee newEmployee = getEmployeeService().save(employee);
        UriComponents showURI = EmployeesItemJsonController.showURI(newEmployee);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employees
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<Employee> employees, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getEmployeeService().save(employees);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param employees
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<Employee> employees, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getEmployeeService().save(employees);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return ResponseEntity
     */
    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        getEmployeeService().delete(ids);
        return ResponseEntity.ok().build();
    }
}
