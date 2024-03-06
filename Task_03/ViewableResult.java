package Task_03;

public class ViewableResult implements Viewable {
    @Override
    public View getView() {
    return new ViewResult();
    }
    }
