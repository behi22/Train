import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 * A class for testing the methods of the Train class behave
 * as expected.
 * See: http://junit.sourceforge.net/javadoc/org/junit/Assert.html
 * For more JUnit Assertion Statements
 */
class TestTrain {
	@Test
	void testGetName() {
		Train t = new Train("myTrain", 5);
		Train random = new Train();
		assertEquals("myTrain", t.getName(), "the name should be myTrain");
		assertEquals("my_Random_Train", random.getName(), "the name should be my_Random_Train");
	}
	
	@Test
	void testGetLoco() {
		Train t = new Train("myTrain", 5);
		Train random = new Train();
		assertEquals(5, t.getLoco(), "the number of locomotives should be 5");
		assertEquals(3, random.getLoco(), "the number of locomotives should be 3");
	}
	
	@Test
	void testSetName() {
		Train t = new Train("myTrain", 5);
		t.setName("new");
		Train random = new Train();
		random.setName("new_random");
		assertEquals("new", t.getName(), "the name should be new");
		assertEquals("new_random", random.getName(), "the name should be new_random");
	}
	
	@Test
	void testSetLoco() {
		Train t = new Train("myTrain", 5);
		t.setLoco(6);
		Train random = new Train();
		random.setLoco(7);
		assertEquals(6, t.getLoco(), "the number of locomotives should be 6");
		assertEquals(7, random.getLoco(), "the number of locomotives should be 7");
		t.setLoco(0);
		assertEquals(6, t.getLoco(), "the number of locomotives should be 6");
	}
	
	@Test
	void testGetCars() {
		Train t = new Train("myTrain", 5);
		Train random = new Train();
		assertEquals(random.getCars().length, t.getCars().length);
		t.addCars(5,6,7,8,9);
		assertEquals(5, t.getCars()[0]);
		t.removeAllCars();
		assertEquals(random.getCars().length, t.getCars().length);
	}
	
	@Test
	void testGetTotalWeightOfCars() {
		Train t = new Train("myTrain", 5);
		t.addCars(1,2,3);
		assertEquals(6, t.getTotalWeightOfCars(), "the Total Weight Of Cars should be 6");
		t.removeAllCars();
		assertEquals(0, t.getTotalWeightOfCars(), "the Total Weight Of Cars should be 0");
	}
	
	@Test
	void testGetNumberOfCars() {
		Train t = new Train("myTrain", 5);
		t.addCars(1,2,3);
		assertEquals(3, t.getNumberOfCars(), "the Total Number Of Cars should be 3");
		t.removeAllCars();
		assertEquals(0, t.getNumberOfCars(), "the Total Number Of Cars should be 0");
	}
	
	@Test
	void testMaxSpeed() {
		Train t = new Train("myTrain", 5);
		t.addCars(1,2,3);
		assertEquals(244, t.maxSpeed(), "the max speed should be 244");
		t.removeAllCars();
		assertEquals(250, t.maxSpeed(), "the max speed should be 250");
		t.setLoco(1);
		assertEquals(50, t.maxSpeed(), "the max speed should be 50");
	}
	
	@Test
	void testRemoveAllCars() {
		Train t = new Train("myTrain", 5);
		t.addCars(1,2,3);
		t.removeAllCars();
		assertEquals(0, t.getNumberOfCars(), "the Total Number Of Cars should be 0");
		t.removeAllCars();
		assertEquals(0, t.getNumberOfCars(), "the Total Number Of Cars should be 0");
	}
	
	@Test
	void testAddCars() {
		Train t = new Train("myTrain", 5);
		t.addCars(1,2,3);
		assertEquals(3, t.getNumberOfCars(), "the Total Number Of Cars should be 3");
		t.removeAllCars();
		t.addCars(null);
		assertEquals(0, t.getNumberOfCars(), "the Total Number Of Cars should be 0");
	}
	
	@Test
	void testMergeTrains() {
		Train t = new Train("myTrain", 5);
		t.addCars(1,2);
		Train s = new Train("newTrain", 5);
		t.mergeTrains(s);
		assertEquals(10, t.getLoco(), "the Total Number Of Locomotives should be 10");
		assertEquals(2, t.getNumberOfCars(), "the Total Number Of Cars should be 2");
	}
}
