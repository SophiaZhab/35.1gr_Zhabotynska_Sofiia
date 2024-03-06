package Task_04;

import Task_03.ViewableResult;
import Task_03.View;

public class ViewableTable extends ViewableResult{
    @Override
    public View getView(){
        return new ViewTable();
    }
}
