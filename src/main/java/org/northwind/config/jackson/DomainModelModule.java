package org.northwind.config.jackson;
import org.northwind.domain.Category;
import org.northwind.domain.City;
import org.northwind.domain.Country;
import org.northwind.domain.Customer;
import org.northwind.domain.CustomerOrder;
import org.northwind.domain.Employee;
import org.northwind.domain.OrderDetail;
import org.northwind.domain.Party;
import org.northwind.domain.Product;
import org.northwind.domain.PurchaseOrder;
import org.northwind.domain.Region;
import org.northwind.domain.Report;
import org.northwind.domain.Shipper;
import org.northwind.domain.SoldProduct;
import org.northwind.domain.Store;
import org.northwind.domain.Supplier;
import org.northwind.web.CategoryJsonMixin;
import org.northwind.web.CityJsonMixin;
import org.northwind.web.CountryJsonMixin;
import org.northwind.web.CustomerJsonMixin;
import org.northwind.web.CustomerOrderJsonMixin;
import org.northwind.web.EmployeeJsonMixin;
import org.northwind.web.OrderDetailJsonMixin;
import org.northwind.web.PartyJsonMixin;
import org.northwind.web.ProductJsonMixin;
import org.northwind.web.PurchaseOrderJsonMixin;
import org.northwind.web.RegionJsonMixin;
import org.northwind.web.ReportJsonMixin;
import org.northwind.web.ShipperJsonMixin;
import org.northwind.web.SoldProductJsonMixin;
import org.northwind.web.StoreJsonMixin;
import org.northwind.web.SupplierJsonMixin;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDomainModelModule;

import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * = DomainModelModule
 TODO Auto-generated class documentation
 *
 */
@RooDomainModelModule
@JsonComponent
public class DomainModelModule extends SimpleModule {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * TODO Auto-generated constructor documentation
     *
     */
    public DomainModelModule() {
        // Mixin registration
        setMixInAnnotation(Category.class, CategoryJsonMixin.class);
        setMixInAnnotation(City.class, CityJsonMixin.class);
        setMixInAnnotation(Country.class, CountryJsonMixin.class);
        setMixInAnnotation(Customer.class, CustomerJsonMixin.class);
        setMixInAnnotation(CustomerOrder.class, CustomerOrderJsonMixin.class);
        setMixInAnnotation(Employee.class, EmployeeJsonMixin.class);
        setMixInAnnotation(OrderDetail.class, OrderDetailJsonMixin.class);
        setMixInAnnotation(Party.class, PartyJsonMixin.class);
        setMixInAnnotation(Product.class, ProductJsonMixin.class);
        setMixInAnnotation(PurchaseOrder.class, PurchaseOrderJsonMixin.class);
        setMixInAnnotation(Region.class, RegionJsonMixin.class);
        setMixInAnnotation(Report.class, ReportJsonMixin.class);
        setMixInAnnotation(Shipper.class, ShipperJsonMixin.class);
        setMixInAnnotation(SoldProduct.class, SoldProductJsonMixin.class);
        setMixInAnnotation(Store.class, StoreJsonMixin.class);
        setMixInAnnotation(Supplier.class, SupplierJsonMixin.class);
    }
}
