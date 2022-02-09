package Filters;

import Interfaces.PixelFilter;
import core.DImage;
import core.Scores;

import java.util.ArrayList;

public class AdvancedAnswerFilter implements PixelFilter {
    short grid[][];
    ArrayList<String> answerHolder;

    @Override
    public DImage processImage(DImage img) {
        grid = getImageGrid(img);
        return img;
    }

    public short[][] getImageGrid(DImage img){
        BlurFilter blur = new BlurFilter();
        short[][] holder = img.getBWPixelGrid();
        return blur.blur(holder);
    }

    public Scores getAnswers(){
        Scores result = new Scores(getIDNumber(grid), analyzeBars(grid));
        return result;
    }

    public int getIDNumber(short[][] grid){
        return 0;
    }

    public ArrayList<String> analyzeBars(short[][] grid){
        ArrayList<String> answers = new ArrayList<String>();
        for(int i = 1; i <= 25; i++){
            for(int j = 0; j <= 48; j+=2){
                answers.add(j, findLeftAnswer(grid, 37,45, i));
            }
        }
        for(int i = 1; i <= 25; i++){
            for(int j = 1; j < 50; j+=2){
                answers.add(j, findRightAnswer(grid, 37,70, i));
            }
        }
        return answers;
    }

    private String findLeftAnswer(short[][] grid, int x, int y, int multiplier) {
        return null;
    }

    private String findRightAnswer(short[][] grid, int x, int y, int multiplier) {
        return null;
    }



}
