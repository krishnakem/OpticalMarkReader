package FileIO;

import core.Scores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ScoresCSVWriter {

    Scores student;
    ArrayList<String> answers;

    public ScoresCSVWriter(Scores student, ArrayList<String> answers){
        this.student = student;
        this.answers = answers;
    }

    public void csvWriter(){
        PrintWriter writer;
        try{
            writer = new PrintWriter(new File(student.getStudentID() + "_answers.csv"));
            StringBuffer csvHeader = new StringBuffer("");
            StringBuffer csvData = new StringBuffer("");
            csvHeader.append("Question #, Student's Answer, Correct\n");
            writer.write(csvHeader.toString());

            int counter = 0;

            for(int i = 0; i < student.getAnswers().size(); i++){
                csvData.append(i+1);
                csvData.append(",");
                csvData.append(student.getAnswers().get(i));
                csvData.append(",");
                if(student.getAnswers().get(i).equals(answers.get(i))){
                    csvData.append("Correct");
                    counter++;
                }
                else csvData.append("Incorrect");
            }
            csvData.append("Total Right : ");
            csvData.append(",");
            csvData.append(counter + " / " + answers.size());
            writer.write(csvData.toString());
            writer.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
