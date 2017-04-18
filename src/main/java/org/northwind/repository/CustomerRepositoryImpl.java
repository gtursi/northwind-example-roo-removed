package org.northwind.repository;
import org.northwind.domain.Customer;
import org.northwind.domain.QCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;

/**
 * = CustomerRepositoryImpl
 TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = CustomerRepositoryCustom.class)
@Transactional(readOnly = true)
public class CustomerRepositoryImpl extends QueryDslRepositorySupportExt<Customer> implements CustomerRepositoryCustom {

    /**
     * TODO Auto-generated constructor documentation
     */
    CustomerRepositoryImpl() {
        super(Customer.class);
    }

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CONTACT_NAME = "contactName";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String COMPANY_NAME = "companyName";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CITY = "city";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String COUNTRY = "country";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CONTACT_TITLE = "contactTitle";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String POSTAL_CODE = "postalCode";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String ADDRESS = "address";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String PHONE = "phone";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String FAX = "fax";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String EMAIL = "email";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REGION = "region";

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Customer> findAll(GlobalSearch globalSearch, Pageable pageable) {
        QCustomer customer = QCustomer.customer;
        JPQLQuery<Customer> query = from(customer);
        Path<?>[] paths = new Path<?>[] { customer.city, customer.country, customer.address, customer.postalCode, customer.phone, customer.region, customer.companyName, customer.contactName, customer.contactTitle, customer.fax, customer.email };
        applyGlobalSearch(globalSearch, query, paths);
        AttributeMappingBuilder mapping = buildMapper().map(CITY, customer.city).map(COUNTRY, customer.country).map(ADDRESS, customer.address).map(POSTAL_CODE, customer.postalCode).map(PHONE, customer.phone).map(REGION, customer.region).map(COMPANY_NAME, customer.companyName).map(CONTACT_NAME, customer.contactName).map(CONTACT_TITLE, customer.contactTitle).map(FAX, customer.fax).map(EMAIL, customer.email);
        applyPagination(pageable, query, mapping);
        applyOrderById(query);
        return loadPage(query, pageable, customer);
    }
}
