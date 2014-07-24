package framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;

public class Report_Header {

	public void report_Header(String viewPort, String application)
			throws IOException {
		String ipaddress = Inet4Address.getLocalHost().getHostAddress();
		String osname = System.getProperty("os.name");
		FileWriter fw = null;
		BufferedWriter bw = null;

		System.out.println("Came to report header");
		File ff=new File("DriverSheet.ods");
		String path=ff.getAbsolutePath();
		String newPath=path.substring(0,path.lastIndexOf("/")).concat("/");
		//String Filevalue = "/Users/kalyan_v/Desktop/FRAMEWORK/";
		String Files = newPath.concat(viewPort).concat(application)
				.concat(".html");
		File file = new File(Files);
		System.out.println(newPath.concat(viewPort).concat(application)
				.concat(".html"));

		if (file.exists()) {
			file.delete();
		}
		fw = new FileWriter(Files);
		bw = new BufferedWriter(fw);
		String pixel = "1000px";
		bw.write("<html><head><title>Automation reports</title></head><body>");
		bw.write("<TABLE Border=1 style=width:"
				+ pixel
				+ "><TR  BGCOLOR=#C0C0C0><TH style=width:333px align=left>IPAddress:"
				+ ipaddress + "<TH style=width:333px align=left>OS version:"
				+ osname
				+ "<TH style=width:40px align=left>application:Steps</TR>");
		bw.write("<TABLE Border=1 style=width:"
				+ pixel
				+ "><TR  BGCOLOR=#C0C0C0><TH style=width:333px align=left>TCNO<TH style=width:333px align=left>TCDescription<TH style=width:333px align=left>Status</TR>");
		bw.write("</TABLE>");
		bw.close();
	}
}
