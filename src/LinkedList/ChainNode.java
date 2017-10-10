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
public class ChainNode {
    Object element;
    ChainNode next;
    
    ChainNode(){}
    
    ChainNode(Object element){
        this.element = element;
    }
    
    ChainNode(Object element, ChainNode next){
        this.element = element;
        this.next = next;
    }
}
