
/* Name: Harshita Aka Dharna Mistry
 * Name : Sheenam Kamal
 * Name : Kour Sanminder
 * JavaProject
 *
 * description:A java file that search stored phone Numbers from file. 
 */
package javaproject;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Harshita Mistry
 */
public class SearchPhoneNumbers {
    String fileName ="SignIn.dat";
    String string; 
    String stringTwo;
    int counter=0;
    String firstName;
    
    String billAmt,phoneNum,phNumTwo; 
    
    /**
     * a function to search details from file.
     * @param searchWord 
     */
    public void searchFile(String searchWord){  
        try {  
            
            BufferedReader br = new BufferedReader(new FileReader(fileName));  
              
            while((string = br.readLine()) != null){  
                String starr[] = string.split(" ");  
                  
                for (String string2 : starr) {  
                    if(string2.matches(searchWord)){
                        counter++;
                        Scanner reader = new Scanner(fileName);
                        phoneNum = br.readLine();
                      
                    } 
                }
                
            }
            if(counter>=1)
                {
                    
                    DisplayOrders dos = new DisplayOrders();
                    dos.setVisible(true);
                    signIn s = new signIn();
                    s.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, 
                            "Sorry you are not registered!! Please register "
                                    + "youself\n"
                                    + "Thank You");  
                }
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
    }  
     public void pickUpOrder(String searchWord){  
         String custNum = null;
        try {  
            
            BufferedReader br = new BufferedReader(new FileReader(fileName));  
              
            while((string = br.readLine()) != null){  
                String starr[] = string.split(" ");  
                  
                for (String string2 : starr) {  
                    if(string2.matches(searchWord)){
                        counter++;
                        Scanner reader = new Scanner(fileName);
                        phoneNum = br.readLine();
                      custNum=phoneNum;
                    } 
                }
                
            }
            if(counter>=1)
                {
                    BufferedReader brTwo = new BufferedReader(new FileReader("customerPhoneNumbers.dat"));
                    while((phoneNum = brTwo.readLine()) != null){  
                String starr[] = phoneNum.split(" ");  
                  
                for (String string2 : starr) {  
                    if(string2.matches(searchWord)){
                        counter++;
                        Scanner readerTwo = new Scanner("customerPhoneNumbers.dat");
                        
                        firstName= brTwo.readLine();
                        billAmt = brTwo.readLine();
                        
                        
                        

                      
                    } 
                }
                
            }
                       
                    JOptionPane.showMessageDialog(null, 
                            "Customer Name: "+firstName+"\n"+
                            "Bill : "+billAmt+"\n"
                            ,"Customer Pickup",
                            JOptionPane.INFORMATION_MESSAGE);
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, 
                            "Your Order was not found!"
                                    + "please check again\n"
                                    + "Thank You");  
                }
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
          
    }  
      
     
    
    
}
