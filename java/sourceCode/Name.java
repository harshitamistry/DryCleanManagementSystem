/* Name: Harshita Aka Dharna Mistry
 * Name : Sheenam Kamal
 * Name : Kour Sanminder
 * JavaProject
 *
 * fileName: Name.java
 */

package javaproject;

import java.util.Objects;

/**
 *
 * @author Harshita Mistry
 */
public final class Name {
    private  String firstName;
    private  String lastName;

    /**
     * Construct a name object with given first name and last name.
     * @param firstName
     * @param lastName 
     */
    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**accessors method for the firstName.
    *@return firstName of the person.
    */
    public String getFName()
    {
        return firstName;
    }
    
    /**
     * accessors method for the lastName.
     * @return lastName of the person.
     */
     
    public String getLName()
    {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gives the details about Name
     * @return String
     */
    @Override
    public String toString() {
        return "Name{" + "firstName=" + firstName +
                ", lastName=" + lastName + '}';
    }

  /**
   * equals method for Name class
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
        final Name other = (Name) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.firstName);
        hash = 19 * hash + Objects.hashCode(this.lastName);
        return hash;
    }
    
    
    
}
