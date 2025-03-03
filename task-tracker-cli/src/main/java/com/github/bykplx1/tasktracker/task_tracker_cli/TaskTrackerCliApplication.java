package com.github.bykplx1.tasktracker.task_tracker_cli;

import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TaskTrackerCliApplication {

	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.out.println("No action provided. Usage: task-cli <action> [parameters]");
		}

		// System.out.println("DEBUG: args -> " + Arrays.toString(args));

		String action = args[0];
		String[] parameters = new String[args.length - 1];
		System.arraycopy(args, 1, parameters, 0, parameters.length);
		JsonFileService jsonFileService = new JsonFileService();

		// System.out.println("DEBUG: Action received -> " + action);
		// System.out.println("DEBUG: Parameters -> " + Arrays.toString(parameters));

		switch (action.toLowerCase()) {
			case "add" -> {
				handleAdd(parameters, jsonFileService);
			}
			case "update" -> {
			
			}
			case "delete" -> {
			
			}
			case "mark-in-progress" -> {
			
			}
			case "mark-done" -> {
			
			}
			case "list" -> {
			
			}
			default -> {
				System.out.println("Unknown action: " + action);
				return;
			}
		}

		SpringApplication.run(TaskTrackerCliApplication.class, args);
	}

	public static void handleAdd(String[] params, JsonFileService jsonFileService) {
		try {
			if (params.length == 1	) {
				TaskDataModel task = new TaskDataModel();
				String dateTime = getDateNowAsString();
				task.setDescription(params[0]);
				task.setCreatedAt(dateTime);
				task.setUpdatedAt(dateTime);
				task.setStatus("todo");
				jsonFileService.addTask(task);
			} else {
				System.out.println("Invalid command. Usage: task-cli add \"Task Description\"");
			}
		} catch (IOException e) {
			System.out.println("Error adding task: " + e.getMessage());
		}
	}
	public static void handleUpdate(String[] params) {
		System.out.println(MessageFormat.format("Perform task : {0}", params[0]));
	}
	public static void handleDelete(String[] params) {
		System.out.println(MessageFormat.format("Perform task : {0}", params[0]));
	}
	public static void handleMarkInProgress(String[] params) {
		System.out.println(MessageFormat.format("Perform task : {0}", params[0]));
	}
	public static void handleMarkDone(String[] params) {
		System.out.println(MessageFormat.format("Perform task : {0}", params[0]));
	}
	public static void handleList(String[] params) {
		System.out.println(MessageFormat.format("Perform task : {0}", params[0]));
	}

    private static String getDateNowAsString() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return now.format(formatter);
    }

}
