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
public class mainCircularList {
        public static void main(String[] args) {
        CircularList c = new CircularList();
        
        c.add(0, 0);
        c.add(1, 1);
        c.add(2, 2);
        c.add(3, 3);
        c.add(4, 4);
        c.add(0, 5);
        c.add(0, 6);
        
        System.out.println("Isi Elemen\t\t\t: "+c.toString());
        System.out.println("Element Index 0\t\t\t: "+c.get(0));
        System.out.println("Index Dari Elemen Ketiga\t: "+c.indexOf(3));
        
        c.remove(6);
        System.out.println("Isi Setelah Index ke 6 Dihapus\t: "+c.toString());
    }
}
