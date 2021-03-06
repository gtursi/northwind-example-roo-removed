package org.northwind.web;
import java.util.Collection;

import javax.validation.Valid;

import org.northwind.domain.Store;
import org.northwind.service.api.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
 * = StoresCollectionJsonController
 TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/api/stores", name = "StoresCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoresCollectionJsonController {

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
    public StoresCollectionJsonController(StoreService storeService) {
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

    @GetMapping(name = "list")
    public ResponseEntity<Page<Store>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<Store> stores = getStoreService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(stores);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(StoresCollectionJsonController.class).list(null, null)).build().encode();
    }

    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody Store store, BindingResult result) {
        if (store.getId() != null || store.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        Store newStore = getStoreService().save(store);
        UriComponents showURI = StoresItemJsonController.showURI(newStore);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<Store> stores, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getStoreService().save(stores);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<Store> stores, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getStoreService().save(stores);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        getStoreService().delete(ids);
        return ResponseEntity.ok().build();
    }
}
