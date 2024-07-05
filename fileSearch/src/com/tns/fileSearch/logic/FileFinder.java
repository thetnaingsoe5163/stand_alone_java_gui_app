package com.tns.fileSearch.logic;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.tns.exceptions.FileIsNotDirectory;
import com.tns.exceptions.PathIsNotAbsolute;
import com.tns.exceptions.TargetDirNotFoundException;

public class FileFinder {

	ArrayList<String> foundFiles;
	
	ArrayList<Character> avoidCharactersForFile;
	
	{
		this.avoidCharactersForFile = new ArrayList<>();
		this.avoidCharactersForFile.add('\\');
		this.avoidCharactersForFile.add('/');
		this.avoidCharactersForFile.add(':');
		this.avoidCharactersForFile.add('|');
		this.avoidCharactersForFile.add('<');
		this.avoidCharactersForFile.add('>');
		this.avoidCharactersForFile.add('*');
		this.avoidCharactersForFile.add('?');
	}

	public FileFinder() {
		this.foundFiles = new ArrayList<String>();
	}

	public ArrayList<String> findFile(String folder, String fileName) {
		File targetSearchDir = new File(folder);
		if (!targetSearchDir.exists()) {
			throw new TargetDirNotFoundException();
		}
		if(!targetSearchDir.isDirectory()) {
			throw new FileIsNotDirectory();
		}
		if(!targetSearchDir.isAbsolute()) {
			throw new PathIsNotAbsolute();
		}
		String file = replaceBlackSlash(folder);
		file = folder.charAt(folder.length()-1) == '/'? folder.concat(fileName) : folder.concat("/").concat(fileName);
		return find(file);
	}

	private ArrayList<String> find(String fileName) {
		var arr = separator(fileName);
		
		var searchFileName = arr[0];
		var targetDir = arr[1];
			
		Path p = Paths.get(targetDir);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(p)) {
			var list = new ArrayList<String>();
			stream.forEach(a -> list.add(a.toString()));

			for (var l : list) {
				File file = new File(l);
				if (file.isDirectory()) {
					var subDir = file.toString().concat("/").concat(searchFileName);
					find(subDir);
				} else {
					arr = separator(file.toString());
					String compareFile = arr[0];
					var nameAndExtention = extentionAndFileNameSeparator(searchFileName);
					var name = nameAndExtention[0];
					var extention = nameAndExtention[1];
					compareFile = compareFile.toLowerCase();
					name = name.toLowerCase();
					extention = extention.toLowerCase();
					if ((compareFile.startsWith(name) && compareFile.endsWith(extention)) || (compareFile.contains(name) && compareFile.endsWith(extention))) {
						foundFiles.add(replaceBlackSlash(file.toString()));
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return foundFiles;
	}
	
	private String[] separator(String file) {
		file = replaceBlackSlash(file);
		var arr = new String[2];
		arr[0] = file.substring(file.lastIndexOf("/") + 1, file.length());
		arr[1] = file.substring(0, file.lastIndexOf("/"));
		return arr;
	}
	
	public String replaceBlackSlash(String path) {
		return path.replace("\\", "/");
	}
	
	public String[] extentionAndFileNameSeparator(String fileName) {
		var arr = new String[2];
		avoidCharactersForFile.forEach(a -> {
			if(fileName.contains(Character.toString(a))) {
				throw new IllegalArgumentException("Cannot contain [" + a + "]. " + "Take this out!");
			}
		});
		arr[0] = fileName.substring(0, fileName.lastIndexOf("."));
		arr[1] = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		return arr;
	}
}
