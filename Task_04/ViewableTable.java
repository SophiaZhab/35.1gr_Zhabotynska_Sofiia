package Task_04;

import Task_03.ViewableResult;
import Task_03.View;
/**
 * Клас `ViewableTable` успадковує клас `ViewableResult` і призначений для 
 * надання інтерфейсу `View` для доступу до табличних даних і їх відображення.
 */
public class ViewableTable extends ViewableResult{
    /**
     * Метод `getView` реалізує абстрактний метод з `ViewableResult`.
     * Він повертає новий екземпляр класу `ViewTable`, який фактично обробляє логіку
     * створення та відображення таблиці.
     *
     * @return Новий екземпляр класу `ViewTable`.
     */
    @Override
    public View getView(){
        return new ViewTable();
    }
}
