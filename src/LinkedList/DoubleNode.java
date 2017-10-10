/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author Windows 10
 */
public class DoubleNode {
   Object element;
   DoubleNode next;
   DoubleNode previous;

   DoubleNode() {}
     
   DoubleNode(Object theElement){
       element = theElement;
   }

   DoubleNode(Object theElement, DoubleNode thePrevious, DoubleNode theNext)
   {
       element = theElement;
       previous = thePrevious;
       next = theNext;
   }
}
