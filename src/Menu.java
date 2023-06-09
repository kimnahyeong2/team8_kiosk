import java.util.UUID;

public class Menu {
    private String name;
    private String desc;
    private UUID menuId;

    public Menu(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.menuId = UUID.randomUUID();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return name + " | " + desc;
    }

    public UUID getMenuId() { return menuId; }

    public void setMenuId( UUID menuId ) { this.menuId = menuId; }

}

