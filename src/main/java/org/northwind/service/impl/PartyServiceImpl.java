package org.northwind.service.impl;
import java.util.List;

import org.northwind.domain.City;
import org.northwind.domain.Country;
import org.northwind.domain.Party;
import org.northwind.domain.Region;
import org.northwind.repository.PartyRepository;
import org.northwind.service.api.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.service.annotations.RooServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.domain.GlobalSearch;

/**
 * = PartyServiceImpl
 TODO Auto-generated class documentation
 *
 */
@RooServiceImpl(service = PartyService.class)
@Service
@Transactional(readOnly = true)
public class PartyServiceImpl implements PartyService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PartyRepository partyRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param partyRepository
     */
    @Autowired
    public PartyServiceImpl(PartyRepository partyRepository) {
        setPartyRepository(partyRepository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PartyRepository
     */
    public PartyRepository getPartyRepository() {
        return partyRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param partyRepository
     */
    public void setPartyRepository(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param party
     */
    @Transactional
    public void delete(Party party) {
        // Clear bidirectional many-to-one child relationship with Country
        if (party.getCountry() != null) {
            party.getCountry().getParties().remove(party);
        }
        // Clear bidirectional many-to-one child relationship with City
        if (party.getCity() != null) {
            party.getCity().getParties().remove(party);
        }
        // Clear bidirectional many-to-one child relationship with Region
        if (party.getRegion() != null) {
            party.getRegion().getParties().remove(party);
        }
        getPartyRepository().delete(party);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Party> save(Iterable<Party> entities) {
        return getPartyRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Party> toDelete = getPartyRepository().findAll(ids);
        getPartyRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Party
     */
    @Transactional
    public Party save(Party entity) {
        return getPartyRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Party
     */
    public Party findOne(Long id) {
        return getPartyRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Party
     */
    public Party findOneForUpdate(Long id) {
        return getPartyRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Party> findAll(Iterable<Long> ids) {
        return getPartyRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Party> findAll() {
        return getPartyRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getPartyRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Party> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getPartyRepository().findAll(globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Party> findByCity(City city, GlobalSearch globalSearch, Pageable pageable) {
        return getPartyRepository().findByCity(city, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Party> findByCountry(Country country, GlobalSearch globalSearch, Pageable pageable) {
        return getPartyRepository().findByCountry(country, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Party> findByRegion(Region region, GlobalSearch globalSearch, Pageable pageable) {
        return getPartyRepository().findByRegion(region, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @return Long
     */
    public long countByCity(City city) {
        return getPartyRepository().countByCity(city);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return Long
     */
    public long countByCountry(Country country) {
        return getPartyRepository().countByCountry(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return Long
     */
    public long countByRegion(Region region) {
        return getPartyRepository().countByRegion(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Party> getEntityType() {
        return Party.class;
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
