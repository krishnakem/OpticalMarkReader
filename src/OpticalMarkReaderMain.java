import FileIO.ItemAnalysisCSVWriter;
import FileIO.ScoresCSVWriter;
import Filters.AdvancedAnswerFilter;
import core.DImage;
import core.Scores;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

// Author: David Dobervich (this is my edit)
// ANOTHER EDIT.
public class OpticalMarkReaderMain {
    public static void main(String[] args) {
        //String pathToPdf = fileChooser();
        //System.out.println("Loading pdf at " + pathToPdf);

        String pathToPdf = "assets/scantron_sample1.png";

       // FilterTest getPages = new FilterTest();
        AdvancedAnswerFilter filter = new AdvancedAnswerFilter();

        ArrayList<String> answers = new ArrayList<String>();
        answers.add("D");
        answers.add("C");
        answers.add("B");
        answers.add("D");
        answers.add("A");
        answers.add("B");
        answers.add("C");
        answers.add("D");
        answers.add("E");
        answers.add("D");
        answers.add("B");
        answers.add("C");
        answers.add("A");
        answers.add("E");
        answers.add("C");
        answers.add("A");
        answers.add("B");
        answers.add("B");
        answers.add("B");
        for(int i = 19; i < 50; i++){
            answers.add(i, "BLANK");
        }

        ArrayList<DImage> images = FilterTest.getDImages(3);
        ArrayList<Scores> classScores = new ArrayList<>();

        for(int i = 0; i < images.size(); i++){
            filter.processImage(images.get(i));
            classScores.add(filter.getAnswers());
        }

//        ArrayList<String > holder = classScores.get(0).getAnswers();
//        for(int i = 0; i < holder.size(); i++){
//            System.out.println(holder.get(i));
//        }

       for(int i = 0; i < classScores.size(); i++){
            ScoresCSVWriter firstWriter = new ScoresCSVWriter(classScores.get(i), answers);
            firstWriter.csvWriter();
        }

       ItemAnalysisCSVWriter secondWriter = new ItemAnalysisCSVWriter(classScores, answers);
       secondWriter.csvWriter();
    }

    private static String fileChooser() {
        String userDirLocation = System.getProperty("user.dir");
        File userDir = new File(userDirLocation);
        JFileChooser fc = new JFileChooser(userDir);
        int returnVal = fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        return file.getAbsolutePath();
    }
}
