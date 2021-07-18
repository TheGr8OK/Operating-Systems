import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Methods {

	// readFile x
	 public static String readFile(String x) throws FileNotFoundException  {
			String filename = Execute.checkIfVariable(x);
			String s = "";
			  File file = new File(filename+".txt");
			  
		      Scanner sc = new Scanner(file);
		      while(sc.hasNextLine()){
		    	  s+=sc.nextLine()+"\n";
		      }
		      return s;  
		      
		}
	 
	 // writeFile x y
	 
	 public static void WriteInToFile(String x , String y) {
		    try {
		    	String  filenameS = Execute.checkIfVariable(x);
		    	String  fileInput = Execute.checkIfVariable(y);
				File filename = new File(filenameS+".txt");
				if (filename.createNewFile()) {
					System.out.println("File created: " + filename.getName());
					try {
					      FileWriter myWriter = new FileWriter(filenameS+".txt");
					     
					      myWriter.write(fileInput);
					      myWriter.close();
					      System.out.println("Successfully wrote to the file.");
					    } catch (IOException e) {
					      System.out.println("An error occurred.");
					      e.printStackTrace();
					    }
				} else {
					try
					{
					    FileWriter fw = new FileWriter(filenameS+".txt",true); //the true will append the new data
					    fw.write("\n"+fileInput);//appends the string to the file
					    fw.close();
					    System.out.println("Successfully wrote to the file.");
					}
					catch(IOException ioe)
					{
					    System.err.println("IOException: " + ioe.getMessage());
					}
				}
		    	} catch (IOException e) {
		    		System.out.println("An error occurred.");
		    		e.printStackTrace();
		    }
		  }
	 
	
	// print x
	 public static void print(String x) {
		 String y = Execute.checkIfVariable(x);
			System.out.println(y);
			
		}
	 
	// assign x y
	 public static void assign (String varName , String variable) {
		 if(variable.equals("input")) {
			 Scanner input = new Scanner(System.in);
				System.out.println("please enter your input :");
				variable = input.nextLine();
		 }
		 
		 String newValue = Execute.checkIfVariable(variable);
		 Object[] x = new Object[2];
		 x[0]= varName;
		 x[1]= newValue;
		 for (int i = 0 ; i<Execute.variables.size();i++) {
			 Object[]temp=(Object[]) Execute.variables.get(i);
			 if(temp[0].equals(varName)) {
				( (Object[])Execute.variables.get(i))[1]=newValue;
				return ;
			 }
		 }
		 Execute.variables.add(x);
	 }
	 
	 // add x y
	 public static void  AddTwoNumbers(String x,String y) throws InterruptedException  {
		  int a =  Integer.parseInt(Execute.checkIfVariable(x));
		  int b =  Integer.parseInt(Execute.checkIfVariable(y));
			int z = a+b;
			System.out.println("the program is calculating now..... ");
			TimeUnit.SECONDS.sleep(1);
			assign (x , ""+z) ;
			System.out.println("done ");
			//System.out.println(z);
			//return z;
		}
}
