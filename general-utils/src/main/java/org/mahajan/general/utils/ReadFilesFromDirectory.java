package org.mahajan.general.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFilesFromDirectory {
	
	
	public static void main(String[] args) throws IOException {
		
		String directoryPath = args[0];
		
		/*Files.list(Paths.get(directoryPath))
        .forEach(System.out::println);	*/
		
		
		try(Stream<Path> paths = Files.walk(Paths.get(directoryPath))) {
		    paths.forEach(filePath -> {
		        if (Files.isRegularFile(filePath)) {
		            System.out.println(filePath.getFileName());
		        }
		    });
		} 
	}

}
