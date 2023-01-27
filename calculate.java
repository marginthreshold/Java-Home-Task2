//Реализовать простой калькулятор (пользователь вводит 2 числа и вводит операцию (+ - / *). int a ; int b

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.*;

public class calculate {
    
    public static void main(String[] args) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(calculate.class.getName());
        FileHandler fh = new FileHandler("logging.log");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.setUseParentHandlers(false);
        logger.log(Level.INFO, "Начало логирования");
        Scanner sc=new Scanner(System.in);
        String outOf="run";
        do{
        System.out.println("Введите первое число: ");
        try {
            int number1 = sc.nextInt();
            logger.info("Введено Первое число: "+number1);
            System.out.println("Введите второе число: "); 

            int number2 = sc.nextInt();
            logger.info("Введено Второе число: "+number2);
            System.out.println("Введите действие с числами (+ - / *): "); 
            String do_it = sc.next();
            logger.info("Введено Действие: "+do_it);
            calc(number1,do_it,number2);
            System.out.println("Нажмите n, если не хотите делать вычисления, или любую клавишу");
            outOf =sc.next();
            logger.info("Введено для выхода/продолжения: "+outOf);

        } catch (Exception e) {
        System.out.println("Неправильное число или действие!");
        }
        }
        while (!outOf.equals("n"));
        
        sc.close();
    }

        
    public static void calc(int number1,String do_it, int number2) {
        if (do_it.equals("/") && number2==0) {
            System.out.println("Делить на ноль нельзя");
               } else {
                Map <String, Integer> map = new HashMap<>();
                map.put("+",number1+number2);
                map.put("-",number1-number2);
                map.put("*",number1*number2);
                if (number2==0) number2=1;
                map.put("/",number1/number2);
                System.out.println("Целочисленный результат равен: "+map.get(do_it));
            }
        }
}
    

