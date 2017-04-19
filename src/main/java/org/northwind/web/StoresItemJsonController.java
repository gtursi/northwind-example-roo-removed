package org.northwind.web;
import javax.validation.Valid;

import org.northwind.domain.Store;
import org.northwind.service.api.StoreService;
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
 * = StoresItemJsonController
 TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/api/stores/{store}", name = "StoresItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoresItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private StoreService storeService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param storeService
     */
    @Autowired
    public StoresItemJsonController(StoreService storeService) {
        this.storeService = storeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return StoreService
     */
    public StoreService getStoreService() {
        return storeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storeService
     */
    public void setStoreService(StoreService storeService) {
        this.storeService = storeService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Store
     */
    @ModelAttribute
    public Store getStore(@PathVariable("store") Long id) {
        Store store = storeService.findOne(id);
        if (store == null) {
            throw new NotFoundException(String.format("Store with identifier '%s' not found", id));
        }
        return store;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param store
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Store store) {
        return ResponseEntity.ok(store);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param store
     * @return UriComponents
     */
    public static UriComponents showURI(Store store) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(StoresItemJsonController.class).show(store)).buildAndExpand(store.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedStore
     * @param store
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Store storedStore, @Valid @RequestBody Store store, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        store.setId(storedStore.getId());
        getStoreService().save(store);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param store
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Store store) {
        getStoreService().delete(store);
        return ResponseEntity.ok().build();
    }
}
