package org.northwind.web;
import java.util.Collection;

import javax.validation.Valid;

import org.northwind.domain.Product;
import org.northwind.service.api.ProductService;
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
 * = ProductsCollectionJsonController
 TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/api/products", name = "ProductsCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductsCollectionJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ProductService productService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param productService
     */
    @Autowired
    public ProductsCollectionJsonController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ProductService
     */
    public ProductService getProductService() {
        return productService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param productService
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(name = "list")
    public ResponseEntity<Page<Product>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<Product> products = getProductService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(products);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(ProductsCollectionJsonController.class).list(null, null)).build().encode();
    }

    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody Product product, BindingResult result) {
        if (product.getId() != null || product.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        Product newProduct = getProductService().save(product);
        UriComponents showURI = ProductsItemJsonController.showURI(newProduct);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<Product> products, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getProductService().save(products);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<Product> products, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getProductService().save(products);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        getProductService().delete(ids);
        return ResponseEntity.ok().build();
    }
}
