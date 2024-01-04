package travalService.model;

public class QuotationRequest {
    private String destination;
    private int numberOfPeople;

    // Constructors, getters, and setters

    public QuotationRequest(String destination, int numberOfPeople) {
        this.destination = destination;
        this.numberOfPeople = numberOfPeople;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}