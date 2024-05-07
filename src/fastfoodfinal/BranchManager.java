package fastfoodfinal;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;
/** Represents the BranchManager role in the company
 * @author FDAA Group 4
 * @version 2.0
 * @since 2023-04-21
 */
public class BranchManager extends GeneralStaff implements Serializable{
	
	/**
	 * Constructor that uses the superclass constructor
	 * @param name The managers name
	 * @param gender The managers gender
	 * @param age The managers age
	 * @param loginid The managers loginID
	 * @param branch  The managers branch
	 * @param role	The managers role
	 * @param pass The managers account password
	 */
	public BranchManager(String name, char gender, int age, String loginid, String branch, char role, String pass) {
	      super(name, gender, age, loginid, branch, role, pass);}
	/** default constructor
	 * 
	 */
	public BranchManager() {}
	
	/** display staff list of branch that manager is assigned to
	 * 
	 * @param a Main staff list
	 */
	public void displayStaffList(StaffList a) {
		List<GeneralStaff> temp = a.getStaffList();
		System.out.println("Displaying " + getBranchName() + " Branch Staff");
        for (GeneralStaff staff : temp) {
        	if(staff.getBranchName().equals(getBranchName())) {
        		System.out.println(staff.getName() + " - " + staff.getStaffLoginID() + " - " + staff.getRole() + " - " + staff.getGender() + " - " + staff.getAge() + " - " + staff.getBranchName());}
    }}
    
	/** display menu of branch that manager is assigned to
	 * 
	 * @param BranchList Main branch list
	 */
    public void displayMenu(List<Branch> BranchList) {
    	for (Branch place : BranchList) {
    		if(place.getBranchName().equals(getBranchName())) {
    			place.displayBranchMenu();;}}}
    
    
    /** add item to menu of branch object
     * includes error handling for adding objects with the same name
     * @param place branch object to add item to
     */
    public static void addtoMenu(Branch place) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter item name to add: ");
		String name= scanner.nextLine();
		
		for (Food items : place.getBranchMenu().getMenu()) { 
            if ((items.getName().toLowerCase()).equals(name.toLowerCase())) {
                System.out.println("Item already exists! ");
                return;}}

		System.out.println("Enter Price: ");
		double price = scanner.nextDouble();

		System.out.println("Enter item category: ");
		String cat = scanner.next();

		Food item = new Food(name,price,cat);
		place.getBranchMenu().addItem(item);}
    
    /** remove item to menu of branch object
     * includes error handling for removing non-exisitent items
     * @param place branch object to remove item from
     */
    public static void removefromMenu(Branch place) {
    	int have=0;
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter item name to remove: ");
		String name= scanner.nextLine();
		
		for (Food items : place.getBranchMenu().getMenu()) { 
            if ((items.getName().toLowerCase()).equals(name.toLowerCase())) {
                have=1;
                place.getBranchMenu().removeItem(items);
                break;}}
		if(have==0) {
			System.out.println("Item does not exist ");
			return;}
		}
		
    /** edit item in menu of branch object
     * includes error handling for editing non-exisitent items
     * @param place branch object to edit item
     */
    public static void editMenu(Branch place) {
    	int have=0;
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter item name to edit: ");
		String name= scanner.nextLine();
		for (Food items : place.getBranchMenu().getMenu()) { 
            if ((items.getName().toLowerCase()).equals(name.toLowerCase())) {
                have=1;
                System.out.println("Enter new item name: ");
        		String name1= scanner.next();
        		scanner.nextLine();
                System.out.println("Enter new Price: ");
        		double price = scanner.nextDouble();

        		System.out.println("Enter new item category: ");
        		String cat = scanner.next();

        		Food item = new Food(name1,price,cat);
                place.getBranchMenu().updateExistingItem(items,item);
                break;}}
		if(have==0) {
			System.out.println("Item does not exist ");
			return;}
    	
    	} 

}
