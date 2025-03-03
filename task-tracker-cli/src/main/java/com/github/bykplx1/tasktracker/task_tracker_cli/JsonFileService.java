package com.github.bykplx1.tasktracker.task_tracker_cli;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsonFileService {
    private static final String FILE_PATH = "src/main/resources/tasks.json";

    public void addTask(TaskDataModel task) throws IOException {
        File jsonFile = new File(FILE_PATH);
        List<TaskDataModel> tasks = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();

        if (jsonFile.exists()) { tasks = objectMapper.readValue(jsonFile, new TypeReference<List<TaskDataModel>>() {}); }
        int newId = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
        task.setId(newId);
        tasks.add(task);
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, tasks);
        System.out.println(MessageFormat.format("Task added successfully (ID: {0})", newId));
    }

    public void updateTask() {

    }


}
