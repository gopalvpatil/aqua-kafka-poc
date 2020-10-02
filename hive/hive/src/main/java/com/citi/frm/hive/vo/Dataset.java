package com.citi.frm.hive.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Setter
@Getter
public class Dataset {

	private Object _id;
	private String name;
	private String path;
	private String dateColumn;
	private String [] keyColumns;
	private boolean temporal;
	private String [] partitionColumns;
	private String category;
	private String partitioningSchema;
	private String source;
	
}
