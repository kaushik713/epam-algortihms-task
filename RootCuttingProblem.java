package algorithms;

import java.util.Map;
import java.util.Scanner;

//rod cutting problem

public class RootCuttingProblem {

  int rootCutting() {
   Scanner sc = new Scanner(System.in);
    int testcases = sc.nextInt();
    
    for (int i = 0;i < testcases;i++) {
      int number = sc.nextInt();
    
    int specailrodLength = -1;
    number++;
    while (number > 1) {
      specailrodLength++;
      number = number / 2;
    }
    return specailrodLength;
  }
  
    public static void main(String[] args) {
      RootCuttingProblem rp = new RootCuttingProblem();
          System.out.print(rp.rootCutting());
      
    }
   
    
  }
  

}
