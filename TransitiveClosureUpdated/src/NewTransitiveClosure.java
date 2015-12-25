import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;

public class NewTransitiveClosure 
{

	public static void main(String[] args) throws IOException ,ConcurrentModificationException
	{
		 BufferedReader br=new BufferedReader(new FileReader("InputFile Path"));
		 String line;
		 List<HashSet> listA=new CopyOnWriteArrayList<HashSet>();
		 Set<Set> finalset=new HashSet();
		 Set<String> hs3;
	
		 while((line =br.readLine())!=null)
		 {
			 String[] str=line.split(",");
			 HashSet<String> hs=new HashSet<>();
			 
			 for(int i=0;i<str.length;i++)
			 {
				 hs.add(str[i]);
		     }
			 listA.add(hs);
		 }
		 
		 for(Set s:listA)
			 
		 {
			 System.out.println(s.toString());
		 }
	     
		 for(HashSet hs1:listA)
		 {
			 hs3 =new HashSet<String>(hs1);
			 for(HashSet hs2:listA)
			 {
	     		 if(!Collections.disjoint(hs3, hs2))
					 {
	     			     Set<String> hs4 =new HashSet<String>(hs3);
	     			     
						 hs3.addAll(hs2);
						 listA.remove(hs2);
						 listA.remove(hs4);
					 }
	     		 
	          }
			 listA.add((HashSet) hs3);
		 }
		 System.out.println();
		 System.out.println("----------Output-------");
		 int counter=0;
		 BufferedWriter bw=new BufferedWriter(new FileWriter("Outputfile path"));
		 for(Set s: listA)
		 {
			 System.out.println(counter++);
			 System.out.println(s.toString().replace("[","").replace("]", ""));
			 bw.write("LINK_"+randGenerator()+"|"+s.toString().replace("[","").replace("]", ""));
			 bw.newLine();
		 }
		 System.out.println("Done");
     }
	
	public static String randGenerator()
	{
		int length=10;
		boolean useLetters=true;
		boolean useNumbers=true;
		String generatedString= RandomStringUtils.random(length, useLetters, useNumbers);
		
		return generatedString;
		
	}
	
}

