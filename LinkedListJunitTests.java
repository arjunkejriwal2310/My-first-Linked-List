import static org.junit.Assert.assertEquals;

import org.junit.*;

public class LinkedListJunitTests {

	Node<String> l = new Node<String>();
	Node<String> l2 = new Node<String>();
	Node<String> l3 = new Node<String>();
	Node<String> l4 = new Node<String>();

	Node<String> empty = new Node<String>();


	@Before 
	// Runs before EACH test
	public void setup() {


		l.add("One");
		l.add("Two");
		l.add("One");

		l2.add("One");
		l2.add("Two");
		l2.add("Three");
		l2.add("One");

		l3.add("One");
		l3.add("Two");
		l3.add("Three");
		l3.add("Four");
		l3.add("Thirteen");

		l4.add("Two");
		l4.add("Three");
		l4.add("Four");
		l4.add("Thirteen");


	}


	// One test of length

	@Test
	public void testLength() {
		assertEquals("Test of method length",l.length(),3);
	}


	// Tests of Odd


	@Test
	public void testOdd1() {
		assertEquals("Test of method odd",l.odd(),true);
	}

	@Test
	public void testOdd2() {
		assertEquals("Test of method odd",l2.odd(),false);
	}

	@Test
	public void testOdd3() {
		assertEquals("Test of method odd",empty.odd(),false);
	}

	
	@Test
	public void testIth1() {
		assertEquals("Test of ith",l2.ith(3),l2.getNext().getNext().getNext());
	}

	@Test
	public void testIth2() {
		assertEquals("Test of ith",l2.ith(5),null);
	}

	@Test
	public void testIth3() {
		assertEquals("Test of ith",l2.ith(1),l2.getNext());
	}


	@Test
	public void testAddFile() {
		Node<String> lnew = new Node<String>();
		FileExample.addFile("TestData.dat",lnew);
		assertEquals("testing addList", true, lnew.sameList(l3));

	}


	//Tests of the method deleteIth

	@Test
	public void testDeleteIth1()
	{
		l2.deleteIth(3);
		Node<String> lnew = new Node<String>();
		FileExample.addFile("TestData2.dat",lnew);
		assertEquals("Test of method deleteIth1", true, lnew.sameList(l2));
	}

	@Test
	public void testDeleteIth2()
	{
		l3.deleteIth(5);
		Node<String> lnew = new Node<String>();
		FileExample.addFile("TestData3.dat",lnew);
		assertEquals("Test of method deleteIth2", true, lnew.sameList(l3));
	}

	@Test
	public void testDeleteIth3()
	{
		l.deleteIth(1);
		Node<String> lnew = new Node<String>();
		FileExample.addFile("TestData4.dat",lnew);
		assertEquals("Test of method deleteIth3", true, lnew.sameList(l));
	}

	@Test
	public void testDeleteIth4()
	{
		assertEquals("Test of method deleteIth4",l2.deleteIth(5),null);
	}

	@Test
	public void testDeleteIth5()
	{
		assertEquals("Test of method deleteIth5", l4.getNext(), l4.deleteIth(1));
	}

	@Test
	public void testDeleteIth6()
	{
		assertEquals("Test of method deleteIth6", l4.getNext().getNext().getNext(), l4.deleteIth(3));
	}
}
