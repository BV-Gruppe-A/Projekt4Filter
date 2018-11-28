package com.mycompany.imagej;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ByteProcessor;
import ij.process.ImageProcessor;

public class Project4_PlugIn implements PlugInFilter {
    
	final int BLACK = 0;
	final int WHITE = 255;
	 
	final double [][] h1 = {
			{-1/6,-1/6,0},
			{-1/6,0,1/6},
			{0,1/6,1/6}
	};
	
	final double [][] h2 = {
			{0,1/6,1/6},
			{-1/6,0,1/6},
			{-1/6,-1/6,0}
	};
	
	final double [][] h3 = {
			{-2/8,-1/8,0},
			{-1/8,0,1/8},
			{0,1/8,2/8}
	};
	
	final double [][] h4 = {
			{0,1/8,2/8},
			{-1/8,0,1/8},
			{-2/8,-1/8,0}
	};
    
    @Override    
    public int setup(String args, ImagePlus im) {  
    	// this plugin accepts 8-bit greyscales
        return DOES_8G; 
    }

    @Override
    public void run(ImageProcessor ip) {
        
        int whichMethod = (int)IJ.getNumber("Which of the four Filters should be used? (Input: 1-4)", 1);
        
        switch(whichMethod) {
        // Filter h1
        case 1:
        	filter(ip,h1);
            break;
        //Filter h2
        case 2:
        	filter(ip,h2);
            break;
        //Filter h3    
        case 3:
        	filter(ip,h3);
        	break;
        //Filter h4	
        case 4:
        	filter(ip,h4);
        	break;
            
        default:
        
        }
       
    }

	private void filter(ImageProcessor ip, double[][] filter) {
        ImageProcessor copy = ip.duplicate();
        int M = ip.getWidth();
        int N = ip.getHeight();
        for (int u = 1; u < M - 1; u++) {
	        for (int v = 1; v < N - 1; v++) {
		        // compute filter result for position (u,v):
		        double sum = 0;
		        for (int i = -1; i <= 1; i++) {
			        for (int j = -1; j <= 1; j++) {
				        int p = copy.getPixel(u + i, v + j);
				        // get the corresponding filter coefficient:
				        double c = filter[j + 1][i + 1];
				        sum = sum + c * p;
			        }
		        }
	        int q = (int) Math.round(sum);
	        ip.putPixel(u, v, q);
	        }
        }
	}

}