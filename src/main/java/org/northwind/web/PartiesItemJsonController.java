package org.northwind.web;
import javax.validation.Valid;

import org.northwind.domain.Party;
import org.northwind.service.api.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import io.springlets.web.NotFoundException;

/**
 * = PartiesItemJsonController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Party.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/api/parties/{party}", name = "PartiesItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class PartiesItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PartyService partyService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param partyService
     */
    @Autowired
    public PartiesItemJsonController(PartyService partyService) {
        this.partyService = partyService;
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

    @ModelAttribute
    public Party getParty(@PathVariable("party") Long id) {
        Party party = partyService.findOne(id);
        if (party == null) {
            throw new NotFoundException(String.format("Party with identifier '%s' not found", id));
        }
        return party;
    }

    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Party party) {
        return ResponseEntity.ok(party);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param party
     * @return UriComponents
     */
    public static UriComponents showURI(Party party) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(PartiesItemJsonController.class).show(party)).buildAndExpand(party.getId()).encode();
    }

    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Party storedParty, @Valid @RequestBody Party party, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        party.setId(storedParty.getId());
        getPartyService().save(party);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Party party) {
        getPartyService().delete(party);
        return ResponseEntity.ok().build();
    }
}
