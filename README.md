# IPL_Auction-project
this is the project based on IPL Auction


📌 Overview
This IPL Auction System is a Java-based project that simulates the auction process of the Indian Premier League (IPL). It uses SQL as the database and JDBC for database connectivity. The system allows bidding on players, maintains sold and unsold players, and updates team rosters dynamically.

🎯 Features
✅ Add Players – Insert new players into the auction pool.
✅ Start Auction – Randomly pick a player, accept bids from four IPL teams, and finalize sales.
✅ Manual Bidding System – Bid by pressing keys (1️⃣ SRH, 2️⃣ CSK, 3️⃣ MI, 4️⃣ RCB).
✅ Auto-Increment Bid – Each bid increases by ₹0.2 Cr (20 Lakhs).
✅ Update Teams – Players sold are assigned to their respective teams.
✅ View Sold Players – Displays the list of players sold with final bid prices.
✅ View Unsold Players – Shows players who were not bid on.
✅ View Team Players – Shows the roster of each team.
✅ Reset Auction – Moves all sold players back to the unsold list, resetting the auction.

🛠️ Tech Stack
Language: Java (JDK 17+)
Database: MySQL
Database Connectivity: JDBC
IDE: IntelliJ IDEA
📂 Project Structure
main.Main – Entry point, contains the auction menu.
services.AuctionService – Handles bidding and player allocation.
services.DisplayService – Displays unsold/sold players and team rosters.
services.PlayerService – Allows adding new players to the database.
utils.ResetService – Resets the auction data.
db.DBConnection – Manages database connection.
