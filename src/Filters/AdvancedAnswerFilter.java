package Filters;

import Interfaces.PixelFilter;
import core.DImage;

import java.util.ArrayList;

public class AdvancedAnswerFilter implements PixelFilter {
    short grid[][];

    @Override
    public DImage processImage(DImage img) {
        grid = img.getBWPixelGrid();
        img.setPixels(createAnswerGrid(grid));
        return img;
    }

    public short[][] createAnswerGrid(short[][] grid){
        short[][] answerGrid = new short[662][513];
        for(int i = 0; i < answerGrid.length; i++){
            for(int j = 0; j < answerGrid[0].length; j++){
                answerGrid[i][j] = grid[i+463][j+365];
            }
        }
        return answerGrid;
    }

    public void analyzeQuestion(short[][] answerGrid,int startingX, int startingY){
        for(int i = startingX; i < startingX + 225; i++){
            for(int j = startingY; j < startingY + 20; j++){

            }
        }
    }

    public ArrayList<Answer> getAnswerList(){
        ArrayList<Answer> answerList = new ArrayList<>();
        return answerList;
    }
}

class Answer{
    private boolean correct;
    private String filledInAnswer;

    public Answer(boolean correct, String filledInAnswer){
        this.correct = correct;
        this.filledInAnswer = filledInAnswer;
    }
}