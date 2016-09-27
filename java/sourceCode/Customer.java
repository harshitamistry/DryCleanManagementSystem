
/* Name: Harshita Aka Dharna Mistry
 * Name : Sheenam Kamal
 * Name : Kour Sanminder
 * JavaProject
 *
 * description:A java application to check whether a customer is
 * registered or not.
 */

package javaproject;

/**
 *
 * @author admin
 */
public class Customer extends Person {
    private boolean registered;

    public Customer(boolean registered, String firstName, String lastName) {
        super(firstName, lastName);
        this.registered = registered;
    }

    public Customer(boolean registered, String firstName, String lastName, String streetAddress, String postalCode, String city, String province, String phoneNumber) {
        super(firstName, lastName, streetAddress, postalCode, city, province, phoneNumber);
        this.registered = registered;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    @Override
    public String toString() {
        return "Customer{" + "registered=" + registered + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.registered != other.registered) {
            return false;
        }
        return true;
    }
    
}
