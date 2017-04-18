package org.northwind.repository;
import org.northwind.domain.Shipper;
import org.northwind.domain.ShipperPhoneFormBean;
import org.northwind.domain.ShipperProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;

import io.springlets.data.domain.GlobalSearch;

/**
 * = ShipperRepositoryCustom
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = Shipper.class)
public interface ShipperRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Shipper> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<ShipperProjection> findByPhone(ShipperPhoneFormBean formBean, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public abstract long countByPhone(ShipperPhoneFormBean formBean);
}
