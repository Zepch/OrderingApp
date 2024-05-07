package fastfoodfinal;
import java.io.Serializable;

/** One of our base super classes, the foundation of our entire project
 * @author FDAA Group 4
 * @version 2.0
 * @since 2023-04-21
 */
public class Food implements Serializable {
	/** the name of the food
	 * 
	 */
	private String name;
	/** the price of the food
	 * 
	 */
    private double price;
    /** the category of the food
     * 
     */
    private String category;
    /** the quantity of the food
     * 
     */
    private int quantity=1;
    /** constructor using all attributes
     * 
     * @param name Name of Food
     * @param price Price of Food
     * @param category Category of Food
     */
    public Food(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity=1;}
    /** Default constructor of food
     * 
     */
    public Food() {}

    /** set new name of Food
     * 
     * @param name New name
     */
    public void setName(String name) {
        this.name = name;}
    /** set new price of Food
     * 
     * @param price New price of food
     */
    public void setPrice(double price) {
        this.price = price;}
    /** set new category of Food
     * 
     * @param category New category of food
     */
    public void setItemCategory(String category) {
        this.category = category;}
    /** set new quantity of Food
     * 
     * @param category New quantity of food
     */
    public void setQuantity(int quant) {
    	this.quantity=quant;
    }
    
    /** get name of food
     * 
     * @return Name of food
     */
    public String getName() {
        return name;}
    /** get price of food
     * 
     * @return Price of food
     */
    public double getPrice() {
        return price;}
    /** get category of food
     * 
     * @return Category of food
     */
    public String getItemCategory() {
        return category;}
    /** get quantity of food
     * 
     * @return Quantity of food
     */
    public int getQuantity() {
    	return quantity;
    }

}
