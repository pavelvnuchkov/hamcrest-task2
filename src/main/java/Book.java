public class Book {
    public String title;
    public int releaseYear;
    public Author author;
    public int pages;

    public Book(String title, int releaseYear, Author author, int pages) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.pages = pages;
    }

    public boolean isBig() {
        return pages > 500 ? true : false;
    }

    public boolean matches(String word) {
        boolean match = title.contains(word);
        if (!match) {
            match = author.name.contains(word);
            if (!match) {
                match = author.surname.contains(word);
            }
        }
        return match;
    }

    public int estimatePrice() {
        int price = (int) Math.floor(Math.sqrt(author.rating) * pages * 3);
        return price < 250 ? price = 250 : price;
    }
}
