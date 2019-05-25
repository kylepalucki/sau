import java.awt.*;
import java.util.Arrays;
public class MedianFilter {
    public static void main(String[] args) {
        Picture img1 = new Picture("IMG_01.jpg");
        Picture img2 = new Picture("IMG_02.jpg");
        Picture img3 = new Picture("IMG_03.jpg");
        Picture img4 = new Picture("IMG_04.jpg");
        Picture img5 = new Picture("IMG_05.jpg");
        Picture img6 = new Picture("IMG_06.jpg");
        Picture img7 = new Picture("IMG_07.jpg");
        Picture img8 = new Picture("IMG_08.jpg");
        Picture img9 = new Picture("IMG_09.jpg");
        Picture img10 = new Picture("IMG_10.jpg");
        Picture img11 = new Picture("IMG_11.jpg");
        Picture img12 = new Picture("IMG_12.jpg");
        
        Picture[] pics = {img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12};
        
        int height = img1.height();
        int width = img1.width();
        Picture finalPic = new Picture(width, height);
        Color pixelColor;
        int reds[] = new int[12];
        int blues[] = new int[12];
        int greens[] = new int[12];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                for (int i = 0; i < 12; i++) {
                   pixelColor = pics[i].get(col, row);
                   reds[i] = pixelColor.getRed();
                   blues[i] = pixelColor.getBlue();
                   greens[i] = pixelColor.getGreen();
                   Arrays.sort(reds);
                   Arrays.sort(blues);
                   Arrays.sort(greens);
                   int medianRed = reds[reds.length/2];
                   int medianBlue = blues[blues.length/2];
                   int medianGreen = greens[greens.length/2];
                   
                   
                   finalPic.set(col,row, new Color(medianRed, medianGreen, medianBlue));
                   
            }
        }
        finalPic.show();        
    }
   }
}
