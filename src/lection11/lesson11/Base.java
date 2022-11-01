package lection11.lesson11;


@BaseAction(
        level = 2,
        sqlRequest = "SELECT * FROM phonebook"
)
public class Base {

    public static void doAction() {
        Class<Base> baseClass = Base.class;
        BaseAction annotation = (BaseAction)baseClass.getAnnotation(BaseAction.class);
        System.out.println(annotation);
        System.out.println(annotation.level());
        System.out.println(annotation.sqlRequest());
    }

    public static void main(String[] args) {
        doAction();
    }
}
