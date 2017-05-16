package prototype;

import java.io.Serializable;

class Address implements Serializable {
    private int city;//城市
    private String country;//国家
    private String code;//地区编码

    Address(){}
    Address(Address address){
        this.city=address.getCity();
        this.code=address.getCode();
        this.country = address.getCountry();
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCity() {

        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "Address{" +
                "city=" + city +
                ", country='" + country + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}