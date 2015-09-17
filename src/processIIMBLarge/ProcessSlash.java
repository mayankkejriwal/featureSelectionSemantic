package processIIMBLarge;

import java.io.*;

//import general.CSVParser;

import java.util.*;

public class ProcessSlash {

	static String folder="/host/heteroDatasets/journal/IIMB_LARGE/";
	
	public static void main(String[] args)throws IOException{
		File[] elements=(new File(folder)).listFiles();
		ArrayList<File> folders=new ArrayList<File>();
		for(File f:elements)
			if(f.isDirectory())
				folders.add(f);
			
		
		for(File f: folders)
			removeSlash(f.toString());
		
	}
	
	public static void removeSlash(String targetFolder)throws IOException{
		Scanner in=new Scanner(new FileReader(targetFolder+"/onto.csv"));
		PrintWriter out=new PrintWriter(new File(targetFolder+"/onto-mod.csv"));
		
			while(in.hasNextLine()){
				String line=in.nextLine();
				line=line.replace("\\","");
				out.println(line);
			}
		
		
			in.close();
			out.close();
		
		
	}
}
