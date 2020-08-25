public class Main {
    public static void main(String[] args) {
        System.out.println("- Homework Java 1 Lesson 2 -");
        invertArray();
        System.out.println();
        fillArray();
        System.out.println();
        duplicateVarsInArray();
        System.out.println();
        fillDiagonalInSquareArr();
        minMaxInArr();
//            checkBalance();
    }

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void invertArray() {
        System.out.println("----");
        System.out.println("Задание 1: замена 0 и 1 друг на друга в массиве:");
        System.out.println("Исходный массив:");
        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");}
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            }
            else {
                arr[i] = 0;
            }
        }
        System.out.println("Изменённый массив:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 2. Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void fillArray() {
        System.out.println("----");
        int[] arr = new int[8];
        int a = 0;
        for (int j = 1; j < arr.length; j++) {
            a = a + 3;
            arr[j] = a;
        }
        System.out.println("Задание 2: массив с 8-ю переменными с шагом 3:");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }

    //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void duplicateVarsInArray() {
        System.out.println("----");
        System.out.println("Задание 3: умножение на 2 чисел из массива, чьё значение < 6:");
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");}
        System.out.println();
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] < 6) {
                arr[k] = arr[k] * 2;
            }
        }
        System.out.println("Изменённый массив:");
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
    }

    //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void fillDiagonalInSquareArr() {
        System.out.println("----");
        System.out.println("Задание 4: квадратный массив с '1' в диагоналях:");

        int n = 5; // задаём размерность массива, можно запросить его у пользователя через консоль, но в задании такого не было. Для чётных значений результат выглядит забавно
        int[][] squareArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || n-i == j+1) {
                    squareArr[i][j] = 1;
                } else {
                    squareArr[i][j] = 0;
                }
                System.out.print(squareArr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void minMaxInArr() {
        System.out.println("----");
        System.out.println("Задание 5*: max и min в одномерном массиве:");
        int[] arr = new int[7];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 50);
            System.out.print(arr[i] + " ");
        }
        int arrmin = arr[0];
        int arrmax = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr [i] < arrmin) {
                arrmin = arr[i];
            }
            else if (arr [i] > arrmax) {
                arrmax = arr[i];
            }
        }
        System.out.println();
        System.out.println("Минимальное число (min): " + arrmin);
        System.out.println("Максимальное число (max): " + arrmax);
    }
        /*
        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место,
         в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
         граница показана символами ||, эти символы в массив не входят. - В итоге решить не смогла :(

        public static void checkBalance() {
            System.out.println("----");
            System.out.println("Задание 6*: если в массиве есть место, в котором сумма левой и правой части равны, то true, else -> false:");
            int[] arr = {2, 2, 2, 1, 2, 2, 10, 1};
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");}
            System.out.println();

            int length = arr.length;
            int sum = 0;

            for(int i=0; i<length; ++i)
                sum += arr[i];

            int rightSum = sum-arr[0];
            int leftSum = 0;

            for(int i=0; i<length-1; ++i){

                if(leftSum == rightSum)
                    System.out.println("true");

                leftSum += arr[i];
                rightSum -= arr[i+1];
            }

            if (leftSum == rightSum)
                System.out.println("true");;

            System.out.println("false");

        }
*/
/*
7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
 при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
*/


} // - это закрывающая скобка Main!


