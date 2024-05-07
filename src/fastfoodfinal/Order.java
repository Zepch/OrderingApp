package fastfoodfinal;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.io.Serializable;

/**
 * Represents a customer's food order within the fast food system. Manages the items in the order, 
 * order details, status, and automatic cancellation after a timeout period.
 */
public class Order extends Food implements Serializable{
	private ArrayList<Food> cart;
	private String Description;
	private int orderno;
	private String Status;
	private boolean Takeout;
	private transient ScheduledExecutorService scheduler;
	public static int ordercounter = 1;
	private double totalprice;
	
    /**
     * Constructs a new Order with an empty cart, default description, unique order number,
     * initial "Order Processing" status, dine-in option, and a total price of 0.
     */
	public Order() {   
    	this.cart = new ArrayList<Food>();
        this.Description = "Nil";
        this.orderno=ordercounter;
        this.Status="Order Processing";
        this.Takeout=false;
        this.totalprice=0.0;}
	
        /**
     * Starts a timer that automatically changes the order status to "Cancelled" 
     * if it remains as "Ready for Pickup" for more than 30 seconds. 
     * Also shuts down the scheduler if the order status changes to "Completed".
     */
	public void startScheduler() {
	    scheduler = Executors.newScheduledThreadPool(1);
	    scheduler.schedule(() -> {
	        if (this.Status.equals("Ready for Pickup")) {
	            this.Status = "Cancelled";
	            scheduler.shutdown();}
	        else if (this.Status.equals("Completed")) {
	            scheduler.shutdown();}

	    }, 30, TimeUnit.SECONDS);
	}

	    /**
     * Adds a food item to the order cart.
     * @param food The Food object to add.
     */
	public void addItemtocart(Food food) {
        cart.add(food);}

       /**
     * Removes a food item from the order cart.
     * @param food The Food object to remove.
     */
    public void removeItemfromcart(Food food) {
        cart.remove(food);}

        /**
        *display order that was made after processing
        ** Using standard output stream 
        * for giving the output.
        * @return null
        */
    public void displayorder() {
    	System.out.println("Order Number: " + this.getOrderNo());
        for (Food item : cart) {
            System.out.println(item.getQuantity()+ " - " +item.getName() + " - " + item.getPrice() + " - " + item.getItemCategory());}
        System.out.println("Additional Requests: ");
        System.out.println(this.getDescription());
    }

    /**
     * Calculates the total price of the order based on item prices and quantities.
     * @return The total price of the order.
     */
    public double calculateprice() {
    	double total=0.0;
        for (Food item : cart) {
            total+=(item.getPrice()*item.getQuantity());}
        return total;
    }
    
    
        /**
        *set order number
        * @param n order number
        */
    public void setOrderNo(int n) {
        this.orderno = n;}

        /**
        *get order number
        * @return order number
        */
    public int getOrderNo() {
        return orderno;}
    
        /**
        *set order
        * @param f list of food
        */
    public void setOrder(ArrayList<Food> f) {
        this.cart = f;}

        /**
        *get order
        * @return cart containing list of food
        */
    public ArrayList<Food> getOrder() {
        return cart;}
    
        /**
        *set description of order
        * @param description used to describe the order in String
        */
    public void setDescription(String description) {
        this.Description = description;}

         /**
        *get description
        * @return description of order
        */
    public String getDescription() {
        return Description;}

        /**
        *set status of order
        * @param status used to describe the status of order in String
        */
    public void setStatus(String status) {
        this.Status = status;}

        /**
        *get status
        * @return status of order
        */
    public String getStatus() {
        return Status;}
    
        /**
        *set takout or dine in of order
        * @param takeout in boolean 1 to takeout 2 to dinein
        */
    public void setTakeout(boolean takeout) {
        this.Takeout = takeout;}

        /**
        *get takeout status
        * @return takeout or dine in in boolean
        */
    public boolean getTakeout() {
        return Takeout;}
    
         /**
        *set order total price
        */
    public void setTotalPrice() {
        this.totalprice = this.calculateprice();}

        /**
        *get order total price
        *@return total price
        */
    public double getTotalPrice() {
        return totalprice;}
    
        /**
        *get order counter to check for number of orders
        *@return ordercounter
        */
    public static int getOrdercounter() {
    	return ordercounter;
   
    }
	
}
