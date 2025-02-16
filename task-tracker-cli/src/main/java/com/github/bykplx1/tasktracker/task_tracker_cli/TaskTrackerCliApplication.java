package com.github.bykplx1.tasktracker.task_tracker_cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TaskTrackerCliApplication {

	public static void main(String[] args) {
        if (args.length == 0) {
			System.out.println("No action provided. Usage: task-cli <action> [parameters]");
        }

		String action = args[0];
		String[] parameters = new String[args.length - 1];
		System.arraycopy(args, 1, parameters, 0, parameters.length);

		switch (action.toLowerCase()) {
			case "add" -> {

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
				System.exit(1);
            }
		}

		SpringApplication.run(TaskTrackerCliApplication.class, args);
	}

	public void handleAdd(String[] params) {
		System.out.println("Task added successfully (ID: ${})");
	}

}
