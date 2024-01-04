package travalService.service;

import travalService.model.QuotationRequest;
import travalService.model.QuotationResponse;

public interface QuotationService {
    QuotationResponse generateQuotation(QuotationRequest request);
}
