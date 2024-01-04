package travalService.service.impl;

import org.springframework.stereotype.Service;
import travalService.model.QuotationRequest;
import travalService.model.QuotationResponse;
import travalService.service.QuotationService;

@Service
public class QuotationServiceImpl implements QuotationService {

    @Override
    public QuotationResponse generateQuotation(QuotationRequest request) {
        // Your business logic to calculate the quotation
        double price = calculatePrice(request.getDestination(), request.getNumberOfPeople());
        return new QuotationResponse(request.getDestination(), request.getNumberOfPeople(), price);
    }

    private double calculatePrice(String destination, int numberOfPeople) {
        // Implement your pricing logic here
        return 100.0 * numberOfPeople; // Example calculation
    }
}