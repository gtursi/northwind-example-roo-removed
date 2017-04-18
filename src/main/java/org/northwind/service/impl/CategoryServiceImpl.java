package org.northwind.service.impl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.northwind.domain.Category;
import org.northwind.domain.Product;
import org.northwind.repository.CategoryRepository;
import org.northwind.service.api.CategoryService;
import org.northwind.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.domain.GlobalSearch;

/**
 * = CategoryServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = CategoryService.class)
@Service
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CategoryRepository categoryRepository;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ProductService productService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param categoryRepository
     * @param productService
     */
    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, @Lazy ProductService productService) {
        setCategoryRepository(categoryRepository);
        setProductService(productService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CategoryRepository
     */
    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param categoryRepository
     */
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param productsToAdd
     * @return Category
     */
    @Transactional
    public Category addToProducts(Category category, Iterable<Long> productsToAdd) {
        List<Product> products = getProductService().findAll(productsToAdd);
        category.addToProducts(products);
        return getCategoryRepository().save(category);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param productsToRemove
     * @return Category
     */
    @Transactional
    public Category removeFromProducts(Category category, Iterable<Long> productsToRemove) {
        List<Product> products = getProductService().findAll(productsToRemove);
        category.removeFromProducts(products);
        return getCategoryRepository().save(category);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     * @param products
     * @return Category
     */
    @Transactional
    public Category setProducts(Category category, Iterable<Long> products) {
        List<Product> items = getProductService().findAll(products);
        Set<Product> currents = category.getProducts();
        Set<Product> toRemove = new HashSet<Product>();
        for (Iterator<Product> iterator = currents.iterator(); iterator.hasNext(); ) {
            Product nextProduct = iterator.next();
            if (items.contains(nextProduct)) {
                items.remove(nextProduct);
            } else {
                toRemove.add(nextProduct);
            }
        }
        category.removeFromProducts(toRemove);
        category.addToProducts(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        category.setVersion(category.getVersion() + 1);
        return getCategoryRepository().save(category);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param category
     */
    @Transactional
    public void delete(Category category) {
        // Clear bidirectional one-to-many parent relationship with Product
        for (Product item : category.getProducts()) {
            item.setCategory(null);
        }
        getCategoryRepository().delete(category);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Category> save(Iterable<Category> entities) {
        return getCategoryRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Category> toDelete = getCategoryRepository().findAll(ids);
        getCategoryRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Category
     */
    @Transactional
    public Category save(Category entity) {
        return getCategoryRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Category
     */
    public Category findOne(Long id) {
        return getCategoryRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Category
     */
    public Category findOneForUpdate(Long id) {
        return getCategoryRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Category> findAll(Iterable<Long> ids) {
        return getCategoryRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Category> findAll() {
        return getCategoryRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getCategoryRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Category> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getCategoryRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Category> getEntityType() {
        return Category.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
