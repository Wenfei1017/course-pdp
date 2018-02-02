package edu.neu.ccs.cs5010;

/**
 * created by xwenfei on 10/06
 */

public class Address {
    private String Street;
    private String City;
    private String County;
    private String State;
    private String Zip;

    /**
     * constructor
     * @param street the street of address
     * @param city the city of address
     * @param county the county of address
     * @param state the state of address
     * @param zip the zip of address
     */
    public Address(String street,String city,String county,String state,String zip){
        this.Street = street;
        this.City = city;
        this.County = county;
        this.State = state;
        this.Zip = zip;
    }

    /**
     * print the address infomation
     */
    public void printAddress() {
        System.out.println("Address: " + this.Street + ", " + this.City + ", " + this.County + ", " + this.State + ", " + this.Zip );
    }

    /**
     *
     * @return the street of address
     */
    public String getStreet() {
        return Street;
    }

    /**
     *
     * @return the city of address
     */
    public String getCity() {
        return City;
    }

    /**
     *
     * @return the county of address
     */
    public String getCounty() {
        return County;
    }

    /**
     *
     * @return the state of address
     */
    public String getState() {
        return State;
    }

    /**
     *
     * @return the zip of address
     */
    public String getZip() {
        return Zip;
    }
}
