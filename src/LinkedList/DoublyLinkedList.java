/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import LinearList.LinearList;

/**
 *
 * @author Windows 10
 */
public class DoublyLinkedList implements LinearList {
    // data members
   protected DoubleNode firstNode;
   protected DoubleNode lastNode;
   protected int size;

   public DoublyLinkedList(int initialCapacity){}

   public DoublyLinkedList()
      {this(0);}

   @Override
   public boolean isEmpty(){
       return size == 0;
   }

   @Override
   public int size(){
       return size;
   }

   /** @throws IndexOutOfBoundsException when
     * index is not between 0 and size - 1 */
   void checkIndex(int index)
   {
      if (index < 0 || index >= size)
         throw new IndexOutOfBoundsException
             ("index = " + index + "  size = " + size);
   }

   @Override
   public Object get(int index)
   {
      checkIndex(index);

      DoubleNode currentNode;

      if (index < size / 2)
      {
         currentNode = firstNode;
         for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
      }
      else
      {
         currentNode = lastNode;
         int numberToMove = size - index - 1;
         for (int i = 0; i < numberToMove; i++)
            currentNode = currentNode.previous;
      }

      return currentNode.element;
   }
   
   @Override
   public int indexOf(Object elem)
   {
      DoubleNode currentNode = firstNode;
      int index = 0; 
      while (currentNode != null &&
             !currentNode.element.equals(elem))
      {
         currentNode = currentNode.next;
         index++;
      }

      if (currentNode == null)
         return -1;
      else
         return index;
   }

   public Object remove(int index)
   {
      checkIndex(index);

      DoubleNode currentNode;  

      if (index < size / 2)
      {
         currentNode = firstNode;
         for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
      }
      else
      {
         currentNode = lastNode;
         int numberToMove = size - index - 1;
         for (int i = 0; i < numberToMove; i++)
            currentNode = currentNode.previous;
      }

      if (size == 1)    
         firstNode = null;
      else
         if (index == 0)
         {
            firstNode = firstNode.next;
            firstNode.previous = null;
         }
         else
            if (index == size - 1)
            {
               lastNode = lastNode.previous;
               lastNode.next = null;
            }
            else
            {
               currentNode.previous.next = currentNode.next;
               currentNode.next.previous = currentNode.previous;
            }
      size--;
      return currentNode.element;
   }
   
   @Override
   public void add(int index, Object theElement)
   {
      if (index < 0 || index > size)
         throw new IndexOutOfBoundsException
                   ("index = " + index + "  size = " + size);

      if (index == 0)
      {
         firstNode = new DoubleNode(theElement, null, firstNode);
         if (firstNode.next == null)
            lastNode = firstNode;
         else
            firstNode.next.previous = firstNode;
      }
      else
         if (index == size)
         {
            lastNode.next = new DoubleNode(theElement, lastNode, null);
            lastNode = lastNode.next;
         }
         else
         {
            DoubleNode currentNode;
            if (index <= size / 2)
            {
               currentNode = firstNode;
               for (int i = 0; i < index - 1; i++)
                  currentNode = currentNode.next;
            }
            else
            {
               currentNode = lastNode;
               int numberToMove = size - index;
               for (int i = 0; i < numberToMove; i++)
                  currentNode = currentNode.previous;
            }

            currentNode.next =
                   new DoubleNode(theElement, currentNode, currentNode.next);
            currentNode.next.next.previous = currentNode.next;
      }
      size++;
   }
   

   @Override
   public String toString()
   {
      StringBuffer s = new StringBuffer("["); 
      if (size != 0)
      {
         s.append(firstNode.element.toString());
         DoubleNode currentNode = firstNode.next;
         while (currentNode != null)
         {
            s.append(", ").append(currentNode.element.toString());
            currentNode = currentNode.next;
         }
      }
      s.append("]");

      return new String(s);
   }
}
