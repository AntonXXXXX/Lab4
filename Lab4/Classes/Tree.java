package Classes;
import AbstractClasses.StaticEntity;
import java.util.Random;

public class Tree extends StaticEntity {
    private String describtion;
    private Vector2 position;
    private Type TreeType;

    /**
     * Вложенный статический класс
     */
    public static class Type {
        private String type;
        public Type(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    /**
     * Конструктор растения в рандомном месте локации
     * @param describe
     */
    public Tree(String describe) {
        super(new Vector2(new Random().nextInt(5)+1, 0));
        this.describtion = describe;
        TreeType = new Type("plant");
    }

    /**
     * Описываем тип растения
     * @param type
     */
    public void setTreeType(String type) {
        TreeType = new Type(type);
    }

    /**
     * Переопределяем метод toString
     * @return
     */
    @Override
    public String toString() {
        return "{Tree: type=" + TreeType.toString() + "; discribtion=\"" + describtion + "\"; pos=" + getPosition().toString() + "}";

    }

    /**
     * Переопределяем как того требует интерфейс
     * @param obj
     */
    @Override
    public void addDynamic(Object obj) {
    }
}
