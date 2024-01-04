package travalService.model;


public class QuotationResponse {
    private String destination;
    private int numberOfPeople;
    private double price;

    public QuotationResponse(String destination, int numberOfPeople, double price) {
    }

    // Constructors, getters, and setters


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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
