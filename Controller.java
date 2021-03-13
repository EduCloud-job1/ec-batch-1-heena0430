package com.heena.ec.Assignment10.jasper;

import java.io.IOException;
import java.net.URISyntaxException;

import net.sf.jasperreports.engine.JRException;

public class Controller {
	
	public static void main(String args[])  throws URISyntaxException, JRException, IOException
	{
		Service sr=new Service();
		String path=sr.startGeneratingPdf();
		System.out.println("pdf generated at path "+ path);
		
	}

}
