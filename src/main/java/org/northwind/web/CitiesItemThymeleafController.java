package org.northwind.web;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.northwind.domain.City;
import org.northwind.service.api.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooThymeleaf;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;

import io.springlets.web.NotFoundException;
import io.springlets.web.mvc.util.ControllerMethodLinkBuilderFactory;
import io.springlets.web.mvc.util.MethodLinkBuilderFactory;

/**
 * = CitiesItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = City.class, type = ControllerType.ITEM)
@RooThymeleaf
@Controller
@RequestMapping(value = "/cities/{city}", name = "CitiesItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CitiesItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<CitiesItemThymeleafController> itemLink;

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
     * TODO Auto-generated constructor documentation
     *
     * @param cityService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public CitiesItemThymeleafController(CityService cityService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setCityService(cityService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(CitiesItemThymeleafController.class));
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
    public MethodLinkBuilderFactory<CitiesItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<CitiesItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return City
     */
    @ModelAttribute
    public City getCity(@PathVariable("city") Long id, Locale locale, HttpMethod method) {
        City city = null;
        if (HttpMethod.PUT.equals(method)) {
            city = cityService.findOneForUpdate(id);
        } else {
            city = cityService.findOne(id);
        }
        if (city == null) {
            String message = messageSource.getMessage("error_NotFound", new Object[] { "City", id }, "The record couldn't be found", locale);
            throw new NotFoundException(message);
        }
        return city;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute City city, Model model) {
        model.addAttribute("city", city);
        return new ModelAndView("cities/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute City city, Model model) {
        model.addAttribute("city", city);
        return new ModelAndView("cities/showInline :: inline-content");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("city")
    public void initCityBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
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

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute City city, Model model) {
        populateForm(model);
        model.addAttribute("city", city);
        return new ModelAndView("cities/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @param version
     * @param concurrencyControl
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute City city, @RequestParam("version") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("cities/edit");
        }
        // Concurrency control
        City existingCity = getCityService().findOne(city.getId());
        if (city.getVersion() != existingCity.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("city", city);
            model.addAttribute("concurrency", true);
            return new ModelAndView("cities/edit");
        } else if (city.getVersion() != existingCity.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("city", existingCity);
            model.addAttribute("concurrency", false);
            return new ModelAndView("cities/edit");
        } else if (city.getVersion() != existingCity.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            city.setVersion(existingCity.getVersion());
        }
        City savedCity = getCityService().save(city);
        UriComponents showURI = getItemLink().to(CitiesItemThymeleafLinkFactory.SHOW).with("city", savedCity.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param city
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute City city) {
        getCityService().delete(city);
        return ResponseEntity.ok().build();
    }
}
