package Model;

import Exceptions.IncorrectTaskParameterException;
import utill.Constant;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task {
    public static int idGenerator = 1;

    private final int id;
    private String title;
    private String description;
    private Type type;
    private LocalDateTime dateTime;
    private Repeatability repeatability;

    public Task(String title,
                String description,
                Type type,
                LocalDateTime dateTime,
                Repeatability repeatability)
            throws IncorrectTaskParameterException {
        id = idGenerator++;
        setTitle(title);
        setDescription(description);
        setType (type);
        setDateTime(dateTime);
        setRepeatability(repeatability);
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IncorrectTaskParameterException {
        if (title == null || title.isEmpty()) {
            throw new IncorrectTaskParameterException("Заголовок задачи");
        }
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IncorrectTaskParameterException {
        if (description == null || description.isEmpty()) {
            throw new IncorrectTaskParameterException("Описаниие задачи");
        }
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) throws IncorrectTaskParameterException {
        if (type == null ) {
            type = Type.PERSONAL;
        }
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) throws IncorrectTaskParameterException {
        if (dateTime == null ) {
            throw new IncorrectTaskParameterException("Дата и время задачи");
        }
        this.dateTime = dateTime;
    }

    public Repeatability getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(Repeatability repeatability) {
        if (repeatability == null ) {
            repeatability = new OneTime();
        }
        this.repeatability = repeatability;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ").append(id).append("\n")
                .append("название: ").append("\"").append(title).append("\"").append("\n")
                .append("описание: ").append("\"").append(description).append("\"").append("\n")
                .append("тип: ").append(type == Type.PERSONAL ? "личная" : "рабочая").append("\n")
                .append("дата и время: ").append(dateTime.format(Constant.DATE_TIME_FORMATTER)).append("\n")
                .append("повторяемость: ").append(repeatability).append("\n");
        return stringBuilder.toString();
    }
}
