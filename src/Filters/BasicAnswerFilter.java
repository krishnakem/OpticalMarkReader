package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class BasicAnswerFilter implements PixelFilter {

    @Override
    public DImage processImage(DImage img) {
        short[][] grid = img.getBWPixelGrid();

        short[][] output = newAnswerGrid(grid, img);
        String answer = answerBubble(output);
        System.out.println(answer);
        return img;
    }

    public static short[][] newAnswerGrid(short[][] grid, DImage img){
        /*  output should be the whole row and col grid of the bubble answers  */


        //Exact measurement for a full row of a question (without the question number)
        short[][] output1 = new short[grid.length-133][grid[0].length/6];


        //This for-loop only gets the row and col of only question #26
        for (int r = (grid.length/4)+70; r < grid.length-200; r++) {
            for (int c = grid[r].length/3; c < grid[r].length/2; c++) {
                output1[r-((grid.length/21)+171)][c-(grid[r].length/3)] = grid[r][c];
            }
        }

        img.setPixels(output1);
        return output1;
    }

    public static String answerBubble(short[][] grid){
        int num = 295;
        String filledIn;
        int counterA = 0;
        int counterB = 0;
        int counterC = 0;
        int counterD = 0;
        int counterE = 0;

        for (int r = num; r < 313; r++) {
            for (int c = 11; c < 31; c++) {
                if(grid[r][c] == 0){
                    counterA++;
                }
            }
        }

        for (int r = num; r < 313; r++) {
            for (int c = 49; c < 66; c++) {
                if(grid[r][c] == 0){
                    counterB++;
                }
            }
        }

        for (int r = num; r < 313; r++) {
            for (int c = 86; c < 103; c++) {
                if(grid[r][c] == 0){
                    counterC++;
                }
            }
        }

        for (int r = num; r < 313; r++) {
            for (int c = 124; c < 141; c++) {
                if(grid[r][c] == 0){
                    counterD++;
                }
            }
        }

        for (int r = num; r < 313; r++) {
            for (int c = 162; c < 180; c++) {
                if(grid[r][c] == 0){
                    counterE++;
                }
            }
        }

        if(counterA > counterB || counterA > counterC || counterA > counterD || counterA > counterE){
            filledIn = "A";
        } else if(counterB > counterC || counterB > counterD || counterB > counterE){
            filledIn = "B";
        } else if(counterC > counterD || counterC > counterE){
            filledIn = "C";
        } else if(counterD > counterE){
            filledIn = "D";
        } else {
            filledIn = "E";
        }

        System.out.println(counterA);
        System.out.println(counterB);
        System.out.println(counterC);
        System.out.println(counterD);
        System.out.println(counterE);

        return filledIn;
    }

    public static int answerCount20x20(short[][] grid, int n, int targetRow, int targetCol){

        int count = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                //Loops very 20x20 bubble and checks to see if it's filled in with black pixels

            }
        }

        return count;
    }
}

