package org.northwind.web;
import javax.validation.Valid;

import org.northwind.domain.Supplier;
import org.northwind.service.api.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
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
 * = SuppliersItemJsonController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Supplier.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/api/suppliers/{supplier}", name = "SuppliersItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class SuppliersItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private SupplierService supplierService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param supplierService
     */
    @Autowired
    public SuppliersItemJsonController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return SupplierService
     */
    public SupplierService getSupplierService() {
        return supplierService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplierService
     */
    public void setSupplierService(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @ModelAttribute
    public Supplier getSupplier(@PathVariable("supplier") Long id) {
        Supplier supplier = supplierService.findOne(id);
        if (supplier == null) {
            throw new NotFoundException(String.format("Supplier with identifier '%s' not found", id));
        }
        return supplier;
    }

    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Supplier supplier) {
        return ResponseEntity.ok(supplier);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param supplier
     * @return UriComponents
     */
    public static UriComponents showURI(Supplier supplier) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(SuppliersItemJsonController.class).show(supplier)).buildAndExpand(supplier.getId()).encode();
    }

    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Supplier storedSupplier, @Valid @RequestBody Supplier supplier, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        supplier.setId(storedSupplier.getId());
        getSupplierService().save(supplier);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Supplier supplier) {
        getSupplierService().delete(supplier);
        return ResponseEntity.ok().build();
    }
}
