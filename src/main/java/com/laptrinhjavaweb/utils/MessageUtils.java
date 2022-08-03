package com.laptrinhjavaweb.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageUtils {

	public Map<String, String> getMessage(String message) {
		Map<String, String> result = new HashMap<>();
		if (message.equals("update_success")) {
			result.put("message", "Update success");
			result.put("alert", "success");
		} else if (message.equals("insert_success")) {
				result.put("message", "Insert success");
				result.put("alert", "success");
		} else if (message.equals("delete_success")) {
			result.put("message", "Delete success");
			result.put("alert", "success");
		} else if (message.equals("error_system")) {
			result.put("message", "Error system");
			result.put("alert", "danger");
		} else if (message.equals("reset_password_success")) {
			result.put("message", "Reset password success");
			result.put("alert", "success");
		} else if (message.equals("change_password_fail")){
			result.put("message", "Change password failed");
			result.put("alert", "danger");
		}
		return result;
	}
}
