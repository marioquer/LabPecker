package cn.marioquer.labpecker.Bean.Assignment.Teacher;

import java.io.Serializable;

/**
 * Created by marioquer on 2017/7/2.
 */

public class QuestionInfo implements Serializable{
    int id;
    String title;
    String description;
    String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
