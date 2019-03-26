
package algorithms;

import java.util.Comparator;

import java.util.HashMap;

import java.util.Map;

import java.util.Scanner;

import java.util.TreeMap;

public class DesendingWeights { 
  
  /** this takes the input from user and stores it in a map.
   */
  
  public  Map<Integer, Integer> resultMap() {  
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int k = sc.nextInt();
    int value;
    Map<Integer,Integer>  values = new HashMap<Integer,Integer>();
    for (int i = 0;i < size;i++) {
      value = sc.nextInt();
      values.put(value,(value % k)); 
    }
    Map<Integer,Integer> result = sortByValues(values);
    return result;
  } 
  
  /**this is the main function.
   */
  
  public static void main(String[] args) {
    DesendingWeights t = new DesendingWeights();
    Map<Integer, Integer> solutionMap = t.resultMap(); 
    for (int i:solutionMap.keySet()) {
      System.out.print(i + " ");
    }
  }
  
  /**this implements comparator for sorting the map.
   */
  
  public static <K,V extends Comparable<V>> Map<K,V>
        sortByValues(final Map<K,V> inputMap) {
    Comparator<K> valueCompare = new Comparator<K>() {
      public int compare(K value1,K value2) {
        int compare = inputMap.get(value2).compareTo(inputMap.get(value1));
        if (compare == 0) {
          return 1; 
          } else {
          return compare;
        }
        }
      };
    Map<K,V> sortedMap = new TreeMap<K,V>(valueCompare);
    sortedMap.putAll(inputMap);
    return sortedMap;
  }

}