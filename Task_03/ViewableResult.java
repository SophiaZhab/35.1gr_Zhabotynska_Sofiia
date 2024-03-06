package Task_03;

public class ViewableResult implements Viewable {
    /** Создаёт отображаемый объект {@linkplain ViewResult} */
    @Override
    public View getView() {
    return new ViewResult();
    }
    }
