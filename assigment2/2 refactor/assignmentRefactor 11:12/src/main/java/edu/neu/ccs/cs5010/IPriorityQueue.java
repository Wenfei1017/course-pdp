package edu.neu.ccs.cs5010;

import java.util.ArrayList;

/**
 * Class that generate patient.
 *
 * @author wenfei
 *
 * @version 2.0
 */

public interface IPriorityQueue<E extends Comparable<E>> {
    E remove();
    E front();
    boolean isEmpty();
    ArrayList testForwardTraversal();
    ArrayList testReverseTraversal();
}
