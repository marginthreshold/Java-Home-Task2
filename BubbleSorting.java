import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class BubbleSorting {
    
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(calculate.class.getName());
        FileHandler fh = new FileHandler("bubblelog.log");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.setUseParentHandlers(false);
        logger.log(Level.INFO, "Начало логирования");
        int[] bubble = new int[] { 1, 16, 24, 1, 5, 8, 7, 9, 12 };
        int temp;
        for (int i = 0; i < bubble.length; i++) {
            for (int j = i + 1; j < bubble.length; j++) {
                if (bubble[j] < bubble[j - 1]) {
                    temp=bubble[j-1];
                    bubble[j-1]=bubble[j];
                    bubble[j]=temp;
                    logger.info("Элемент массива: "+bubble[j-1]+" встал на позицию "+(j-1));     
                }
        }
    }
    System.out.println(Arrays.toString(bubble));
    }
}