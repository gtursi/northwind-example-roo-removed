package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = UserCertificateDniMessageBean
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class UserCertificateDniMessageBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private int status;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String statusMsg;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String dni;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param status
     * @param statusMsg
     * @param dni
     */
    public UserCertificateDniMessageBean(int status, String statusMsg, String dni) {
        this.status = status;
        this.statusMsg = statusMsg;
        this.dni = dni;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Integer
     */
    public int getStatus() {
        return this.status;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getStatusMsg() {
        return this.statusMsg;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getDni() {
        return this.dni;
    }
}
