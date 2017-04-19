package org.northwind.web;
import javax.validation.Valid;

import org.northwind.domain.Country;
import org.northwind.service.api.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
 * = CountriesItemJsonController
 TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/api/countries/{country}", name = "CountriesItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountriesItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CountryService countryService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param countryService
     */
    @Autowired
    public CountriesItemJsonController(CountryService countryService) {
        this.countryService = countryService;
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

    @ModelAttribute
    public Country getCountry(@PathVariable("country") Long id) {
        Country country = countryService.findOne(id);
        if (country == null) {
            throw new NotFoundException(String.format("Country with identifier '%s' not found", id));
        }
        return country;
    }

    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Country country) {
        return ResponseEntity.ok(country);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param country
     * @return UriComponents
     */
    public static UriComponents showURI(Country country) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(CountriesItemJsonController.class).show(country)).buildAndExpand(country.getId()).encode();
    }

    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Country storedCountry, @Valid @RequestBody Country country, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        country.setId(storedCountry.getId());
        getCountryService().save(country);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Country country) {
        getCountryService().delete(country);
        return ResponseEntity.ok().build();
    }
}
