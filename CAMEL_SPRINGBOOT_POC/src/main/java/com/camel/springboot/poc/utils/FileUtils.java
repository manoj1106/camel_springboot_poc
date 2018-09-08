/**
 * 
 */
package com.camel.springboot.poc.utils;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Manoj Patel
 *
 */
public class FileUtils {

	private static final List<String> validFileExtentions = Arrays.asList(new String[] {"csv" , "xml", "txt"});

	public static boolean isFileExtensionValid(String fileName) {

		if(StringUtils.isBlank(fileName)) {
			return false;
		}

		String file[] = fileName.split("\\.");

		if(file.length != 2) {
			return false;
		}

		if(validFileExtentions.contains(file[1])) {
			return true;
		}

		return false;
	}
	
	public static String getFileExtension(String fileName) {
		return fileName.split("\\.")[1].toLowerCase();
	}

	public static boolean isCsvFile(String ext) {
		if("csv".equalsIgnoreCase(ext)) {
			return true;
		}
		return false;
	}

}
