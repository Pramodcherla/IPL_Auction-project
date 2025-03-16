package models;

public class Player {
    private int id;
    private String name;
    private String role;
    private float basePrice;

    public Player(int id, String name, String role, float basePrice) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.basePrice = basePrice;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public float getBasePrice() { return basePrice; }
}
