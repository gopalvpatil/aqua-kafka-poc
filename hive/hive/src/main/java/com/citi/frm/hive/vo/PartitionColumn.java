package com.citi.frm.hive.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Setter
@Getter
public class PartitionColumn {
	private Object name; // year, month, day, bus_date etc
}
