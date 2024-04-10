import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

class BookName 
{
    private String book_name;

    BookName(String book) 
    {
        book_name = book;
    }

    public String getBookName() 
    {
        return book_name;
    }
}

class Author 
{
    private String author_name;

    Author(String author) 
    {
        author_name = author;
    }

    public String getAuthorName() 
    {
        return author_name;
    }
}

class LibraryCatalog 
{
    Boolean check_in = true;
    LocalDateTime check_in_date = LocalDateTime.now();
    LocalDateTime check_out_date = check_in_date.plusDays(4);
    Boolean check_out = false;

    LibraryCatalog(Boolean out) 
    {
        Boolean check_out = out;
    }

    String check_in_conformation() 
    {
        if (check_in == true)
            return "You have successfully checked in";
        else
            return "You haven't checked in";
    }

    void know_your_check_out_date() 
    {
        if (check_out == false && check_in == true) 
        {
            System.out.println("Your check out date is: " + check_out_date);
        } 
        else 
        {
            System.out.println("First check in to know the check out date");
        }
    }
}

class LibraryRecords {
    BookName a;
    Author b;
    LibraryCatalog c;

    LibraryRecords(String book, String author, Boolean checkedIn) 
    {
        a = new BookName(book);
        b = new Author(author);
        c = new LibraryCatalog(checkedIn);
    }

    String confirmation_of_check_in() 
    {
        return c.check_in_conformation();
    }

    void book_details() 
    {
        System.out.println("Book Name: " + a.getBookName());
        System.out.println("Author Name: " + b.getAuthorName());
        System.out.println("Check in date: " + c.check_in_date);
        System.out.println("Check out Date: " + c.check_out_date);
    }
}

public class Library 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<LibraryRecords> books = new ArrayList<>();

        while (true) 
        {
            System.out.println("Enter your choice:");
            System.out.println("1. Search a Book");
            System.out.println("2. Get Book Details");
            System.out.println("3. Exit the digital library");
            int ch = sc.nextInt();

            switch (ch) 
            {
                case 1:
                    sc.nextLine(); // Consume newline character after nextInt()
                    System.out.println("Enter the name of the book:");
                    String name = sc.nextLine();
                    System.out.println("Enter the name of the author:");
                    String author = sc.nextLine();
                    System.out.println("Do you want to check in this book?");
                    System.out.println("Type 'YES' for yes or 'NO' for no");
                    String confirmation = sc.nextLine();
                    if (confirmation.length() > 0 && confirmation.charAt(0) == 'Y') 
                    {
                        LibraryRecords newBook = new LibraryRecords(name, author, true);
                        books.add(newBook);
                        System.out.println(newBook.confirmation_of_check_in());
                    } 
                    else 
                    {
                        System.out.println("Thank you for visiting our Library");
                    }
                    break;
                case 2:
                    sc.nextLine();
                    System.out.println("Enter the name of the book:");
                    String bookName = sc.nextLine();
                    boolean found = false;
                    for (LibraryRecords book : books) 
                    {
                        if (book.a.getBookName().equalsIgnoreCase(bookName)) 
                        {
                            book.book_details();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Enter valid option");
            }
        }
    }
}
