package algorithms;
/*
 * help out Indian army
 */
import java.util.*;
public class IndianArmy {
    long c;
    long d;
   long res=0;
   long start;
   long end;
  
 
  //function to calculate the uncovered distance
  
  
  public long  result() {
    
    Scanner sc = new Scanner(System.in);
    
    //read no of checkpoint
    
    int n =sc.nextInt();
    
    //starting range
    
     start = sc.nextLong();
     
     // ending range
     end= sc.nextLong();
     
     //it is used to store checkpoints and no of man
     
    TreeMap<Long,Long> tr1=new TreeMap<Long,Long>();
    
    TreeMap<Long,Long> tr2=new TreeMap<Long,Long>();
    for(int i=0;i<n;i++)
    {
        long x = sc.nextLong();
        long p = sc.nextLong();
        tr1.put((x-p),(x+p));
   
}
Map.Entry<Long,Long> temp = tr1.entrySet().iterator().next();

     c = temp.getKey();
     d = temp.getValue();
  
    tr1.forEach((key,value)-> {
    if(key<=d){
        d = Math.max(d,value);
    }
    else
    {
        tr2.put(c,d);
        c=key;
        d=value;
    }}
    );
  
    tr2.put(c,d);

for(Map.Entry<Long,Long> entry:tr2.entrySet()){
 Long k=entry.getKey();
 long v=entry.getValue();
  if(start>=end)
        {
            start=end;
            break;
        }
        if(k<=start && start<=v)
            start =v;
        else if(start<=k && end>=v || (start<=k && end>=k && end<=v))
        {
          res+=k-start;
            start = v;
           
        }
        
          else if(start<=k &&end<=k)
        {
            res+=k-start;;
            start = end;
        }
        
        
 
}
    if(start<end)
        res+=end-start;
    return res;
    
  }
  
  
 
    
      public static void main(String args[]) {
        IndianArmy indianarmy=new IndianArmy();
         System.out.println(indianarmy.result());
      }



        
        
  }


