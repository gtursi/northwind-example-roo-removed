package org.northwind.service.impl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.northwind.domain.City;
import org.northwind.domain.Country;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Party;
import org.northwind.domain.Region;
import org.northwind.domain.Store;
import org.northwind.domain.Supplier;
import org.northwind.repository.RegionRepository;
import org.northwind.service.api.CityService;
import org.northwind.service.api.CustomerOrderService;
import org.northwind.service.api.PartyService;
import org.northwind.service.api.RegionService;
import org.northwind.service.api.StoreService;
import org.northwind.service.api.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.domain.GlobalSearch;

/**
 * = RegionServiceImpl
 TODO Auto-generated class documentation
 *
 */
@Service
@Transactional(readOnly = true)
public class RegionServiceImpl implements RegionService {

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
    private CityService cityService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private RegionRepository regionRepository;

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
     * @param regionRepository
     * @param cityService
     * @param customerOrderService
     * @param partyService
     * @param storeService
     * @param supplierService
     */
    @Autowired
    public RegionServiceImpl(RegionRepository regionRepository, @Lazy CityService cityService, @Lazy CustomerOrderService customerOrderService, @Lazy PartyService partyService, @Lazy StoreService storeService, @Lazy SupplierService supplierService) {
        setRegionRepository(regionRepository);
        setCityService(cityService);
        setCustomerOrderService(customerOrderService);
        setPartyService(partyService);
        setStoreService(storeService);
        setSupplierService(supplierService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return RegionRepository
     */
    public RegionRepository getRegionRepository() {
        return regionRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param regionRepository
     */
    public void setRegionRepository(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CityService
     */
    public CityService getCityService() {
        return cityService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param cityService
     */
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
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
     * @param region
     * @param citiesToAdd
     * @return Region
     */
    @Transactional
    public Region addToCities(Region region, Iterable<Long> citiesToAdd) {
        List<City> cities = getCityService().findAll(citiesToAdd);
        region.addToCities(cities);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param customerOrdersToAdd
     * @return Region
     */
    @Transactional
    public Region addToCustomerOrders(Region region, Iterable<Long> customerOrdersToAdd) {
        List<CustomerOrder> customerOrders = getCustomerOrderService().findAll(customerOrdersToAdd);
        region.addToCustomerOrders(customerOrders);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param partiesToAdd
     * @return Region
     */
    @Transactional
    public Region addToParties(Region region, Iterable<Long> partiesToAdd) {
        List<Party> parties = getPartyService().findAll(partiesToAdd);
        region.addToParties(parties);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param storesToAdd
     * @return Region
     */
    @Transactional
    public Region addToStores(Region region, Iterable<Long> storesToAdd) {
        List<Store> stores = getStoreService().findAll(storesToAdd);
        region.addToStores(stores);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param suppliersToAdd
     * @return Region
     */
    @Transactional
    public Region addToSuppliers(Region region, Iterable<Long> suppliersToAdd) {
        List<Supplier> suppliers = getSupplierService().findAll(suppliersToAdd);
        region.addToSuppliers(suppliers);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param citiesToRemove
     * @return Region
     */
    @Transactional
    public Region removeFromCities(Region region, Iterable<Long> citiesToRemove) {
        List<City> cities = getCityService().findAll(citiesToRemove);
        region.removeFromCities(cities);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param customerOrdersToRemove
     * @return Region
     */
    @Transactional
    public Region removeFromCustomerOrders(Region region, Iterable<Long> customerOrdersToRemove) {
        List<CustomerOrder> customerOrders = getCustomerOrderService().findAll(customerOrdersToRemove);
        region.removeFromCustomerOrders(customerOrders);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param partiesToRemove
     * @return Region
     */
    @Transactional
    public Region removeFromParties(Region region, Iterable<Long> partiesToRemove) {
        List<Party> parties = getPartyService().findAll(partiesToRemove);
        region.removeFromParties(parties);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param storesToRemove
     * @return Region
     */
    @Transactional
    public Region removeFromStores(Region region, Iterable<Long> storesToRemove) {
        List<Store> stores = getStoreService().findAll(storesToRemove);
        region.removeFromStores(stores);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param suppliersToRemove
     * @return Region
     */
    @Transactional
    public Region removeFromSuppliers(Region region, Iterable<Long> suppliersToRemove) {
        List<Supplier> suppliers = getSupplierService().findAll(suppliersToRemove);
        region.removeFromSuppliers(suppliers);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param cities
     * @return Region
     */
    @Transactional
    public Region setCities(Region region, Iterable<Long> cities) {
        List<City> items = getCityService().findAll(cities);
        Set<City> currents = region.getCities();
        Set<City> toRemove = new HashSet<City>();
        for (Iterator<City> iterator = currents.iterator(); iterator.hasNext(); ) {
            City nextCity = iterator.next();
            if (items.contains(nextCity)) {
                items.remove(nextCity);
            } else {
                toRemove.add(nextCity);
            }
        }
        region.removeFromCities(toRemove);
        region.addToCities(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        region.setVersion(region.getVersion() + 1);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param customerOrders
     * @return Region
     */
    @Transactional
    public Region setCustomerOrders(Region region, Iterable<Long> customerOrders) {
        List<CustomerOrder> items = getCustomerOrderService().findAll(customerOrders);
        Set<CustomerOrder> currents = region.getCustomerOrders();
        Set<CustomerOrder> toRemove = new HashSet<CustomerOrder>();
        for (Iterator<CustomerOrder> iterator = currents.iterator(); iterator.hasNext(); ) {
            CustomerOrder nextCustomerOrder = iterator.next();
            if (items.contains(nextCustomerOrder)) {
                items.remove(nextCustomerOrder);
            } else {
                toRemove.add(nextCustomerOrder);
            }
        }
        region.removeFromCustomerOrders(toRemove);
        region.addToCustomerOrders(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        region.setVersion(region.getVersion() + 1);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param parties
     * @return Region
     */
    @Transactional
    public Region setParties(Region region, Iterable<Long> parties) {
        List<Party> items = getPartyService().findAll(parties);
        Set<Party> currents = region.getParties();
        Set<Party> toRemove = new HashSet<Party>();
        for (Iterator<Party> iterator = currents.iterator(); iterator.hasNext(); ) {
            Party nextParty = iterator.next();
            if (items.contains(nextParty)) {
                items.remove(nextParty);
            } else {
                toRemove.add(nextParty);
            }
        }
        region.removeFromParties(toRemove);
        region.addToParties(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        region.setVersion(region.getVersion() + 1);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param stores
     * @return Region
     */
    @Transactional
    public Region setStores(Region region, Iterable<Long> stores) {
        List<Store> items = getStoreService().findAll(stores);
        Set<Store> currents = region.getStores();
        Set<Store> toRemove = new HashSet<Store>();
        for (Iterator<Store> iterator = currents.iterator(); iterator.hasNext(); ) {
            Store nextStore = iterator.next();
            if (items.contains(nextStore)) {
                items.remove(nextStore);
            } else {
                toRemove.add(nextStore);
            }
        }
        region.removeFromStores(toRemove);
        region.addToStores(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        region.setVersion(region.getVersion() + 1);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param suppliers
     * @return Region
     */
    @Transactional
    public Region setSuppliers(Region region, Iterable<Long> suppliers) {
        List<Supplier> items = getSupplierService().findAll(suppliers);
        Set<Supplier> currents = region.getSuppliers();
        Set<Supplier> toRemove = new HashSet<Supplier>();
        for (Iterator<Supplier> iterator = currents.iterator(); iterator.hasNext(); ) {
            Supplier nextSupplier = iterator.next();
            if (items.contains(nextSupplier)) {
                items.remove(nextSupplier);
            } else {
                toRemove.add(nextSupplier);
            }
        }
        region.removeFromSuppliers(toRemove);
        region.addToSuppliers(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        region.setVersion(region.getVersion() + 1);
        return getRegionRepository().save(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     */
    @Transactional
    public void delete(Region region) {
        // Clear bidirectional many-to-one child relationship with Country
        if (region.getCountry() != null) {
            region.getCountry().getRegions().remove(region);
        }
        // Clear bidirectional one-to-many parent relationship with City
        for (City item : region.getCities()) {
            item.setRegion(null);
        }
        // Clear bidirectional one-to-many parent relationship with CustomerOrder
        for (CustomerOrder item : region.getCustomerOrders()) {
            item.setRegion(null);
        }
        // Clear bidirectional one-to-many parent relationship with Party
        for (Party item : region.getParties()) {
            item.setRegion(null);
        }
        // Clear bidirectional one-to-many parent relationship with Store
        for (Store item : region.getStores()) {
            item.setRegion(null);
        }
        // Clear bidirectional one-to-many parent relationship with Supplier
        for (Supplier item : region.getSuppliers()) {
            item.setRegion(null);
        }
        getRegionRepository().delete(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Region> save(Iterable<Region> entities) {
        return getRegionRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Region> toDelete = getRegionRepository().findAll(ids);
        getRegionRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Region
     */
    @Transactional
    public Region save(Region entity) {
        return getRegionRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Region
     */
    public Region findOne(Long id) {
        return getRegionRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Region
     */
    public Region findOneForUpdate(Long id) {
        return getRegionRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Region> findAll(Iterable<Long> ids) {
        return getRegionRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Region> findAll() {
        return getRegionRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getRegionRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Region> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getRegionRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Region> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable) {
        return getRegionRepository().findByCountry(country, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return Long
     */
    public long countByCountry(Country country) {
        return getRegionRepository().countByCountry(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param pageable
     * @return Page
     */
    public Page<Region> findByCountryIdOrderByDescriptionAsc(Long id, Pageable pageable) {
        return getRegionRepository().findByCountryIdOrderByDescriptionAsc(id, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Long
     */
    public long countByCountryIdOrderByDescriptionAsc(Long id) {
        return getRegionRepository().countByCountryIdOrderByDescriptionAsc(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Region> getEntityType() {
        return Region.class;
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
