package org.northwind.service.impl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.northwind.domain.Country;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Party;
import org.northwind.domain.Region;
import org.northwind.domain.Store;
import org.northwind.domain.Supplier;
import org.northwind.repository.CountryRepository;
import org.northwind.service.api.CountryService;
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
 * = CountryServiceImpl
 TODO Auto-generated class documentation
 *
 */
@Service
@Transactional(readOnly = true)
public class CountryServiceImpl implements CountryService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CountryRepository countryRepository;

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
    private RegionService regionService;

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
     * @param countryRepository
     * @param customerOrderService
     * @param partyService
     * @param regionService
     * @param storeService
     * @param supplierService
     */
    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository, @Lazy CustomerOrderService customerOrderService, @Lazy PartyService partyService, @Lazy RegionService regionService, @Lazy StoreService storeService, @Lazy SupplierService supplierService) {
        setCountryRepository(countryRepository);
        setCustomerOrderService(customerOrderService);
        setPartyService(partyService);
        setRegionService(regionService);
        setStoreService(storeService);
        setSupplierService(supplierService);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CountryRepository
     */
    public CountryRepository getCountryRepository() {
        return countryRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param countryRepository
     */
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
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
     * @return RegionService
     */
    public RegionService getRegionService() {
        return regionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param regionService
     */
    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
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
     * @param country
     * @param customerOrdersToAdd
     * @return Country
     */
    @Transactional
    public Country addToCustomerOrders(Country country, Iterable<Long> customerOrdersToAdd) {
        List<CustomerOrder> customerOrders = getCustomerOrderService().findAll(customerOrdersToAdd);
        country.addToCustomerOrders(customerOrders);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param partiesToAdd
     * @return Country
     */
    @Transactional
    public Country addToParties(Country country, Iterable<Long> partiesToAdd) {
        List<Party> parties = getPartyService().findAll(partiesToAdd);
        country.addToParties(parties);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param regionsToAdd
     * @return Country
     */
    @Transactional
    public Country addToRegions(Country country, Iterable<Long> regionsToAdd) {
        List<Region> regions = getRegionService().findAll(regionsToAdd);
        country.addToRegions(regions);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param storesToAdd
     * @return Country
     */
    @Transactional
    public Country addToStores(Country country, Iterable<Long> storesToAdd) {
        List<Store> stores = getStoreService().findAll(storesToAdd);
        country.addToStores(stores);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param suppliersToAdd
     * @return Country
     */
    @Transactional
    public Country addToSuppliers(Country country, Iterable<Long> suppliersToAdd) {
        List<Supplier> suppliers = getSupplierService().findAll(suppliersToAdd);
        country.addToSuppliers(suppliers);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param customerOrdersToRemove
     * @return Country
     */
    @Transactional
    public Country removeFromCustomerOrders(Country country, Iterable<Long> customerOrdersToRemove) {
        List<CustomerOrder> customerOrders = getCustomerOrderService().findAll(customerOrdersToRemove);
        country.removeFromCustomerOrders(customerOrders);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param partiesToRemove
     * @return Country
     */
    @Transactional
    public Country removeFromParties(Country country, Iterable<Long> partiesToRemove) {
        List<Party> parties = getPartyService().findAll(partiesToRemove);
        country.removeFromParties(parties);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param regionsToRemove
     * @return Country
     */
    @Transactional
    public Country removeFromRegions(Country country, Iterable<Long> regionsToRemove) {
        List<Region> regions = getRegionService().findAll(regionsToRemove);
        country.removeFromRegions(regions);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param storesToRemove
     * @return Country
     */
    @Transactional
    public Country removeFromStores(Country country, Iterable<Long> storesToRemove) {
        List<Store> stores = getStoreService().findAll(storesToRemove);
        country.removeFromStores(stores);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param suppliersToRemove
     * @return Country
     */
    @Transactional
    public Country removeFromSuppliers(Country country, Iterable<Long> suppliersToRemove) {
        List<Supplier> suppliers = getSupplierService().findAll(suppliersToRemove);
        country.removeFromSuppliers(suppliers);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param customerOrders
     * @return Country
     */
    @Transactional
    public Country setCustomerOrders(Country country, Iterable<Long> customerOrders) {
        List<CustomerOrder> items = getCustomerOrderService().findAll(customerOrders);
        Set<CustomerOrder> currents = country.getCustomerOrders();
        Set<CustomerOrder> toRemove = new HashSet<CustomerOrder>();
        for (Iterator<CustomerOrder> iterator = currents.iterator(); iterator.hasNext(); ) {
            CustomerOrder nextCustomerOrder = iterator.next();
            if (items.contains(nextCustomerOrder)) {
                items.remove(nextCustomerOrder);
            } else {
                toRemove.add(nextCustomerOrder);
            }
        }
        country.removeFromCustomerOrders(toRemove);
        country.addToCustomerOrders(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        country.setVersion(country.getVersion() + 1);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param parties
     * @return Country
     */
    @Transactional
    public Country setParties(Country country, Iterable<Long> parties) {
        List<Party> items = getPartyService().findAll(parties);
        Set<Party> currents = country.getParties();
        Set<Party> toRemove = new HashSet<Party>();
        for (Iterator<Party> iterator = currents.iterator(); iterator.hasNext(); ) {
            Party nextParty = iterator.next();
            if (items.contains(nextParty)) {
                items.remove(nextParty);
            } else {
                toRemove.add(nextParty);
            }
        }
        country.removeFromParties(toRemove);
        country.addToParties(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        country.setVersion(country.getVersion() + 1);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param regions
     * @return Country
     */
    @Transactional
    public Country setRegions(Country country, Iterable<Long> regions) {
        List<Region> items = getRegionService().findAll(regions);
        Set<Region> currents = country.getRegions();
        Set<Region> toRemove = new HashSet<Region>();
        for (Iterator<Region> iterator = currents.iterator(); iterator.hasNext(); ) {
            Region nextRegion = iterator.next();
            if (items.contains(nextRegion)) {
                items.remove(nextRegion);
            } else {
                toRemove.add(nextRegion);
            }
        }
        country.removeFromRegions(toRemove);
        country.addToRegions(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        country.setVersion(country.getVersion() + 1);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param stores
     * @return Country
     */
    @Transactional
    public Country setStores(Country country, Iterable<Long> stores) {
        List<Store> items = getStoreService().findAll(stores);
        Set<Store> currents = country.getStores();
        Set<Store> toRemove = new HashSet<Store>();
        for (Iterator<Store> iterator = currents.iterator(); iterator.hasNext(); ) {
            Store nextStore = iterator.next();
            if (items.contains(nextStore)) {
                items.remove(nextStore);
            } else {
                toRemove.add(nextStore);
            }
        }
        country.removeFromStores(toRemove);
        country.addToStores(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        country.setVersion(country.getVersion() + 1);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param suppliers
     * @return Country
     */
    @Transactional
    public Country setSuppliers(Country country, Iterable<Long> suppliers) {
        List<Supplier> items = getSupplierService().findAll(suppliers);
        Set<Supplier> currents = country.getSuppliers();
        Set<Supplier> toRemove = new HashSet<Supplier>();
        for (Iterator<Supplier> iterator = currents.iterator(); iterator.hasNext(); ) {
            Supplier nextSupplier = iterator.next();
            if (items.contains(nextSupplier)) {
                items.remove(nextSupplier);
            } else {
                toRemove.add(nextSupplier);
            }
        }
        country.removeFromSuppliers(toRemove);
        country.addToSuppliers(items);
        // Force the version update of the parent side to know that the parent has changed
        // because it has new books assigned
        country.setVersion(country.getVersion() + 1);
        return getCountryRepository().save(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     */
    @Transactional
    public void delete(Country country) {
        // Clear bidirectional one-to-many parent relationship with CustomerOrder
        for (CustomerOrder item : country.getCustomerOrders()) {
            item.setCountry(null);
        }
        // Clear bidirectional one-to-many parent relationship with Party
        for (Party item : country.getParties()) {
            item.setCountry(null);
        }
        // Clear bidirectional one-to-many parent relationship with Region
        for (Region item : country.getRegions()) {
            item.setCountry(null);
        }
        // Clear bidirectional one-to-many parent relationship with Store
        for (Store item : country.getStores()) {
            item.setCountry(null);
        }
        // Clear bidirectional one-to-many parent relationship with Supplier
        for (Supplier item : country.getSuppliers()) {
            item.setCountry(null);
        }
        getCountryRepository().delete(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Country> save(Iterable<Country> entities) {
        return getCountryRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Country> toDelete = getCountryRepository().findAll(ids);
        getCountryRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Country
     */
    @Transactional
    public Country save(Country entity) {
        return getCountryRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Country
     */
    public Country findOne(Long id) {
        return getCountryRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Country
     */
    public Country findOneForUpdate(Long id) {
        return getCountryRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Country> findAll(Iterable<Long> ids) {
        return getCountryRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Country> findAll() {
        return getCountryRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getCountryRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Country> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getCountryRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Country> getEntityType() {
        return Country.class;
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
