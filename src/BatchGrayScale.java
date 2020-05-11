import edu.duke.*;
import java.io.File;

public class BatchGrayScale {
	
	public ImageResource makeGray(ImageResource inImage)	//Convert current Image into GrayScale and return that image 
	{
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		for(Pixel pixel : outImage.pixels())
		{
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
			pixel.setRed(average);
			pixel.setBlue(average);
			pixel.setGreen(average);
		}
		return outImage;
	}
	
	public void doSave()									//Convert all the Images into grayScale and save it as gray-"ImageName" in the same folder
	{
		DirectoryResource dr = new DirectoryResource();
		for(File f : dr.selectedFiles())
		{
			String fname = f.getName();
			String newName = "gray-" + fname;
			ImageResource ir = new ImageResource(f);
			ImageResource currentGrayImage = makeGray(ir);
			currentGrayImage.setFileName(newName);
			//currentGrayImage.draw();
			currentGrayImage.save();
			System.out.println("Save Image - " + newName);
		}
		System.out.println("Saved all the Images");
	}

	public static void main(String[] args) {
		
		BatchGrayScale obj = new BatchGrayScale();
		obj.doSave();

	}

}
