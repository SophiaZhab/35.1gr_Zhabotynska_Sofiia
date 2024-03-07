package Task_05;

import Task_03.Item2d;

public class CangeItemCommand implements Command {
    private Item2d item;
    private int offset;
    public Item2d setItem(Item2d item) {
        return this.item = item;
        }
        public Item2d getItem() {
        return item;
        }
        public double setOffset(int offset) {
        return this.offset = offset;
        }
        public double getOffset() {
        return offset;
        }
        @Override
        public void execute() {
        item.setOctNumber(item.getOctNumber() * offset);
        }
}
