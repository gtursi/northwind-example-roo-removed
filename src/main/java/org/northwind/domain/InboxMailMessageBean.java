package org.northwind.domain;

import io.springlets.format.EntityFormat;

/**
 * = InboxMailMessageBean
 TODO Auto-generated class documentation
 *
 */
@EntityFormat
public class InboxMailMessageBean {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String subject;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String content;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private String from;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param subject
     * @param content
     * @param from
     */
    public InboxMailMessageBean(String subject, String content, String from) {
        this.subject = subject;
        this.content = content;
        this.from = from;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getSubject() {
        return this.subject;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getContent() {
        return this.content;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return String
     */
    public String getFrom() {
        return this.from;
    }
}
