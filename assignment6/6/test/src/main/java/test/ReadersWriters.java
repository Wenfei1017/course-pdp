/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
/**
  This app creates a specified number of readers and 
  writers and starts them.
*/
public class ReadersWriters
{
  /**
    Creates the specified number of readers and writers and starts them.
 

  */
  public static void main(String[] args)
  {
    if (args.length < 2)
    {
      System.out.println("Usage: java Simulator <number of readers> <number of writers>");
    }
    else
    {
      final int READERS = Integer.parseInt(args[0]);
      final int WRITERS = Integer.parseInt(args[1]);
      test.Database database = new test.Database();
      for (int i = 0; i < READERS; i++)
      {
        new Reader(database).start();
      }
      for (int i = 0; i < WRITERS; i++)
      {
        new Writer(database).start();
      }
    }
  }
}
