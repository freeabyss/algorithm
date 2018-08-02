package science.freeabyss.algorithm.other;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 加权灰度化图片
 *
 * @author abyss
 * @date 2018/5/4
 */
public class GrayImage {

    public static BufferedImage grayImage(BufferedImage bufferedImage) {
        BufferedImage grayImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), bufferedImage.getType());

        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                final int color = bufferedImage.getRGB(i, j);
                final int r = (color >> 16) & 0xff;
                final int g = (color >> 8) & 0xff;
                final int b = color & 0xff;
                int gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);
                int newPixel = colorToRGB(255, gray, gray, gray);
                grayImage.setRGB(i, j, newPixel);
            }
        }
        return grayImage;
    }

    private static int colorToRGB(int alpha, int red, int green, int blue) {
        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;

    }

    public static void main(String[] args) throws IOException {
        String imageUrl = "/Users/abyss/Downloads/DCIM(1)/IMG_20130403_204029.jpg";
        BufferedImage bufferedImage = ImageIO.read(new File(imageUrl));
        BufferedImage grayImage = grayImage(bufferedImage);
        File newFile = new File("/Users/abyss/Downloads/ok.jpg");
        ImageIO.write(grayImage, "jpg", newFile);
    }
}
