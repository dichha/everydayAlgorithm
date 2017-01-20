/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;

/**
 *
 * @author dichha
 */
public class QuickSort {
    private int array[];
    private int length;
    public void sort(int[] inputArr){
        array = inputArr;
        length = inputArr.length;
        quickSort(0, length-1);
    }
    private void quickSort(int lowerIndex, int higherIndex){
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        
        while(array[i] < pivot){
            i++;
        }
        while(array[j] > pivot){
            j--;
        }
        if(i <= j){
            exchangeNumber(i,j);
            i++;
            j--;
        }
        if(lowerIndex<j){
            quickSort(lowerIndex,j);
        }
        if(i<higherIndex){
            quickSort(i, higherIndex);
        }
    }
    private void exchangeNumber(int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args){
        QuickSort qs = new QuickSort();
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        qs.sort(input);
        for (int i:input){
            System.out.printf("%s ,",i );
        }        
    }
}
