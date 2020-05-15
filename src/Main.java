public class Main {

    public static void main(String[] args) {

        byte a;
        a = 110;
        short b = 13892;
        int c = 25000;
        long d = -1200000;
        float e = 134.24f;
        double f = 432.234;
        char g = 't', h = 60000;
        boolean i = false;
        String word = "Hello";

        System.out.println(expression(1,2,3,4));

        System.out.println(checkSumm(10, 20));

        negativeOrPositive(-1);

        System.out.println(trueIfNegative(-10));

        sayHello("Ivan");

        leapYear(2024);
    }

    public static float expression(float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    public static boolean checkSumm(int a, int b){
        if (a + b <= 20 && a + b >= 10){
            return true;
        } else{
            return false;
        }
    }

    public static void negativeOrPositive(int a){
        if(a >= 0){
            System.out.println(a + " is Positive");
        } else{
            System.out.println(a + " is Negative");
        }
    }

    public static boolean trueIfNegative(int a){
        if(a < 0){
            return true;
        } else{
            return false;
        }
    }

    public static void sayHello(String name){
        System.out.println("Hello " + name);
    }

    public static void leapYear(int a){
        if(a % 4 == 0 && a % 100 != 0){
            System.out.println(a + " is a leap year!");
        } else if(a % 400 == 0) {
            System.out.println(a + " is a leap year!");
        } else {
            System.out.println(a + " is not a leap year!");
        }
    }

}
