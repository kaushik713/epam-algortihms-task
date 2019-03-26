package algorithms;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
public class GlowingBulbs {
 
public static long sum = 0;


public void input()
{
    Scanner input = new Scanner(System.in);
int testcaseno = input.nextInt();/*  it read no.of test cases */
for(int l=0;l<testcaseno;l++)
{
String bulb_switch = input.next();/*it read read bulb switch  status */
long k = input.nextLong();
List<Integer> list = new LinkedList<Integer>();/* creating List*/
for(int i=0;i<bulb_switch.length();i++)
{
if(bulb_switch.charAt(i) == '1')
{
list.add(i+1);/* pushing the status of ON bulb switch  position */
}
}
if(list.size() == 1)/* checking if List contains only one Glowing bulb */
{
System.out.println(list.get(0)*k);
}
else
{
long lowpos = list.get(0);
long highpos = list.get(0)*k;
long glowing_bulb= 0;/* initiallizing  glowing bulbs position is zero */

while(lowpos <= highpos)
{
long count = 0;
long mid = (lowpos + highpos)/2;
for(int i=0;i<list.size();i++)
{
long d = mid/list.get(i);/* here we get the glowing bulbs position before the mid and add those bulbs position
to the count variable*/
count = count + d;
}

for(int i=2;i<=list.size();i++)
{
sum = 0;
combination(list,list.size(),i,mid);/* calling combination function with these parameters */
if(i%2!=0)
{
count = count + sum;
}
else
{
    count = count - sum;

}
}
//count = count - (arr.size() - 1);
//System.out.println(count);
if(count >= k)
{
    glowing_bulb = mid;/* assigning mid to glowing_bulb if count lesser than the given k position*/
highpos = mid - 1 ;

}
else
{
    lowpos = mid + 1;

}
}
System.out.println( glowing_bulb);
}
}
input.close();

}


public static void combinationutil(List<Integer> list3,int[] data,int startpos,int endpos,int index,int i,long mid)
{
if(index == i)
{
long tempvar = 1;
for(int j=0;j<i;j++)
{
tempvar = tempvar*data[j];
}
long tempvar1 = mid/tempvar;
sum = sum + tempvar1;
return;
}
for(int j=startpos;j<=endpos && endpos-j+1>=i-index;j++)
{
data[index] = list3.get(j);
combinationutil(list3,data,j+1,endpos,index+1,i,mid);
}
}

public static void combination(List<Integer> list2,int size,int i,long mid)
{
int[] data = new int[i];
combinationutil(list2,data,0,size-1,0,i,mid);
}

public static void main(String[] args)
{
GlowingBulbs obj=new GlowingBulbs();

obj.input();
}
  


}
