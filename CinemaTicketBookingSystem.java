
import java.util.*;

class TicketBooking {
    String customerName;
    String movieName;
    double ticketPrice;
    int numberOfTickets;

    double totalAmount;
    double discount;
    double finalAmount;
    boolean bookingSuccessful;

    TicketBooking(String customerName, String movieName,double ticketPrice, int numberOfTickets) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    TicketBooking(String customerName, String movieName,double ticketPrice) {
        this(customerName, movieName, ticketPrice, 0);
    }

    void bookTickets() {
        calculateAmount();
    }

    void bookTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
        calculateAmount();
    }

    void bookTickets(String movieName, double ticketPrice,int numberOfTickets) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
        calculateAmount();
    }

    void calculateAmount() {
        bookingSuccessful =
            customerName != null &&
            !customerName.trim().isEmpty() &&
            movieName != null &&
            !movieName.trim().isEmpty() &&
            ticketPrice > 0 &&
            numberOfTickets > 0;

        totalAmount = 0;
        discount = 0;
        finalAmount = 0;

        if (bookingSuccessful) {
            totalAmount = ticketPrice * numberOfTickets;

            if (numberOfTickets >= 5) {
                discount = totalAmount * 0.10;
            }

            finalAmount = totalAmount - discount;
        }
    }

    void displaySummary() {
        displaySummary(true);
    }

    void displaySummary(boolean showTicketPrice) {
        System.out.printf("%-19s: %s%n",
                "Customer Name", customerName.toUpperCase(Locale.ROOT));

        System.out.printf("%-19s: %s%n",
                "Movie Name", movieName.toUpperCase(Locale.ROOT));

        if (showTicketPrice) {
            System.out.printf(Locale.US, "%-19s: Rs. %.2f%n",
                    "Ticket Price", ticketPrice);
        }

        System.out.printf("%-19s: %d%n",
                "Number of Tickets", numberOfTickets);

        System.out.println();

        System.out.printf("%-19s: %s%n",
                "Booking Status",
                bookingSuccessful ? "Booking Successful" : "Booking Failed");

        System.out.printf(Locale.US, "%-19s: Rs. %.2f%n",
                "Total Amount", totalAmount);

        System.out.printf(Locale.US, "%-19s: Rs. %.2f%n",
                "Discount", discount);

        System.out.printf(Locale.US, "%-19s: Rs. %.2f%n",
                "Final Amount", finalAmount);
    }

    boolean verifyCustomer(String expectedName) {
        return customerName != null &&
               expectedName != null &&
               customerName.trim().equalsIgnoreCase(
                   expectedName.trim());
    }
}

public class CinemaTicketBookingSystem {
    public static void main(String[] args) {
        System.out.println(
            "========== CINEMA TICKET BOOKING ==========");

        TicketBooking booking1 =
            new TicketBooking("Sneha", "Avatar", 200.00, 5);

        booking1.bookTickets();
        System.out.println();
        booking1.displaySummary();

        System.out.println();

        TicketBooking booking2 =
            new TicketBooking("Arjun", "Avatar", 200.00);

        booking2.bookTickets(2);
        booking2.displaySummary(false);

        System.out.println("Customer Verification:");

        if (booking1.verifyCustomer("sNeHa")) {
            System.out.println("Names Match");
        } else {
            System.out.println("Names Do Not Match");
        }

        System.out.println(
            "=============================================");
    }
}
