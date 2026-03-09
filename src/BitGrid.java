import java.util.Scanner;

public class BitGrid {
    static Scanner sc = new Scanner(System.in);
    static BitGrid game = new BitGrid();
    public static void main(String[] args) {
        game.difficultyChoose();
    }
    void difficultyChoose(){
        System.out.println("Enter difficulty level: ");
        System.out.println("Easy- 2 digit long / Medium- 3 digit long / Hard- 4 digit long: ");
        String difficulty = sc.nextLine().toUpperCase();
        switch (difficulty){
            case "EASY":
                game.startGame(2);
                break;
            case "MEDIUM":
                game.startGame(3);
                break;
            case "HARD":
                game.startGame(4);
                break;
            default:
                System.out.println("Invalid difficulty");
        }
    }
    void startGame(int length){
        int[] secretCode = new int[length];
        int attempts = 0;
        for(int i = 0; i < length; i++){
            secretCode[i] = (int)(Math.random()*10);
        }
        while(attempts < 10){
            attempts++;
            System.out.println("Enter guess: ");
            String guessVar = sc.nextLine();
            if(guessVar.length() != length){
                System.out.println("Enter a " + length + " digit number");
                attempts--;
                continue;
            }
            int[] guess = new int[length];
            for(int i = 0; i < length; i++){
                guess[i] = guessVar.charAt(i) - '0';
            }
            int correctPosition = 0;
            int wrongPosition = 0;
            boolean[] secretUsed = new boolean[length];
            boolean[] guessUsed = new boolean[length];
            for(int i = 0; i < length; i++){
                if(guess[i] == secretCode[i]){
                    correctPosition++;
                    secretUsed[i] = true;
                    guessUsed[i] = true;
                }
            }
            if(correctPosition == length){
                System.out.println("YOU WIN!");
                System.exit(0);
            }
            for(int i = 0; i < length; i++){
                if(guessUsed[i]) continue;
                for(int j = 0; j < length; j++){
                    if(secretUsed[j]) continue;
                    if(guess[i] == secretCode[j]){
                        wrongPosition++;
                        secretUsed[j] = true;
                        break;
                    }
                }
            }
            System.out.println("Correct positions: " + correctPosition);
            System.out.println("Correct digits but wrong position: " + wrongPosition);
            System.out.println("Attempts: " + attempts + "/10");
        }
        System.out.print("YOU LOSE! Secret code: ");
        for(int i = 0; i < length; i++){
            System.out.print(secretCode[i]);
        }
        System.out.println();
    }
}
