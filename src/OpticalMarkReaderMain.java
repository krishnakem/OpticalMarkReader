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
        String pathToPdf = fileChooser();
        System.out.println("Loading pdf at " + pathToPdf);

        FilterTest getPages = new FilterTest();
        AdvancedAnswerFilter filter = new AdvancedAnswerFilter();

        ArrayList<String> answers = new ArrayList<String>;
        answers.add("A");
        answers.add("B");

        ArrayList<DImage> images = getPages.getDImages(3);
        ArrayList<Scores> classScores = new ArrayList<>();

        for(int i = 0; i < images.size(); i++){
            filter.processImage(images.get(i));
            classScores.add(filter.getAnswers());
        }

        for(int i = 0; i < classScores.size()){
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
