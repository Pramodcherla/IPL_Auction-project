package utils;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResetService {
    public static void resetAuction() {
        try (Connection con = DBConnection.getConnection()) {
            String restoreQuery = "INSERT INTO players (id, player_name, role, base_price) SELECT id, player_name, role, base_price FROM sold_players";
            String deleteQuery = "DELETE FROM sold_players";

            con.prepareStatement(restoreQuery).executeUpdate();
            con.prepareStatement(deleteQuery).executeUpdate();

            System.out.println("🔄 Auction has been reset!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
