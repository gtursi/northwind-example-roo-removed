package org.northwind.web;
import java.io.IOException;

import org.northwind.domain.OrderDetail;
import org.northwind.service.api.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import io.springlets.web.NotFoundException;

/**
 * = OrderDetailDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = OrderDetail.class)
@JsonComponent
public class OrderDetailDeserializer extends JsonObjectDeserializer<OrderDetail> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private OrderDetailService orderDetailService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param orderDetailService
     * @param conversionService
     */
    @Autowired
    public OrderDetailDeserializer(@Lazy OrderDetailService orderDetailService, ConversionService conversionService) {
        this.orderDetailService = orderDetailService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return OrderDetailService
     */
    public OrderDetailService getOrderDetailService() {
        return orderDetailService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param orderDetailService
     */
    public void setOrderDetailService(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ConversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param conversionService
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return OrderDetail
     * @throws IOException
     */
    public OrderDetail deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        OrderDetail orderDetail = orderDetailService.findOne(id);
        if (orderDetail == null) {
            throw new NotFoundException("OrderDetail not found");
        }
        return orderDetail;
    }
}
