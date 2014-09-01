package org.yq.spring.ch5.pe;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

public class PropertyEditorBean {
	private byte[] bytes;

	@SuppressWarnings("rawtypes")
	private Class cls;

	private Boolean trueOrFalse;

	private List<String> stringList;

	private Date date;

	private Float floatValue;

	private File file;

	private InputStream stream;

	private Locale locale;

	private Pattern pattern;

	private Properties properties;

	private String trimString;

	private URL url;

	public void setBytes(byte[] bytes) {

		this.bytes = bytes;
		System.out.println("Adding " + this.bytes.length + " bytes");
	}

	@SuppressWarnings("rawtypes")
	public void setCls(Class cls) {
		this.cls = cls;
		System.out.println("Setting class:" + this.cls.getName());
	}

	public void setTrueOrFalse(Boolean trueOrFalse) {
		this.trueOrFalse = trueOrFalse;
		System.out.println("Setting Boolean:" + this.trueOrFalse);
	}

	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
		System.out.println("Setting string list with size:"
				+ this.stringList.size());
		for (String str : this.stringList) {
			System.out.println("String member:" + str);
		}
	}

	public void setDate(Date date) {
		this.date = date;
		System.out.println("Setting date:" + this.date);
	}

	public void setFloatValue(Float floatValue) {
		this.floatValue = floatValue;
		System.out.println("Setting float value:" + this.floatValue);
	}

	public void setFile(File file) {
		this.file = file;
		System.out.println("Setting file:" + this.file.getName());
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
		System.out.println("Setting stream:" + this.stream);
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
		System.out.println("Setting locale:" + this.locale.getDisplayName());
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
		System.out.println("Setting pattern:" + this.pattern);
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
		System.out.println("Loaded " + this.properties.size() + " properties");
	}

	public void setTrimString(String trimString) {
		this.trimString = trimString;
		System.out.println("Setting trim string:" + this.trimString);
	}

	public void setUrl(URL url) {
		this.url = url;
		System.out.println("Setting URL:" + this.url.toExternalForm());
	}

}
