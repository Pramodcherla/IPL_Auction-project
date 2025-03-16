package services;

import db.DBConnection;
import models.Player;
import java.sql.*;
import java.util.Scanner;

public class AuctionService {
    public static void startAuction() {
        Connection con = DBConnection.getConnection();
        if (con == null) {
            System.out.println("Database connection failed.");
            return;
        }

        try {
            String query = "SELECT * FROM players ORDER BY RAND() LIMIT 1";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("No available players for auction.");
                return;
            }

            Player player = new Player(rs.getInt("id"), rs.getString("player_name"), rs.getString("role"), rs.getFloat("base_price"));

            System.out.println("\n🎉 Player Up for Auction: " + player.getName());
            System.out.println("Role: " + player.getRole());
            System.out.println("Base Price: ₹" + player.getBasePrice() + " Cr");

            Scanner scanner = new Scanner(System.in);
            float currentBid = player.getBasePrice();
            String winningTeam = null;

            System.out.println("\nPress      1-> SRH   ||     2-> CSK    ||    3-> MI    ||     4-> RCB     to bid.");
            System.out.println("Press 0 to end the auction.");

            while (true) {
                System.out.print("Enter your bid choice: ");
                int choice = scanner.nextInt();

                if (choice == 0) {
                    if (winningTeam == null) {
                        System.out.println("No bids placed. Player remains unsold.");
                    } else {
                        System.out.println("Auction ended. " + player.getName() + " is sold to " + winningTeam + " for ₹" + currentBid + " Cr");
                        TeamService.updateSoldPlayer(con, player, winningTeam, currentBid);
                    }
                    break;
                }

                switch (choice) {
                    case 1 -> winningTeam = "SRH";
                    case 2 -> winningTeam = "CSK";
                    case 3 -> winningTeam = "MI";
                    case 4 -> winningTeam = "RCB";
                    default -> {
                        System.out.println("Invalid input. Try again.");
                        continue;
                    }
                }

                currentBid += 0.2F; // 20 lakhs in crores
                System.out.println("🔼 " + winningTeam + " bids ₹" + currentBid + " Cr");
            }

            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
