package fastfoodfinal;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

/** Customer class
 * @author FDAA Group 4
 * @version 2.0
 * @since 2023-04-21
 */
public class Customer extends Human implements Serializable{
	
	/** each customer contains has 1 order
	 * 
	 */
	private Order customerorder;

	/** constructor using the super class constructor
	 * additionally creating a new order object for each customer
	 * @param name Name of customer
	 * @param gender Gender of customer
	 * @param age Age of customer
	 */
	public Customer(String name, char gender, int age) {
        super(name, gender, age);
        this.customerorder=new Order();
    }
	
	/** method that displays the menu of the branch the customer is currently at
	 * 
	 * @param m Menu of relevant branch
	 */
	public void displayMenuItems(Menu m) {
		Menu temp = m;
		temp.displayMenu();}
	/** Method that adds an item from the branch menu to their order
	 * includes handling of multiple errors
	 * 1) Item not found in branch menu
	 * 2) Item being added already exists in their order
	 * 3) Item Quantity being 0 or negative
	 *
	 * @param m Menu of relevant branch
	 */
    public void addItemToOrder(Menu m) {
        Scanner scanner = new Scanner(System.in);
    	int have=0;
    	System.out.println("Enter the item name:");
        String itemName = scanner.nextLine();
        
        for (Food items : m.getMenu()) { 
        	have=0;
            if ((items.getName()).toLowerCase().equals(itemName.toLowerCase())) {
                have=1;
                break;}}
        if(have==0) {
        	System.out.println("Item not found in menu. Please try again.");
            return;}
        
        for (Food items : customerorder.getOrder()) { 
            if ((items.getName().toLowerCase()).equals(itemName.toLowerCase())) {
                System.out.println("Item already exists in order! ");
                return;}}
         
        System.out.println("Enter the quantity:");
        int quantity = Integer.parseInt(scanner.nextLine());
        
        if(quantity==0) {
        	System.out.println("Quantity of items to be added is 0. Please try again.");
            return;}
        
        else if(quantity<0) {
            System.out.println("Invalid Quantity, Please try again.");
            return;}
        
        else {
        	for (Food items : m.getMenu()) { 
        		if ((items.getName()).toLowerCase().equals(itemName.toLowerCase())) {
        			Food toadd = new Food(items.getName(),items.getPrice(),items.getItemCategory());
        			toadd.setQuantity(quantity);
        			customerorder.addItemtocart(toadd);
        			System.out.println("Item added");
        			break;}}}
        return;
        }
        
    /** Method that edits an item from the customers order
	 * includes handling of multiple errors
	 * 1) Item not found in order
	 * 2) New quantity being 0 deletes item
	 * 3) New Quantity being negative
	 *
	 * 
	 */
    public void editOrderItem() {
        Scanner scanner = new Scanner(System.in);
    	int have=0;
    	System.out.println("Enter the item name to edit:");
        String itemName = scanner.nextLine();
        
        for (Food items : customerorder.getOrder()) { 
        	have=0;
            if ((items.getName()).toLowerCase().equals(itemName.toLowerCase())) {
                have=1;
                break;}}
        if(have==0) {
        	System.out.println("Item not found. Please try again.");
            return;}
         
        System.out.println("Enter the new quantity:");
        int quantity = Integer.parseInt(scanner.nextLine());
        
        if(quantity==0) {
        	System.out.println("New Quantity is 0. Deleting Item.");
        	for (Food items : customerorder.getOrder()) { 
                if ((items.getName()).toLowerCase().equals(itemName.toLowerCase())) {
                    customerorder.removeItemfromcart(items);
                    break;}}}
        else if(quantity<0) {
            System.out.println("Invalid Quantity, Please try again.");
            return;}
        else {
        	for (Food items : customerorder.getOrder()) { 
                if ((items.getName()).toLowerCase().equals(itemName.toLowerCase())) {
                    items.setQuantity(quantity);
                    break;}}}
        return;
    }
    
    /** Method that deletes an item from the customers order
	 * includes handling of errors where item is not found in order
	 * 
	 */
    public void deleteOrderItem() {
        Scanner scanner = new Scanner(System.in);
    	int have=0;
    	System.out.println("Enter the item name to delete:");
        String itemName = scanner.nextLine();
        
        for (Food items : customerorder.getOrder()) { 
        	have=0;
            if ((items.getName()).toLowerCase().equals(itemName.toLowerCase())) {
                have=1;
                break;}}
        if(have==0) {
        	System.out.println("Item not found. Please try again.");
            return;}
        for (Food items : customerorder.getOrder()) { 
            if ((items.getName()).toLowerCase().equals(itemName.toLowerCase())) {
            	System.out.println(items+"Successfully removed");
                customerorder.removeItemfromcart(items);
                break;}}
        }
    /** method that allows customer to choose if thier order is for dining in or takeout
     * 
     */
    public void chooseTakeawayOrDineIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Takeaway (T) or Dine-In (D)?");
        char c = scanner.next().charAt(0);
        if(c=='t' || c=='T') {
        	customerorder.setTakeout(true);}
        else if(c=='d' || c=='D') {
        	customerorder.setTakeout(false);}
        else {
        	System.out.println("Invalid Choice, try again.");
        	return;}
    }
    
    /** method that passes customer order to the relevant branch
     * 
     * @param branchorders ArrayList of orders of relevant branch
     */
    public void checkoutCart(ArrayList<Order> branchorders) {
        System.out.println("Successfully Checked Out");
        branchorders.add(this.customerorder);
        
    }
    
    /** method that prints the receipt of the customer's order
     * 
     */
    public void printReceipt() {
        // implementation
    	System.out.println("Receipt:");
        customerorder.displayorder();
        System.out.println("Total Price:");
        System.out.printf("$%.2f%n", customerorder.calculateprice());  
    }
    /** method that allows customer to check the status of their order at the relevant branch
     * 
     * @param branchorders ArrayList of orders of relevant branch
     */
    public void checkorderstatus(ArrayList<Order> branchorders) {
        Scanner scanner = new Scanner(System.in);
    	int have=0;
    	System.out.println("Enter your order number:");
        int orderno = Integer.parseInt(scanner.nextLine());
        for (Order orders : branchorders) { 
        	have=0;
            if (orders.getOrderNo()==orderno) {
                have=1;
                System.out.println("Order Status: " + orders.getStatus());
                return;}}
        if(have==0) {
        	System.out.println("Order not found. Please try again.");
            return;}}
    /** method that allows customers to "collect" their food and updates the ArrayList of orders in the relevant branch
     * 
     * @param branchorders ArrayList of orders of relevant branch
     */
    public void collectFood(ArrayList<Order> branchorders) {
        Scanner scanner = new Scanner(System.in);
    	int have=0;
    	System.out.println("Enter your order number:");
        int orderno = Integer.parseInt(scanner.nextLine());
        for (Order orders : branchorders) { 
        	have=0;
            if (orders.getOrderNo()==orderno) {
                have=1;
                if(orders.getStatus().equals("Ready for Pickup")) {
                	System.out.println("Thank you for waiting, enjoy your food");
                	orders.setStatus("Completed");
                	return;}
                else if(orders.getStatus().equals("Order Processing")) {
                	System.out.println("Order is still being processed, please wait");
                	return;}}}
        if(have==0) {
        	System.out.println("Order not found. Please try again.");
            return;}
        }
    
    public void SetOrder(Order o) {
    	this.customerorder=o;}
    
    public Order GetOrder() {
    	return customerorder;}

        
        
        
    }
