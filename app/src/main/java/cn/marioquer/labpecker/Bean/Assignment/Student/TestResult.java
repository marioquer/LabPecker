package cn.marioquer.labpecker.Bean.Assignment.Student;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marioquer on 2017/7/2.
 */

public class TestResult implements Serializable {
    String git_url;
    boolean compile_succeeded;
    boolean tested;
    List<TestCase> testcases;

    public String getGit_url() {
        return git_url;
    }

    public void setGit_url(String git_url) {
        this.git_url = git_url;
    }

    public boolean isCompile_succeeded() {
        return compile_succeeded;
    }

    public void setCompile_succeeded(boolean compile_succeeded) {
        this.compile_succeeded = compile_succeeded;
    }

    public boolean isTested() {
        return tested;
    }

    public void setTested(boolean tested) {
        this.tested = tested;
    }

    public List<TestCase> getTestCases() {
        return testcases;
    }

    public void setTestCases(List<TestCase> testcases) {
        this.testcases = testcases;
    }
}
