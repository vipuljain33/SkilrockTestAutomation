package utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ReusableStaticMethods 
{
	/*numcount is total numbers which will select
	 * numcount should not be greater than upper bound
	 */
	public static List<Integer> randomNumber(int lowerbound,int upperbound,int numcount)
	
	{
		List<Integer> random=new ArrayList<Integer>();
		//Random randomgenerate=new Random();
		//int randomnum=0;
		final int[] ints = new Random().ints(lowerbound, upperbound+1).distinct().limit(numcount).toArray();
		for(int i=0;i<ints.length;i++)
		{
			System.out.println(ints[i]);
			random.add(ints[i]);
		}
		
//		for(int i=0;i<numcount;i++)
//		{
//			
//		
//			randomnum=randomgenerate.nextInt((upperbound - lowerbound)+1)+lowerbound;
//			
//			
//			if(random.contains(randomnum))
//			{
//				
//				randomnum=randomgenerate.nextInt((upperbound - lowerbound)+1)+lowerbound;
//				random.add(randomnum);
//				System.out.println(randomnum);
//			}
//			else
//			{
//				random.add(randomnum);
//				System.out.println(randomnum);
//			}
//			}
		System.out.println(random);
		return random;
	}
	
	public static List<String> convertIntegerListToString(List<Integer> list) 
	{
		List<String> temp=new ArrayList<String>();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i) < 10)
			{
				temp.add("0"+list.get(i));
			}else
			{
				temp.add(String.valueOf(list.get(i)));
			}
			
		}
		return temp;
		
	}
	
	public static String covertStringToTwoDecimalNum(String input)
	 {
	  float ftnum=Float.parseFloat(input);
	  return String.format("%.2f",ftnum );
	  
	 }
	 public static String removeZeroFromticket(String val)
	 {
	  if(val.length()!=0)
	  {
	   val=val.substring(0, val.length()-1);
	   return val;
	   
	  }
	  else
	  {
	  return null;
	  }
	 }
	 public static String convertsToDateFormate(String Dateinput)
	 {
	  java.util.Date date=new Date(Dateinput);
	  SimpleDateFormat formate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String format=formate.format(date);
	  System.out.println(format);
	  return format;
	 }
	
}
