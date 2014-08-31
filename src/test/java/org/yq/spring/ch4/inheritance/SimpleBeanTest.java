package org.yq.spring.ch4.inheritance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBeanTest {

	@Test
	public void test() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/inheritance.xml");
		ctx.refresh();

		SimpleBean parent = ctx.getBean("inheritParent", SimpleBean.class);
		System.out.println(parent);
		SimpleBean child = ctx.getBean("inheritChild", SimpleBean.class);

		System.out.println(child);
		ctx.close();
		File parentDir = new File("E:\\5000W");
		File[] dirFiles = parentDir.listFiles();
		
		for(File dir:dirFiles)
		{
			if(dir.isFile())
			{
				continue;
			}
			File[] files = dir.listFiles();
			for(File file:files)
			{
				if(file.getName().endsWith(".csv"))
				{
					parseFile(file);
				}
			}
		}

	}

	private void parseFile(File file) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(file),
					"UTF-8"));
			String str = null;
			while ((str = reader.readLine()) != null) {
				String[] fields = str.split(",");
				if (null != fields && fields.length >= 1) {
					String name = fields[0];
					if("".equals(name.trim()))
					{
						System.out.println(str);
					}
					//System.out.println(name);
				}
			}
			reader.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
