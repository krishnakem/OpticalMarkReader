package FileIO;

import core.Scores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ItemAnalysisCSVWriter {

    ArrayList<Scores> classData;
    ArrayList<String> answerSheet;

    public ItemAnalysisCSVWriter(ArrayList<Scores> classData, ArrayList<String> answerSheet){
        this.classData = classData;
        this.answerSheet = answerSheet;
    }

    public void csvWriter(){
        PrintWriter writer;
        try{
            writer = new PrintWriter(new File("class_item_analysis.csv"));
            StringBuffer csvHeader = new StringBuffer("");
            StringBuffer csvData = new StringBuffer("");
            csvHeader.append("Question #, # of students who answered incorrectly\n");
            writer.write(csvHeader.toString());

            for(int i = 0; i < answerSheet.size(); i++){
                csvData.append(i+1);
                csvData.append(",");
                int counter = 0;
                for(int j = 0; j < classData.size(); j++){
                    ArrayList<String> currentIndexStudent = classData.get(j).getAnswers();
                    if(!currentIndexStudent.get(i).equals(answerSheet.get(i))){
                        counter++;
                    }
                }
                csvData.append(counter+ "\n");
            }

            writer.write(csvData.toString());
            writer.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

}
