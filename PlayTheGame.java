import java.util.*;

public class PlayTheGame {
   static Scanner GlobalScanner;
    public static void main(String[] args) {
        GlobalScanner = new Scanner(System.in);
        selectTheGame();
    }

        public static void selectTheGame () {
            System.out.println("Choose what game you want to play: type 1 for 'Guess the number', type 2 for 'Guess the word' or type anything different to exit the program");
            //Scanner scanner = new Scanner(System.in);

          int lintChooseTheGame = GlobalScanner.nextInt() ;
            switch (lintChooseTheGame) {
                case 1:
                    guessTheNumber();
                    break;
                case 2:
                    guessTheFood();
                    break;
                default:
                    System.out.println("We have no such game");
                    break;
        }
    }

    public static void guessTheNumber() { // Scanner from console practice
        System.out.println("Okay, you wanna play 'Guess the Number' game, you have 3 attempts");
       // Scanner numScanner = new Scanner(System.in);
        int lintUsersChoice;
        int lintRandom = (int) (Math.random() * 10);

        for (int lintAttemptsCounter = 0; lintAttemptsCounter < 3; lintAttemptsCounter++) {
            System.out.println("Guess the number from 0 to 9, attempt " + (lintAttemptsCounter + 1));
            lintUsersChoice = GlobalScanner.nextInt();
            if (lintUsersChoice == lintRandom) {
                System.out.println("Keanu says that you are breathtaking!");
                break;
            } else {
                if (lintRandom < lintUsersChoice) {
                    System.out.println("Your number is more than guessed " /*+ lintRandom <- использовалось для проверки правильности логики*/);
                } else {
                    System.out.println("Your number is less than guessed " /*+ lintRandom <- использовалось для проверки правильности логики*/);
                }
            }
        }
        System.out.println("The guessed number is " + lintRandom);
       // numScanner.close();
        selectTheGame();
    }

    /* Создать массив из слов
    String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
            При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его с загаданным
             словом и сообщает, правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
    apple – загаданное
    apricot - ответ игрока
    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    Для сравнения двух слов посимвольно можно пользоваться:
    String str = "apple";
    char a = str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово.
    Используем только маленькие буквы.
    */

    public static void guessTheFood() /*throws Exception*/ { // Arrays practice
        System.out.println("Okay, you wanna play 'Guess the word' game, computer will give you some hints. Here is the array:");
        System.out.println("-------");
        String[] wordsArray = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};
        PrintTheArray(10, wordsArray);
        System.out.println("-------");

        int lintCompsChoice = new Random().nextInt(wordsArray.length);
        String secretWord = wordsArray[lintCompsChoice];
//        Scanner lintConsoleInput = new Scanner(System.in);
        System.out.print("Type a word that computer guessed, you think: ");
        boolean successFlag = false;
        while (!successFlag) { //Выполняем пока слово не угадается
            successFlag = checkAnswer(secretWord, readInput());
        }
        selectTheGame();
    }

    private static String readInput() { //Считываем введенное значение от пользователя

        Scanner lintConsoleInput = new Scanner(System.in);
        String consoleInput = lintConsoleInput.nextLine();
        System.out.println("Your answer is: " + consoleInput);
        return consoleInput;
    }

    public static boolean checkAnswer (String secretWord, String inputWord) { //Проверяем ответ и возвращаем true если угадали и false с подсказкой если нет
        if (secretWord.equals(inputWord)) { //А вдруг сразу угадал, тогда выходим
            System.out.println("You win. Guessed word is: " + secretWord);
            return true;
        }
        for (int letterNum = 0; letterNum < inputWord.length(); letterNum++) {
            char a = inputWord.charAt(letterNum);
            if (letterNum != secretWord.length()) { //Проверяем, чтобы не вылететь за размер, если введеденное слово будет больше чем загаданное
                if (secretWord.charAt(letterNum) == a) {
                    System.out.print(a); /*Если буква в позиции совпала, то выводим
                    (но если набрать в консоли, например, "aaaaaaaaaaaaaaaaa", то шансы на победу увеличиваются, неплохо сделать бы проверку на вводимое слово,
                    чтобы пользователь был ограничен в своей вводимой дичи*/

                } else {
                    System.out.print("#"); //Если нет, то закрываем
                }
            } else {
                break; //Рвем цикл, если выходим за границы загаданного слова
            }
        }
        System.out.print("#############");// Дописываем для ужаса еще решеток
        System.out.println();
        System.out.println("Try another word, if several letters equals you have a hint above");
        return false;
    }

    public static void PrintTheArray(int delimiterSize, String[] inputArray) { // помощь зала
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(inputArray));
        for (int start = 0; start < arrayList.size(); start += delimiterSize) {
            int end = Math.min(start + delimiterSize, arrayList.size());
            List<String> sublist = arrayList.subList(start, end);
            System.out.println(sublist);
        }
    }
}
