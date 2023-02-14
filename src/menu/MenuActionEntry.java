package src.menu;

 public interface MenuActionEntry {

    public  void apply(MainMenu menu) ;
    public  String getLabel();

    public boolean isVisible();
}
