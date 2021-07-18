import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Execute {
	
	public static ArrayList variables = new ArrayList();
	
	public static String checkIfVariable  (String x) {
		for(int i = 0 ; i<variables.size();i++) {
			Object [] temp = (Object[]) variables.get(i);
			if(temp[0].equals(x)) {
				return (String) temp[1];
			}
		}
		return x;
	}
	
	public static ArrayList readProgram (String path) throws FileNotFoundException {
		
		  File file = new File(path+".txt");
	      Scanner sc = new Scanner(file);
	      
	      /*
	       write x y
	       add x y
	       */
	      
	      /*
	       [[write,x,y],
	       [add,x,y]]
	       */
	      ArrayList program = new ArrayList ();
	      while(sc.hasNextLine()){
	    	  // [write, x, y]
	    	  String [] temp = sc.nextLine().split(" ");
	    	  
	    	  program.add(temp);
	      }
	      
	      
	      
	      return program ;
	}
	
	public static void executeFile (String path) throws FileNotFoundException, InterruptedException {
		ArrayList program =readProgram(path);
		System.out.println("start executing program");
		TimeUnit.SECONDS.sleep(2);
		for(int i = 0 ; i<program.size();i++) {
			returnInput((String[]) program.get(i));
		}
		TimeUnit.SECONDS.sleep(1);
		System.out.print("finish executing program");
		
	}
	public static String returnInput (String [] arr) throws InterruptedException, FileNotFoundException {
		String temp = arr[0];
		switch(temp){
		case "print":
			Methods.print(returnInput(Arrays.copyOfRange(arr, 1, arr.length)));
			return "";
			
		case "assign":
			Methods.assign(returnInput(Arrays.copyOfRange(arr, 1, arr.length)),returnInput(Arrays.copyOfRange(arr, 2, arr.length)));
			return "";

		case "writeFile":
			Methods.WriteInToFile(returnInput(Arrays.copyOfRange(arr, 1, arr.length)),returnInput(Arrays.copyOfRange(arr, 2, arr.length)));
			return "";
			
		case "readFile":
			return Methods.readFile(returnInput(Arrays.copyOfRange(arr, 1, arr.length)));
			
			
	    case "add":
		    Methods.AddTwoNumbers(returnInput(Arrays.copyOfRange(arr, 1, arr.length)),returnInput(Arrays.copyOfRange(arr, 2, arr.length)));
		    return "";
	    default:
	    	return arr[0];
			
			
			
		}
	}
	public static void main (String[]args) throws FileNotFoundException, InterruptedException {
	executeFile("Program 1");
	executeFile("Program 2");
	executeFile("Program 3");
	}
	
	

}
