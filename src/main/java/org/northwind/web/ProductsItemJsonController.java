package org.northwind.web;
import javax.validation.Valid;

import org.northwind.domain.Product;
import org.northwind.service.api.ProductService;
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
 * = ProductsItemJsonController
 TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/api/products/{product}", name = "ProductsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductsItemJsonController {

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
    public ProductsItemJsonController(ProductService productService) {
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

    @ModelAttribute
    public Product getProduct(@PathVariable("product") Long id) {
        Product product = productService.findOne(id);
        if (product == null) {
            throw new NotFoundException(String.format("Product with identifier '%s' not found", id));
        }
        return product;
    }

    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Product product) {
        return ResponseEntity.ok(product);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param product
     * @return UriComponents
     */
    public static UriComponents showURI(Product product) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(ProductsItemJsonController.class).show(product)).buildAndExpand(product.getId()).encode();
    }

    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Product storedProduct, @Valid @RequestBody Product product, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        product.setId(storedProduct.getId());
        getProductService().save(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Product product) {
        getProductService().delete(product);
        return ResponseEntity.ok().build();
    }
}
