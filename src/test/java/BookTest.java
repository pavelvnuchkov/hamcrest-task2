import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class BookTest {

    static Author author;
    static Author author2;
    static Book book;
    static Book book2;
    static Book nullBook;

    @BeforeAll
    static void beforeAll() {
        author = new Author("Лев", "Толстой", 5);
        author2 = new Author("Иван", "Иванов", 1);
        book = new Book("Война и мир", 1830, author, 1000);
        book2 = new Book("Java c 0", 1999, author2, 10);
    }

    @Test
    void isBigTest() {
        boolean result = book.isBig();
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "Лев, true",
            "Толстой,true",
            "Тол, true",
            "Павел, false",
            "Иванов, false"
    })
    void matchesTest(String name, boolean expected) {
        assertThat(expected, equalTo(book.matches(name)));
    }

    @Test
    void estimatePriceTest() {
        int result = book.estimatePrice();
        assertThat(result, greaterThan(250));
        assertThat(result, equalTo(book.estimatePrice()));
        assertThat(book2.estimatePrice(), greaterThanOrEqualTo(250));
    }

    @Test
    void notNullClass() {
        assertThat(book, notNullValue());
    }

    @Test
    void nullClass() {
        assertThat(nullBook, nullValue());
    }


}