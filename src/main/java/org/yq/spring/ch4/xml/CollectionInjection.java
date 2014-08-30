package org.yq.spring.ch4.xml;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {

	private Map<String, Object> map;

	private Properties props;

	@SuppressWarnings("rawtypes")
	private Set set;

	@SuppressWarnings("rawtypes")
	private List list;

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	@SuppressWarnings("rawtypes")
	public Set getSet() {
		return set;
	}

	public void setSet(@SuppressWarnings("rawtypes") Set set) {
		this.set = set;
	}

	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	public void setList(@SuppressWarnings("rawtypes") List list) {
		this.list = list;
	}

	public void displayInfo() {
		System.out.println("Map content:\n");
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			System.out.println("Key:" + entry.getKey() + "-Value:"
					+ entry.getValue());
		}
		System.out.println("\nProperties contents:\n");
		for (Map.Entry<Object, Object> entry : props.entrySet()) {
			System.out.println("Key:" + entry.getKey() + "-Value:"
					+ entry.getValue());
		}
		System.out.println("\nSet contents:\n");
		for (Object obj : set) {
			System.out.println("Value:" + obj);
		}

		System.out.println("\nList contents:\n");
		for (Object obj : list) {
			System.out.println("Value:" + obj);
		}
	}

}
