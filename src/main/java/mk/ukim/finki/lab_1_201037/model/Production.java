package mk.ukim.finki.lab_1_201037.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Production {

    private Long id;
    private String name;
    private String country;
    private String address;

    public Production() {
        this.id = (long) (Math.random()*1000);
    }

    public Production(String name, String country, String address) {
        this.id = (long) (Math.random()*1000);
        this.name = name;
        this.country = country;
        this.address = address;
    }
}
