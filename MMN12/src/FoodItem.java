/**
 * Matala MMN12 q.2 - class that present food items
 * 
 * @author amaztia adler
 * @version 2020a
 */

public class FoodItem {

	private final String _name;
	private final long _catalogueNumber;
	private int _quantity, _price;
	private final int _minTemperature, _maxTemperature;
	private Date _productionDate, _expiryDate;
	private final int CATALOGUE_NUM_DEFAULT=9999, PRICE_DEFAULT=1, QUANTITY_DEFAULT=0, ZERO=0;
	
	
	// constructors
	/** constructor 1 - input all the identifiers and check there integrity
	 * @param name - name of the food item
	 * @param catalagueNumber - integer for the catalog number
	 * @param quantity - the numbers of products there is in the item
	 * @param productionDate - manufacturing date
	 * @param expiryDate - expire date of the item 
	 * @param minTemperature - minimum temp for the item
	 * @param maxTemperature - maximum temp for the item
	 * @param price - price of the item
	 */
	public FoodItem(String name, long catalogueNumber, int quantity, Date productionDate, Date expiryDate, 
			int minTemperature, int maxTemperature, int price) {
		if(name == "")
			_name = "item";
		else
			_name = name;
		
		if(catalogueNumber < 1000 || catalogueNumber > 9999) // if the number is not with 4 digits
			_catalogueNumber = CATALOGUE_NUM_DEFAULT;
		else
			_catalogueNumber = catalogueNumber;
		
		if(quantity < 0) // if the quantity negative
			_quantity = QUANTITY_DEFAULT;
		else
			_quantity = quantity;
		
		if (minTemperature > maxTemperature) {
			_maxTemperature = minTemperature;
			_minTemperature = maxTemperature;
		}
		else {
			_minTemperature = minTemperature;
			_maxTemperature = maxTemperature;
		}
		
		_productionDate = new Date(productionDate);
		
		if (expiryDate.before(_productionDate))
			_expiryDate = new Date(productionDate.tomorrow()); // default value
		else
			_expiryDate = new Date(expiryDate); 
		
		if(price < 1) // there isn't item that cost 0 or less
			_price = PRICE_DEFAULT;
		else
			_price = price;
	}
	
	/**
	 * constructor 2 - copy constructor
	 * @param other - another food item for the copy
	 */
	public FoodItem(FoodItem other) {
		_name = other._name;
		_catalogueNumber = other._catalogueNumber;
		_quantity = other._quantity;
		_minTemperature = other._minTemperature;
		_maxTemperature = other._maxTemperature;
		_price = other._price;
		_productionDate = new Date(other._productionDate);
		_expiryDate = new Date(other._expiryDate);
	}
	
	
	// getters && setters divide by variable
	/** gets the name */
	public String getName() {
		return _name; }
	
	/** gets the Catalogue Number */
	public long getCatalogueNumber() {
		return _catalogueNumber; }
	
	/** gets the CatalogueNumber */
	public int getMinTemperature() {
		return _minTemperature; }
	
	/** gets the Maximum Temperature */
	public int getMaxTemperature() {
		return _maxTemperature; }

	/** gets the Quantity */
	public int getQuantity() {
		return _quantity; }
	
	/** set the Quantity
	 * @param n the value to be set
	 */
	public void setQuantity(int n) {
		if (n >= 0)
			_quantity = n; }
	
	/** get the price */
	public int getPrice() {
		return _price; }
	
	/** set the price
	 * @param n the value to be set
	 */
	public void setPrice(int n) {
		if (n > 0)
			_price = n; }
	
	/** get production date */
	public Date getProductionDate() {
		return new Date(_productionDate); }
	
	/** set production date
	 * @param d the value to be set
	 */
	public void setProductionDate(Date d) {
		if(! d.after(_expiryDate))
			_productionDate = new Date(d); }
	
	/** get expiry date */
	public Date getExpiryDate() {
		return new Date(_expiryDate); }
	
	/** set expiry date
	 * @param d the value to be set
	 */
	public void setExpiryDate(Date d) {
		if(! d.before(_productionDate))
			_expiryDate = new Date(d); }

	
	/**
	 * method that check if the food item is equals to "other"
	 * @param other - food item from the input
	 * @return true if they equals and false if they not 
	 */
	public boolean equals(FoodItem other) {
		return (_name.equals(other._name) && _catalogueNumber == other._catalogueNumber && _minTemperature == other._minTemperature
				&& _maxTemperature == other._maxTemperature && _price == other._price
				&& _productionDate.equals(other._productionDate) && _expiryDate.equals(other._expiryDate));
	}
	
	/**
	 * method that check if the food item is fresh
	 * @param d - Date from the input
	 * @return true or false
	 */
	public boolean isFresh(Date d) {
		return (! d.before(_productionDate)) && (! d.after(_expiryDate));
	}
	
	/**
	 * ToString
	 * @return the object as string
	 * in the following format:
	 * FoodItem: \t(name) CatalagueNumber: \t(catalogueNumber) ProductionDate: \t(productionDate) ExpiryDate: \texpiryDate) Quantity: \t(quantity)
	 */
	public String toString() {
		return "FoodItem: " + _name + "\tCatalagueNumber: " + _catalogueNumber + "\tProductionDate: " + _productionDate 
				+ "\tExpiryDate: " + _expiryDate + "\tQuantity: " + _quantity;
	}
	
	/**
	 * check if the food item is older
	 * @return true or false
	 */ 
	public boolean olderFoodItem(FoodItem other) {
		return other._productionDate.after(_productionDate);
	}
	
	/**
	 * if there is, how many items the input money can buy
	 * @param amount - the input money
	 * @return integer for the quantity
	 */
	public int howManyItems(int amount) {
		if(amount >= _price) { // if there is enough money for one or more items
			if(amount >= _quantity * _price)
				return _quantity;
			else
				return amount / _price;
		}
		return ZERO;
	}
	
	/**
	 * check if the item "other" is more expensive
	 * @return true or false
	 */
	public boolean isCheaper(FoodItem other) {
		return other._price > _price;
	}
}
 