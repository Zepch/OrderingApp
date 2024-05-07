package fastfoodfinal;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

/** Represents a branch of the company
 * @author FDAA Group 4
 * @version 2.0
 * @since 2023-04-21
 */
public class Branch implements Serializable{
	/** 
     * Branch Name
     */
	private String branchName;
    /** 
     * Branch Location
     * default location is anywhere until set
     */
    private String location = "anywhere";
    /** Each branch contains a menu object
     * 
     */
    private Menu branchMenu;
    /** indicates if branch is open or not
     * boolean value
     */
    private boolean IsOpen;
    /** manager quota of branch
     * 
     */
    private int managerquota;
    /** total staff quota of branch
     * 
     */
    private int totalquota;
    /** ArrayList of Order objects for the branch
     * 
     */
    private ArrayList<Order> BranchOrders;

    
    /** Direct constuctor of new branch with all information available
     * 
     * @param branchName Branch Name
     * @param location Branch Location
     * @param menuList Branch Menu (Menu Object)
     * @param IsOpen Boolean for whether branch is open or not
     * @param totalquota Total number of staff that can be assigned to branch
     */
    public Branch(String branchName, String location, Menu menuList, boolean IsOpen, int totalquota) {
        this.branchName = branchName;
        this.location = location;
        this.branchMenu=menuList;
        this.IsOpen = IsOpen;
        this.totalquota = totalquota;
        this.BranchOrders = new ArrayList<Order>();}
    
    /** Constructor just requiring branch name
     * for situations where all the data for the branch attributes is not immediately available
     * @param branchName Branch Name
     */
    public Branch(String branchName){
        this.branchMenu=new Menu(branchName);
    	this.branchName=branchName;
    	this.IsOpen = true;
    	this.totalquota=0;
    	this.BranchOrders = new ArrayList<Order>();}

   
    
    /** Method to display(print to console) branch name
     * 
     */
    public void displayBranchName() {
        System.out.println("Branch Name: " + branchName);}
	
    /** Method to display staff from main staff list that are assigned to current branch
     * 
     * @param input Main StaffList
     */
    public void displayStaffList(StaffList input) {
    	List<GeneralStaff> temp = input.getStaffList();
        System.out.println(getBranchName() + " Branch Staff: ");
        for (GeneralStaff staff : temp) {
        	if(staff.getBranchName().equals(getBranchName())) {
        		System.out.println(staff.getName() + " - " + staff.getStaffLoginID() + " - " + staff.getRole() + " - " + staff.getGender() + " - " + staff.getAge() + " - " + staff.getBranchName());
        	}}}
    
    /** Method to display branch menu
     * 
     */
    public void displayBranchMenu(){
      getBranchMenu().displayMenu();}
    
    /** Method  to display branch orders awaiting processing
     * 
     */
    public void displayNewOrders() {
    	System.out.println("New Orders:");
        for (Order orders : BranchOrders) {
        	if(orders.getStatus().equals("Order Processing")) {
        		System.out.println(orders.getOrderNo());
        	}}}
    /** Method to display branch orders ready for collection
     * 
     */
    public void displayPickupableOrders() {
    	System.out.println("Orders ready for collection:");
        for (Order orders : BranchOrders) {
        	if(orders.getStatus().equals("Ready for Pickup")) {
        		System.out.println(orders.getOrderNo());
        	}}}
    
    /** Method to display completed/collected branch orders
     * 
     */
    public void displayCompletedOrders() {
    	System.out.println("Completed Orders:");
        for (Order orders : BranchOrders) {
        	if(orders.getStatus().equals("Completed")) {
        		System.out.println(orders.getOrderNo());
        	}}}
    /** Method to display cancelled branch orders(customer did not pick up in time)
     * 
     */
    public void displayCancelledOrders() {
    	System.out.println("Cancelled Orders:");
        for (Order orders : BranchOrders) {
        	if(orders.getStatus().equals("Cancelled")) {
        		System.out.println(orders.getOrderNo());
        	}}}
    
    /** calculation of manager quota based on number of general staff in branch
     * from our main StaffList
     * @param input Main StaffList
     */
    public void calculatemanagerquota(StaffList input) {
    	int count=0;
    	List<GeneralStaff> temp = input.getStaffList();
    	for (GeneralStaff staff : temp) {
        	if(staff.getBranchName().equals(getBranchName())) {
        		count++;}}
    	if(9<=count && count<=15) {
    		this.managerquota=3;}
    	else if(5<=count && count<=8) {
    		this.managerquota=2;}
    	else if(1<=count && count<=4) {
    		this.managerquota=1;}}
    
    /** Get branch name
     * 
     * @return branch name
     */
    public String getBranchName() {
        return branchName;}
    /** Get is open status
     * 
     * @return whether branch is open
     */
    public boolean getIsOpen() {
    	return IsOpen;}
    /** Get branch menu
     * 
     * @return branch menu (menu object)
     */    
    public Menu getBranchMenu() {
		return branchMenu;}
    /** Get branch manager quota
     * 
     * @return manager quota
     */
    public int getManagerQuota() {
    	return managerquota;}
    /** Get total staff quota of branch
     * 
     * @return total staff quota of branch
     */
    public int getTotalQuota() {
    	return totalquota;}
    /** Get orders of branch
     * 
     * @return ArrayList of all orders for branch
     */
    public ArrayList<Order> getBranchOrders(){
    	return BranchOrders;
    }
    
    /** set branch name
     * 
     * @param branchName New branch name
     */
    public void setBranchName(String branchName){
        this.branchName = branchName;}
    /** set branch menu
     * 
     * @param branchMenu New branch menu (menu object)
     */
	public void setBranchMenu(Menu branchMenu) {
		this.branchMenu = branchMenu;}
	/** set open status
	 * 
	 * @param isopen new open status
	 */
	public void setIsOpen(boolean isopen) {
		this.IsOpen=isopen;}
  
	/** set total staff quota for branch
	 * 
	 * @param total New staff quota for branch
	 */
	public void setTotalQuota(int total) {
    	this.totalquota=total;}
	/** set branch orders
	 * 
	 * @param yee New ArrayList of orders for branch
	 */
	public void setBranchOrders(ArrayList<Order> yee) {
		this.BranchOrders=yee;
	}

  



  
}