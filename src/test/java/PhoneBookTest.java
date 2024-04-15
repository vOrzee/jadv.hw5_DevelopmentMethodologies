import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.PhoneBook;

public class PhoneBookTest {

    static PhoneBook phoneBook;

    @BeforeEach
    public void setup() {
        phoneBook = new PhoneBook();
        phoneBook.add("Елена", "89261234567");
    }

    @ParameterizedTest
    @CsvSource({
            "Иван, 89033004567",
            "Мария, 89033004568",
            "Андрей, 89033004569"
    })
    public void addTest(String name, String number) {
        int expected = 2;
        int actual = phoneBook.add(name, number);
        Assertions.assertEquals(expected, actual, "После добавления в пустую книгу с одной записью размер должен быть равен двум");
    }

    @ParameterizedTest
    @CsvSource({
            "89261234567, Елена",
            "89033004567, Иван",
            "89033004568, Мария"
    })
    public void findByNumberTest(String number, String expectedName) {
        phoneBook.add(expectedName, number);
        Assertions.assertEquals(expectedName, phoneBook.findByNumber(number), "Должно вернуть правильное имя по номеру");
    }

    @ParameterizedTest
    @CsvSource({
            "Елена, 89261234567",
            "Иван, 89033004567",
            "Мария, 89033004568"
    })
    public void findByNameTest(String name, String expectedNumber) {
        phoneBook.add(name, expectedNumber);
        Assertions.assertEquals(expectedNumber, phoneBook.findByName(name), "Должно вернуть правильный номер по имени");
    }

    @ParameterizedTest
    @CsvSource({
            "Иван, 89033004567",
            "Мария, 89033004568",
            "Андрей, 89033004569"
    })
    public void printAllNamesTest(String name, String number) {
        phoneBook.add(name, number);
        Assertions.assertTrue(phoneBook.printAllNames().contains(name), "Список всех имен должен содержать добавленное имя");
    }
}
