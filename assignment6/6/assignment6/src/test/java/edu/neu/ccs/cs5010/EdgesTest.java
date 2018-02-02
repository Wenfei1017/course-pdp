package edu.neu.ccs.cs5010;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The type Edges test.
 */
public class EdgesTest {
	private Edges edges;

	/**
	 * Sets up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		edges = new Edges();
	}

	/**
	 * Sets adj vex.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void setAdjVex() throws Exception {
		edges.setAdjVex(14);
	}

	/**
	 * Sets next.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void setNext() throws Exception {
		edges.setNext(new Edges());
	}

	/**
	 * Gets vex.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void getadjVex() throws Exception {
		edges.setAdjVex(15);
		edges.getadjVex();
	}

	/**
	 * Gets next.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void getNext() throws Exception {
		edges.setNext(new Edges());
		edges.getNext();
	}

}