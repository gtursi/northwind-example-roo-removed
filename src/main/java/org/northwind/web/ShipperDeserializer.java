package org.northwind.web;
import java.io.IOException;

import org.northwind.domain.Shipper;
import org.northwind.service.api.ShipperService;
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
 * = ShipperDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Shipper.class)
@JsonComponent
public class ShipperDeserializer extends JsonObjectDeserializer<Shipper> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ShipperService shipperService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param shipperService
     * @param conversionService
     */
    @Autowired
    public ShipperDeserializer(@Lazy ShipperService shipperService, ConversionService conversionService) {
        this.shipperService = shipperService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ShipperService
     */
    public ShipperService getShipperService() {
        return shipperService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param shipperService
     */
    public void setShipperService(ShipperService shipperService) {
        this.shipperService = shipperService;
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
     * @return Shipper
     * @throws IOException
     */
    public Shipper deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Shipper shipper = shipperService.findOne(id);
        if (shipper == null) {
            throw new NotFoundException("Shipper not found");
        }
        return shipper;
    }
}
