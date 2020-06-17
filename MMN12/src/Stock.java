/**
 * Matala MMN13 q.1 - class that present the stock in the supermarket. 
 * in the stock there is 100 index max, but for any item can be more than one amount.
 * you can order, update, add item and more.
 * 
 * @author amatzia adler
 * @version 2020a
 */

public class Stock {
	
	private FoodItem[] _stock; // array of the food items
	private int _noOfItems = 0; // current size of the array 
	private final int MAX_LENGTH = 100; // max size of the array
	
	
	/** default constructor - defined the array for 100 index */
	public Stock() {
		_stock = new FoodItem[MAX_LENGTH];
		//for(int i = 0; i < MAX_LENGTH || _stock[i] != null; i++)
		//	_noOfItems += 1;
	}
	
	/** Get a values for the array */
	public int getNumOfItems() {
		return _noOfItems;
	}
	
	/**
	 * add an item or more of the same item to the array
	 * @param newItem - new food item to the stock
	 * @return true if succeeded to add the new item and false else 
	 */
	public boolean addItem(FoodItem newItem) {
		for(int i = 0; i < _noOfItems; i++) {
			// add the quantity of the item to quantity of a matching item if there is
			if(_stock[i].equals(newItem)) {
				_stock[i].setQuantity(_stock[i].getQuantity() + newItem.getQuantity()); // set the sum in quantity
				return true;
			}
			// add the item before the food item with the same name and catalogue and update the stock accordingly
			else if(_stock[i].getName() == newItem.getName() && _stock[i].getCatalogueNumber() == newItem.getCatalogueNumber()) {
				fillTakenIndex(i, newItem); // private method - input the new item in current index
				return true;
			}
			// add the item in the right place by catalogue number and update the stock accordingly
			else if(_stock[i].getCatalogueNumber() > newItem.getCatalogueNumber()) {
				fillTakenIndex(i, newItem); // private method - input the new item in current index
				return true;
			}
		}
		// return false - happened only if the array is full and there isn't the same item in it
		if(_noOfItems == MAX_LENGTH)
			return false;
		// else - create one more index and input the new item in it
		_stock[_noOfItems++] = new FoodItem(newItem);
		return true;
	}
	
	/**
	 * Method that check which items need refill
	 * @param amount - amount of the minimum quantity number of any item that need to be in the stock
	 * @return string that present all the items that need refill
	 */
	public String order(int amount) {
		String TempStr=""; // temp string of the array
		int i;
		for(i = 0; i < _noOfItems; i++) {
			int tempQuantity = _stock[i].getQuantity(); // temp of the quantity
			for(int j = 0; j < _noOfItems; j++) {
				// check if name and catalogue are equals
				if(_stock[i].getName() == _stock[j].getName() && _stock[i].getCatalogueNumber() == _stock[j].getCatalogueNumber()) {
					tempQuantity += _stock[j].getQuantity();
				}
			}
			// fix add himself twice
			if(tempQuantity > _stock[i].getQuantity())
				tempQuantity -= _stock[i].getQuantity();
			// make the string
			if(tempQuantity < amount)
				TempStr += _stock[i].getName() + ", ";
		}
		// fix for string without ',' in the end 
		return (TempStr.length() > 2 ? TempStr.substring(0, TempStr.length() - 2) : TempStr);
	}
	
	/**
	 * check how many items can move to fridge that his temperature is the integer temp
	 * @param numItems - present the quantity for items that can be inside that fridge
	 * @return the how many numbers
	 */
	public int howMany(int temp) {
		int numItems = 0;
		for(int i = 0; i < _noOfItems; i++) {
			if(_stock[i].getMinTemperature() < temp && _stock[i].getMaxTemperature() > temp)
				numItems += _stock[i].getQuantity();
		}
		return numItems;
	}
	
	/**
	 * delete every item that his experyDate pass
	 * @param d - input expiry date for all the items
	 */
	public void removeAfterDate(Date d) {
		for(int i = 0; i < _noOfItems; i++) {
			if(_stock[i].getExpiryDate().before(d)) { // find old date
				fillBlankIndex(i); // private method
				i--; // because the i index deleted
			}
		}
	}
	
	/**
	 * check which is the most expensive food item in the stock
	 * @return new anonymous food item biggest
	 */
	public FoodItem mostExpensive() {
		if(_noOfItems == 0) // check if the array is empty
			return null;
		FoodItem biggest = _stock[0]; // the current most expensive food item
		
		for(int i = 0; i < _noOfItems; i++) {
			if(_stock[i].getPrice() > biggest.getPrice()) // check if the price is more expensive
				biggest = _stock[i]; // biggest is equals always to the highest
		}
		return new FoodItem(biggest);
	}
	
	/**
	 * Calculate all the quantity that there is in the stock
	 * @return numOfQuantity
	 */
	// return all the quantity that there is in the stock
	public int howManyPieces() {
		if(_noOfItems == 0)
			return 0;
		
		int numOfQuantity = 0; // temp sum of quantity
		for(int i = 0; i < _noOfItems; i++) {
			numOfQuantity += _stock[i].getQuantity();
		}
		return numOfQuantity;
	}
	
	/**
	 * ToString
	 * @return the stock array as string
	 * in the following format:
	 * FoodItem: **** \tCatalogueNumber: **** \tProductionDate: 01/01/2000 \tExpiryDate: 01/01/2001 \tQuantity: ** [new line and again]
	 */
	public String toString() {
		String tempToString = "";
		for(int i = 0; i < _noOfItems; i++) {
			tempToString += _stock[i] + "\n";
		}
		return tempToString;
	}
	
	/**
	 * update stock according to the buy
	 * @param itemList - string array that present the items that been soled by names
	 */
	public void updateStock(String[] itemList) {
		for(int j, i = 0; i < itemList.length; i++) {
			for(j = 0; j < _noOfItems; j++) {
				if(itemList[i].equals(_stock[j].getName()) && (_stock[j].getQuantity() > 0)) { // check if the word in the list equals to the name of the stock
					_stock[j].setQuantity(_stock[j].getQuantity()-1);
					break; // after remove 1 amount
				}
			}
			if(_stock[j].getQuantity() == 0){ // removing the items if run out the quantity
				fillBlankIndex(j); // private method
				j--; // because the i index deleted
			}
		}
	}
	
	/**
	 * check which temp can fit to all items
	 * @return the best temperature of MAX_VALUE if there isn't one
	 */
	public int getTempOfStock() {
		if(_noOfItems > 0) {
			int maxTemp = _stock[0].getMaxTemperature(); // maximum temp of the item
			int minTemp = _stock[0].getMinTemperature(); // minimum temp of the item
			for(int i = 1; i < _noOfItems; i++) {		
				if(_stock[i].getMaxTemperature() < maxTemp)
					maxTemp = _stock[i].getMaxTemperature();
				if(_stock[i].getMinTemperature() > minTemp)
					minTemp = _stock[i].getMinTemperature();
			}
			if(maxTemp >= minTemp)
				return minTemp;
		}
		return Integer.MAX_VALUE;
	}
	
	/** private method that fill the blank index in the stock after remove an item */
	private void fillBlankIndex(int i) {
		_noOfItems--;
		for(int j = i; j < _noOfItems; j++)
			_stock[j] = _stock[j+1];
		_stock[_noOfItems] = null;
	}
	
	/** private method that clean the right index and fill it with the new item */
	private void fillTakenIndex(int i, FoodItem newItem) {
		_stock[_noOfItems] = new FoodItem(_stock[_noOfItems-1]);
		for(int k = _noOfItems-1; k > i; k--) {
			_stock[k] = _stock[k-1];
		}
		_stock[i] = newItem;
		_noOfItems++;
	}
	
}
