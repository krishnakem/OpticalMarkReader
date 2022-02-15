import FileIO.PDFHelper;
import Filters.DisplayInfoFilter;
import Interfaces.PixelFilter;
import core.DImage;
import core.DisplayWindow;
import processing.core.PImage;

import java.util.ArrayList;

public class FilterTest {
    public static String currentFolder = System.getProperty("user.dir") + "/";

    public static void main(String[] args) {
        SaveAndDisplayExample();

//        RunTheFilter();
    }

    private static void RunTheFilter() {
        System.out.println("Loading pdf....");
        PImage in = PDFHelper.getPageImage("assets/omrtest.pdf",1);
        DImage img = new DImage(in);       // you can make a DImage from a PImage

        System.out.println("Running filter on page 1....");
        DisplayInfoFilter filter = new DisplayInfoFilter();
        filter.processImage(img);  // if you want, you can make a different method
                                   // that does the image processing an returns a DTO with
                                   // the information you want
    }

    public static ArrayList<DImage> getDImages(int numPages){
        ArrayList<DImage> pages = new ArrayList<DImage>();
        for(int i = 0; i < numPages; i++){
            PImage in = PDFHelper.getPageImage("assets/scantron_sample1.pdf", i);
            DImage img = new DImage(in);
            pages.add(img);
        }
        return pages;
    }

    private static void SaveAndDisplayExample() {
        PImage img = PDFHelper.getPageImage("assets/scantron_sample.png",1);
        img.save(currentFolder + "assets/scantron_sample.png");

        DisplayWindow.showFor("assets/scantron_sample.png");
    }
}