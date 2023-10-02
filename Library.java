import java.time.LocalDateTime;
import java.util.Scanner;
class BookName
{
    private String book_name;
    BookName(String book)
    {
        book = book_name;
    }
    BookName()
    {
    
    }
}
class Author
{
    private String author_name;
    Author(String author)
    {
        author_name = author;
    }
    Author()
    {

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
    LibraryCatalog()
    {

    }
    String check_in_conformation()
    {
        if(check_in == true)
        return "You have successfully check in";
        else
        return "You havent checked in";
    }
    void know_your_check_out_date()
    {
        if(check_out == false && check_in == true)
        {
            System.out.println("Your check out date is :" +check_out_date);
        }
        else
        {
            System.out.println("First check in to know the check out date");
        }
    }
}
class LibraryRecords
{   
    BookName a = new BookName();
    Author b = new Author();
    LibraryCatalog c = new LibraryCatalog(false);
    String confirmation_of_check_in()
    {
        return c.check_in_conformation();
    }
    void book_details(String a,String b)
    {
        System.out.println("Book Name :" +a);
        System.out.println("Author Name :" +b);
        System.out.println("Check in date :" +c.check_in_date);
        System.out.println("Check out Date :" +c.check_out_date);
    }
}
public class Library {
    public static void main(String [] args)
    {
        LibraryRecords book1 = new LibraryRecords();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the book :");
        String name = sc.nextLine();
        System.out.println("Enter the name of the author");
        String author = sc.nextLine(); 
        System.out.println("Do you want to check in this book :");
        System.out.println("Type 'YES' for yes (or) 'NO' for no");
        String confirmation = sc.nextLine();
        if(confirmation.length() > 0 && confirmation.charAt(0) == 'Y')
        {
            String conformation_response = book1.confirmation_of_check_in();
            System.out.println(conformation_response);
        }
        else
        {
            System.out.println("Thank you for visiting our Library");
            System.exit(1);
        }
        System.out.println("Enter 1 for knowing the details of your book");
        System.out.println("Enter 0 if you wish to leave our digital library");
        int choice = sc.nextInt();
        sc.nextLine();
        if(choice == 1)
        {   
            System.out.println("Enter the name of the book :");
            String choice1 = sc.nextLine();
            if(choice1.equalsIgnoreCase(name))
            {
                book1.book_details(name,author);
            }
            else
            {
                System.out.println("You have entered the wrong book name :");
            }
        }
        else
        {
            System.exit(1);
        }
        sc.close();
        
    }

   
    
}
