package Filters;

import Interfaces.PixelFilter;
import core.DImage;

import java.util.ArrayList;

public class AnswerFilter implements PixelFilter {

    @Override
    public DImage processImage(DImage img) {
        double[][] kernel = { {}

        };

        short[][] grid = img.getBWPixelGrid();
        short[][] output1 = newAnswerGrid1stC(grid, img);
        short[][] output2 = newAnswerGrid2ndC(grid, img);
        short[][] output3 = newAnswerGrid3rdC(grid, img);
        short[][] output4 = newAnswerGrid4thC(grid, img);

        ArrayList<String> answer1stC = answerCount20x20(output1);
        System.out.println(answer1stC);

        ArrayList<String> answer2ndC = answerCount20x20(output2);
        System.out.println(answer2ndC);

        ArrayList<String> answer3rdC = answerCount20x20(output3);
        System.out.println(answer3rdC);

        ArrayList<String> answer4thC = answerCount20x20(output4);
        System.out.println(answer4thC);
        return img;
    }

    public static short[][] newAnswerGrid1stC(short[][] grid, DImage img){
        /*  output should be the whole row and col grid of the bubble answers  */


        //Exact measurement for a full row of a question (without the question number)
        short[][] output1 = new short[917][175];


        //This for-loop only gets the row and col of only question #26
        for (int r = 466; r < 1383; r++) {
            for (int c = 134; c < 309; c++) {
                output1[r-466][c-134] = grid[r][c];
            }
        }

        img.setPixels(output1);
        return output1;
    }

    public static short[][] newAnswerGrid2ndC(short[][] grid, DImage img){
        /*  output should be the whole row and col grid of the bubble answers  */


        //Exact measurement for a full row of a question (without the question number)
        short[][] output1 = new short[917][175];


        //This for-loop only gets the row and col of only question #26
        for (int r = 466; r < 1383; r++) {
            for (int c = 419; c < 594; c++) {
                output1[r-466][c-419] = grid[r][c];
            }
        }

        img.setPixels(output1);
        return output1;
    }

    public static short[][] newAnswerGrid3rdC(short[][] grid, DImage img){
        /*  output should be the whole row and col grid of the bubble answers  */


        //Exact measurement for a full row of a question (without the question number)
        short[][] output1 = new short[917][175];


        //This for-loop only gets the row and col of only question #26
        for (int r = 466; r < 1383; r++) {
            for (int c = 702; c < 877; c++) {
                output1[r-466][c-702] = grid[r][c];
            }
        }

        img.setPixels(output1);
        return output1;
    }

    public static short[][] newAnswerGrid4thC(short[][] grid, DImage img){
        /*  output should be the whole row and col grid of the bubble answers  */


        //Exact measurement for a full row of a question (without the question number)
        short[][] output1 = new short[917][175];


        //This for-loop only gets the row and col of only question #26
        for (int r = 466; r < 1383; r++) {
            for (int c = 984; c < 1159; c++) {
                output1[r-466][c-984] = grid[r][c];
            }
        }

        img.setPixels(output1);
        return output1;
    }

    public static ArrayList<String> answerCount20x20(short[][] grid){
        ArrayList<String> filledIn = new ArrayList<>();
        int questionNum = 0;
        int counterA, counterB, counterC, counterD, counterE;

        for (int BigRow = 0; BigRow < grid.length; BigRow+=37) {
            counterA = 0;
            counterB = 0;
            counterC = 0;
            counterD = 0;
            counterE = 0;


            for (int r = BigRow; r < BigRow+25; r++) {
                for (int col = 0; col < 21; col++) {
                    if(grid[r][col] == 0){
                        counterA++;
                    }
                }

                for (int col = 40; col < 62; col++) {
                    if(grid[r][col] == 0){
                        counterB++;
                    }
                }

                for (int col = 76; col < 98; col++) {
                    if(grid[r][col] == 0){
                        counterC++;
                    }
                }

                for (int col = 115; col < 137; col++) {
                    if(grid[r][col] == 0){
                        counterD++;
                    }
                }

                for (int col = 152; col < 175; col++) {
                    if(grid[r][col] == 0){
                        counterE++;
                    }
                }
            }
            questionNum++;
            //System.out.println("QN: " + questionNum);
            if(counterA > counterB && counterA > counterC && counterA > counterD && counterA > counterE){
                filledIn.add("A");
            } else if(counterB > counterC && counterB > counterD && counterB > counterE){
                filledIn.add("B");
            } else if(counterC > counterD && counterC > counterE){
                filledIn.add("C");
            } else if(counterD > counterE){
                filledIn.add("D");
            } else {
                filledIn.add("E");
            }
           /*
           System.out.println("A" + counterA);
           System.out.println("B" + counterB);
           System.out.println("C" + counterC);
           System.out.println("D" + counterD);
           System.out.println("E" +counterE);
           System.out.println();
            */
        }
        return filledIn;
    }
}


