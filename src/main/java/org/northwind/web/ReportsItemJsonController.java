package org.northwind.web;
import javax.validation.Valid;

import org.northwind.domain.Report;
import org.northwind.service.api.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
 * = ReportsItemJsonController
 TODO Auto-generated class documentation
 *
 */
@RestController
@RequestMapping(value = "/api/reports/{report}", name = "ReportsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReportsItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ReportService reportService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param reportService
     */
    @Autowired
    public ReportsItemJsonController(ReportService reportService) {
        this.reportService = reportService;
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

    @ModelAttribute
    public Report getReport(@PathVariable("report") Long id) {
        Report report = reportService.findOne(id);
        if (report == null) {
            throw new NotFoundException(String.format("Report with identifier '%s' not found", id));
        }
        return report;
    }

    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Report report) {
        return ResponseEntity.ok(report);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param report
     * @return UriComponents
     */
    public static UriComponents showURI(Report report) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(ReportsItemJsonController.class).show(report)).buildAndExpand(report.getId()).encode();
    }

    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Report storedReport, @Valid @RequestBody Report report, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        report.setId(storedReport.getId());
        getReportService().save(report);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Report report) {
        getReportService().delete(report);
        return ResponseEntity.ok().build();
    }
}
