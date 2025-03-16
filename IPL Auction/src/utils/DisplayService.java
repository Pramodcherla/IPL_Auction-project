package utils;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisplayService {
    public static void showUnsoldPlayers() {
        Connection con = DBConnection.getConnection();
        if (con == null) return;

        try {
            String query = "SELECT * FROM players";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n📋 Unsold Players:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("player_name") + " - " + rs.getString("role") + " - ₹" + rs.getFloat("base_price") + " Cr");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showSoldPlayers() {
        Connection con = DBConnection.getConnection();
        if (con == null) return;

        try {
            String query = "SELECT * FROM sold_players";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n🏆 Sold Players:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("player_name") + " - " + rs.getString("role") + " - Team: " + rs.getString("team") + " - ₹" + rs.getFloat("bid_price") + " Cr");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showTeamPlayers() {
        String[] teams = {"SRH", "CSK", "MI", "RCB"};
        Connection con = DBConnection.getConnection();
        if (con == null) return;

        try {
            for (String team : teams) {
                String query = "SELECT * FROM " + team;
                PreparedStatement ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();

                System.out.println("\n🏏 Players in " + team + ":");
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + ". " + rs.getString("player_name") + " - " + rs.getString("role"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
