package fastfoodfinal;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

	/**
     * Represents a collection of staff members within the fast food system.
     * Provides functionality to add, remove, update, and filter staff records.
     */
    public class StaffList implements Serializable{
	private List<GeneralStaff> allstaff;

     /**
     * Creates a new empty StaffList.
     */
	public StaffList() {   
    	this.allstaff = new ArrayList<GeneralStaff>();}

    /**
     * Displays information about all staff members in the list.
     */
    public void displayallstaff() {
        System.out.println("Displaying all staff:  ");
        for (GeneralStaff staff : allstaff) {
            System.out.println(staff.getName() + " - " + staff.getStaffLoginID() + " - " + staff.getRole() + " - " + staff.getGender() + " - " + staff.getAge() + " - " + staff.getBranchName());}
    }
    
    /**
     * Displays information about staff members belonging to a specific branch.
     * @param branch The name of the branch to filter by.
     */
    public void displayfilterbranch(String branch) {
        System.out.println("Displaying all staff:  ");
        System.out.println("Filtering by " + branch + " branch:  ");
        for (GeneralStaff staff : allstaff) {
        	if(staff.getBranchName().equals(branch)) {
        		System.out.println(staff.getName() + " - " + staff.getStaffLoginID() + " - " + staff.getRole() + " - " + staff.getGender() + " - " + staff.getAge() + " - " + staff.getBranchName());}
    }}
    
    /**
     * Displays information about staff members belonging to a specific role.
     * @param role The role to filter by.
     */
    public void displayfilterrole(char role) {
        System.out.println("Displaying all staff:  ");
        System.out.println("Filtering by " + role + " role:  ");
        for (GeneralStaff staff : allstaff) {
        	if(staff.getRole()==role) {
        		System.out.println(staff.getName() + " - " + staff.getStaffLoginID() + " - " + staff.getRole() + " - " + staff.getGender() + " - " + staff.getAge() + " - " + staff.getBranchName());}
    }}
    
    /**
     * Displays information about staff members belonging to a specific gender.
     * @param gender The gender to filter by.
     */
    public void displayfiltergender(char gender) {
        System.out.println("Displaying all staff:  ");
        System.out.println("Filtering by " + gender + " role:  ");
        for (GeneralStaff staff : allstaff) {
        	if(staff.getGender()==gender) {
        		System.out.println(staff.getName() + " - " + staff.getStaffLoginID() + " - " + staff.getRole() + " - " + staff.getGender() + " - " + staff.getAge() + " - " + staff.getBranchName());}
    }}
    
    /**
     * Displays information about staff members belonging to a specific age.
     * @param role The age to filter by.
     */
    public void displayfilterage(int agestart, int ageend) {
        System.out.println("Displaying all staff:  ");
        System.out.println("Filtering by ages "+ agestart + " to" + ageend + " :");
        for (GeneralStaff staff : allstaff) {
        	if(staff.getAge()<=ageend && staff.getAge()>=agestart) {
        		System.out.println(staff.getName() + " - " + staff.getStaffLoginID() + " - " + staff.getRole() + " - " + staff.getGender() + " - " + staff.getAge() + " - " + staff.getBranchName());}
    }}
     /**
     * Adds a new staff member to the StaffList.
     * @param staff The GeneralStaff object representing the new staff member.
     */
    public void addStaff(GeneralStaff staff) {
        allstaff.add(staff);}
    
    /**
     * Removes a staff member from the StaffList.
     * @param staff The GeneralStaff object representing the staff member to remove.
     */
    public void removeStaff(GeneralStaff staff) {
        allstaff.remove(staff);}

    /**
     * Updates the information of an existing staff member.
     * @param oldstaff The GeneralStaff object representing the original version.
     * @param newstaff The GeneralStaff object containing updated information. 
     */
    public void updateExistingStaff(GeneralStaff oldstaff, GeneralStaff newstaff) {
        int index = allstaff.indexOf(oldstaff);
        if (index != -1) {
            allstaff.set(index, newstaff);}}
    
    /**
     * Replaces the entire staff list.
     * @param allstaff The new list of GeneralStaff objects.
     */
    public void setStaffList(List<GeneralStaff> allstaff) {
    	this.allstaff=allstaff;}
    
    /**
     * Returns the current list of staff members.
     * @return A list of GeneralStaff objects.
     */
    public List<GeneralStaff> getStaffList() {
    	return allstaff;}


	}


	


