package org.northwind.web;
import java.util.Collection;

import javax.validation.Valid;

import org.northwind.domain.PurchaseOrder;
import org.northwind.service.api.PurchaseOrderService;
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
 * = PurchaseOrdersCollectionJsonController
 TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/api/purchaseorders", name = "PurchaseOrdersCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class PurchaseOrdersCollectionJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PurchaseOrderService purchaseOrderService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param purchaseOrderService
     */
    @Autowired
    public PurchaseOrdersCollectionJsonController(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PurchaseOrderService
     */
    public PurchaseOrderService getPurchaseOrderService() {
        return purchaseOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param purchaseOrderService
     */
    public void setPurchaseOrderService(PurchaseOrderService purchaseOrderService) {
        this.purchaseOrderService = purchaseOrderService;
    }

    @GetMapping(name = "list")
    public ResponseEntity<Page<PurchaseOrder>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<PurchaseOrder> purchaseOrders = getPurchaseOrderService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(purchaseOrders);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(PurchaseOrdersCollectionJsonController.class).list(null, null)).build().encode();
    }

    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody PurchaseOrder purchaseOrder, BindingResult result) {
        if (purchaseOrder.getId() != null || purchaseOrder.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        PurchaseOrder newPurchaseOrder = getPurchaseOrderService().save(purchaseOrder);
        UriComponents showURI = PurchaseOrdersItemJsonController.showURI(newPurchaseOrder);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<PurchaseOrder> purchaseOrders, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getPurchaseOrderService().save(purchaseOrders);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<PurchaseOrder> purchaseOrders, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getPurchaseOrderService().save(purchaseOrders);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        getPurchaseOrderService().delete(ids);
        return ResponseEntity.ok().build();
    }
}
