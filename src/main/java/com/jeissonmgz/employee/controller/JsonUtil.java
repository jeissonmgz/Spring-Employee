/**
 * 
 */
package com.jeissonmgz.employee.controller;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author JMalaver
 *
 */
public class JsonUtil {
    static byte[] toJson(Object object) throws IOException {
	ObjectMapper mapper = new ObjectMapper();
	mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	return mapper.writeValueAsBytes(object);
    }

}
