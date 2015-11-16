package com.ppship.common.util;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

	private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	public static <T> T getT(String string, Class<T> resultClass) {
		try {
			return OBJECT_MAPPER.readValue(string, resultClass);
		} catch (Exception e) {
			logger.error("error", e);
		}

		return null;
	}

	public static <T, K> Map<T, K> getMap(String string) {
		try {
			TypeReference<Map<T, K>> tr = new TypeReference<Map<T, K>>() {
			};
			return OBJECT_MAPPER.readValue(string, tr);
		} catch (Exception e) {
			logger.error("error", e);
		}

		return null;
	}

	public static <T> List<T> getList(String string) {
		try {
			TypeReference<List<T>> tr = new TypeReference<List<T>>() {
			};
			return OBJECT_MAPPER.readValue(string, tr);
		} catch (Exception e) {
			logger.error("error", e);
		}

		return null;
	}

	public static <T> String getString(T t) {

		try {
			return OBJECT_MAPPER.writeValueAsString(t);
		} catch (Exception e) {
			logger.error("error", e);
		}

		return null;
	}
}
