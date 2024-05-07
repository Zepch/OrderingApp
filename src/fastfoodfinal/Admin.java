package fastfoodfinal;
import java.util.Scanner;
import java.util.List;
import java.util.Iterator;
import java.io.Serializable;

/** Represents the admin role in the company
 * @author FDAA Group 4
 * @version 2.0
 * @since 2023-04-21
 */
public class Admin extends GeneralStaff implements Serializable{
	

	/** Constructor that uses the superclass constructor, just with setting the role and branch specifically for admins
	 * 
	 * @param name The admin's name
	 * @param gender The admin's gender
	 * @param age The admin's age
	 * @param loginid The admin's loginID
	 * @param branch 
	 * @param role
	 * @param pass The admin's account password
	 */

    public Admin(String name, char gender, int age, String loginid, String branch, char role, String pass) {
        super(name, gender, age, loginid, branch, role, pass);
        this.setrole('A');
        this.setBranchName("ADMIN");}
    
    /** Default constructor
     * 
     */
    public Admin() {}

    /** method for addition of object to StaffList
     * also includes error handling for already existing name
     * 
     * @param a Our main StaffList
     */
  
    public static void addStaffAccount(StaffList a) {
        // implementation
		Scanner scanner = new Scanner(System.in);

		System.out.println("Name");
		String aname = scanner.nextLine();
		
		for (GeneralStaff staff : a.getStaffList()) { 
            if ((staff.getName().toLowerCase()).equals(aname.toLowerCase())) {
                System.out.println("Staff already exists! ");
                return;}}

		System.out.println("Gender");
		char agen= scanner.next().charAt(0);
		agen = Character.toUpperCase(agen);

		System.out.println("Age");
		int aage = scanner.nextInt();

		System.out.println("LoginID");
		String algid = scanner.next();

		System.out.println("Branch");
		String abr = scanner.next();
		abr = abr.toUpperCase();

		System.out.println("Role");
		char arole = scanner.next().charAt(0);
		arole = Character.toUpperCase(arole);

		GeneralStaff temp = new GeneralStaff(aname, agen, aage, algid, abr, arole, "password");
		a.addStaff(temp);
		System.out.println("Added " + temp.getName() + " - " + temp.getStaffLoginID() + " - " + temp.getRole() + " - " + temp.getGender() + " - " + temp.getAge() + " - " + temp.getBranchName());
    }
    
    /** method for removal of object from StaffList
     * also includes error handling for non-existent name
     * 
     * @param a Our main StaffList
     */
    
    public static void removeStaffAccount(StaffList a) {
        // implementation
    	int have=0;
		Scanner scanner = new Scanner(System.in);
		String removename = scanner.nextLine();
		for (GeneralStaff staff : a.getStaffList()) { 
            if ((staff.getName().toLowerCase()).equals(removename.toLowerCase())) {
                have=1;}}
		if(have==0) {
			System.out.println("Staff does not exist");
			return;}
		Iterator<GeneralStaff> it = a.getStaffList().iterator();
    while (it.hasNext()) {
        GeneralStaff temp = it.next();
        if (temp.getName().equals(removename)) {
            System.out.println("Removed "+ temp.getName() + " - " + temp.getStaffLoginID() + " - " + temp.getRole() + " - " + temp.getGender() + " - " + temp.getAge() + " - " + temp.getBranchName());
            it.remove(); // Use the iterator's remove method
        }
    }

    }
    
    /** method for editing of objects from StaffList
     * also includes error handling for non-existent name
     * 
     * @param a Our main StaffList
     */
    public static void editStaffAccount(StaffList a) {
        // implementation
		Scanner scanner = new Scanner(System.in);
		int have=0;
		String editname = scanner.nextLine();
		for (GeneralStaff staff : a.getStaffList()) { 
            if ((staff.getName().toLowerCase()).equals(editname.toLowerCase())) {
                have=1;}}
		if(have==0) {
			System.out.println("Staff does not exist");
			return;}
		
                              for (GeneralStaff tempstaff : a.getStaffList()) { 
                                if (tempstaff.getName().equals(editname) ) 
                                {
	
		System.out.println("Edit Staff (Enter name, Gender, Age, LoginID, Branch, Role)");

                              System.out.println("Name");
                              String sname = scanner.next();
							  tempstaff.setName(sname);

                              System.out.println("Gender");
                              char sgen = scanner.next().charAt(0);
							  sgen = Character.toUpperCase(sgen);
							  tempstaff.setGender(sgen);

                              System.out.println("Age");
                              int sage = scanner.nextInt();
							  tempstaff.setAge(sage);

                              System.out.println("LoginID");
                              String slgid = scanner.next();
							  tempstaff.setStaffLoginID(slgid);

                              System.out.println("Branch");
                              String sbr = scanner.next();
							  sbr = sbr.toUpperCase();
							  tempstaff.setBranchName(sbr);

                              System.out.println("Role");
                              char srole = scanner.next().charAt(0);
							  srole = Character.toUpperCase(srole);
							  tempstaff.setrole(srole);


		System.out.println("Edited "+ tempstaff.getName() + " - " + tempstaff.getStaffLoginID() + " - " + tempstaff.getRole() + " - " + tempstaff.getGender() + " - " + tempstaff.getAge() + " - " + tempstaff.getBranchName());
	      }}
    }

    /** Method that assigns branchmanagers to a different branch, including error handling for cases where manager quota in the
     * target branch is already filled
     * 
     * @param a Our main BranchList
     * @param branch target branch
     * @param b Our main StaffList
     * @param name Name of Manager to be transferred
     */
    public static void assignBranchManagersToBranches(BranchList a, String branch, StaffList b, String name) {
    	List<Branch> temp = a.getBranchList();
    	List<GeneralStaff> temp1 = b.getStaffList();
    	int branchmanagerquota=0;
    	int branchmanagernumber=0;
    	
        for (Branch branches : temp) {
        	if(branches.getBranchName().equals(branch)) {
        		branches.calculatemanagerquota(b);
        		branchmanagerquota=branches.getManagerQuota();}}
        
        for (GeneralStaff staff : temp1) {
        	if(staff.getBranchName().equals(branch) && staff.getRole()=='M') {
        		branchmanagernumber++;}}
        
        if(branchmanagernumber<branchmanagerquota) {
        	for (GeneralStaff staff : temp1) {
            	if(staff.getName().equals(name) && staff.getRole()=='M') {
            		staff.setBranchName(branch);
            		System.out.println("Staff " + name + " sucessfully assigned to branch manager of "+ branch+ " branch");
            		return;}
            	else if(staff.getName().equals(name) && staff.getRole()!='M') {
            		System.out.println("Staff " + name + " is not a branch manager");
            		return;}}}
        
        else {
        	System.out.println("Manager Quota for " + branch + " branch exceeded!");
        	System.out.println("Unable to assign branch manager");
        	return;}
    }
    /** Method that promotes a staff in a branch to branch manager
     * including error handling for cases where manager quota in the
     * target branch is already filled
     * 
     * @param a Our main BranchList
     * @param branch target branch
     * @param b Our main StaffList
     * @param name Name of Manager to be transferred
     */

    public static void promoteToBranchManager(BranchList a, String branch, StaffList b, String name) {
    	List<Branch> temp = a.getBranchList();
    	List<GeneralStaff> temp1 = b.getStaffList();
    	int branchmanagerquota=0;
    	int branchmanagernumber=0;
    	
        for (Branch branches : temp) {
        	if(branches.getBranchName().equals(branch)) {
        		branches.calculatemanagerquota(b);
        		branchmanagerquota=branches.getManagerQuota();}}
        
        for (GeneralStaff staff : temp1) {
        	if(staff.getBranchName().equals(branch) && staff.getRole()=='M') {
        		branchmanagernumber++;}}
        
        if(branchmanagernumber<branchmanagerquota) {
			
        	for (GeneralStaff staff : temp1) {
            	if(staff.getName().equals(name) && staff.getRole()=='S' && staff.getBranchName().equals(branch)) {
            		staff.setrole('M');
            		System.out.println("Staff " + name + " sucessfully promoted to branch manager of "+ branch+ " branch");
            		return;}
            	else if(staff.getName().equals(name) && staff.getRole()!='S' && staff.getBranchName().equals(branch)) {
            		System.out.println("Staff " + name + " is already a branch manager of "+ branch+ " branch");
            		return;}}}
        
        else {
        	System.out.println("Manager Quota for " + branch + " branch exceeded!");
        	System.out.println("Unable to promote to branch manager");
        	return;}
    }
    /** Transfers GeneralStaff between branches
     * also check if staff is already in target branch
     * 
     * @param targetbranch target branch
     * @param b Main StaffList
     * @param name Name of staff to transfer
     */

    public static void transferGeneralStaff(String targetbranch, StaffList b, String name) {
    	List<GeneralStaff> temp1 = b.getStaffList();
    	String temp;
    	for (GeneralStaff staff : temp1) {
        	if(staff.getName().equals(name) && staff.getRole()=='S' && !(staff.getBranchName().equals(targetbranch))) {
        		temp=staff.getBranchName();
        		staff.setBranchName(targetbranch);
        		System.out.println("Staff " + name + " successfully transferred from "+ temp +" branch to "+ targetbranch+ " branch");
        		return;}
        	else if(staff.getName().equals(name) && staff.getRole()=='S' && staff.getBranchName().equals(targetbranch)) {
        		System.out.println("Staff " + name + " is already from "+ targetbranch+ " branch");}}  
    }
    
    /** Same as above, but for GeneralManagers
     * includes error handling in staff to be transferred is not a manager
     * and the similiar targetbranch manager quota checking
     * @param a Our main BranchList
     * @param branch target branch
     * @param b Our main StaffList
     * @param name Name of Manager to be transferred
     */

    public static void transferBranchManager(BranchList a, String targetbranch, StaffList b, String name) {
    	List<Branch> temp = a.getBranchList();
    	List<GeneralStaff> temp1 = b.getStaffList();
    	int branchmanagerquota=0;
    	int branchmanagernumber=0;
    	
        for (Branch branches : temp) {
        	if(branches.getBranchName().equals(targetbranch)) {
        		branches.calculatemanagerquota(b);
        		branchmanagerquota=branches.getManagerQuota();}}
        
        for (GeneralStaff staff : temp1) {
        	if(staff.getBranchName().equals(targetbranch) && staff.getRole()=='M') {
        		branchmanagernumber++;}}
        
        if(branchmanagernumber<branchmanagerquota) {
        	for (GeneralStaff staff : temp1) {
        		if(staff.getName().equals(name) && staff.getRole()=='S') {
            		System.out.println("Staff " + name + " is not a branch manager");
            		return;}
        		else if(staff.getName().equals(name) && staff.getRole()=='M' && !(staff.getBranchName().equals(targetbranch))) {
            		staff.setBranchName(targetbranch);
            		System.out.println("Branch Manager " + name + " sucessfully transferred "+ targetbranch+ " branch");
            		return;}
            	else if(staff.getName().equals(name) && staff.getRole()!='S' && staff.getBranchName().equals(targetbranch)) {
            		System.out.println("Staff " + name + " is already a branch manager of "+ targetbranch+ " branch");
            		return;}}}
        
        else {
        	System.out.println("Manager Quota for " + targetbranch + " branch exceeded!");
        	System.out.println("Unable to transfer branch manager");
        	return;}
    }
    /** addition, removal and editing of payment methods
     * 
     * @param c Our main PaymentMethods object
     */
    public static void addRemovePaymentMethod(PaymentMethods c) {
		int have=0;
    	Scanner scanner1 = new Scanner(System.in);
    	System.out.println("Edit Payment: Type Add or Remove");
        String itemName = scanner1.nextLine();
		itemName = itemName.toLowerCase();
        
        if(itemName.equals("add") || itemName.equalsIgnoreCase("add")) {
        	System.out.println("Enter new Payment Method:");
            String pay = scanner1.nextLine();
        	c.addPaymentMethods(pay);
        	System.out.println("Payment Method "+pay+" added:");
        	return;}
        
        else if(itemName.equals("remove") || itemName.equalsIgnoreCase("remove")) {
        	System.out.println("Enter name of payment method to be removed:");
            String remove = scanner1.nextLine();
            
            for (String payment : c.getPaymentMethods()) { 
            	have=0;
                if (payment.toLowerCase().equals(remove.toLowerCase())) {
                    have=1;
                    c.removePaymentMethods(remove);
                    System.out.println("Payment Method "+remove+" removed:");
                    return;}}
            if(have==0) {
            	System.out.println("Payment Method not found. Please try again.");
                return;}}
        
        else {
        	System.out.println("Invalid Option, please choose again");
        	return;
        }
	}
    
    /** Method to open a branch
     *  checks if target branch is already open or not 
     * @param branch Target branch
     * @param a Our main BranchList object
     */

    public static void OpenBranch(String branch, BranchList a) {
    	List<Branch> temp = a.getBranchList();
    	for (Branch branches : temp) {
        	if(branches.getBranchName().equals(branch)) {
        		if(branches.getIsOpen()==true) {
        			System.out.println(branch + " branch is already open");
        			return;}
        		else if(branches.getIsOpen()==false) {
        			branches.setIsOpen(true);
        			System.out.println(branch + " branch sucessfully opened");}}}}
    
    /** Method to close a branch
     * checks if target branch is already closed or not 
     * @param branch Target branch
     * @param a Our main BranchList object
     */
    public static void CloseBranch(String branch, BranchList a) {
        List<Branch> temp = a.getBranchList();
        for (Branch branches : temp) {
            if(branches.getBranchName().equals(branch)) {
            	if(branches.getIsOpen()==false) {
            		System.out.println(branch + " branch is already closed");
            		return;}
            	else if(branches.getIsOpen()==true) {
            		branches.setIsOpen(false);
            		System.out.println(branch + " branch sucessfully closed");}}}
    
        		
    }
    
    /** Method to promote GeneralStaff to BranchManager
     * directly
     * @param tempstaff Staff object to be promoted
     */
	public static void promoteStaffAccount(GeneralStaff tempstaff) {
		tempstaff.setrole('M');
		System.out.println(tempstaff.getName() + " was successfully promoted to manager");
	}}
