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
                game.easyGame();
                break;
            case "MEDIUM":
                game.mediumGame();
                break;
            case "HARD":
                game.hardGame();
                break;
            default:
                System.out.println("Invalid difficulty");
        }
    }
    void easyGame(){
        int length = 2;
    }
    void mediumGame(){
        int length = 3;
    }
    void hardGame(){
        int length = 4;
    }
}
