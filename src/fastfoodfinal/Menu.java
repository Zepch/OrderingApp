package fastfoodfinal;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a food menu for a specific branch of the fast food system.
 * Provides functionality to add, remove, update items on the menu.
 */
public class Menu extends Food implements Serializable{
    private List<Food> items;
    private String branchName;

    /**
     * Creates a new Menu object for a given branch.
     * @param branchName The name of the branch this menu belongs to.
     */
    public Menu(String branchName) {   
    	this.items = new ArrayList<Food>();
        this.branchName = branchName;}
        
        /**
        * Display Menu based on the branch
        * Using standard output stream 
        * for giving the output.
        * @return null
        */
    public void displayMenu() {
        System.out.println("Menu for " + branchName + " branch:");
        for (Food item : items) {
            System.out.println(item.getName() + " - " + item.getPrice() + " - " + item.getItemCategory());}
    }

        /**
        * add new food item into branch menu
        * @param food
        */
    public void addItem(Food food) {
        items.add(food);}

        /**
        * remove food item into branch menu
        * @param food
        */
    public void removeItem(Food food) {
        items.remove(food);}

        /**
        * update food item with another existing food item
        * @param oldfood old food item for replacement
        * @param newfood new food item to replace with 
        */
    public void updateExistingItem(Food oldFood, Food newFood) {
        int index = items.indexOf(oldFood);
        if (index != -1) {
            items.set(index, newFood);}
    }
        /**
        * set Menu with a list of food 
        * @param items 
        */
    public void setMenu(List<Food> items) {
    	this.items=items;}
    
        /**
        * get Menu with a list of food 
        * @return list of item in the menu 
        */
    public List<Food> getMenu() {
    	return items;}
}
