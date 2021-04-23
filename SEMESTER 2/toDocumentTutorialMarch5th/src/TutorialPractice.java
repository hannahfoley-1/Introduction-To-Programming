import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class TutorialPractice {

	public static void main(String[] args) {
		
		try
		{
			FileWriter fw = new FileWriter("C:\\Users\\hanna\\OneDrive\\Desktop\\captmidn.txt");
			//toDocument(fw);
			directoryProperties("C:\Users\hanna\OneDrive\Desktop\captmidn.txt");
			
		}
		catch (Exception e)
		{
			System.err.print(e);
		}
	}
	
	public static void toDocument(FileWriter fw) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(fw);
		InputStreamReader input = new InputStreamReader (System.in);
		BufferedReader bfr = new BufferedReader(input);
		
		String toPrint = "abc";
		while((toPrint != "null"))
		{
			System.out.print("What would you like to print into the file? Or if you're done type 'null' ");
			toPrint = bfr.readLine();
			if (!toPrint.equalsIgnoreCase("null"))
			{
				fw.write(toPrint + " ");
			}
		}
		bw.close();
	}
	
	public static void directoryProperties(String directory)
	{
		//make file names array, make list // for loop to loop thorugh file names
		File file = new File(directory);
		String fileName = file.getName();
		long fileLength = file.length();
		System.out.print("File name: " + fileName);
		System.out.print("File length: " + fileLength);
	}

}
