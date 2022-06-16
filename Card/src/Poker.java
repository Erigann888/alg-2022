import java.util.Scanner;

    public class Poker {

        public static void main(String[] args) {

            String[] suits_list = {
                    "Пик", "Бубен", "Черв", "Треф"
            };

            String[] rank_list = {
                    "2", "3", "4", "5", "6", "7", "8", "9", "10",
                    "Валет", "Королева", "Король", "Туз"
            };

            int card = 5;
            int n = suits_list.length * rank_list.length;

            System.out.print("Введите количество игроков: ");
            Scanner in = new Scanner(System.in);
            int Players = in.nextInt();

            if (Players < 2) {
                System.out.println("Вы не можете играть один");
            } else if (n < Players * card) {
                System.out.println("Карт не хватает");
                System.exit(0);
            }

            String[] deck = new String[n];
            for (int i = 0; i < rank_list.length; i++) {
                for (int j = 0; j < suits_list.length; j++) {
                    deck[suits_list.length*i + j] = rank_list[i] + " " + suits_list[j];
                }
            }
    
            for (int i = 0; i < n; i++) {
                int r = i + (int) (Math.random() * (n-i));
                String temp = deck[r];
                deck[r] = deck[i];
                deck[i] = temp;
            }
            
            for (int i = 0; i < Players * card; i++) {
                if (i == 0)
                    System.out.println("Игрок " + 1);
                System.out.println(deck[i]);
                if (i % card == card - 1) {
                    if (i != (Players * card - 1)) {
                        System.out.println("Игрок " + ((i / card) + 2));
                    }
                }
            }
        }
    }
