package services;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PlayerService {
    public static void addPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Player Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Player Role (Batsman/Bowler/All-Rounder/Wicketkeeper): ");
        String role = scanner.nextLine();

        System.out.print("Enter Base Price (in Crores): ");
        float basePrice = scanner.nextFloat();

        Connection con = DBConnection.getConnection();
        if (con == null) {
            System.out.println("Database connection failed.");
            return;
        }

        try {
            String query = "INSERT INTO players (player_name, role, base_price) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, role);
            ps.setFloat(3, basePrice);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Player added successfully!");
            } else {
                System.out.println("❌ Failed to add player.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

