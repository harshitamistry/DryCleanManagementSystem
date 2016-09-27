/* Name: Harshita Aka Dharna Mistry
 * Name : Sheenam Kamal
 * Name : Kour Sanminder
 * JavaProject
 *
 * description:A java application to validate all the textboxes 
 * and and functions to read/write in file.
 */

package javaproject;


import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.*;

/**
 *
 * @author Harshita Mistry
 */
public class Functionality {
   
    static Scanner userInput = new Scanner(System.in);
    static int counter=0;
   
    
   
    
    static int uipCount=0;
    
    /**
     * A function to write the data in .dat file.
     * @param ip
     * @throws IOException 
     */
    public void storePhoneNumbers(String ip) throws IOException
    {
        
    BufferedWriter bw = null;
    try
    {
     bw = new BufferedWriter(new FileWriter("customerPhoneNumbers.dat",true));
     bw.write(ip);
     bw.newLine();
     bw.flush();
      } catch (IOException ioe) {
     ioe.printStackTrace();
      } 
    finally {                       
     if (bw != null) {
        bw.close();
     } 
    }
    
    }
    
    public void storeOrders(String ip) throws IOException
    {
        
    BufferedWriter bwTwo = null;
    try
    {
     bwTwo = new BufferedWriter(new FileWriter("customerOrders.dat",true));
     bwTwo.write(ip);
     bwTwo.newLine();
     bwTwo.flush();
      } catch (IOException ioe) {
     ioe.printStackTrace();
      } 
    finally {                       
     if (bwTwo != null) {
        bwTwo.close();
     } 
    }
    
    }
    
    public void storeNumbers(String ip) throws IOException
    {
        
    BufferedWriter bw = null;
    try
    {
     bw = new BufferedWriter(new FileWriter("SignIn.dat",true));
     bw.write(ip);
     bw.newLine();
     bw.flush();
      } catch (IOException ioe) {
     ioe.printStackTrace();
      } 
    finally {                       
     if (bw != null) {
        bw.close();
     } 
    }
    
    }
    
    
    public void storeOrderNums(String ip) throws IOException
    {
        
    BufferedWriter bwThree = null;
    try
    {
     bwThree = new BufferedWriter(new FileWriter("Orders.dat",true));
     bwThree.write(ip);
     bwThree.newLine();
     bwThree.flush();
      } catch (IOException ioe) {
     ioe.printStackTrace();
      } 
    finally {                       
     if (bwThree != null) {
        bwThree.close();
     } 
    }
    
    }
    
    /**
     * A function to check whether user input doesn't contain number
     * or space.
     * @param ip 
     */
    public void isNotDigitOrSpace(String ip)
    {
     int i;
    counter=0;
    
  
        for(i=0;i<ip.length();i++)
        {
           if(ip.charAt(i)==' ' || Character.isDigit(ip.charAt(i)))
            {
                
                counter++;
            }
            
        }
        if(counter>=1)
        {
           JOptionPane.showMessageDialog(null,"Please don't enter number or "
                   + "white spaces",
                   "Input Error message",
                   JOptionPane.INFORMATION_MESSAGE);
        }
    }   
    /**
     * Checks the length of SIN.
     * @param len 
     */
    public static void checkLengthSIN(String len)
    {
        counter=0;
        int length = len.length();
        int i;
        if(length>9 || length<9)
        {
            counter++;
        }
        for(i=0;i<length;i++)
        {
            if(!Character.isDigit(len.charAt(i)))
            {
                counter++;
            }
        }
        
         if(counter>=1)
        {
            JOptionPane.showMessageDialog(null,"Please enter valid 9 digit "
                    + "SIN number",
                    "Input Error message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    /**
     * Checks the length of PhoneNumber.
     * @param len 
     */
    public static void checkLengthPhone(String len)
    {
        counter=0;
        int i;
        int length=len.length();
        if(length>10 || length<10)
        {
            counter++;
        }
       
        for(i=0;i<length;i++)
        {
            if(!Character.isDigit(len.charAt(i)))
            {
                counter++;
            }
        }
         if(counter>=1)
        {
            JOptionPane.showMessageDialog(null,"Please enter valid 10 "
                    + "digit phone number",
                    "Input Error message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    /**
     * checks if user enters valid postal code or not.
     * @param pc 
     */
    public static void checkPostal(String pc)
    {
        int i;
        counter=0;
        if(pc.length()>6 || pc.length()<6)
        {
            counter++;
        }
        for(i=0;i<pc.length();i=i+2)
        {
         if(!Character.isLetter(pc.charAt(i)))
         {
             counter++;
         }
        }
        for(i=1;i<pc.length();i=i+2)
        {
         if(!Character.isDigit(pc.charAt(i)))
         {
             counter++;
         }
        }
        
        if(counter>=1)
        {
            JOptionPane.showMessageDialog(null,"Please enter valid six digit "
                    + "long postal code",
                    "Input Error message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    /**
     * checks if user enters valid province or not.
     * @param f 
     */
    public static void checkLength(String f)
    {
        counter=0;
        int length =f.length();
        if(length>2 || length<2)
        {
            counter++;
        }
        for(int i=0;i<length;i++)
        {
         if(!Character.isLetter(f.charAt(i)))
         {
             counter++;
         }
        }
         if(counter>=1)
        {
            JOptionPane.showMessageDialog(null,"Please enter two characters"
                    + " long province",
                    "Input Error message",
                    JOptionPane.INFORMATION_MESSAGE);
           
        }
    }
    
    
    
}
