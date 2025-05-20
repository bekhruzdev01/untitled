package it.revo.demo.payload;

public class CountryDTO {
    private Long id;
    private String name;
    private String capital;

    public CountryDTO() {}

    public CountryDTO(Long id, String name, String capital) {
        this.id = id;
        this.name = name;
        this.capital = capital;
    }

    // Getter va Setter metodlari

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
