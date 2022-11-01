package lection9.hometask9.second_part_hometask.task1;

/*
1. Створити клас Notepad з внутрішнім класом або класами, за допомогою об'єктів якого можуть зберігатися кілька записів на одну дату.
Створені класи до завдання:
  - Notepad.java
  - NotePadRunner.java
 */


import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Клас, що відображає блокнот
 * Структура блокноту:
 *  -NotePad
 *      -NotePadDate
 *          - Note
 *          - Note
 *          - Note
 *      -NotePadDate
 *          - Note
 *          - Note
 */
public class Notepad {
    /*
    Список, що зберігає папки з нотатками
    Кожна папка має певну дату та список нотаків, що зберігаються у цій папці
     */
    private static ArrayList<NotePadDate> dates = new ArrayList<>();

    /**
     * Клас відображає окрему папку в блокноті яка має дату і містить список нотатків збережених у ній
     */
    private class NotePadDate {
        private LocalDate date; // Дата нотаток
        private ArrayList<Note> notes = new ArrayList<>(); // Список всіх нотаток, що мають однакову дату

        public NotePadDate(String date) {
            this.date = createData(date);
        }

        /**
         * Метод для перетворення строкового представлення дати типу YYYY-MM-DD в дату, що представляється класом LocalDate
         * @param date дата для створення об'єкту LocalDate
         * @return об'єкт LocalDate з поданою в date датою
         */
        private static LocalDate createData(String date) {
            String[] strDateComponents = date.split("-");
            int[] intDateComponents = new int[strDateComponents.length];
            for (int i = 0; i < strDateComponents.length; i++) {
                if (strDateComponents[i].matches("0\\d")) {
                    strDateComponents[i] = strDateComponents[i].substring(1);
                }
                intDateComponents[i] = Integer.parseInt(strDateComponents[i]);
            }
            return LocalDate.of(intDateComponents[0], intDateComponents[1], intDateComponents[2]);
        }

        /**
         * Перевірка дати на відповідність шаблону YYYY-MM-DD
         * @param date дата для перевірки
         * @return true - якщо дата відповідає шаблону YYYY-MM-DD.
         *         false - якщо дата не відповідає шаблону YYYY-MM-DD
         */
        private static boolean isDateCorrect(String date) {
            if (date.matches("\\d{4}-((0?\\d)|1[0-2])-((0?[1-9])|[1-2]\\d|(30|31))")) {
                return true;
            }
            return false;
        }

        /**
         * Метод для перевірки існування вказаної дати "date" в списку всіх дати "dates"
         * @param date дата для перевірки
         * @return true - якщо подана дата існує в списку всіх дати "dates".
         *         false- якщо подана дата відсутня в списку всіх дати "dates"
         */
        private static boolean isDateInDataBase(String date) {
            LocalDate localDate = createData(date);
            for (NotePadDate notePadDate : dates) {
                if (localDate.equals(notePadDate.date)) { // todo check date.toString()
                    return true;
                }
            }
            return false;
        }

        /**
         * Метод для отримання дати з списку всіх дати "dates"
         * @param date Дата для отримання
         * @return об'єкт типу NotePadDate з списку всіх дат "dates" - якщо дата "date" існує в поданому списку.
         *         null - якщо дата "date" відсутня у списку "dates"
         */
        private static NotePadDate getDateFromDataBase(String date) {
            LocalDate localDate = createData(date);
            for (int i = 0; i < dates.size(); i++) {
                if (localDate.equals(dates.get(i).date)) {
                    return dates.get(i);
                }
            }
            return null;
        }

        /**
         * Метод для перевірки існування вказаної нотатки "noteName" в списку всіх нотатків "notes" поданої дати у якої даний метод викликається
         * @param noteName Нотатка для пошуку в в списку "notes"
         * @return true - якщо нотатка існує.
         *         false - якщо нотатка відсутня
         */
        private boolean isNoteExists(String noteName) {
            for (Note note : notes) {
                if (noteName.equals(note.noteName)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Метод для отримання нотатки з списку всіх нотаток "notes"
         * @param noteName Ім'я нотатки для отримання з списку "notes"
         * @return об'єкт типу Note з списку всіх нотаток "notes" - якщо нотатка "noteName" існує в поданому списку.
         *         null - якщо нотатка "noteName" відсутня у списку "notes"
         */
        private Note getNoteFromDataBase(String noteName) {
            for (int i = 0; i < notes.size(); i++) {
                if (noteName.equals(notes.get(i).noteName)) {
                    return notes.get(i);
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return  "Дата: " + date;
        }
    }

    /**
     * Клас, що відображає нотатку(окремий запис в блокноті)
     */
    private class Note {
        private String noteName; // (Назва / Заголовок) нотатки
        private String noteText; // Текст нотатки

        public Note(String noteName, String noteText) {
            this.noteName = noteName;
            this.noteText = noteText;

        }

        /**
         * Метод для додавання тексту у вже існуючу нотатку
         * @param textToAdd текст який потрібно додати
         */
        private void addTextToNote(String textToAdd) {
            noteText += "\n" + textToAdd;
        }

        @Override
        public String toString() {
            return  "Заголовок: " + noteName + "\n" +
                    "------Текст нотакти------\n" + noteText + "\n";
        }
    }

    /**
     * Метод для створення нової нотатки
     * @param noteName Назва нової нотатки
     * @param noteText Текст нової нотатки
     * @param date Дата нової нотатки
     * @return true - якщо нотатка була успішно створена.
     *         false - якщо:
     *          1) Заданий невірний формат дати для нотатки у полі "date"
     *          2) Якщо нотатка з таким ім'ям вже існує у поданої дати "NotePadDate"
     */
    public boolean createNewNote(String noteName, String noteText, String date) {
        if (NotePadDate.isDateCorrect(date)) {
            if (NotePadDate.isDateInDataBase(date)) {
                NotePadDate notePadDate = NotePadDate.getDateFromDataBase(date);
                if (notePadDate.isNoteExists(noteName)) {
                    return false;
                } else {
                    notePadDate.notes.add(new Note(noteName, noteText));
                    return true;
                }
            } else {
                dates.add(new NotePadDate(date));
                NotePadDate.getDateFromDataBase(date).notes.add(new Note(noteName, noteText));
                return true;
            }
        }
        return false;
    }

    /**
     * Метод для додавання нового тексту в кінець вже існуючої нотатки
     * @param noteName Назва нотатки в яку потрібно дадати текст
     * @param textToAdd Текст який потрібно додати в кінець вже існуючої додатки
     * @param date Дата нотатки
     * @return true - якщо текст був успішно дозаписаний в подану нотатку.
     *         false - якщо:
     *          1) Заданий невірний формат дати для нотатки у полі "date"
     *          2) Дата "date" відсутня у списку всіх дат "dates"
     *          3) Нотатки з назвою "noteName" не існує
     */
    public boolean addTextToExistingNote(String noteName, String textToAdd, String date) {
        if (NotePadDate.isDateCorrect(date)) {
            if (NotePadDate.isDateInDataBase(date)) {
                NotePadDate notePadDate = NotePadDate.getDateFromDataBase(date);
                if (notePadDate.isNoteExists(noteName)) {
                    Note note = notePadDate.getNoteFromDataBase(noteName);
                    note.addTextToNote(textToAdd);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Метод для видалення нотатки
     * @param noteName Назва нотатки яку потрібно видалити
     * @param date Дата з якої треба видалити нотатку з назвою "noteName"
     * @return true - якщо нотатка була успішно видалена.
     *         false - якщо:
     *          1) Заданий невірний формат дати для нотатки у полі "date"
     *          2) Дата "date" відсутня у списку всіх дат "dates"
     *          3) Нотатки з назвою "noteName" не існує в списку "notes" поданої дати "date"
     */
    public boolean removeNote(String noteName, String date) {
        if (NotePadDate.isDateCorrect(date) && NotePadDate.isDateInDataBase(date)) {
            NotePadDate notePadDate = NotePadDate.getDateFromDataBase(date);
            if (notePadDate.isNoteExists(noteName)) {
                notePadDate.notes.remove(notePadDate.getNoteFromDataBase(noteName));
                return true;
            }
        }
        return false;
    }

    /**
     * Метод для видалення всіх нотаток закріплених за датою "date"
     * @param date Дата яку потрібно видалити з блокноту
     * @return true - якщо видалення дати "date" відбулось успішно.
     *         false - якщо:
     *          1) Заданий невірний формат дати для нотатки у полі "date"
     *          2) Дата "date" відсутня у списку всіх дат "dates"
     */
    public boolean removeAllNotesForCertainDate(String date) {
        if (NotePadDate.isDateCorrect(date) && NotePadDate.isDateInDataBase(date)) {
            NotePadDate notePadDate = NotePadDate.getDateFromDataBase(date);
            dates.remove(notePadDate);
            return true;
        }
        return false;
    }

    /**
     * Метод для отримання всіх нотаків(записів) закріплених за датою "date"
     * @param date дата, нотатки якої потрібно отримати
     * @return всі записи закріплені за датою "date" якщо така дата існує, інакше повертає "No existing notes for date: "date" in notePad
     */
    public String getNotes(String date) {
        if (NotePadDate.isDateCorrect(date) && NotePadDate.isDateInDataBase(date)) {
            NotePadDate notePadDate = NotePadDate.getDateFromDataBase(date);
            String allNotePadDateNotes = "------Нотатки за " + notePadDate.date.toString() + "------\n";
            for (int i = 0; i < notePadDate.notes.size(); i++) {
                allNotePadDateNotes += (i + 1) + ") " + notePadDate.notes.get(i) + "\n";
            }
            return allNotePadDateNotes;
        }
        return "No existing notes for date: " + date + " in notePad\n";
    }

    @Override
    public String toString() {
        String notePad = "----Всі дати записів в блокноті----\n";
        for (int i = 0; i < dates.size(); i++) {
            notePad += (i + 1) + ") " + dates.get(i) + "\n";
        }
        return notePad;
    }
}
