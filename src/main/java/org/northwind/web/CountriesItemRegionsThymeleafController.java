package org.northwind.web;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.northwind.domain.Country;
import org.northwind.domain.Region;
import org.northwind.service.api.CountryService;
import org.northwind.service.api.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooDetail;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.datatables.ConvertedDatatablesData;
import io.springlets.data.web.datatables.Datatables;
import io.springlets.data.web.datatables.DatatablesColumns;
import io.springlets.data.web.datatables.DatatablesPageable;
import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;

/**
 * = CountriesItemRegionsThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Country.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "regions")
@RooThymeleaf
@Controller
@RequestMapping(value = "/countries/{country}/regions", name = "CountriesItemRegionsThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CountriesItemRegionsThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

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
     * TODO Auto-generated attribute documentation
     *
     */
    private RegionService regionService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<CountriesCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param countryService
     * @param regionService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public CountriesItemRegionsThymeleafController(CountryService countryService, RegionService regionService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setCountryService(countryService);
        setRegionService(regionService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(CountriesCollectionThymeleafController.class));
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
     * @return RegionService
     */
    public RegionService getRegionService() {
        return regionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param regionService
     */
    public void setRegionService(RegionService regionService) {
        this.regionService = regionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MessageSource
     */
    public MessageSource getMessageSource() {
        return messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param messageSource
     */
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return MethodLinkBuilderFactory
     */
    public MethodLinkBuilderFactory<CountriesCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<CountriesCollectionThymeleafController> collectionLink) {
        this.collectionLink = collectionLink;
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

    @ModelAttribute
    public Country getCountry(@PathVariable("country") Long id, Locale locale, HttpMethod method) {
        Country country = null;
        if (HttpMethod.PUT.equals(method)) {
            country = countryService.findOneForUpdate(id);
        } else {
            country = countryService.findOne(id);
        }
        if (country == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Country", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return country;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateForm(Model model) {
        populateFormats(model);
    }

    @GetMapping(name = "datatables", produces = Datatables.MEDIA_TYPE, value = "/dt")
    @ResponseBody
    public ResponseEntity<ConvertedDatatablesData<Region>> datatables(@ModelAttribute Country country, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<Region> regions = getRegionService().findByCountry(country, search, pageable);
        long totalRegionsCount = getRegionService().countByCountry(country);
        ConvertedDatatablesData<Region> data = new ConvertedDatatablesData<Region>(regions, totalRegionsCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute Country country, Model model) {
        populateForm(model);
        model.addAttribute("region", new Region());
        return new ModelAndView("countries/regions/create");
    }

    @DeleteMapping(name = "removeFromRegions", value = "/{regionsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromRegions(@ModelAttribute Country country, @PathVariable("regionsToRemove") Long regionsToRemove) {
        getCountryService().removeFromRegions(country, Collections.singleton(regionsToRemove));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(name = "removeFromRegionsBatch", value = "/batch/{regionsToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromRegionsBatch(@ModelAttribute Country country, @PathVariable("regionsToRemove") Collection<Long> regionsToRemove) {
        getCountryService().removeFromRegions(country, regionsToRemove);
        return ResponseEntity.ok().build();
    }

    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute Country country, @RequestParam(value = "regionsIds", required = false) List<Long> regions, @RequestParam("parentVersion") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Remove empty values
        if (regions != null) {
            for (Iterator<Long> iterator = regions.iterator(); iterator.hasNext(); ) {
                if (iterator.next() == null) {
                    iterator.remove();
                }
            }
        }
        // Concurrency control
        if (version != country.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            // Obtain the selected books and include them in the author that will be
            // included in the view
            if (regions != null) {
                country.setRegions(new HashSet<Region>(getRegionService().findAll(regions)));
            } else {
                country.setRegions(new HashSet<Region>());
            }
            // Reset the version to prevent update
            country.setVersion(version);
            // Include the updated element in the model
            model.addAttribute("country", country);
            model.addAttribute("concurrency", true);
            return new ModelAndView("countries/regions/create");
        } else if (version != country.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            // Provide the original element from the Database
            model.addAttribute("country", country);
            model.addAttribute("concurrency", false);
            return new ModelAndView("countries/regions/create");
        }
        getCountryService().setRegions(country, regions);
        return new ModelAndView("redirect:" + getCollectionLink().to(CountriesCollectionThymeleafLinkFactory.LIST).toUriString());
    }
}
