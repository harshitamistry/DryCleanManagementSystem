
/* Name: Harshita Aka Dharna Mistry
 * Name : Sheenam Kamal
 * Name : Kour Sanminder
 * JavaProject
 *
 *Description: A java class that makes an object of name class
 * and Address class with accessors and mutators.
 */

package javaproject;
import java.util.Objects;

/**
 *
 * @author Harshita Mistry
 */
public abstract class Person {
    
    Name name;
    Address address;
    protected String phoneNumber;

   
    
    /**
     * Construct a person object with first name and last name
     * @param firstName
     * @param lastName 
     */
    public Person(String firstName,String lastName)
    {
        
       this.name=new Name(firstName,lastName);
      //this.address=null;
       
    }
    
    /**
     * Construct a person object with given data fields.
     * @param firstName
     * @param lastName
     * @param date
     * @param streetAddress
     * @param postalCode
     * @param city
     * @param province
     * @param phoneNumber 
     */
    public Person(String firstName,
                String lastName,
                String streetAddress,
                String postalCode,
                String city, 
                String province,
                String phoneNumber) {
        this.name = new Name(firstName,lastName);
        this.address = new Address(streetAddress, postalCode, city, province);
        this.phoneNumber = phoneNumber;
    }

    /**
     * accessors method to get the name
     * @return name
     */
    public Name getName() {
        return name;
    }

    /**
     * Accessors method to get the address.
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Mutators method to set the address
     * @param address 
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Accessors method to get the phone number.
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Mutators method to set the phone number.
     * @param phoneNumber 
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * toString method to display the details.
     * @return String
     */
    @Override
    public String toString() {
        return "Person{" + "name=" + name + 
                ", address=" + address + ", phoneNumber=" + phoneNumber + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Equals method for Person class.
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phoneNumber, other.phoneNumber)) {
            return false;
        }
        return true;
    }

    

   
    
}
