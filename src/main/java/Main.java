public class Main {
    public static void main(String[] args) {

        Author author = new Author("Петя", "Иванов", 3);

        Book book = new Book("Один", 1985, author, 510);
        System.out.println(book.isBig());
        System.out.println(book.matches("Война"));
        System.out.println(book.estimatePrice());
    }
}
