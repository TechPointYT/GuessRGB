
package com.example.guessrgb;
import android.graphics.Color;


import java.util.Random;
public class RGBR {
    int[] RGB = new int[3];
    Random rand = new Random();

    public RGBR(){
        RGB[0] = rand.nextInt(256);
        RGB[1] = rand.nextInt(256);
        RGB[2] = rand.nextInt(256);
    }

    public Color getColor(){
        return Color.valueOf((new Color()).pack(RGB[0], RGB[1], RGB[2]));
    }

    public int[] getRGB(){
        return this.RGB;
    }
}
