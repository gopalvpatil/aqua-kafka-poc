package com.citi.frm.main;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.BasicConfigurator;

import com.citi.frm.hive.service.MetadataService;
import com.citi.frm.hive.service.impl.JsonMetadataService;
import com.citi.frm.hive.vo.Dataset;

import lombok.extern.log4j.Log4j;

@Log4j
public class HiveBoot {

	public static void main(String[] args) {
		BasicConfigurator.configure();

		log.info("Hive Application Booted ....");

		MetadataService service = new JsonMetadataService();
		List<Dataset> datasets = service.createDatasets();

		// print datasets
		// datasets.forEach(System.out :: println);
		log.debug("Total Dataset Count :: " + datasets.size());

		datasets.forEach(log::debug);
		log.debug("************************************************************************************************");

		List<Dataset> orcDatasets = datasets.stream().filter(dataset -> "ORC".equals(dataset.getSource()))
				.collect(Collectors.toList());

		orcDatasets.forEach(log::debug);

		log.debug("Total ORC Dataset Count :: " + orcDatasets.size());
	}

}
