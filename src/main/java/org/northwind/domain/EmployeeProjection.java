package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.roo.addon.dto.annotations.RooDTO;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;

import io.springlets.format.EntityFormat;

/**
 * = EmployeeProjection
 TODO Auto-generated class documentation
 *
 */
@RooDTO(immutable = true)
@RooJavaBean(settersByDefault = false)
@EntityFormat
public class EmployeeProjection {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long employeeId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long supervisorId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String firstName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String lastName;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String phone;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String extension;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String supervisorName;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param employeeId
     * @param supervisorId
     * @param firstName
     * @param lastName
     * @param phone
     * @param extension
     * @param supervisorName
     */
    public EmployeeProjection(Long employeeId, Long supervisorId, String firstName, String lastName, String phone, String extension, String supervisorName) {
        this.employeeId = employeeId;
        this.supervisorId = supervisorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.extension = extension;
        this.supervisorName = supervisorName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getEmployeeId() {
        return this.employeeId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getSupervisorId() {
        return this.supervisorId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getExtension() {
        return this.extension;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getSupervisorName() {
        return this.supervisorName;
    }
}
