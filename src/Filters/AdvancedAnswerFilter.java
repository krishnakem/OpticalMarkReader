package Filters;

import Interfaces.PixelFilter;
import core.DImage;

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
}
