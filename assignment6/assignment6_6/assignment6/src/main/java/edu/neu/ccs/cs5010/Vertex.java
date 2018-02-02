package edu.neu.ccs.cs5010;

/**
 * The interface Vertex.
 *
 * @param <V> the type parameter
 */
public interface Vertex<V> {

    /**
     * Gets next.
     *
     * @return the next
     */
    Edges getNext();

    /**
     * Sets user.
     *
     * @param user the user
     */
    void setUser(Users user);

}
