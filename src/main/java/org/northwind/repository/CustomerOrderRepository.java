package org.northwind.repository;
import org.northwind.domain.City;
import org.northwind.domain.Country;
import org.northwind.domain.Customer;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Employee;
import org.northwind.domain.Region;
import org.northwind.domain.Shipper;
import org.springframework.transaction.annotation.Transactional;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = CustomerOrderRepository
 TODO Auto-generated class documentation
 *
 */
@Transactional(readOnly = true)
public interface CustomerOrderRepository extends DetachableJpaRepository<CustomerOrder, Long>, CustomerOrderRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return Long
     */
    public abstract long countByCountry(Country country);

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipper
     * @return Long
     */
    public abstract long countByShipper(Shipper shipper);

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @return Long
     */
    public abstract long countByCity(City city);

    /**
     * TODO Auto-generated method documentation
     *
     * @param employee
     * @return Long
     */
    public abstract long countByEmployee(Employee employee);

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return Long
     */
    public abstract long countByRegion(Region region);

    /**
     * TODO Auto-generated method documentation
     *
     * @param customer
     * @return Long
     */
    public abstract long countByCustomer(Customer customer);
}
