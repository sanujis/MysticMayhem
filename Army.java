public abstract class Army implements Cloneable{
    private String name;
    private int price;
    private double attack;
    private double defence;
    private double health;
    private double speed;
    private String type;
    private Armour armour;
    private Artefact artefact;
    

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        if (this.armour != null) {
            // Remove the effects of the current armour
            this.setAttack(this.getAttack() - this.armour.getAttackBonus());
            this.setDefence(this.getDefence() - this.armour.getDefenceBonus());
            this.setHealth(this.getHealth() - this.armour.getHealthBonus());
            this.setSpeed(this.getSpeed() - this.armour.getSpeedBonus());
        }
        
        // Assign the new armour
        this.armour = (Armour) armour.clone();
        
        // Apply the effects of the new armour
        this.setAttack(this.getAttack() + armour.getAttackBonus());
        this.setDefence(this.getDefence() + armour.getDefenceBonus());
        this.setHealth(this.getHealth() + armour.getHealthBonus());
        this.setSpeed(this.getSpeed() + armour.getSpeedBonus());
    }

    public Artefact getArtefact() {
        return artefact;
    }

    public void setArtefact(Artefact artefact) {
        if (this.armour!=null){
            this.setAttack(this.getAttack() - this.artefact.getAttackBonus());
            this.setDefence(this.getDefence() - this.artefact.getDefenceBonus());
            this.setHealth(this.getHealth() - this.artefact.getHealthBonus());
            this.setSpeed(this.getSpeed() - this.artefact.getSpeedBonus());
        }
        this.artefact = (Artefact) artefact.clone();
        this.setAttack(this.getAttack() + artefact.getAttackBonus());
        this.setDefence(this.getDefence() + artefact.getDefenceBonus());
        this.setHealth(this.getHealth() + artefact.getHealthBonus());
        this.setSpeed(this.getSpeed() + artefact.getSpeedBonus());
    }

    public Army(String name, int price, int attack, int defence, int health, int speed, String type) {
        this.name = name;
        this.price = price;
        this.attack = attack;
        this.defence = defence;
        this.health = health;
        this.speed = speed;
        this.type=type;
    }

    public void printDetails(){
        System.out.println("Name: "+this.name);
        System.out.println("Price: "+this.price);
        System.out.println("Attack: "+this.attack);
        System.out.println("Defence: "+this.defence);
        System.out.println("Health:"+this.health);
        System.out.println("Speed: "+this.speed);
    }

    @Override
    public Army clone() {
        try {
            return (Army) super.clone();
        } catch (CloneNotSupportedException e) {
            // This should never happen since Army implements Cloneable
            throw new AssertionError();
        }
    }

    public double getSpeed(){
        return speed;
    }

    public double getDefence(){
        return this.defence;
    }

    public double getHealth(){
        return health;
    }

    public void setHealth(double health){
        health=Math.round(health*10.0)/10.0;
        if(health<=0.0){
            this.health=0.0;
        }
        else{
            this.health=health;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        attack=Math.round(attack*10.0)/10.0;
        this.attack = attack;
    }

    public void setDefence(double defence) {
        defence=Math.round(defence*10.0)/10.0;
        this.defence = defence;
    }

    public void setSpeed(double speed) {
        speed=Math.round(speed*10.0)/10.0;
        this.speed = speed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void increaseAttack(int value) {
        this.attack += value;
    }

    public void decreaseAttack(int value) {
        this.attack -= value;
    }

    public void increaseDefense(int value) {
        this.defence += value;
    }

    public void decreaseDefense(int value) {
        this.defence -= value;
    }

    public void increaseSpeed(int value) {
        this.speed += value;
    }

    public void decreaseSpeed(int value) {
        this.speed -= value;
    }

    public void decreaseHealth(int value) {
        this.health -= value;
    }

    public void increaseHealth(int value) {
        this.health -= value;
    }
}
