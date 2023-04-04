import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class PicGenerator {
  void cria(InputStream inputStream, String fileName) throws IOException {
    //read the image file
    // InputStream inputStream = 
    // new InputStream(new File("input/aladin.jpg"));
    // InputStream inputStream = 
    //   new URL("https://m.media-amazon.com/images/M/MV5BNzE4NDg5OWMtMzg3NC00ZDRjLTllMDMtZTRjNWZmNjBmMGZlXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_Ratio0.7015_AL_.jpg")
    //   .openStream();
    BufferedImage imageOriginal = ImageIO.read(inputStream);

    //create new image with transparence and new size
    int width = imageOriginal.getWidth();
    int height = imageOriginal.getHeight();
    int newHeight = height + 200;
    BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

    // copy the original image to the new image (in memory)
    Graphics2D graphics = (Graphics2D) newImage.getGraphics();
    graphics.drawImage(imageOriginal, 0, 0, null);

    // Fount configuration for
    var font = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setFont(font);
    graphics.setColor(Color.YELLOW);

    // write a text to the image
    graphics.drawString("topzera", 100, newHeight-100);
    
    
    // write the new image to a file
    ImageIO.write(newImage, "png", new File(fileName));
  }

}
