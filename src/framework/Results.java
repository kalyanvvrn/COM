package framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Results {
	@SuppressWarnings("unused")
	public void results(String testCaseno, String testCaseDescription,
			String Status, String viewPort, String application)
			throws IOException {
		String output = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		String filevalue = "/Users/venkatarama_n/Documents/JAVA_PROJECTS/COM/";
		String Files = filevalue.concat(viewPort).concat(application)
				.concat(".html");
		String align = "center";
		File tickMark=new File("tickmark.png");
		String tick=tickMark.getAbsolutePath();
		File xmark=new File("x mark");
	    String cross=xmark.getAbsolutePath();
		String color = "lightgreen";
		String headercolor = "grey";
		File f = new File(Files);
		fw = new FileWriter(Files, true);
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
