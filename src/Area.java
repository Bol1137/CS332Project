public class Area {
    private String source;
    private String destination;
    Driver d ;
    Passenger p;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
        d=new Driver();
        d.getNotified(getSource());
    }
    public void forwardOffer(int ubberFare){
        p=new Passenger();
        p.confirmOffer(ubberFare);
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
