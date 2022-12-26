package Exceptions;

public class TaskNotFoundExceptions extends Exception{
    private final int id;

    public TaskNotFoundExceptions(int id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Задача с id "+ id+ "не найдена!";
    }
}
