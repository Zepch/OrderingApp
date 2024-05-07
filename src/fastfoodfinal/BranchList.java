package fastfoodfinal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/** Represents a ArrayList of Branches
 * @author FDAA Group 4
 * @version 2.0
 * @since 2023-04-21
 */
public class BranchList implements Serializable{
	/** An ArrayList of Branch objects, for use in main method
	 * 
	 */
	private ArrayList<Branch> allbranches;
	/** constructor that creates a new ArrayList of branch objects
	 * 
	 */
	public BranchList() {   
    	this.allbranches = new ArrayList<Branch>();}
	
	/** method that prints all branches in branch list
	 * displays both open and closed branches
	 */
	 public void displayBranchList() {
			String openclose = "open";
	        System.out.println("Displaying all Branches:  ");

	        for (Branch branch : allbranches) {
				if (branch.getIsOpen() == true)
				{openclose = "open";}
				else 
				{openclose = "closed";}
	            System.out.println(branch.getBranchName() + " - " + openclose);}
	    }
	 /** method that prints all open branches
	  * for use in customer interface
	  */
	 public void displayBranchListcustomer() {
	        System.out.println("Displaying all Branches:  ");
	        for (Branch branch : allbranches) {
	        	if(branch.getIsOpen()==true) {
	        		System.out.println(branch.getBranchName());}}
	    }
	 	
	 	/** method to add new branch from BranchList object
	 	 * 
	 	 * @param branch Branch object to be added
	 	 */
	    public void addBranch(Branch branch) {
	        allbranches.add(branch);}
	    
	    /** method to remove branch from BranchList object
	     * 
	     * @param branch Branch object to be removed
	     */
	    public void removeBranch(Branch branch) {
	        allbranches.remove(branch);}
	    /** method to replace specific branch object with another from branch object
	     * 
	     * @param branch Branch object to be removed
	     */
	    public void updateExistingBranch(Branch oldbranch, Branch newbranch) {
	        int index = allbranches.indexOf(oldbranch);
	        if (index != -1) {
	            allbranches.set(index, newbranch);}}
	    /** set the ArrayList of branches for a branchlist
	     * 
	     * @param allbranches New Branch list
	     */
	    public void setBranchList(ArrayList<Branch> allbranches) {
	    	this.allbranches=allbranches;}
	    /** Get the ArrayList of branches of the BranchList
	     * 
	     * @return
	     */
	    public List<Branch> getBranchList() {
	    	return allbranches;}
	
	
	
	
	

	
	
	
	
	
}
