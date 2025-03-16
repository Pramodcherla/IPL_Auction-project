

import services.AuctionService;
import utils.DisplayService;
import services.PlayerService;
import utils.DisplayService;
import utils.ResetService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n📢 IPL AUCTION MENU");
            System.out.println("1️⃣ View Unsold Players");
            System.out.println("2️⃣ View Team Players");
            System.out.println("3️⃣ View Sold Players");
            System.out.println("4️⃣ Start Auction");
            System.out.println("5️⃣ Reset Auction");
            System.out.println("6️⃣ Add Player");
            System.out.println("0️⃣ Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> DisplayService.showUnsoldPlayers();
                case 2 -> DisplayService.showTeamPlayers();
                case 3 -> DisplayService.showSoldPlayers();
                case 4 -> AuctionService.startAuction();
                case 5 -> ResetService.resetAuction();
                case 6 -> PlayerService.addPlayer();
                case 0 -> {
                    System.out.println("🏏 Exiting IPL Auction. See you next time!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }
}
