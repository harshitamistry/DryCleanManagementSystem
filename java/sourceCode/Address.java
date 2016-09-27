
/* Name: Harshita Aka Dharna Mistry
 * Name : Sheenam Kamal
 * Name : Kour Sanminder
 * JavaProject
 *
 * Description: A java class which contains information about the street address,
 * postal code, city, province and country.
 */
package javaproject;

import java.util.Objects;

/**
 *
 * @author Harshita mistry
 */
public class Address {
    private String streetAddress;
    private String postalCode;
    private String city;
    private String province;
    private static final String country="CANADA";
    
    /**
     * Construct an Address object with street address, postal code, city 
     * and province.
     * @param streetAddress
     * @param postalCode
     * @param city
     * @param province 
     */

    public Address(String streetAddress, String postalCode,
            String city, String province) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
        //this.country = "CANADA";
    }

    /**
     * accessors method to get street address
     * @return streetAddress
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * accessors method to get the postal code.
     * @return postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }
    /**
     * accessors method to get the city
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * accessors method to get the province
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * mutator method to set street address
     * @param streetAddress 
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * mutator method to set the postal code
     * @param postalCode 
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * mutator method to set the city
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * mutator method to set the province
     * @param province 
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * Gives the details about address
     * @return String
     */
    @Override
    public String toString() {
        return "Address{" + "streetAddress=" + streetAddress + ","
                + " postalCode=" + postalCode + ", city=" + city + 
                ", province=" + province + ", country=" + country + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    /**
     * equals method for Address class
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Address other = (Address) obj;
        if (!Objects.equals(this.streetAddress, other.streetAddress)) {
            return false;
        }
        if (!Objects.equals(this.postalCode, other.postalCode)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.province, other.province)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        return true;
    }
    
    
    
}
