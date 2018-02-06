package com.pet.mvc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MvcUtil {

	private static boolean checkInterface(Class clazz, String interfaceName) {
		boolean res = false;
		Class interfaces[] = clazz.getInterfaces();
		for (Class temp : interfaces) {
			if (temp.getName().equals(interfaceName)) {
				res = true;
				break;
			}
		}
		return res;
	}

	public static Map buildHandler(String propsFile) throws MvcException {
		Map handlers = new HashMap();
		Properties props = new Properties();
		FileInputStream inputStream = null;

		try {
			inputStream = new FileInputStream(propsFile);
			props.load(inputStream);
			Enumeration propEnum = props.propertyNames();
			while (propEnum.hasMoreElements()) {
				String key = (String) propEnum.nextElement();
				String handClazz = props.getProperty(key);
				Class handClazzRef = Class.forName(handClazz);
				if (checkInterface(handClazzRef,
						"com.nttdata.mvc.HttpRequestHandler")) {
					handlers.put(key, handClazzRef.newInstance());
				} else {
					throw new MvcException(
							"Class does not implement com.nttdata.mvc."
									+ "HttpRequestHandler interface");
				}

			}

		} catch (FileNotFoundException e) {
			throw new MvcException("Property file not found", e);
		} catch (IOException e) {
			throw new MvcException("Could not load the property file", e);
		} catch (ClassNotFoundException e) {
			throw new MvcException("No such handler class defined", e);
		} catch (InstantiationException e) {
			throw new MvcException(e);
		} catch (IllegalAccessException e) {
			throw new MvcException(e);
		}
		return handlers;
	}
}
