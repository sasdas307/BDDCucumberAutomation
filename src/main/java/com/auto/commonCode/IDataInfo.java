package com.auto.commonCode;

public interface IDataInfo {
	
	default void display(){
		System.out.println("In IDataInfo");
	}
	
	int getNumber();

}
