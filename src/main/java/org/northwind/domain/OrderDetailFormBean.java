package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = OrderDetailFormBean
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class OrderDetailFormBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long customerId;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param customerId
     */
    public OrderDetailFormBean(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getCustomerId() {
        return this.customerId;
    }
}
