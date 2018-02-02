package edu.neu.ccs.cs5010.Assignment8;

import java.util.List;

/**
 * The interface Database.
 */
public interface Database {

	/**
	 * Read list.
	 *
	 * @param arg the arg
	 * @return the list
	 */
	List<String> read(int arg);

	/**
	 * Write.
	 *
	 * @param arg the arg
	 */
	void write(int arg);
}
