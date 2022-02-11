package Filters;

import Interfaces.PixelFilter;
import core.DImage;
import core.Scores;

import java.util.ArrayList;

public class AnswerFilter implements PixelFilter {

    @Override
    public DImage processImage(DImage img) {
        ArrayList<String> answers;
        short[][] grid = getImageGrid(img);
        short[][] output = numberBox(grid, img);

        answers = totalAnswer(output);
        System.out.println(answers);
        return img;
    }

    //Converts img into blur effect
    public short[][] getImageGrid(DImage img){
        BlurFilter blur = new BlurFilter();
        short[][] holder = img.getBWPixelGrid();
        return blur.blur(holder);
    }


//Finds the grid of only the black boxes and the questions (both the left and right side bubbles)
    public static short[][] numberBox(short[][] grid, DImage img){
        if(grid == null) return null;
        if(img == null) return null;
        short[][] output1 = new short[1200][356];

        for (int r = 111; r < 1311; r++) {
            for (int c = 18; c < 374; c++) {
                output1[r-111][c-18] = grid[r][c];
            }
        }

        img.setPixels(output1);
        return output1;
    }



//Uses the grid and finds the black bars that correspond to the left side of bubbles
    public static ArrayList<String> answerLeftBubble(short[][] grid){
        ArrayList<String> answers = new ArrayList<>();
        if(grid == null) return null;
        int counterA, counterB, counterC, counterD, counterE;

        for (int BigRow = 0; BigRow < grid.length; BigRow+=48) {
            counterA = 0;
            counterB = 0;
            counterC = 0;
            counterD = 0;
            counterE = 0;


            for (int r = BigRow; r < BigRow+12; r++) {
                for (int col = 72; col < 91; col++) {
                    if(grid[r][col] < 130){
                        counterA++;
                    }
                }

                for (int col = 97; col < 115; col++) {
                    if(grid[r][col] < 130){
                        counterB++;
                    }
                }

                for (int col = 121; col < 139; col++) {
                    if(grid[r][col] < 130){
                        counterC++;
                    }
                }

                for (int col = 146; col < 163; col++) {
                    if(grid[r][col] < 130){
                        counterD++;
                    }
                }

                for (int col = 170; col < 187; col++) {
                    if(grid[r][col] < 130){
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
            } else if(counterE > counterD){
                answers.add("E");
            } else {
                answers.add("BLANK");
            }
        }
        return answers;
    }


//Uses the grid and finds the black bars that correspond to the right side of bubbles
    public static ArrayList<String> answerRightBubble(short[][] grid){
        if(grid == null) return null;
        ArrayList<String> answers = new ArrayList<>();
        int counterA, counterB, counterC, counterD, counterE;

        for (int BigRow = 23; BigRow < grid.length; BigRow+=48) {
            counterA = 0;
            counterB = 0;
            counterC = 0;
            counterD = 0;
            counterE = 0;


            for (int r = BigRow; r < BigRow+12; r++) {
                for (int col = 241; col < 260; col++) {
                    if(grid[r][col] < 130){
                        counterA++;
                    }
                }

                for (int col = 266; col < 283; col++) {
                    if(grid[r][col] < 130){
                        counterB++;
                    }
                }

                for (int col = 290; col < 308; col++) {
                    if(grid[r][col] < 130){
                        counterC++;
                    }
                }

                for (int col = 314; col < 332; col++) {
                    if(grid[r][col] < 130){
                        counterD++;
                    }
                }

                for (int col = 338; col < grid[0].length; col++) {
                    if(grid[r][col] < 130){
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
            } else if(counterE > counterD){
                answers.add("E");
            } else {
                answers.add("BLANK");
            }
        }
        return answers;
    }

    public static ArrayList<String> totalAnswer(short[][] grid){
        ArrayList<String> leftAns = answerLeftBubble(grid);
        ArrayList<String> rightAns = answerRightBubble(grid);
        ArrayList<String> totalAnswers = new ArrayList<>();
        for (int i = 0; i < leftAns.size(); i++) {
            totalAnswers.add(leftAns.get(i));
        }
        for (int i = 0; i < rightAns.size(); i++) {
            totalAnswers.add(rightAns.get(i));
        }

        return totalAnswers;
    }
}



