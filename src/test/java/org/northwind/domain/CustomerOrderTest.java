package org.northwind.domain;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;
import org.northwind.domain.dod.CustomerOrderFactory;
import org.northwind.domain.dod.OrderDetailFactory;
import org.springframework.roo.addon.jpa.annotations.test.RooJpaUnitTest;

/**
 * = CustomerOrderTest
 TODO Auto-generated class documentation
 *
 */
@RooJpaUnitTest(targetClass = CustomerOrder.class)
public class CustomerOrderTest {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CustomerOrderFactory customerOrderFactory = new CustomerOrderFactory();

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OrderDetailFactory orderDetailFactory = new OrderDetailFactory();

    /**
     * TODO Auto-generated method documentation
     *
     * @return CustomerOrderFactory
     */
    public CustomerOrderFactory getCustomerOrderFactory() {
        return customerOrderFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param customerOrderFactory
     */
    public void setCustomerOrderFactory(CustomerOrderFactory customerOrderFactory) {
        this.customerOrderFactory = customerOrderFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return OrderDetailFactory
     */
    public OrderDetailFactory getOrderDetailFactory() {
        return orderDetailFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetailFactory
     */
    public void setOrderDetailFactory(OrderDetailFactory orderDetailFactory) {
        this.orderDetailFactory = orderDetailFactory;
    }

    @Test
    public void addToOrderDetailsShouldAddTheOrderDetailToTheorderDetailsRelationship() {
        // Setup
        CustomerOrder customerOrder = getCustomerOrderFactory().create(0);
        OrderDetail orderDetail1 = getOrderDetailFactory().create(0);
        OrderDetail orderDetail2 = getOrderDetailFactory().create(1);
        // Exercise
        customerOrder.addToOrderDetails(Arrays.asList(orderDetail1, orderDetail2));
        // Verify
        assertThat(customerOrder.getOrderDetails()).as("Check 'addToOrderDetails' adds the orderDetails to the relationship").contains(orderDetail1).contains(orderDetail2);
        assertThat(customerOrder).as("Check 'addToOrderDetails' updates the OrderDetail relationship side").isEqualTo(orderDetail1.getCustomerOrder()).isEqualTo(orderDetail2.getCustomerOrder());
    }

    @Test
    public void addToOrderDetailsShouldRemoveTheOrderDetailFromTheorderDetailsRelationship() {
        // Setup
        CustomerOrder customerOrder = getCustomerOrderFactory().create(0);
        OrderDetail orderDetail1 = getOrderDetailFactory().create(0);
        OrderDetail orderDetail2 = getOrderDetailFactory().create(1);
        customerOrder.addToOrderDetails(Arrays.asList(orderDetail1, orderDetail2));
        // Exercise
        customerOrder.removeFromOrderDetails(Collections.singleton(orderDetail1));
        // Verify
        assertThat(orderDetail1.getCustomerOrder()).as("Check 'removeFromOrderDetails' updates the OrderDetail relationship side").isNull();
        assertThat(customerOrder.getOrderDetails()).as("Check 'removeFromOrderDetails' removes a OrderDetail from the relationship").doesNotContain(orderDetail1).contains(orderDetail2);
    }
}
