package com.heena.ec.Assignment16.jasper;

import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class Service {

	public static String destinationPath="C:\\Assignment16.pdf";
	public String startGeneratingPdf() throws URISyntaxException, JRException, IOException {
		
		
		//jrxml location
		String JrxmlPath=getJrxmlLocationPath();
		
		//load jasper design
		JasperDesign jasperDesign= getJasperDesign(JrxmlPath);
	
		//compile jasper
		JasperReport jasperReport=compileJasperDesign(jasperDesign);
		
		//parameterMap
		Map<String,Object> parameterMap=getParameterMap();
		
		//empty data source
		JRDataSource dataSource=getEmptyDataSource();
		
		//jasper reportfill
		JasperPrint jasperPrint=buildReport(jasperReport,parameterMap,dataSource);	
		
		//export to pdf
		String exportPath=exportReportPdf(jasperPrint);
		
		return exportPath;
		
	}

	private String exportReportPdf(JasperPrint jasperPrint) throws JRException {
		JasperExportManager.exportReportToPdfFile(jasperPrint, destinationPath);
		return destinationPath;
	}

	private JasperPrint buildReport(JasperReport jasperReport, Map<String, Object> parameterMap, JRDataSource dataSource) throws JRException {
		return JasperFillManager.fillReport(jasperReport, parameterMap, dataSource);
	}

	private JRDataSource getEmptyDataSource() {
		JRDataSource dataSource=new JREmptyDataSource();
		return dataSource;
	}

	private Map<String, Object> getParameterMap() {
		Map<String,Object> parameterMap=new HashMap<>();
		return parameterMap;
	}

	private JasperReport compileJasperDesign(JasperDesign jasperDesign) throws JRException {
		return JasperCompileManager.compileReport(jasperDesign);
	}

	private JasperDesign getJasperDesign(String jrxmlPath) throws JRException, IOException {
		
		InputStream inputStream=new FileInputStream(new File(jrxmlPath));
		JasperDesign jasperDesign=JRXmlLoader.load(inputStream);
		inputStream.close();
		return jasperDesign;
	}

	private String getJrxmlLocationPath() throws URISyntaxException {
		
		String path=getClass().getClassLoader().getResource("Assignment16.jrxml").toURI().getPath();
		
		return path;
	}

}