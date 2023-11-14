package ÖvnUpp5bTelefonBokPrataMedKompis;

import java.util.ArrayList;
import java.util.Arrays;

public class DAO {

    Kompis k1 = new Kompis("Peter", "0123", "1985-02-12", "peter@gmail.com");
    Kompis k2 = new Kompis("Mary", "0456", "1945-02-12", "mary@gmail.com");
    Kompis k3 = new Kompis("John", "0552", "1956-02-12", "john@gmail.com");
    Kompis k4 = new Kompis("David", "0632", "1985-06-12", "david@gmail.com");
    Kompis k5 = new Kompis("Olof", "0485", "1932-12-12", "olof@gmail.com");
    Kompis k6 = new Kompis("Victor", "0421", "1989-02-19", "victor@gmail.com");
    ArrayList<Kompis> kontactlist;

    DAO(){
        kontactlist = new ArrayList<>(Arrays.asList(k1, k2, k3, k4, k5, k6));
    }

    public ArrayList<Kompis> getKontactlist() {
        return kontactlist;
    }

    public void setKontactlist(ArrayList<Kompis> kontactlist) {
        this.kontactlist = kontactlist;
    }

    public String getKompis(String name){
        for (Kompis k : kontactlist){
            if (k.getName().equalsIgnoreCase(name)){
                return k.getName() + " " + k.getMobilnummer() + " " + k.getFördelsedag() + " " + k.getEmail();
            }
        }
        return null;
    }
}
