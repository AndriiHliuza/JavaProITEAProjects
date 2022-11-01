package lection9.lesson9;

public class Teacher extends AbstractTeacher{

    public Teacher(int id) {
        super(id);
    }

    @Override
    public boolean excludeStudent(String name) {
        return false;
    }
}
