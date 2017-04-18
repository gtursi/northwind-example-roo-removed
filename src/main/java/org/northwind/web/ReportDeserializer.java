package org.northwind.web;
import java.io.IOException;

import org.northwind.domain.Report;
import org.northwind.service.api.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.ConversionService;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDeserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import io.springlets.web.NotFoundException;

/**
 * = ReportDeserializer
 TODO Auto-generated class documentation
 *
 */
@RooDeserializer(entity = Report.class)
@JsonComponent
public class ReportDeserializer extends JsonObjectDeserializer<Report> {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ReportService reportService;

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ConversionService conversionService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param reportService
     * @param conversionService
     */
    @Autowired
    public ReportDeserializer(@Lazy ReportService reportService, ConversionService conversionService) {
        this.reportService = reportService;
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ReportService
     */
    public ReportService getReportService() {
        return reportService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param reportService
     */
    public void setReportService(ReportService reportService) {
        this.reportService = reportService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ConversionService
     */
    public ConversionService getConversionService() {
        return conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param conversionService
     */
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param jsonParser
     * @param context
     * @param codec
     * @param tree
     * @return Report
     * @throws IOException
     */
    public Report deserializeObject(JsonParser jsonParser, DeserializationContext context, ObjectCodec codec, JsonNode tree) {
        String idText = tree.asText();
        Long id = conversionService.convert(idText, Long.class);
        Report report = reportService.findOne(id);
        if (report == null) {
            throw new NotFoundException("Report not found");
        }
        return report;
    }
}
