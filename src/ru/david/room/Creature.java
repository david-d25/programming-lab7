package ru.david.room;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * Существо с координатами, размером, именем и временем создания.
 */
public class Creature extends PhysicalObject implements Comparable<Creature> {
    private String name = "Безымянный";
    private ZonedDateTime created = ZonedDateTime.now();

    /**
     * Создаёт безымянное существо с указанными координатами
     * @param x x-координата существа
     * @param y y-координата существа
     */
    public Creature(int x, int y) {
        super(x, y);
    }

    /**
     * Создаёт существо с указанными координатами и именем
     * @param x x-координата существа
     * @param y y-координата существа
     * @param name имя существа
     */
    public Creature(int x, int y, String name) {
        super(x, y);
        this.name = name;
    }

    /**
     * Создаёт безымянное существо с указанными координатами и размером
     * @param x x-координата существа
     * @param y y-координата существа
     * @param width ширина существа
     * @param height высота существа
     */
    public Creature(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    /**
     * Создаёт безымянное существо с указанными координатами, размером и именем
     * @param x x-координата существа
     * @param y y-координата существа
     * @param width ширина существа
     * @param height высота существа
     * @param name имя существа
     */
    public Creature(int x, int y, int width, int height, String name) {
        super(x, y, width, height);
        this.name = name;
    }

    public Creature(int x, int y, int width, int height, String name, ZonedDateTime created) {
        super(x, y, width, height);
        this.name = name;
        this.created = created;
    }

    /**
     * @return Имя существа
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя существа
     * @param name имя существа
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return время создания существа
     */
    public ZonedDateTime getCreated() {
        return created;
    }

    /**
     * Устанавливает время создания существа
     * @param created время создания существа
     */
    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    /**
     * @return существо в виде читабельной строки
     */
    @Override
    public String toString() {
        return String.format("Существо в точке (%s; %s), \tразмер: %s x %s, создано %s, имя: %s",
                getX(),
                getY(),
                getWidth(),
                getHeight(),
                new SimpleDateFormat("hh:mm aa, dd.MM.yyyy").format(new Date(created.toInstant().getEpochSecond()*1000)),
                name
        );
    }

    /**
     * Определяет числовой эквивалент "крутости" существа
     * @return крутость существа
     */
    private int getCoolness() {
        return getX() + getY();
    }

    @Override
    public int compareTo(Creature o) {
        return getCoolness() - o.getCoolness();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) return false;
        if (this == o) return true;
        Creature c = (Creature) o;
        return  c.getName().equals(getName()) &&
                c.getX() == getX() &&
                c.getY() == getY() &&
                c.getWidth() == getWidth() &&
                c.getHeight() == getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, getX(), getY(), getWidth(), getHeight());
    }
}
