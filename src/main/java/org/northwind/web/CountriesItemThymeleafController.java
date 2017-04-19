package org.northwind.web;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.northwind.domain.Country;
import org.northwind.service.api.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
 * = CountriesItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@Controller
@RequestMapping(value = "/countries/{country}", name = "CountriesItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class CountriesItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<CountriesItemThymeleafController> itemLink;

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
     * TODO Auto-generated constructor documentation
     *
     * @param countryService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public CountriesItemThymeleafController(CountryService countryService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setCountryService(countryService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(CountriesItemThymeleafController.class));
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
    public MethodLinkBuilderFactory<CountriesItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<CountriesItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
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

    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Country country, Model model) {
        model.addAttribute("country", country);
        return new ModelAndView("countries/show");
    }

    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Country country, Model model) {
        model.addAttribute("country", country);
        return new ModelAndView("countries/showInline :: inline-content");
    }

    @InitBinder("country")
    public void initCountryBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
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

    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Country country, Model model) {
        populateForm(model);
        model.addAttribute("country", country);
        return new ModelAndView("countries/edit");
    }

    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Country country, @RequestParam("version") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("countries/edit");
        }
        // Concurrency control
        Country existingCountry = getCountryService().findOne(country.getId());
        if (country.getVersion() != existingCountry.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("country", country);
            model.addAttribute("concurrency", true);
            return new ModelAndView("countries/edit");
        } else if (country.getVersion() != existingCountry.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("country", existingCountry);
            model.addAttribute("concurrency", false);
            return new ModelAndView("countries/edit");
        } else if (country.getVersion() != existingCountry.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            country.setVersion(existingCountry.getVersion());
        }
        Country savedCountry = getCountryService().save(country);
        UriComponents showURI = getItemLink().to(CountriesItemThymeleafLinkFactory.SHOW).with("country", savedCountry.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Country country) {
        getCountryService().delete(country);
        return ResponseEntity.ok().build();
    }
}
