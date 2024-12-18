package com.hexagonal.tasks.application.services;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.models.Task;
import com.hexagonal.tasks.domain.ports.in.*;


import java.util.List;
import java.util.Optional;


public class TaskService implements CreateTaskUseCase , DeleteTaskUseCase ,
        RetrieveTaskUseCase , UpdateTaskUseCase , GetAdditionalTaskInfoUseCase  {
    private final CreateTaskUseCase createTaskUseCase;
    private  final RetrieveTaskUseCase retrieveTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final  GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;


    public TaskService(CreateTaskUseCase createTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase,  UpdateTaskUseCase updateTaskUseCase,DeleteTaskUseCase deleteTaskUseCase, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long Id) {
        return deleteTaskUseCase.deleteTask(Id);
    }



    @Override
    public Optional<Task> getTask(Long Id) {
        return retrieveTaskUseCase.getTask(Id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long Id, Task updateTask) {
        return updateTaskUseCase.updateTask(Id, updateTask);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
    return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(taskId);
    }}