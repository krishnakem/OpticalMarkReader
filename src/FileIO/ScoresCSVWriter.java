package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ScoresCSVWriter {

    private int numQuestions;
    boolean[] answers;

    public ScoresCSVWriter(int numQuestions, boolean[] answers){
        this.numQuestions = numQuestions;
        this.answers = answers;
    }

    public void csvWriter(){
        PrintWriter writer;
        try{
            writer = new PrintWriter(new File("answers.csv"));
            StringBuffer csvHeader = new StringBuffer("");
            StringBuffer csvData = new StringBuffer("");
            csvHeader.append("Question, Correct\n");
            writer.write(csvHeader.toString());

            for(int i = 0; i < numQuestions; i++){
                csvData.append(i+1);
                csvData.append(",");
                csvData.append(answers[i]);
            }
            writer.write(csvData.toString());
            writer.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
