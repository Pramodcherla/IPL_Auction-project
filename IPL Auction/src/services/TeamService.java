package services;

import models.Player;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeamService {
    public static void updateSoldPlayer(Connection con, Player player, String team, float bidPrice) {
        try {
            String query = "INSERT INTO sold_players (id, player_name, role, team, base_price, bid_price) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, player.getId());
            ps.setString(2, player.getName());
            ps.setString(3, player.getRole());
            ps.setString(4, team);
            ps.setFloat(5, player.getBasePrice());
            ps.setFloat(6, bidPrice);
            ps.executeUpdate();

            String teamQuery = "INSERT INTO " + team + " (id, player_name, role) VALUES (?, ?, ?)";
            PreparedStatement teamPs = con.prepareStatement(teamQuery);
            teamPs.setInt(1, player.getId());
            teamPs.setString(2, player.getName());
            teamPs.setString(3, player.getRole());
            teamPs.executeUpdate();

            String deleteQuery = "DELETE FROM players WHERE id = ?";
            PreparedStatement deletePs = con.prepareStatement(deleteQuery);
            deletePs.setInt(1, player.getId());
            deletePs.executeUpdate();

            System.out.println("📌 " + player.getName() + " is now part of " + team + ".");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
