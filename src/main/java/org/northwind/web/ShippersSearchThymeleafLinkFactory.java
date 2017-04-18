package org.northwind.web;
import java.util.Map;

import org.springframework.roo.addon.web.mvc.thymeleaf.annotations.RooLinkFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;

import io.springlets.web.mvc.util.MethodLinkFactory;
import io.springlets.web.mvc.util.SpringletsMvcUriComponentsBuilder;

/**
 * = ShippersSearchThymeleafLinkFactory
 TODO Auto-generated class documentation
 *
 */
@RooLinkFactory(controller = ShippersSearchThymeleafController.class)
@Component
public class ShippersSearchThymeleafLinkFactory implements MethodLinkFactory<ShippersSearchThymeleafController> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYPHONEFORM = "byPhoneForm";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYPHONE = "byPhone";

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    public static final String BYPHONEDT = "byPhoneDt";

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<ShippersSearchThymeleafController> getControllerClass() {
        return ShippersSearchThymeleafController.class;
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
        if (methodName.equals(BYPHONEFORM)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byPhoneForm(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYPHONE)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byPhone(null, null)).buildAndExpand(pathVariables);
        }
        if (methodName.equals(BYPHONEDT)) {
            return SpringletsMvcUriComponentsBuilder.fromMethodCall(SpringletsMvcUriComponentsBuilder.on(getControllerClass()).byPhoneDt(null, null, null, null)).buildAndExpand(pathVariables);
        }
        throw new IllegalArgumentException("Invalid method name: " + methodName);
    }
}
