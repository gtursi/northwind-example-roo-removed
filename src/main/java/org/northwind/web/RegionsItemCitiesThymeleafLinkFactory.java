package org.northwind.web;
import java.util.Map;

import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooLinkFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import io.springlets.web.mvc.util.MethodLinkFactory;
import io.springlets.web.mvc.util.SpringletsMvcUriComponentsBuilder;

/**
 * = RegionsItemCitiesThymeleafLinkFactory
 TODO Auto-generated class documentation
 *
 */
@RooLinkFactory(controller = RegionsItemCitiesThymeleafController.class)
@Component
public class RegionsItemCitiesThymeleafLinkFactory implements MethodLinkFactory<RegionsItemCitiesThymeleafController> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REMOVEFROMCITIESBATCH = "removeFromCitiesBatch";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CREATE = "create";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String REMOVEFROMCITIES = "removeFromCities";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String DATATABLES = "datatables";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String CREATEFORM = "createForm";

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<RegionsItemCitiesThymeleafController> getControllerClass() {
        return RegionsItemCitiesThymeleafController.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param methodName
     * @param parameters
     * @param pathVariables
     * @return UriComponents
     */
    public UriComponents toUri(String methodName, Object[] parameters, Map<String, Object> pathVariables) {
        if (methodName.equals(DATATABLES)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).datatables(null, null, null, null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(CREATEFORM)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).createForm(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(REMOVEFROMCITIES)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).removeFromCities(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(REMOVEFROMCITIESBATCH)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).removeFromCitiesBatch(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(CREATE)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).create(null, null, null, null, null)).buildAndExpand(pathVariables);
        }
        throw new IllegalArgumentException("Invalid method name: " + methodName);
    }
}
