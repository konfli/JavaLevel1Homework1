public class HomeWork2 {

    public static void main(String[] args) {

        swapZeroAndOne();

        fillArray();

        changeArray();

        fillDiagonal();

        findMinAndMaxOfArray();

        int[] array = new int[]{2, 2, 3, 4, 5, 6};
        System.out.println(checkBalance(array));

        shiftArray(array, 2);
    }


    public static void swapZeroAndOne() {
        int[] arr = new int[]{0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
                System.out.print(arr[i] + "\t");
            } else {
                arr[i] = 0;
                System.out.print(arr[i] + "\t");
            }
        }
        System.out.println();
    }

    public static void fillArray() {
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i * 3;
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    public static void changeArray() {
        int[] arr = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
                System.out.print(arr[i] + "\t");
            } else {
                System.out.print(arr[i] + "\t");
            }
        }
        System.out.println();
    }

    public static void fillDiagonal() {
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, j1 = arr[i].length; j < arr[i].length; j++, j1--) {
                if (i == j || i == j1 - 1) {
                    arr[i][j] = 1;
                    System.out.print(arr[i][j] + "\t");


                } else System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void findMinAndMaxOfArray() {
        int[] arr = new int[]{10, 20, -130, 150, 180};
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            }
        }
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println("минимальное число масива : " + min);
        System.out.println("максимальное число масива : " + max);
    }

    public static boolean checkBalance(int[] arr) {
        int sum1, sum2;
        for (int i = 0; i < arr.length; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j < i; j++)
                sum1 += arr[j];
            for (int j = i; j < arr.length; j++)
                sum2 += arr[j];
            if (sum1 == sum2)
                return true;
        }
        return false;

    }


    public static void shiftArray(int[] arr, int n) {

    }



}
