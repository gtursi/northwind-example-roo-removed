package org.northwind.web;
import java.io.IOException;

import org.northwind.domain.Employee;
import org.northwind.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import io.springlets.web.NotFoundException;

/**
 * = EmployeeDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Employee.class)
@JsonComponent
public class EmployeeDeserializer extends JsonObjectDeserializer<Employee> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private EmployeeService employeeService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param employeeService
     * @param conversionService
     */
    @Autowired
    public EmployeeDeserializer(@Lazy EmployeeService employeeService, ConversionService conversionService) {
        this.employeeService = employeeService;
        this.conversionService = conversionService;
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
     * @return ConversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param conversionService
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return Employee
     * @throws IOException
     */
    public Employee deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Employee employee = employeeService.findOne(id);
        if (employee == null) {
            throw new NotFoundException("Employee not found");
        }
        return employee;
    }
}
