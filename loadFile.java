package cookirun;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class loadFile {
	public String[] map() throws IOException {
		String map[] = new String[80];
		File file = new File("C:\\Users\\cndls\\OneDrive\\Desktop\\자바 쿠키런\\map.txt");
		int i=0;
		if(file.exists()) 
		{ 
			BufferedReader inFile = new BufferedReader(new FileReader(file)); 
			String sLine = null; 
			while( (sLine = inFile.readLine()) != null ) {
				map[i]=sLine;
				i++;
			}
		}
        
        return map;
    }
}