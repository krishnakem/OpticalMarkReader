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

    public ArrayList<String> analyzeBars(short[][] grid){
        ArrayList<String> answers = new ArrayList<String>();
        for(int i = 0; i < answers.size(); i+=2){
            answers.add(i,findLeftAnswer(grid).get(i));
        }
        for(int i = 1; i < answers.size(); i+=2){
            answers.add(i,findRightAnswer(grid).get(i));
        }
        return answers;
    }

    private ArrayList<String> findLeftAnswer(short[][] grid) {
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

    private ArrayList<String> findRightAnswer(short[][] grid) {
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


    public String getIDNumber(short[][] grid){
        return findIDNumber(grid);
    }

    public String findIDNumber(short[][] grid){
        short[][] output = new short[236][236];

        //grid of only the ID # boxes
        for (int r = 680; r < 916; r++) {
            for (int c = 428; c < 664; c++) {
                output[r-680][c-428] = grid[r][c];
            }
        }

        int counter0, counter1, counter2, counter3, counter4, counter5, counter6, counter7, counter8, counter9;
        String studentID = "";
        int num = 120;

        for (int BigCol = 0; BigCol < output[0].length; BigCol+=24) {
            counter0 = 0;
            counter1 = 0;
            counter2 = 0;
            counter3 = 0;
            counter4 = 0;
            counter5 = 0;
            counter6 = 0;
            counter7 = 0;
            counter8 = 0;
            counter9 = 0;


            for (int c = BigCol; c < BigCol+20; c++) {
                //#0
                for (int row = 0; row < 18; row++) {
                    if(output[row][c] < num){
                        counter0++;
                    }
                }
                //#1
                for (int row = 25; row < 43; row++) {
                    if(output[row][c] < num){
                        counter1++;
                    }
                }
                //#2
                for (int row = 49; row < 67; row++) {
                    if(output[row][c] < num){
                        counter2++;
                    }
                }
                //#3
                for (int row = 73; row < 90; row++) {
                    if(output[row][c] < num){
                        counter3++;
                    }
                }
                //#4
                for (int row = 97; row < 115; row++) {
                    if(output[row][c] < num){
                        counter4++;
                    }
                }
                //#5
                for (int row = 121; row < 138; row++) {
                    if(output[row][c] < num){
                        counter5++;
                    }
                }
                //#6
                for (int row = 145; row < 162; row++) {
                    if(output[row][c] < num){
                        counter6++;
                    }
                }
                //#7
                for (int row = 169; row < 186; row++) {
                    if(output[row][c] < num){
                        counter7++;
                    }
                }
                //#8
                for (int row = 194; row < 211; row++) {
                    if(output[row][c] < num){
                        counter8++;
                    }
                }
                //#9
                for (int row = 218; row < 235; row++) {
                    if(output[row][c] < num){
                        counter9++;
                    }
                }
            }
            //System.out.println("QN: " + questionNum);
            if(counter0 > counter1 && counter0 > counter2 && counter0 > counter3 && counter0 > counter4 && counter0 > counter5 && counter0 > counter6 && counter0 > counter7 && counter0 > counter8 && counter0 > counter9){
                studentID += "0";
            } else if(counter1 > counter2 && counter1 > counter3 && counter1 > counter4 && counter1 > counter5 && counter1 > counter6 && counter1 > counter7 && counter1 > counter8 && counter1 > counter9){
                studentID += "1";
            } else if(counter2 > counter3 && counter2 > counter4 && counter2 > counter5 && counter2 > counter6 && counter2 > counter7 && counter2 > counter8 && counter2 > counter9){
                studentID += "2";
            } else if(counter3 > counter4 && counter3 > counter5 && counter3 > counter6 && counter3 > counter7 && counter3 > counter8 && counter3 > counter9){
                studentID += "3";
            } else if(counter4 > counter5 && counter4 > counter6 && counter4 > counter7 && counter4 > counter8 && counter4 > counter9){
                studentID += "4";
            } else if(counter5 > counter6 && counter5 > counter7 && counter5 > counter8 && counter5 > counter9){
                studentID += "5";
            } else if(counter6 > counter7 && counter6 > counter8 && counter6 > counter9){
                studentID += "6";
            } else if(counter7 > counter8 && counter7 > counter9){
                studentID += "7";
            } else if(counter8 > counter9){
                studentID += "8";
            } else if(counter9 > counter8){
                studentID += "9";
            } else {
                studentID += "";
            }
        }
        return studentID;
    }
}
