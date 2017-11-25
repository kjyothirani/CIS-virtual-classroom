package com.ucmo.virtualclassroom.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {
	
	
	
	 
	 public static String asJsonString(final Object obj) {
		    try {
		        final ObjectMapper mapper = new ObjectMapper();
		        final String jsonContent = mapper.writeValueAsString(obj);
		        return jsonContent;
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}
	 
	 public static Object asObject(final String obj, Class<?> classType) {
		    try {
		        final ObjectMapper mapper = new ObjectMapper();
		       return mapper.readValue(obj, classType);
		    } catch (Exception e) {
		        throw new RuntimeException(e);
		    }
		}

}
