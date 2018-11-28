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
    	// this plugin accepts RGB images
        return DOES_8G; 
    }

    @Override
    public void run(ImageProcessor ip) {
        int M = ip.getWidth();
        int N = ip.getHeight();
        
  
        int whichMethod = (int)IJ.getNumber("Which of the two Methods should be used? (Input: 1-2)", 1);
        
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
		// TODO Auto-generated method stub
		
	}



}