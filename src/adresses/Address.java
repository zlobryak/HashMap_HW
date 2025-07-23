package adresses;

import java.util.Objects;

public class Address {
    protected String country;
    protected String city;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return Objects.equals(country, address.country) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    @Override
    public String toString() {
        return String.format("Address: country %s, city %s", country, city);
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
