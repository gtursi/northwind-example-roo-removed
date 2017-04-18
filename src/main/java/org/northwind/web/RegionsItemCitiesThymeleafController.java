package org.northwind.web;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.northwind.domain.City;
import org.northwind.domain.Region;
import org.northwind.service.api.CityService;
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
 * = RegionsItemCitiesThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Region.class, type = ControllerType.DETAIL)
@RooDetail(relationField = "cities")
@RooThymeleaf
@Controller
@RequestMapping(value = "/regions/{region}/cities", name = "RegionsItemCitiesThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class RegionsItemCitiesThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private CityService cityService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

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
    private MethodLinkBuilderFactory<RegionsCollectionThymeleafController> collectionLink;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param regionService
     * @param cityService
     * @param conversionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public RegionsItemCitiesThymeleafController(RegionService regionService, CityService cityService, ConversionService conversionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setRegionService(regionService);
        setCityService(cityService);
        setConversionService(conversionService);
        setMessageSource(messageSource);
        setCollectionLink(linkBuilder.of(RegionsCollectionThymeleafController.class));
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
     * @return CityService
     */
    public CityService getCityService() {
        return cityService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param cityService
     */
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
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
    public MethodLinkBuilderFactory<RegionsCollectionThymeleafController> getCollectionLink() {
        return collectionLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param collectionLink
     */
    public void setCollectionLink(MethodLinkBuilderFactory<RegionsCollectionThymeleafController> collectionLink) {
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
    public Region getRegion(@PathVariable("region") Long id, Locale locale, HttpMethod method) {
        Region region = null;
        if (HttpMethod.PUT.equals(method)) {
            region = regionService.findOneForUpdate(id);
        } else {
            region = regionService.findOne(id);
        }
        if (region == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "Region", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return region;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param model
     */
    public void populateFormats(Model model) {
        model.addAttribute("application_locale", LocaleContextHolder.getLocale().getLanguage());
        model.addAttribute("createdDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        model.addAttribute("modifiedDate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
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
    public ResponseEntity<ConvertedDatatablesData<City>> datatables(@ModelAttribute Region region, DatatablesColumns datatablesColumns, GlobalSearch search, DatatablesPageable pageable, @RequestParam("draw") Integer draw) {
        Page<City> cities = getCityService().findByRegion(region, search, pageable);
        long totalCitiesCount = getCityService().countByRegion(region);
        ConvertedDatatablesData<City> data = new ConvertedDatatablesData<City>(cities, totalCitiesCount, draw, getConversionService(), datatablesColumns);
        return ResponseEntity.ok(data);
    }

    @GetMapping(value = "/create-form", name = "createForm")
    public ModelAndView createForm(@ModelAttribute Region region, Model model) {
        populateForm(model);
        model.addAttribute("city", new City());
        return new ModelAndView("regions/cities/create");
    }

    @DeleteMapping(name = "removeFromCities", value = "/{citiesToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromCities(@ModelAttribute Region region, @PathVariable("citiesToRemove") Long citiesToRemove) {
        getRegionService().removeFromCities(region, Collections.singleton(citiesToRemove));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(name = "removeFromCitiesBatch", value = "/batch/{citiesToRemove}")
    @ResponseBody
    public ResponseEntity<?> removeFromCitiesBatch(@ModelAttribute Region region, @PathVariable("citiesToRemove") Collection<Long> citiesToRemove) {
        getRegionService().removeFromCities(region, citiesToRemove);
        return ResponseEntity.ok().build();
    }

    @PostMapping(name = "create")
    public ModelAndView create(@ModelAttribute Region region, @RequestParam(value = "citiesIds", required = false) List<Long> cities, @RequestParam("parentVersion") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, Model model) {
        // Remove empty values
        if (cities != null) {
            for (Iterator<Long> iterator = cities.iterator(); iterator.hasNext(); ) {
                if (iterator.next() == null) {
                    iterator.remove();
                }
            }
        }
        // Concurrency control
        if (version != region.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            // Obtain the selected books and include them in the author that will be
            // included in the view
            if (cities != null) {
                region.setCities(new HashSet<City>(getCityService().findAll(cities)));
            } else {
                region.setCities(new HashSet<City>());
            }
            // Reset the version to prevent update
            region.setVersion(version);
            // Include the updated element in the model
            model.addAttribute("region", region);
            model.addAttribute("concurrency", true);
            return new ModelAndView("regions/cities/create");
        } else if (version != region.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            // Provide the original element from the Database
            model.addAttribute("region", region);
            model.addAttribute("concurrency", false);
            return new ModelAndView("regions/cities/create");
        }
        getRegionService().setCities(region, cities);
        return new ModelAndView("redirect:" + getCollectionLink().to(RegionsCollectionThymeleafLinkFactory.LIST).toUriString());
    }
}
