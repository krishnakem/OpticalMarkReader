package Filters;

import Interfaces.PixelFilter;
import core.DImage;

public class BlurFilter implements PixelFilter {
    private double[][] blurKernel =
            {       {1.0/9, 1.0/9, 1.0/9},
                    {1.0/9, 1.0/9, 1.0/9},
                    {1.0/9, 1.0/9, 1.0/9}   };

    @Override
    public DImage processImage(DImage img) {
        short[][] image = img.getBWPixelGrid();
        short[][] imageCopy = new short[image.length][image[0].length];
        int kernelWeight = findKernelWeight(blurKernel);
        for(int row = 1; row < image.length-2; row++){
            for(int col = 1; col < image[0].length-2; col++){
                int output = 0;
                for(int r = 0; r < 3; r++){
                    for(int c = 0; c < 3; c++){
                        double kernelVal = blurKernel[r][c];
                        int pixelVal = image[row+r][col+c];
                        output += kernelVal*pixelVal;
                    }
                }
                if(kernelWeight != 0) output = output/kernelWeight;
                if(output < 0) output = 0;
                if(output > 255) output = 255;
                imageCopy[row+1][col+1] = (short) output;
            }
        }
        img.setPixels(imageCopy);
        return img;
    }

    public short[][] blur(short[][] image){
        short[][] imageCopy = new short[image.length][image[0].length];
        int kernelWeight = findKernelWeight(blurKernel);
        for(int row = 1; row < image.length-2; row++){
            for(int col = 1; col < image[0].length-2; col++){
                int output = 0;
                for(int r = 0; r < 3; r++){
                    for(int c = 0; c < 3; c++){
                        double kernelVal = blurKernel[r][c];
                        int pixelVal = image[row+r][col+c];
                        output += kernelVal*pixelVal;
                    }
                }
                if(kernelWeight != 0) output = output/kernelWeight;
                if(output < 0) output = 0;
                if(output > 255) output = 255;
                imageCopy[row+1][col+1] = (short) output;
            }
        }
        return imageCopy;
    }


    public int findKernelWeight(double[][] kernel){
        int sum = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                sum += kernel[i][j];
            }
        }
        return sum;
    }
}
