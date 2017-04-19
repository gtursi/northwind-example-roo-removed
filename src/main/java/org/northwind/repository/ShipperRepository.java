package org.northwind.repository;
import org.northwind.domain.Shipper;
import org.northwind.domain.ShipperPhoneFormBean;
import org.northwind.domain.ShipperProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = ShipperRepository
 TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public interface ShipperRepository extends DetachableJpaRepository<Shipper, Long>, ShipperRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param companyName
     * @param pageable
     * @return Page
     */
    public abstract Page<Shipper> findByCompanyName(String companyName, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param companyName
     * @return Long
     */
    public abstract long countByCompanyName(String companyName);
}
