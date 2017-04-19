package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = CustomerMailMessageBean
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class CustomerMailMessageBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long customerId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String companyName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String message;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerId
     * @param companyName
     * @param message
     */
    public CustomerMailMessageBean(Long customerId, String companyName, String message) {
        this.customerId = customerId;
        this.companyName = companyName;
        this.message = message;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getCustomerId() {
        return this.customerId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getCompanyName() {
        return this.companyName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getMessage() {
        return this.message;
    }
}
