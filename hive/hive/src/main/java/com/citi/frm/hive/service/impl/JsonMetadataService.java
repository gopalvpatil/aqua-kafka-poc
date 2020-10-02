package com.citi.frm.hive.service.impl;

import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.citi.frm.hive.service.MetadataService;
import com.citi.frm.hive.vo.Dataset;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import lombok.extern.log4j.Log4j;;

@Log4j
public class JsonMetadataService implements MetadataService {
	
	@Override
	public List<Dataset> createDatasets() {
		log.debug("Reading datasets json file and creating datasets");
		List<Dataset> datasets = new ArrayList<Dataset>();
		try {
			// create a reader
			URL resource = getClass().getClassLoader().getResource("datasets.json");
			Reader reader = Files.newBufferedReader(Paths.get(resource.toURI()));
			// convert JSON array to list of users
			datasets = new Gson().fromJson(reader, new TypeToken<List<Dataset>>() {
			}.getType());
			// close reader
			reader.close();
		} catch (Exception ex) {
			log.error("Error: Exception while creating datasets", ex);
		}
		return datasets;
	}

	

}
