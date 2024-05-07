package fastfoodfinal;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

/**
 * Represents a collection of payment methods accepted by the fast food system.
 * Provides functionality to manage supported payment methods and facilitate customer payment selection.
 */
public class PaymentMethods implements Serializable {
	
	private ArrayList<String> paymentmethods;
	/**
     * Creates a new empty payment arraylist.
     */
	public PaymentMethods() {
    this.paymentmethods = new ArrayList<String>();
    }
	
	    /**
        *add a new payment methos
        *@param pay payment type in String
        */
	    public void addPaymentMethods(String pay){
		this.paymentmethods.add(pay);}
	
	    /**
        *remove a new payment methos
        *@param pay payment type in String
        */
	    public void removePaymentMethods(String pay){
		this.paymentmethods.remove(pay);}
	
		/**
        *show the different types of payment
        * Using standard output stream 
        * for giving the output.
        * @return null
        */    
	     public void displayPaymentMethods() {
		 System.out.println("Payment Methods:");
		 for (String types : paymentmethods) { 
			 System.out.println(types);}
		 }
	
		 /**
        *show the different types of payment for the customer to choose what methods to pay in
        * Using standard output stream 
        * for giving the output.
        * @return null
        */    
	public void makePayment() {
		Scanner scanner = new Scanner(System.in);
		int have=0;
		System.out.println("Enter the payment type:");
        String itemName = scanner.nextLine();
        for (String types : paymentmethods) { 
        	have=0;
            if ((itemName.toLowerCase()).equals(types.toLowerCase())) {
                have=1;
                System.out.println("Payment Method "+types+" successfully selected:");
                System.out.println("Please proceed to make payment:");
                System.out.println("Payment Successful:");         
                return;}}
        if(have==0) {
        	System.out.println("Invalid Payment Method. Please try again.");
            return;}}

		/**
        *get different types of payment methods
        * @return payment methods
        */   
	public ArrayList<String> getPaymentMethods() {
		return paymentmethods;}
	
		/**
        *set list of payment methods
        *@param pay list of payment methods
        */   
	public void setPaymentMethods(ArrayList<String> pay) {
		this.paymentmethods=pay;}	
}