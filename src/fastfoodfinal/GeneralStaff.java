package fastfoodfinal;
import java.util.Scanner;
import java.io.Serializable;
/**
 * Represents a general staff member within the fast food system. Inherits basic 
 * information (name, gender, age) from the Human class.
 */
public class GeneralStaff extends Human implements Serializable{
	private String StaffLoginID;
	private String BranchName;
	private char role;
	private String pass;
	
  /**
     * Creates a GeneralStaff object with specified details.
     * @param name The staff member's full name.
     * @param gender The staff member's gender ('M', 'F', or other if applicable).
     * @param age The staff member's age in years.
     * @param loginid The staff member's unique login ID.
     * @param branch The name of the branch they work at.
     * @param role The staff member's role (e.g., 'C' for cashier, 'K' for kitchen staff).
     * @param pass The staff member's password.
     */
  public GeneralStaff(String name, char gender, int age, String loginid, String branch, char role, String pass) {
      super(name, gender, age);
      this.StaffLoginID = loginid;
      this.BranchName = branch;
      this.role = role;
      this.pass = pass;
    }

    /**
     * Creates a new GeneralStaff object with default values.
     */
  public GeneralStaff() {}
  
//getters
  public String getStaffLoginID() { return StaffLoginID; }
  public String getBranchName() { return BranchName; }
  public char getRole() { return role; }
  public String getpass() { return pass; }

  /** 
   * this is to check if login is valid, and returns staff object
   * @param  inputLoginID
   * @param  pass
   * @param  stafflist
   * @return staff object
   */
  public GeneralStaff checkLogin(String inputLoginID, String pass,	StaffList staffList) {
    for (GeneralStaff staff : staffList.getStaffList()) { 
        if (staff.getStaffLoginID().equals(inputLoginID) && staff.getpass().equals(pass)) {
            return staff; 
        }
    }

    return null; // Return null if login failed
}
  // setters
  public void setStaffLoginID(String loginid) { this.StaffLoginID = loginid; }
  public void setBranchName(String branch) { this.BranchName = branch; }
  public void setrole(char role) { this.role = role; }
  public void setpass(String pass) { this.pass = pass; }
  
  // Display order list
  /** 
   * this is to display new orders when newly created
   * @param  b Branchlist consisting of all branches
   * @param  branchn branch name in String of the current staff
   */
  public static void displayneworder(BranchList b, String branchn) {
	  for(Branch branches : b.getBranchList()) {
		  if(branches.getBranchName().equals(branchn)){
			  branches.displayNewOrders();}}}

  
  /** 
   * this is to display orders that are ready
   * @param  b Branchlist consisting of all branches
   * @param  branchn branch name in String of the current staff
   */
  public static void displayreadyorder(BranchList b, String branchn) {
	  for(Branch branches : b.getBranchList()) {
		  if(branches.getBranchName().equals(branchn)){
			  branches.displayPickupableOrders();}}}
  
    /** 
   * this is to display orders that are completed
   * @param  b Branchlist consisting of all branches
   * @param  branchn branch name in String of the current staff
   */
  public static void displaycompletedorder(BranchList b, String branchn) {
	  for(Branch branches : b.getBranchList()) {
		  if(branches.getBranchName().equals(branchn)){
			  branches.displayCompletedOrders();;}}}
  
  /** 
   * this is to display orders that are cancelled
   * @param  b Branchlist consisting of all branches
   * @param  branchn branch name in String of the current staff
   */
  public static void displaycancelledorder(BranchList b, String branchn) {
	  for(Branch branches : b.getBranchList()) {
		  if(branches.getBranchName().equals(branchn)){
			  branches.displayCancelledOrders();}}}
  
  /** 
   * this is to display specific order details
   * @param  b Branchlist consisting of all branches
   * @param  branchn branch name in String of the current staff
   */
  public static void showorderdetails(BranchList b, String branchn) {  
    Scanner scanner = new Scanner(System.in);
	  int have=0;
	  System.out.println("Enter the order number:");
      int orderno = Integer.parseInt(scanner.nextLine());
      
      for(Branch branches : b.getBranchList()) {
		  if(branches.getBranchName().equals(branchn)){
			  for(Order orders : branches.getBranchOrders()) {
				  if (orders.getOrderNo()==orderno) {
		              have=1;
		              System.out.println("Order Details: ");
		              orders.displayorder();
		              System.out.println("Order Status: "+orders.getStatus());
		              return;}}}}
      if(have==0) {
      	System.out.println("Order not found. Please try again.");
          return;}}
  
  
  /** 
   * this is to process specific order and change status of order to ready to pickup
   * @param  b Branchlist consisting of all branches
   * @param  branchn branch name in String of the current staff
   */
  public static void processorder(BranchList b, String branchn) {  
    Scanner scanner = new Scanner(System.in);
	  int have=0;
	  System.out.println("Enter the order number:");
      int orderno = Integer.parseInt(scanner.nextLine());
      
      for(Branch branches : b.getBranchList()) {
		  if(branches.getBranchName().equals(branchn)){
			  for(Order orders : branches.getBranchOrders()) {
				  if (orders.getOrderNo()==orderno) {
		              have=1;
		              System.out.println("Order Processed ");
		              orders.setStatus("Ready for Pickup");
		              orders.startScheduler();
		              return;}}}}
      if(have==0) {
      	System.out.println("Order not found. Please try again.");
          return;}}


}