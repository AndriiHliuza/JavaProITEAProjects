package lection9.lesson9;

public class TeacherCreator {
    public static AbstractTeacher createTeacher(int id) {
        class Rector extends AbstractTeacher {
            public Rector(int id) {
                super(id);
            }

            @Override
            public boolean excludeStudent(String name) {
                return name != null;
            }
        }

        if (isRector(id)) {
            return new Rector(id);
        } else {
            return new Teacher(id);
        }
    }

    private static boolean isRector(int id) {
        return id == 6;
    }
}
