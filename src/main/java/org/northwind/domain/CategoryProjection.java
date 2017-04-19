package org.northwind.domain;
import org.springframework.format.annotation.NumberFormat;

import io.springlets.format.EntityFormat;

/**
 * = CategoryProjection
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class CategoryProjection {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @NumberFormat
    private Long categoryId;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String name;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String description;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param categoryId
     * @param name
     * @param description
     */
    public CategoryProjection(Long categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public Long getCategoryId() {
        return this.categoryId;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getDescription() {
        return this.description;
    }
}
