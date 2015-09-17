package processIIMBLarge;

import java.io.*;

import general.CSVParser;

import java.util.*;

public class TestCSV {

	static String folder="/host/heteroDatasets/journal/IIMB_LARGE/";
	
	public static void main(String[] args)throws IOException{
		
		File[] elements=(new File(folder)).listFiles();
		ArrayList<File> folders=new ArrayList<File>();
		for(File f:elements)
			if(f.isDirectory())
				folders.add(f);
			
		
		for(File f: folders)
			testCSV(f.toString()+"/onto-mod.csv");
	}
	
	public static void testCSV(String file)throws IOException{
		Scanner in=new Scanner(new FileReader(file));
		int count=1;
		
			while(in.hasNextLine()){
				String line=in.nextLine();
				line=line.replace("\\","");
				try{
					
				String[] k=(new CSVParser()).parseLine(line);
				if(k.length!=3)
					System.out.println(count);
				}catch(IOException e){
					System.out.println(count);
				}
				count++;
			}
		
		
			in.close();
		
		
	}
}
