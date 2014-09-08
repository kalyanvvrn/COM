package framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results {
	@SuppressWarnings("unused")
	public void results(String testCaseno, String testCaseDescription,
			String Status, String viewPort, String application,String startTm,String endTm)
			throws IOException {
		System.out.println("Came to results");
		String osname = System.getProperty("os.name");
		String output = null;
		String newPath=null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		File ff = new File("DriverSheet.ods");
		String path=ff.getAbsolutePath();
		//String newPath=path.substring(0,path.lastIndexOf("/")).concat("/");
		if(osname.toUpperCase().contains("MAC"))
		{
			 newPath=path.substring(0,path.lastIndexOf("/")).concat("/");
			System.out.println("came to reports making");
		}
		else
		{
		 newPath=path.substring(0,path.lastIndexOf("\\")).concat("\\");
		}
		System.out.println(newPath);
		String Files = newPath.concat(viewPort).concat(application)
				.concat(".html");
		String align = "center";
		//File tickMark=new File("tickmark.png");
		//String tick=tickMark.getAbsolutePath();
		//File xmark=new File("x mark");
	   // String cross=xmark.getAbsolutePath();
		String color = "lightgreen";
		String headercolor = "grey";
		
		
		File f = new File(Files);
		fw = new FileWriter(f, true);
		bw = new BufferedWriter(fw);
		System.out.println(Status);
		bw.write("<table border=1 style=width:1000px>");
		bw.write("<tr>");
		if (Status.equals("Pass")) {
			bw.write("<td style=width:333px BGCOLOR=" + color + ">" + testCaseno
					+ "</td>");
			bw.write("<td style=width:333px BGCOLOR=" + color + ">"
					+ testCaseDescription + "</td>");
			bw.write("<td style=width:333px BGCOLOR=" + color + ">"
					+ "PASS" + "</td>");
		}
		if (Status.equals("Fail")) {
			bw.write("<td style=width:333px BGCOLOR=#FF0000 >" + testCaseno
					+ "</td>");
			bw.write("<td style=width:333px BGCOLOR=#FF0000 >"
					+ testCaseDescription + "</td>");
			bw.write("<td style=width:333px BGCOLOR=#FF0000 >"
					+ "FAIL" + "</td>");
		}
		bw.write("</tr>");
		bw.write("</table>");
		bw.close();
	}
}
