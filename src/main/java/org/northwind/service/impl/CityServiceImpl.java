package org.northwind.service.impl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.northwind.domain.City;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Party;
import org.northwind.domain.Region;
import org.northwind.domain.Store;
import org.northwind.domain.Supplier;
import org.northwind.repository.CityRepository;
import org.northwind.service.api.CityService;
import org.northwind.service.api.CustomerOrderService;
import org.northwind.service.api.PartyService;
import org.northwind.service.api.StoreService;
import org.northwind.service.api.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.domain.GlobalSearch;

/**
 * = CityServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = CityService.class)
@Service
@Transactional(readOnly = true)
public class CityServiceImpl implements CityService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerOrderService customerOrderService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private StoreService storeService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CityRepository cityRepository;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PartyService partyService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private SupplierService supplierService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param cityRepository
     * @param customerOrderService
     * @param partyService
     * @param storeService
     * @param supplierService
     */
    @Autowired
    public CityServiceImpl(CityRepository cityRepository, @Lazy CustomerOrderService customerOrderService, @Lazy PartyService partyService, @Lazy StoreService storeService, @Lazy SupplierService supplierService) {
        setCityRepository(cityRepository);
        setCustomerOrderService(customerOrderService);
        setPartyService(partyService);
        setStoreService(storeService);
        setSupplierService(supplierService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CityRepository
     */
    public CityRepository getCityRepository() {
        return cityRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param cityRepository
     */
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerOrderService
     */
    public CustomerOrderService getCustomerOrderService() {
        return customerOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrderService
     */
    public void setCustomerOrderService(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PartyService
     */
    public PartyService getPartyService() {
        return partyService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param partyService
     */
    public void setPartyService(PartyService partyService) {
        this.partyService = partyService;
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

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param customerOrdersToAdd
     * @return City
     */
    @Transactional
    public City addToCustomerOrders(City city, Iterable<Long> customerOrdersToAdd) {
        List<CustomerOrder> customerOrders = getCustomerOrderService().findAll(customerOrdersToAdd);
        city.addToCustomerOrders(customerOrders);
        return getCityRepository().save(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param partiesToAdd
     * @return City
     */
    @Transactional
    public City addToParties(City city, Iterable<Long> partiesToAdd) {
        List<Party> parties = getPartyService().findAll(partiesToAdd);
        city.addToParties(parties);
        return getCityRepository().save(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param storesToAdd
     * @return City
     */
    @Transactional
    public City addToStores(City city, Iterable<Long> storesToAdd) {
        List<Store> stores = getStoreService().findAll(storesToAdd);
        city.addToStores(stores);
        return getCityRepository().save(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param suppliersToAdd
     * @return City
     */
    @Transactional
    public City addToSuppliers(City city, Iterable<Long> suppliersToAdd) {
        List<Supplier> suppliers = getSupplierService().findAll(suppliersToAdd);
        city.addToSuppliers(suppliers);
        return getCityRepository().save(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param customerOrdersToRemove
     * @return City
     */
    @Transactional
    public City removeFromCustomerOrders(City city, Iterable<Long> customerOrdersToRemove) {
        List<CustomerOrder> customerOrders = getCustomerOrderService().findAll(customerOrdersToRemove);
        city.removeFromCustomerOrders(customerOrders);
        return getCityRepository().save(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param partiesToRemove
     * @return City
     */
    @Transactional
    public City removeFromParties(City city, Iterable<Long> partiesToRemove) {
        List<Party> parties = getPartyService().findAll(partiesToRemove);
        city.removeFromParties(parties);
        return getCityRepository().save(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param storesToRemove
     * @return City
     */
    @Transactional
    public City removeFromStores(City city, Iterable<Long> storesToRemove) {
        List<Store> stores = getStoreService().findAll(storesToRemove);
        city.removeFromStores(stores);
        return getCityRepository().save(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param suppliersToRemove
     * @return City
     */
    @Transactional
    public City removeFromSuppliers(City city, Iterable<Long> suppliersToRemove) {
        List<Supplier> suppliers = getSupplierService().findAll(suppliersToRemove);
        city.removeFromSuppliers(suppliers);
        return getCityRepository().save(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param customerOrders
     * @return City
     */
    @Transactional
    public City setCustomerOrders(City city, Iterable<Long> customerOrders) {
        List<CustomerOrder> items = getCustomerOrderService().findAll(customerOrders);
        Set<CustomerOrder> currents = city.getCustomerOrders();
        Set<CustomerOrder> toRemove = new HashSet<CustomerOrder>();
        for (Iterator<CustomerOrder> iterator = currents.iterator(); iterator.hasNext(); ) {
            CustomerOrder nextCustomerOrder = iterator.next();
            if (items.contains(nextCustomerOrder)) {
                items.remove(nextCustomerOrder);
            } else {
                toRemove.add(nextCustomerOrder);
            }
        }
        city.removeFromCustomerOrders(toRemove);
        city.addToCustomerOrders(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        city.setVersion(city.getVersion() + 1);
        return getCityRepository().save(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param parties
     * @return City
     */
    @Transactional
    public City setParties(City city, Iterable<Long> parties) {
        List<Party> items = getPartyService().findAll(parties);
        Set<Party> currents = city.getParties();
        Set<Party> toRemove = new HashSet<Party>();
        for (Iterator<Party> iterator = currents.iterator(); iterator.hasNext(); ) {
            Party nextParty = iterator.next();
            if (items.contains(nextParty)) {
                items.remove(nextParty);
            } else {
                toRemove.add(nextParty);
            }
        }
        city.removeFromParties(toRemove);
        city.addToParties(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        city.setVersion(city.getVersion() + 1);
        return getCityRepository().save(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param stores
     * @return City
     */
    @Transactional
    public City setStores(City city, Iterable<Long> stores) {
        List<Store> items = getStoreService().findAll(stores);
        Set<Store> currents = city.getStores();
        Set<Store> toRemove = new HashSet<Store>();
        for (Iterator<Store> iterator = currents.iterator(); iterator.hasNext(); ) {
            Store nextStore = iterator.next();
            if (items.contains(nextStore)) {
                items.remove(nextStore);
            } else {
                toRemove.add(nextStore);
            }
        }
        city.removeFromStores(toRemove);
        city.addToStores(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        city.setVersion(city.getVersion() + 1);
        return getCityRepository().save(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param suppliers
     * @return City
     */
    @Transactional
    public City setSuppliers(City city, Iterable<Long> suppliers) {
        List<Supplier> items = getSupplierService().findAll(suppliers);
        Set<Supplier> currents = city.getSuppliers();
        Set<Supplier> toRemove = new HashSet<Supplier>();
        for (Iterator<Supplier> iterator = currents.iterator(); iterator.hasNext(); ) {
            Supplier nextSupplier = iterator.next();
            if (items.contains(nextSupplier)) {
                items.remove(nextSupplier);
            } else {
                toRemove.add(nextSupplier);
            }
        }
        city.removeFromSuppliers(toRemove);
        city.addToSuppliers(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        city.setVersion(city.getVersion() + 1);
        return getCityRepository().save(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     */
    @Transactional
    public void delete(City city) {
        // Clear bidirectional many-to-one child relationship with Region
        if (city.getRegion() != null) {
            city.getRegion().getCities().remove(city);
        }
        // Clear bidirectional one-to-many parent relationship with CustomerOrder
        for (CustomerOrder item : city.getCustomerOrders()) {
            item.setCity(null);
        }
        // Clear bidirectional one-to-many parent relationship with Party
        for (Party item : city.getParties()) {
            item.setCity(null);
        }
        // Clear bidirectional one-to-many parent relationship with Store
        for (Store item : city.getStores()) {
            item.setCity(null);
        }
        // Clear bidirectional one-to-many parent relationship with Supplier
        for (Supplier item : city.getSuppliers()) {
            item.setCity(null);
        }
        getCityRepository().delete(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<City> save(Iterable<City> entities) {
        return getCityRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<City> toDelete = getCityRepository().findAll(ids);
        getCityRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return City
     */
    @Transactional
    public City save(City entity) {
        return getCityRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return City
     */
    public City findOne(Long id) {
        return getCityRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return City
     */
    public City findOneForUpdate(Long id) {
        return getCityRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<City> findAll(Iterable<Long> ids) {
        return getCityRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<City> findAll() {
        return getCityRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getCityRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<City> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getCityRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<City> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
        return getCityRepository().findByRegion(region, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return Long
     */
    public long countByRegion(Region region) {
        return getCityRepository().countByRegion(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param pageable
     * @return Page
     */
    public Page<City> findByRegionIdOrderByDescriptionAsc(Long id, Pageable pageable) {
        return getCityRepository().findByRegionIdOrderByDescriptionAsc(id, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Long
     */
    public long countByRegionIdOrderByDescriptionAsc(Long id) {
        return getCityRepository().countByRegionIdOrderByDescriptionAsc(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<City> getEntityType() {
        return City.class;
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
