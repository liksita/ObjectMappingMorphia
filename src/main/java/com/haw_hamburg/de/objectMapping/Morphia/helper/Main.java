package com.haw_hamburg.de.objectMapping.Morphia.helper;

import com.haw_hamburg.de.objectMapping.Morphia.app.FrameworkTest;

public class Main 
{
    public static void main( String[] args )
    {
//		 MongoDB
		FrameworkTest mongodb = new FrameworkTest(1, 1);
		try {
			mongodb.performWriteTest().printMeasureResult();
		} catch (Exception e) {
			System.out.println("Test Failed");
			e.printStackTrace();
		}
    }
}

