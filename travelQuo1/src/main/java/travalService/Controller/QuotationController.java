package travalService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import travalService.model.QuotationRequest;
import travalService.model.QuotationResponse;
import travalService.service.QuotationService;

@RestController
@RequestMapping("/quotations")
public class QuotationController {

    private final QuotationService quotationService;

    @Autowired
    public QuotationController(QuotationService quotationService) {
        this.quotationService = quotationService;
    }

    @PostMapping
    public QuotationResponse getQuotation(@RequestBody QuotationRequest request) {
        return quotationService.generateQuotation(request);
    }
}