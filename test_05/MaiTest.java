package test_05;

import static org.junit.Assert.*;
import org.junit.Test;
import Task_03.Item2d;
import Task_03.ViewResult;
import Task_05.ChangeConsoleCommand;
import Task_05.ChangeItemCommand;

public class MaiTest {
    @Test
    public void testExecute() {
        ChangeItemCommand cmd = new ChangeItemCommand();
        cmd.setItem(new Item2d());
        int decimal, oct, hex, offset;
        for (int ctr = 0; ctr < 1000; ctr++) {
            cmd.getItem().setDecOctHex(decimal = (int)Math.random() * 100, oct = (int)Math.random() * 100, hex = (int)Math.random() * 100);
            cmd.setOffset(offset = (int)(Math.random() * 100));
            cmd.execute();
            assertEquals(decimal, cmd.getItem().getDecimalValue(), .1e-10);
            assertEquals(oct * offset, cmd.getItem().getOctNumber(), .1e-10);
            assertEquals(hex * offset, cmd.getItem().getHexNumber(), .1e-10);
        }
    }

    @Test
    public void testChangeConsoleCommand() {
        ChangeConsoleCommand cmd = new ChangeConsoleCommand(new ViewResult());
        cmd.getView().viewInit();
        cmd.execute();
        assertEquals("'м'інити", cmd.toString());
        assertEquals('м', cmd.getKey());
    }
}
