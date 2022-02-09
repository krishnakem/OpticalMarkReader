package Filters;

import Interfaces.PixelFilter;
import core.DImage;
import core.Scores;

import java.util.ArrayList;

public class AnswerFilter implements PixelFilter {

    @Override
    public DImage processImage(DImage img) {
        short[][] grid = img.getBWPixelGrid();
        /*
        short[][] output1 = newAnswerGrid1stC(grid, img);
        short[][] output2 = newAnswerGrid2ndC(grid, img);
        short[][] output3 = newAnswerGrid3rdC(grid, img);
        short[][] output4 = newAnswerGrid4thC(grid, img);

        ArrayList<String> totalAnswers = new ArrayList<>();
        ArrayList<String> studentID = new ArrayList<>();



        answerCount20x20(output1, totalAnswers);
        answerCount20x20(output2, totalAnswers);
        answerCount20x20(output3, totalAnswers);
        answerCount20x20(output4, totalAnswers);

        System.out.println(totalAnswers);

        Scores test = new Scores(1, totalAnswers);

 */


        short[][] output = numberBox(grid, img);


        return img;
    }

    public static short[][] numberBox(short[][] grid, DImage img){
        /*  output should be the whole row and col grid of the bubble answers  */


        //Exact measurement for a full row of a question (without the question number)
        short[][] output1 = new short[1177][356];


        //This for-loop only gets the row and col of only question #26
        for (int r = 111; r < 1288; r++) {
            for (int c = 18; c < 374; c++) {
                output1[r-111][c-18] = grid[r][c];
            }
        }

        img.setPixels(output1);
        return output1;
    }

    public static ArrayList<String> answerLeftBubble(short[][] grid, ArrayList<String> answers){
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
            if(counterA > counterB && counterA > counterC && counterA > counterD && counterA > counterE){
                answers.add("A");
            } else if(counterB > counterC && counterB > counterD && counterB > counterE){
                answers.add("B");
            } else if(counterC > counterD && counterC > counterE){
                answers.add("C");
            } else if(counterD > counterE){
                answers.add("D");
            } else {
                answers.add("E");
            }
        }
        return answers;
    }

    public static short[][] numberLeft(short[][] grid, DImage img){
        /*  output should be the whole row and col grid of the bubble answers  */


        //Exact measurement for a full row of a question (without the question number)
        short[][] output1 = new short[24][190];


        //This for-loop only gets the row and col of only question #26
        for (int r = 111; r < 135; r++) {
            for (int c = 16; c < 206; c++) {
                output1[r-111][c-16] = grid[r][c];
            }
        }

        img.setPixels(output1);
        return output1;
    }

    public static short[][] numberRight(short[][] grid, DImage img){
        /*  output should be the whole row and col grid of the bubble answers  */


        //Exact measurement for a full row of a question (without the question number)
        short[][] output1 = new short[17][358];


        //This for-loop only gets the row and col of only question #26
        for (int r = 135; r < 152; r++) {
            for (int c = 16; c < 374; c++) {
                output1[r-135][c-16] = grid[r][c];
            }
        }

        img.setPixels(output1);
        return output1;
    }

    public static ArrayList<String> answerCount20x20(short[][] grid, ArrayList<String> answers){
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
            if(counterA > counterB && counterA > counterC && counterA > counterD && counterA > counterE){
                answers.add("A");
            } else if(counterB > counterC && counterB > counterD && counterB > counterE){
                answers.add("B");
            } else if(counterC > counterD && counterC > counterE){
                answers.add("C");
            } else if(counterD > counterE){
                answers.add("D");
            } else {
                answers.add("E");
            }
        }
        return answers;
    }

    //STUDENT ID**


}



