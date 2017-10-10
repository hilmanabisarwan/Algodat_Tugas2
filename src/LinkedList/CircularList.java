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
public class CircularList implements LinearList{
   protected ChainNode lastNode;
   protected int size;

   public CircularList(int initialCapacity){}

   public CircularList(){
       this(0);
   }

   @Override
   public boolean isEmpty(){
       return size == 0;
   }

   @Override
   public int size(){
       return size;
   }

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

      ChainNode currentNode = lastNode.next;
      for (int i = 0; i < index; i++)
         currentNode = currentNode.next;

      return currentNode.element;
   }
   
   @Override
   public int indexOf(Object elem)
   {
      if (size == 0)
         return -1; 

      ChainNode currentNode = lastNode.next;
      int index = 0;
      while (currentNode != lastNode &&
             !currentNode.element.equals(elem))
      {
         currentNode = currentNode.next;
         index++;
      }

      if (currentNode.element.equals(elem))
         return index;
      else
         return -1;
   }
   
   @Override
   public Object remove(int index)
   {
      checkIndex(index);

      Object removedElement;
      if (size == 1)
      {
         removedElement = lastNode.element;
         lastNode = null;
      }
      else
      {
         ChainNode q = lastNode;
         for (int i = 0; i < index; i++)
            q = q.next;

         if (q.next == lastNode)
            lastNode = q;

         removedElement = q.next.element;
         q.next = q.next.next;
      }
      size--;
      return removedElement;
   }

   @Override
   public void add(int index, Object theElement)
   {
      if (index < 0 || index > size)
         throw new IndexOutOfBoundsException
                   ("index = " + index + "  size = " + size);

      if (size == 0)
      {
         lastNode = new ChainNode(theElement);
         lastNode.next = lastNode;
      }
      else
         if (index == size)
         {
            ChainNode newNode = new ChainNode(theElement, lastNode.next);
            lastNode.next = newNode;
            lastNode = newNode;
         }
         else
         {
             ChainNode p = lastNode;
             for (int i = 0; i < index; i++)
                p = p.next;
   
             p.next = new ChainNode(theElement, p.next);
         }
      size++;
   }
   
   @Override
   public String toString()
   {
      StringBuffer s = new StringBuffer("["); 
      if (lastNode != null)
      {
         ChainNode firstNode = lastNode.next;
         s.append(firstNode.element.toString());

         ChainNode currentNode = firstNode.next;
         while(currentNode != firstNode)
         {
            s.append(", ").append(currentNode.element.toString());
            currentNode = currentNode.next;
         }
      }
      s.append("]");

      return new String(s);
   }
}
