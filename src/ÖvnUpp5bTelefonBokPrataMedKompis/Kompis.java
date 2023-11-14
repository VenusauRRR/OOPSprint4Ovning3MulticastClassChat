package ÖvnUpp5bTelefonBokPrataMedKompis;

public class Kompis {
    String name;
    String mobilnummer;
    String fördelsedag;
    String email;

    public Kompis(String name, String mobilnummer, String fördelsedag, String email) {
        this.name = name;
        this.mobilnummer = mobilnummer;
        this.fördelsedag = fördelsedag;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getMobilnummer() {
        return mobilnummer;
    }

    public String getFördelsedag() {
        return fördelsedag;
    }

    public String getEmail() {
        return email;
    }
}
