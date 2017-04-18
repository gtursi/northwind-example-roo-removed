package org.northwind.web;
import java.io.IOException;

import org.northwind.domain.Party;
import org.northwind.service.api.PartyService;
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
 * = PartyDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Party.class)
@JsonComponent
public class PartyDeserializer extends JsonObjectDeserializer<Party> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PartyService partyService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param partyService
     * @param conversionService
     */
    @Autowired
    public PartyDeserializer(@Lazy PartyService partyService, ConversionService conversionService) {
        this.partyService = partyService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PartyService
     */
    public PartyService getPartyService() {
        return partyService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param partyService
     */
    public void setPartyService(PartyService partyService) {
        this.partyService = partyService;
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
     * @return Party
     * @throws IOException
     */
    public Party deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Party party = partyService.findOne(id);
        if (party == null) {
            throw new NotFoundException("Party not found");
        }
        return party;
    }
}
