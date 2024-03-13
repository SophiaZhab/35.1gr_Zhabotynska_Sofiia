package test_04;

import org.junit.jupiter.api.Test;

import Task_0203.Calculate;
import Task_0203.Item2d;
import Task_0203.ViewResult;
import Task_04.ViewTable;

import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;

import java.io.IOException;

/**
 * Клас тестів для перевірки функціональності класів Calculate і ViewResult.
 */
public class MainTest {
    /**
     * Тестує метод init() класу ViewResult для перевірки правильності розрахунків.
     */
    @Test
        public void testCalc() {
        ViewTable tbl = new ViewTable(10, 5);
    ViewResult view = new ViewResult(3);
    view.init(7);
    Item2d item = new Item2d();
    int ctr = 0;
    item.setDecOctHex(0, 1, 1);
    assertTrue("очікувався:<" + item + "> але був:<" + view.getItems().get(ctr) + ">",
    view.getItems().get(ctr).equals(item));
    ctr++;
    item.setDecOctHex(7, 1, 1);
    assertTrue("очікувався:<" + item + "> але був:<" + view.getItems().get(ctr) + ">",
    view.getItems().get(ctr).equals(item));
    ctr++;
    item.setDecOctHex(14, 2, 1);
    assertTrue("очікувався:<" + item + "> але був:<" + view.getItems().get(ctr) + ">",
    view.getItems().get(ctr).equals(item));
    ctr++;
    }
    /**
     * Тестує методи viewSave() і viewRestore() класу ViewResult для перевірки збереження та відновлення даних.
     */
    @Test
    public void testRestore() {
        ViewResult view1 = new ViewResult(1000);
        ViewResult view2 = new ViewResult();
        view1.init((int)Math.random()*1000);
        try {
            view1.viewSave();
            } catch (IOException e) {
            Assert.fail(e.getMessage());
            }
            try {
            view2.viewRestore();
            } catch (Exception e) {
            Assert.fail(e.getMessage());
            }
            
            assertEquals(view1.getItems().size(), view2.getItems().size());
           
            assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
            }
}