package org.northwind.web;
import java.io.IOException;

import org.northwind.domain.SoldProduct;
import org.northwind.service.api.SoldProductService;
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
 * = SoldProductDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = SoldProduct.class)
@JsonComponent
public class SoldProductDeserializer extends JsonObjectDeserializer<SoldProduct> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private SoldProductService soldProductService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param soldProductService
     * @param conversionService
     */
    @Autowired
    public SoldProductDeserializer(@Lazy SoldProductService soldProductService, ConversionService conversionService) {
        this.soldProductService = soldProductService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return SoldProductService
     */
    public SoldProductService getSoldProductService() {
        return soldProductService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param soldProductService
     */
    public void setSoldProductService(SoldProductService soldProductService) {
        this.soldProductService = soldProductService;
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
     * @return SoldProduct
     * @throws IOException
     */
    public SoldProduct deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        SoldProduct soldProduct = soldProductService.findOne(id);
        if (soldProduct == null) {
            throw new NotFoundException("SoldProduct not found");
        }
        return soldProduct;
    }
}
