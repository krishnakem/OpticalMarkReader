package core;

import java.util.ArrayList;

public class Scores {
    private int studentID;
    private ArrayList<String> answers;

    public Scores(int studentID, ArrayList<String> answers){
        this.studentID = studentID;
        this.answers = answers;
    }

    public int getStudentID(){
        return studentID;
    }

    public ArrayList<String> getAnswers(){
        return answers;
    }
}
