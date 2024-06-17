public abstract class Equipment implements Cloneable{
    String name;
        int price;
        int attackBonus;
        int defenceBonus;
        int healthBonus;
        int speedBonus;
    
        public Equipment(String name, int price, int attackBonus, int defenceBonus, int healthBonus, int speedBonus) {
            this.name = name;
            this.price = price;
            this.attackBonus = attackBonus;
            this.defenceBonus = defenceBonus;
            this.healthBonus = healthBonus;
            this.speedBonus = speedBonus;
        }
    
        public void printDetails(){
            System.out.println("Name: "+this.name);
            System.out.println("Price: "+this.price);
            System.out.println("Attack Bonus: "+this.attackBonus);
            System.out.println("Defence Bonus: "+this.defenceBonus);
            System.out.println("Health Bonus: "+this.healthBonus);
            System.out.println("Speed Bonus: "+this.speedBonus);
        }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAttackBonus() {
        return this.attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getDefenceBonus() {
        return this.defenceBonus;
    }

    public void setDefenceBonus(int defenceBonus) {
        this.defenceBonus = defenceBonus;
    }

    public int getHealthBonus() {
        return this.healthBonus;
    }

    public void setHealthBonus(int healthBonus) {
        this.healthBonus = healthBonus;
    }

    public int getSpeedBonus() {
        return this.speedBonus;
    }

    public void setSpeedBonus(int speedBonus) {
        this.speedBonus = speedBonus;
    }

    @Override
    public Equipment clone() {
        try {
            return (Equipment) super.clone();
        } catch (CloneNotSupportedException e) {
            // This should never happen since Army implements Cloneable
            throw new AssertionError();
        }
    }
}