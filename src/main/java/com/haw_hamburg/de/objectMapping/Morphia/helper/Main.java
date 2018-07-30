package com.haw_hamburg.de.objectMapping.Morphia.helper;

import com.haw_hamburg.de.objectMapping.Morphia.app.FrameworkTest;

public class Main {
	public static void main(String[] args) {
		// MongoDB
		FrameworkTest frameworkTest = new FrameworkTest(1, 1);
		try {
			System.out.println("WRITE TEST");
			frameworkTest.performWriteTest().printMeasureResultWrite();
			System.out.println("READ TEST");
			frameworkTest.performReadTest().printMeasureResultRead();
		} catch (Exception e) {
			System.out.println("Test Failed");
			e.printStackTrace();
		}
	}
}
