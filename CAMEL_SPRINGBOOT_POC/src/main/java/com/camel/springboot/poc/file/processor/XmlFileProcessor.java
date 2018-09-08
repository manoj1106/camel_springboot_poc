/**
 * 
 */
package com.camel.springboot.poc.file.processor;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Manoj Patel
 *
 */
@Component("xmlFileProcessor")
public class XmlFileProcessor implements FileProcessor {

	private static final Logger log = LoggerFactory.getLogger(XmlFileProcessor.class);
	
	@Override
	public void processsFile(File file) {
		log.info("processing file : {} ", file.getName());	
	}

}
