package com.heena.ec.Assignment9.jasper;

import java.io.IOException;
import java.net.URISyntaxException;
import net.sf.jasperreports.engine.JRException;

public class Assign9Controller {
	
	public static void main(String args[])  throws URISyntaxException,JRException, IOException
	{
		Assign9Service sr=new Assign9Service();
		String path=sr.startGeneratingPdf();
		System.out.println("pdf generated at path "+ path);
		
	}

}
