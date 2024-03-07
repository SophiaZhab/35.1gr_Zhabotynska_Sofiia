package Task_05;

import Task_03.Item2d;

/**
 * Команда
 * Change item;
 * шаблон Command
 * 
 * @author Софія Жаботинська
 */
public class ChangeItemCommand implements Command {
    private Item2d item;
    private int offset;

    /**
     * Встановлює поле {@linkplain ChangeItemCommand#item}
     * 
     * @param item значення для {@linkplain ChangeItemCommand#item}
     * @return нове значення {@linkplain ChangeItemCommand#item}
     */
    public Item2d setItem(Item2d item) {
        return this.item = item;
    }

    /**
     * Повертає поле {@linkplain ChangeItemCommand#item}
     * 
     * @return значення {@linkplain ChangeItemCommand#item}
     */
    public Item2d getItem() {
        return item;
    }

    /**
     * Встановлює поле {@linkplain ChangeItemCommand#offset}
     * 
     * @param offset значення для {@linkplain ChangeItemCommand#offset}
     * @return нове значення {@linkplain ChangeItemCommand#offset}
     */
    public int setOffset(int offset) {
        return this.offset = offset;
    }

    /**
     * Повертає поле {@linkplain ChangeItemCommand#offset}
     * 
     * @return значення {@linkplain ChangeItemCommand#offset}
     */
    public int getOffset() {
        return offset;
    }

    @Override
    public void execute() {
        item.setOctNumber(item.getOctNumber() * offset);
        item.setHexNumber(item.getHexNumber() * offset);
    }
}
