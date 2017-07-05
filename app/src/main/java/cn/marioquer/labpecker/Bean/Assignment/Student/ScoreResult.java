package cn.marioquer.labpecker.Bean.Assignment.Student;

import java.io.Serializable;

/**
 * Created by marioquer on 2017/7/2.
 */

public class ScoreResult implements Serializable{
    String git_url;
    int score;
    boolean scored;

    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isScored() {
        return scored;
    }

    public void setScored(boolean scored) {
        this.scored = scored;
    }
}
