package AbstractClasses;

/**
 * Родительский класс всех животных
 * @author Антон Хрусталев
 * @version 1.0
 */

public abstract class Animal extends TaskedEntity {
    private int health = 10;
    public boolean isAlive = true;

    /**
     * Раним животное
     * @param damage
     */
    public void damage(int damage) {
        this.health -= damage;
        if (this.health <= 0) this.isAlive = false;

    }

    /**
     * Исцеляем животное
     * @param heal
     */
    public void heal(int heal) {
        this.health += heal;
        if (this.health <= 0) {this.isAlive = false;}
        else {this.isAlive = true;}
    }

}
