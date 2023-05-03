import java.util.Arrays;

/**
 *         A train class that simulates a freight train.
 *         @author bbabai00
 */
public class Train {
	private String name;
	private int loco;
	private int[] cars = {};

	/**
	 * constructor for making trains
	 * @param name: a string that contains the name of the train
	 * @param loco: an integer that contains the number of 
	 * locomotives that the train contains
	 * @author bbabai00
	 */
	public Train(String name, int loco) {
		this.setName(name);
		this.setLoco(loco);
	}
	
	/**
	 * random constructor for making trains
	 * sets the train name to "my_Random_Train"
	 * sets the number of locomotives to 3
	 * @author bbabai00
	 */	
	public Train() {
		this.setName("my_Random_Train");
		this.setLoco(3);
	}
	
	/**
	 * A copy constructor for train objects
	 * @param t: a train class to copy
	 * @author bbabai00
	 */
	public Train(Train t) {
		this(t.getName(), t.getLoco());
	}
	
	/**
	 * A static method for creating a deep copy of a train object
	 * @param t: a train class to copy
	 * @author bbabai00
	 */
	public static Train makeCopy(Train t) {
		return new Train(t.getName(), t.getLoco());
	}

	
	/**
	 * A getter for name
	 * @return name: the name of the train
	 * @author bbabai00
	 */
	public String getName() {
		return name;
	}

	/**
	 * A setter for name
	 * @param name: the name of the train
	 * @author bbabai00
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * A getter for number of locomotives
	 * @return loco: number of locomotives in the train
	 * @author bbabai00
	 */
	public int getLoco() {
		return loco;
	}

	/**
	 * A setter for number of locomotives
	 * @param loco: number of locomotives in the train
	 * @author bbabai00
	 */
	public void setLoco(int loco) {
		if(loco > 0) {
			this.loco = loco;
		}
	}
	
	/**
	 * A getter for the array of freight cars
	 * @return the copy of freight cars
	 * @author bbabai00
	 */
	public int[] getCars() {
		if(cars != null)
		{
		return Arrays.copyOf(cars, cars.length);
		} else {
			return null;
		}
	}  
	
	/**
	 * A function that calculates the total weight of cars in the train
	 * @return sum: the total weight of cars in the train
	 * @author bbabai00
	 */
	public int getTotalWeightOfCars() {
		int sum = 0;
		for(int i = 0; i < this.cars.length; i++) {
			sum += this.cars[i];
		}
		return sum;
	}
	
	/**
	 * A function that calculates the number of cars in the train
	 * @return the number of cars in the train
	 * @author bbabai00
	 */
	public int getNumberOfCars() {
		return this.cars.length;
	}
	
	/**
	 * A function that calculates the maximum speed of the train
	 * @return max: the maximum speed of the train
	 * @author bbabai00
	 */
	public int maxSpeed() {
		if(this.getLoco() > 0) {
			int max;
			int total = this.getLoco() * 50;
			max = total - this.getTotalWeightOfCars();
			return max;
		} else {
			return 0;
		}
	}
	
	/**
	 * removes all cars from the freight cars array
	 * @author bbabai00
	 */
	public void removeAllCars() {
		if(this.cars != null && this.cars.length > 0) {
			this.cars = new int[0];
		}
	}
	
	/**
	 * adds cars to the freight cars array
	 * @param weights: the weight of the cars that are 
	 * going to be added to the train
	 * @author bbabai00
	 */
	public void addCars(int... weights) {
		if (weights != null) {
			int[] temp = new int[this.cars.length + weights.length];
			for (int i = 0; i < this.cars.length; i++) {
				temp[i] = this.cars[i];
			}
			for(int i = this.cars.length; i < this.cars.length + weights.length; i++) {
				temp[i] = weights[i];
			}
			this.cars = temp;
		}
	}
	
	/**
	 * A function that merges two trains
	 * @param other: another train class
	 * @author bbabai00
	 */
	public void  mergeTrains(Train other) {
		this.setLoco(this.getLoco() + other.getLoco());
		other.setLoco(0);
		this.addCars(other.getCars());
		other.removeAllCars();
	}
	
	/**
	 * the basic toString function for the Train Class
	 * @author bbabai00
	 */
	public String toString() {
		String result = "*******Train: " + this.name + "*******";
		result += "\nNumber of Locomotives: " + this.loco;
		result += "\nFreight Cars: {";
		for(int i = 0; i < cars.length; i++) {
			result += cars[i];
			if(i != cars.length - 1)
			{
				result += ",";
			}
		}
		return result + "}\n";
	}
	
}
