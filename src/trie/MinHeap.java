/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

import java.util.Arrays;

/**
 *
 * @author dichha
 */
public class MinHeap {
    private int capacity = 10;
    private int size = 0;
    int[] items = new int[capacity];
    
    private int getLeftChildIndex(int parentIndex){
        return 2*parentIndex+1; 
    }
    private int getRightChildIndex(int parentIndex){
        return 2*parentIndex+2;
    }
    private int getParentIndex(int childIndex){
        return (childIndex-2)/2;
    }
    
    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) > size-1;
    }
    private boolean hasRightChild(int index){
        return getRightChildIndex(index) > size-1;
    }
    private boolean hasParent(int index){
        return getParentIndex(index) >= 0;
    }
    private int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }
    private int rightChild(int index){
        return items[getRightChildIndex(index)];
    }
    private int parent(int index){
        return items[getParentIndex(index)];
    }
    public void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;    
    }
    public void ensureCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity*2);
            capacity *= 2;
        }
    }
    public int peek(){
        if(size == 0){
            throw new IllegalStateException();
        }
        return items[0];
    }
    public int poll(){
        if(size==0)
            throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }
    public void add(int item){
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
    
    public void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }
            if(items[index] < items[smallerChildIndex]){
                break;
            }else{
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }    
    }
    public void heapifyUp(){
        int index = size-1;
        while(hasParent(index) && parent(index) > items[index]){
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }  
    }
}
