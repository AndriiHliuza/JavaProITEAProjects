package lection9.hometask9.second_part_hometask.task1;


public class NotePadRunner {
    public static void main(String[] args) {
        // Створюємо блокнот
        Notepad notepad = new Notepad();

        // Створюємо декілька нотатків
        System.out.println("New note was created: " + notepad.createNewNote("note1", "this is note1 text", "2022-6-30"));
        System.out.println("New note was created: " + notepad.createNewNote("note2", "this is note2 text", "2022-6-30"));
        System.out.println("New note was created: " + notepad.createNewNote("note1", "hello world!!!", "2022-7-30"));
        System.out.println("New note was created: " + notepad.createNewNote("note1", "To do list: go to the shop, go to the cinema", "2022-6-29"));
        System.out.println("New note was created: " + notepad.createNewNote("note2", "Just wrote some text", "2022-6-29"));
        /*
        Намагаємось створити нотатку з невірним вказанням формату дати
        Дата: 2022-42-67
        Не існує 42 місяця в році та 67 дня в місяці
         */
        System.out.println("New note was created: " + notepad.createNewNote("note1", "hello world!!!", "2022-42-67"));

        // Роздруковуємо список всіх дат в блокноті
        System.out.println(notepad);

        /*
        Роздруковуємо нотатки, що закріплені за датами:
        2022-06-30
        2022-07-30
        2022-06-29
         */
        System.out.print(notepad.getNotes("2022-06-30"));
        System.out.print(notepad.getNotes("2022-07-30"));
        System.out.print(notepad.getNotes("2022-06-29"));

        /*
        Намагаємось роздрукувати всі нотатки за число 2021-06-30
        Так як нотаток з такою датою не існує, то отримуємо в консоль "No existing notes for date: 2021-06-30 in notePad"
         */
        System.out.println(notepad.getNotes("2021-06-30"));

        // Додаємо текст до вже існуючої нотатки
        System.out.println("Текст було додано: " + notepad.addTextToExistingNote("note2", "Some added text", "2022-6-30"));
        System.out.print(notepad.getNotes("2022-6-30"));

        // Видаляємо нотатку
        System.out.println("Note was removed: " + notepad.removeNote("note1", "2022-06-30"));
        System.out.print(notepad.getNotes("2022-06-30"));

        // Видаляємо всі нотатки, що закріплені за датою 2022-06-29
        System.out.println("All notes for certain date was removed: " + notepad.removeAllNotesForCertainDate("2022-6-29"));
        System.out.print(notepad.getNotes("2022-06-29"));
        System.out.print(notepad);
    }
}
