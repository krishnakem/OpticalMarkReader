package core;

import java.util.ArrayList;

public class Scores {
    private String studentID;
    private ArrayList<String> answers;

    public Scores(String studentID, ArrayList<String> answers){
        this.studentID = studentID;
        this.answers = answers;
    }

    public String getStudentID(){
        return studentID;
    }

    public ArrayList<String> getAnswers(){
        return answers;
    }
}
