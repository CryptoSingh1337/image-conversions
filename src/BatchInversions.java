
import edu.duke.*;
import java.io.File;

public class BatchInversions {
	
	public ImageResource makeNegative(ImageResource inImage)
	{
		int red, green, blue;
		int newRed, newGreen, newBlue;
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		for(Pixel pixel : outImage.pixels())
		{
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			
			red = inPixel.getRed();
			newRed = 255 - red;
			pixel.setRed(newRed);
			
			green = inPixel.getGreen();
			newGreen = 255 - green;
			pixel.setGreen(newGreen);
			
			blue = inPixel.getBlue();
			newBlue = 255 - blue;
			pixel.setBlue(newBlue);
		}
		return outImage;
	}
	
	public void selectAndConvert()
	{
		DirectoryResource dr = new DirectoryResource();
		for(File f : dr.selectedFiles())
		{
			String fname = f.getName();
			String newName = "inverted-" + fname;
			ImageResource ir = new ImageResource(f);
			ImageResource invertedImage = makeNegative(ir);
			invertedImage.setFileName(newName);
			//invertedImage.draw();
			invertedImage.save();
			System.out.println("Save Image - " + newName);
		}
		System.out.println("Saved all the Images");
	}

	public static void main(String[] args) {
		
		BatchInversions obj = new BatchInversions();
		obj.selectAndConvert();
	}

}
