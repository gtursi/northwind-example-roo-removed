package org.northwind.web;
import javax.validation.Valid;

import org.northwind.domain.Region;
import org.northwind.service.api.RegionService;
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
 * = RegionsItemJsonController
 TODO Auto-generated class documentation
 *
 */
@RooController(entity = Region.class, pathPrefix = "/api", type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/api/regions/{region}", name = "RegionsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegionsItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private RegionService regionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param regionService
     */
    @Autowired
    public RegionsItemJsonController(RegionService regionService) {
        this.regionService = regionService;
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

    @ModelAttribute
    public Region getRegion(@PathVariable("region") Long id) {
        Region region = regionService.findOne(id);
        if (region == null) {
            throw new NotFoundException(String.format("Region with identifier '%s' not found", id));
        }
        return region;
    }

    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Region region) {
        return ResponseEntity.ok(region);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param region
     * @return UriComponents
     */
    public static UriComponents showURI(Region region) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(RegionsItemJsonController.class).show(region)).buildAndExpand(region.getId()).encode();
    }

    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Region storedRegion, @Valid @RequestBody Region region, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        region.setId(storedRegion.getId());
        getRegionService().save(region);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Region region) {
        getRegionService().delete(region);
        return ResponseEntity.ok().build();
    }
}
