package cn.marioquer.labpecker.Bean.Assignment.Student;

import java.io.Serializable;

/**
 * Created by marioquer on 2017/7/2.
 */

public class TestCase implements Serializable{
    String name;
    boolean passed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }
}
