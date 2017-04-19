package org.northwind.web;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.northwind.domain.Region;
import org.northwind.service.api.RegionService;
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
 * = RegionsItemThymeleafController
 TODO Auto-generated class documentation
 *
 */
@Controller
@RequestMapping(value = "/regions/{region}", name = "RegionsItemThymeleafController", produces = MediaType.TEXT_HTML_VALUE)
public class RegionsItemThymeleafController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MethodLinkBuilderFactory<RegionsItemThymeleafController> itemLink;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private MessageSource messageSource;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private RegionService regionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param regionService
     * @param messageSource
     * @param linkBuilder
     */
    @Autowired
    public RegionsItemThymeleafController(RegionService regionService, MessageSource messageSource, ControllerMethodLinkBuilderFactory linkBuilder) {
        setRegionService(regionService);
        setMessageSource(messageSource);
        setItemLink(linkBuilder.of(RegionsItemThymeleafController.class));
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
    public MethodLinkBuilderFactory<RegionsItemThymeleafController> getItemLink() {
        return itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param itemLink
     */
    public void setItemLink(MethodLinkBuilderFactory<RegionsItemThymeleafController> itemLink) {
        this.itemLink = itemLink;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @param locale
     * @param method
     * @return Region
     */
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
     * @param region
     * @param model
     * @return ModelAndView
     */
    @GetMapping(name = "show")
    public ModelAndView show(@ModelAttribute Region region, Model model) {
        model.addAttribute("region", region);
        return new ModelAndView("regions/show");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/inline", name = "showInline")
    public ModelAndView showInline(@ModelAttribute Region region, Model model) {
        model.addAttribute("region", region);
        return new ModelAndView("regions/showInline :: inline-content");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param dataBinder
     */
    @InitBinder("region")
    public void initRegionBinder(WebDataBinder dataBinder) {
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

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param model
     * @return ModelAndView
     */
    @GetMapping(value = "/edit-form", name = "editForm")
    public ModelAndView editForm(@ModelAttribute Region region, Model model) {
        populateForm(model);
        model.addAttribute("region", region);
        return new ModelAndView("regions/edit");
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @param version
     * @param concurrencyControl
     * @param result
     * @param model
     * @return ModelAndView
     */
    @PutMapping(name = "update")
    public ModelAndView update(@Valid @ModelAttribute Region region, @RequestParam("version") Long version, @RequestParam(value = "concurrency", required = false, defaultValue = "") String concurrencyControl, BindingResult result, Model model) {
        // Check if provided form contain errors
        if (result.hasErrors()) {
            populateForm(model);
            return new ModelAndView("regions/edit");
        }
        // Concurrency control
        Region existingRegion = getRegionService().findOne(region.getId());
        if (region.getVersion() != existingRegion.getVersion() && StringUtils.isEmpty(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("region", region);
            model.addAttribute("concurrency", true);
            return new ModelAndView("regions/edit");
        } else if (region.getVersion() != existingRegion.getVersion() && "discard".equals(concurrencyControl)) {
            populateForm(model);
            model.addAttribute("region", existingRegion);
            model.addAttribute("concurrency", false);
            return new ModelAndView("regions/edit");
        } else if (region.getVersion() != existingRegion.getVersion() && "apply".equals(concurrencyControl)) {
            // Update the version field to be able to override the existing values
            region.setVersion(existingRegion.getVersion());
        }
        Region savedRegion = getRegionService().save(region);
        UriComponents showURI = getItemLink().to(RegionsItemThymeleafLinkFactory.SHOW).with("region", savedRegion.getId()).toUri();
        return new ModelAndView("redirect:" + showURI.toUriString());
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return ResponseEntity
     */
    @ResponseBody
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Region region) {
        getRegionService().delete(region);
        return ResponseEntity.ok().build();
    }
}
