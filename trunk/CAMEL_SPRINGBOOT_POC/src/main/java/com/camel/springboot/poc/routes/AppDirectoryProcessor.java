/**
 * 
 */
package com.camel.springboot.poc.routes;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.camel.springboot.poc.file.processor.FileProcessor;
import com.camel.springboot.poc.utils.FileUtils;

/**
 * @author Manoj Patel
 *
 */
public class AppDirectoryProcessor implements Processor {
	
	private static final Logger log = LoggerFactory.getLogger(AppDirectoryProcessor.class);
	
	@Autowired
	private FileProcessor csvFileProcessor;
	
	@Autowired
	private FileProcessor xmlFileProcessor;
	
	@Override
	public void process(Exchange exchange) throws Exception {
		log.info("Processor - process() - start");
		if(null != exchange.getIn() && null != exchange.getIn().getBody()) {
			File file = exchange.getIn().getBody(File.class);
			String fileName = file.getName();
			log.info("File from the exchange property is : {}" , fileName);
			if(FileUtils.isFileExtensionValid(fileName)) {
				log.info("Valid extension in the file : {}" , fileName);
				//TODO : do your further processing valid extension
				//TODO : check what type of extension file is received create your processor for specific processor and then do further processing
				String ext = FileUtils.getFileExtension(fileName);
				log.info("extension in the file : {}" , ext);
				switch(ext) {
					case "csv" :
						log.info("csv file received processing csv file : {}" , fileName);
						csvFileProcessor.processsFile(file);
						break;
					case "xml":
						log.info("xml file received processing xml file : {}" , fileName);
						xmlFileProcessor.processsFile(file);
						break;
					default:
						log.error("invalid file... {} " , fileName);
						break;
				}
			} else {
				log.error("invalid file extension ... {} " , fileName);
			}
			
		}
		log.info("Processor - process() - end");
	}

}
