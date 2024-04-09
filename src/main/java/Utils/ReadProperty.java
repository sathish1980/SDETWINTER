package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {

	static String filepath = System.getProperty("user.dir")+"//Environment//env.properties";

	public static Properties GetPropertyData() throws IOException
	{
		File F = new File(filepath);
		FileInputStream fs = new FileInputStream(F);
		Properties P = new Properties();
		P.load(fs);
		return P;
	}
}
