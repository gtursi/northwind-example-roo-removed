package org.northwind.web;
import java.io.IOException;

import org.northwind.domain.Country;
import org.northwind.service.api.CountryService;
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
 * = CountryDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Country.class)
@JsonComponent
public class CountryDeserializer extends JsonObjectDeserializer<Country> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CountryService countryService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param countryService
     * @param conversionService
     */
    @Autowired
    public CountryDeserializer(@Lazy CountryService countryService, ConversionService conversionService) {
        this.countryService = countryService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return CountryService
     */
    public CountryService getCountryService() {
        return countryService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param countryService
     */
    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
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
     * @return Country
     * @throws IOException
     */
    public Country deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Country country = countryService.findOne(id);
        if (country == null) {
            throw new NotFoundException("Country not found");
        }
        return country;
    }
}
