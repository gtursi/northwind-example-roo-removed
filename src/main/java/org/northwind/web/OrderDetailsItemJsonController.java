package org.northwind.web;
import javax.validation.Valid;

import org.northwind.domain.OrderDetail;
import org.northwind.service.api.OrderDetailService;
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
 * = OrderDetailsItemJsonController
 TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/api/orderdetails/{orderDetail}", name = "OrderDetailsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderDetailsItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OrderDetailService orderDetailService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param orderDetailService
     */
    @Autowired
    public OrderDetailsItemJsonController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return OrderDetailService
     */
    public OrderDetailService getOrderDetailService() {
        return orderDetailService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetailService
     */
    public void setOrderDetailService(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return OrderDetail
     */
    @ModelAttribute
    public OrderDetail getOrderDetail(@PathVariable("orderDetail") Long id) {
        OrderDetail orderDetail = orderDetailService.findOne(id);
        if (orderDetail == null) {
            throw new NotFoundException(String.format("OrderDetail with identifier '%s' not found", id));
        }
        return orderDetail;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetail
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute OrderDetail orderDetail) {
        return ResponseEntity.ok(orderDetail);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetail
     * @return UriComponents
     */
    public static UriComponents showURI(OrderDetail orderDetail) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(OrderDetailsItemJsonController.class).show(orderDetail)).buildAndExpand(orderDetail.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedOrderDetail
     * @param orderDetail
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute OrderDetail storedOrderDetail, @Valid @RequestBody OrderDetail orderDetail, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        orderDetail.setId(storedOrderDetail.getId());
        getOrderDetailService().save(orderDetail);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetail
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute OrderDetail orderDetail) {
        getOrderDetailService().delete(orderDetail);
        return ResponseEntity.ok().build();
    }
}
