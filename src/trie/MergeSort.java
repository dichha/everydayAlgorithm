/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trie;
import java.lang.System;

/**
 *
 * @author dichha
 */
public class MergeSort {
  private int[] array;
  private int[] tempMergArr;
  private int length;
  public static void main(String[] args){
      int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
      MergeSort ms = new MergeSort();
      ms.sort(inputArr);
      for(int i:inputArr){
          System.out.printf("%s ",i);
      }
  }
  public void sort(int[] inputArr){
      this.array = inputArr;
      this.length = inputArr.length;
      this.tempMergArr = new int[length];
      doMergeSort(0, length-1);
      
      
  }
  public void doMergeSort(int lowerIndex, int higherIndex){
      if(lowerIndex >= higherIndex){
          return;
      }
      int middle = lowerIndex + (higherIndex - lowerIndex)/2;
      doMergeSort(lowerIndex, middle);
      doMergeSort(middle+1, higherIndex);
      mergeParts(lowerIndex, middle, higherIndex);
  }
  public void mergeParts(int lowerIndex, int middle, int higherIndex){
      for (int i=lowerIndex; i<= higherIndex; i++){
          tempMergArr[i] = array[i];
      }
      int i = lowerIndex;
      int j = middle+1;
      int k = lowerIndex;
      while(i <= middle && j<=higherIndex){
          if(tempMergArr[i] <= tempMergArr[j]){
              array[k] = tempMergArr[i];
              i++;
          }else{
              array[k] = tempMergArr[j];
              j++;
          }
          k++;
      }
     
      while(i <= middle){
          array[k] = tempMergArr[i];
          k++;
          i++;
      }
  }
  
    
}
