package domain;

public enum Methods {
    CAESAR("Caesar"),
    SPIEGEL("Spiegel");

    private final String omschrijving;

    Methods(String omschrijving){
        this.omschrijving = omschrijving;
    }
    public String getOmschrijving(){
        return  omschrijving;
    }
}
