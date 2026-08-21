import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


// =====================================================
// COLORS UTILITY CLASS (ANSI ESCAPE CODES)
// =====================================================

class Colors {

    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";

    // Standard colors
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Bright / High intensity colors
    public static final String BRIGHT_RED = "\u001B[91m";
    public static final String BRIGHT_GREEN = "\u001B[92m";
    public static final String BRIGHT_YELLOW = "\u001B[93m";
    public static final String BRIGHT_BLUE = "\u001B[94m";
    public static final String BRIGHT_PURPLE = "\u001B[95m";
    public static final String BRIGHT_CYAN = "\u001B[96m";
    public static final String BRIGHT_WHITE = "\u001B[97m";
}


// =====================================================
// PATIENT CLASS
// =====================================================

class Patient {

    int patientId;
    String name;
    int age;
    String gender;
    String phone;
    String address;
    String username;
    String password;

    Patient(int patientId, String name, int age,
            String gender, String phone,
            String address, String username,
            String password) {

        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
    }

    void displayProfile() {

        System.out.println("\n" + Colors.CYAN + Colors.BOLD + "========================================");
        System.out.println("             MY PROFILE");
        System.out.println("========================================" + Colors.RESET);

        System.out.println(Colors.BOLD + "Patient ID : " + Colors.RESET + Colors.BRIGHT_CYAN + patientId + Colors.RESET);
        System.out.println(Colors.BOLD + "Name       : " + Colors.RESET + Colors.BRIGHT_WHITE + name + Colors.RESET);
        System.out.println(Colors.BOLD + "Age        : " + Colors.RESET + age);
        System.out.println(Colors.BOLD + "Gender     : " + Colors.RESET + gender);
        System.out.println(Colors.BOLD + "Phone      : " + Colors.RESET + phone);
        System.out.println(Colors.BOLD + "Address    : " + Colors.RESET + address);
        System.out.println(Colors.BOLD + "Username   : " + Colors.RESET + Colors.YELLOW + username + Colors.RESET);

        System.out.println(Colors.CYAN + Colors.BOLD + "========================================" + Colors.RESET);
    }
}


// =====================================================
// DOCTOR CLASS
// =====================================================

class Doctor {

    int doctorId;
    String name;
    String specialization;

    LocalTime availableFrom;
    LocalTime availableTo;

    double consultationFee;

    Doctor(int doctorId,
           String name,
           String specialization,
           String from,
           String to,
           double consultationFee) {

        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("HH:mm", Locale.ENGLISH);

        availableFrom =
                LocalTime.parse(from, format);

        availableTo =
                LocalTime.parse(to, format);

        this.consultationFee = consultationFee;
    }

    void displayDoctor() {

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH);

        System.out.println(Colors.BLUE + "----------------------------------------" + Colors.RESET);

        System.out.println(Colors.BOLD + "Doctor ID      : " + Colors.RESET + Colors.BRIGHT_CYAN + doctorId + Colors.RESET);
        System.out.println(Colors.BOLD + "Doctor Name    : " + Colors.RESET + Colors.BRIGHT_GREEN + Colors.BOLD + name + Colors.RESET);
        System.out.println(Colors.BOLD + "Specialization : " + Colors.RESET + Colors.YELLOW + specialization + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Availability   : " + Colors.RESET
                + availableFrom.format(format)
                + " - "
                + availableTo.format(format));

        System.out.println(
                Colors.BOLD + "Consultation   : " + Colors.RESET + Colors.BRIGHT_GREEN
                + "Rs." + consultationFee + Colors.RESET);

        System.out.println(Colors.BLUE + "----------------------------------------" + Colors.RESET);
    }
}


// =====================================================
// APPOINTMENT CLASS
// =====================================================

class Appointment {

    int appointmentId;
    int patientId;
    int doctorId;

    String doctorName;
    String date;
    String time;
    String status;

    Appointment(int appointmentId,
                int patientId,
                int doctorId,
                String doctorName,
                String date,
                String time) {

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;

        status = "Booked";
    }

    void displayAppointment() {

        System.out.println(Colors.BLUE + "----------------------------------------" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Appointment ID : " + Colors.RESET + Colors.BRIGHT_CYAN + appointmentId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Doctor         : " + Colors.RESET + Colors.GREEN + doctorName + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Date           : " + Colors.RESET + date);

        System.out.println(
                Colors.BOLD + "Time           : " + Colors.RESET + time);

        String statusColor = status.equals("Booked") ? (Colors.GREEN + Colors.BOLD) : (status.equals("Cancelled") ? (Colors.RED + Colors.BOLD) : Colors.YELLOW);

        System.out.println(
                Colors.BOLD + "Status         : " + Colors.RESET + statusColor + status + Colors.RESET);

        System.out.println(Colors.BLUE + "----------------------------------------" + Colors.RESET);
    }
}


// =====================================================
// MEDICINE CLASS
// =====================================================

class Medicine {

    int medicineId;
    String name;
    String category;
    double price;
    int stock;

    Medicine(int medicineId,
             String name,
             String category,
             double price,
             int stock) {

        this.medicineId = medicineId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    void displayMedicine() {

        System.out.println(Colors.BLUE + "----------------------------------------" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Medicine ID : " + Colors.RESET + Colors.BRIGHT_CYAN + medicineId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Name        : " + Colors.RESET + Colors.BRIGHT_WHITE + Colors.BOLD + name + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Category    : " + Colors.RESET + Colors.PURPLE + category + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Price       : " + Colors.RESET + Colors.GREEN + "Rs." + price + Colors.RESET);

        String stockColor = stock > 10 ? Colors.GREEN : (stock > 0 ? Colors.YELLOW : Colors.RED);

        System.out.println(
                Colors.BOLD + "Stock       : " + Colors.RESET + stockColor + stock + (stock == 0 ? " (Out of stock)" : " units") + Colors.RESET);

        System.out.println(Colors.BLUE + "----------------------------------------" + Colors.RESET);
    }
}


// =====================================================
// PHARMACY ORDER CLASS
// =====================================================

class PharmacyOrder {

    int orderId;
    int patientId;

    String medicineName;

    int quantity;

    double price;
    double total;

    String status;

    PharmacyOrder(int orderId,
                  int patientId,
                  String medicineName,
                  int quantity,
                  double price) {

        this.orderId = orderId;
        this.patientId = patientId;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.price = price;

        total = price * quantity;

        status = "Ordered";
    }

    void displayOrder() {

        System.out.println(Colors.BLUE + "----------------------------------------" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Order ID : " + Colors.RESET + Colors.BRIGHT_CYAN + orderId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Medicine : " + Colors.RESET + Colors.BOLD + medicineName + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Quantity : " + Colors.RESET + quantity);

        System.out.println(
                Colors.BOLD + "Price    : " + Colors.RESET + "Rs." + price);

        System.out.println(
                Colors.BOLD + "Total    : " + Colors.RESET + Colors.GREEN + Colors.BOLD + "Rs." + total + Colors.RESET);

        String statusColor = status.equals("Paid") ? (Colors.GREEN + Colors.BOLD) : (Colors.YELLOW + Colors.BOLD);

        System.out.println(
                Colors.BOLD + "Status   : " + Colors.RESET + statusColor + status + Colors.RESET);

        System.out.println(Colors.BLUE + "----------------------------------------" + Colors.RESET);
    }
}


// =====================================================
// BILL CLASS
// =====================================================

class Bill {

    int billId;
    int patientId;
    int referenceId;

    String billType;
    String description;

    double amount;

    String paymentStatus;
    String paymentMethod;

    LocalDateTime paymentDateTime;

    Bill(int billId,
         int patientId,
         int referenceId,
         String billType,
         String description,
         double amount) {

        this.billId = billId;
        this.patientId = patientId;
        this.referenceId = referenceId;

        this.billType = billType;
        this.description = description;

        this.amount = amount;

        paymentStatus = "Pending";
        paymentMethod = "Not Paid";

        paymentDateTime = null;
    }

    void displayBill() {

        System.out.println("\n" + Colors.CYAN + Colors.BOLD + "========================================");

        System.out.println(
                "                BILL");

        System.out.println(
                "========================================" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Bill ID        : " + Colors.RESET + Colors.BRIGHT_CYAN + billId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Bill Type      : " + Colors.RESET + Colors.PURPLE + billType + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Reference ID   : " + Colors.RESET + referenceId);

        System.out.println(
                Colors.BOLD + "Description    : " + Colors.RESET + description);

        System.out.println(
                Colors.BOLD + "Amount         : " + Colors.RESET + Colors.BRIGHT_GREEN + Colors.BOLD + "Rs." + amount + Colors.RESET);

        String statusColor = paymentStatus.equals("Paid") ? (Colors.GREEN + Colors.BOLD) : (paymentStatus.equals("Pending") ? (Colors.YELLOW + Colors.BOLD) : (paymentStatus.equals("Refunded") ? (Colors.PURPLE + Colors.BOLD) : (Colors.RED + Colors.BOLD)));

        System.out.println(
                Colors.BOLD + "Payment Status : " + Colors.RESET + statusColor + paymentStatus + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Payment Method : " + Colors.RESET + paymentMethod);

        if (paymentDateTime != null) {

            DateTimeFormatter format =
                    DateTimeFormatter.ofPattern(
                            "dd-MM-yyyy hh:mm a", Locale.ENGLISH);

            System.out.println(
                    Colors.BOLD + "Paid On        : " + Colors.RESET
                    + Colors.GREEN + paymentDateTime.format(format) + Colors.RESET);

        } else {

            System.out.println(
                    Colors.BOLD + "Paid On        : " + Colors.RESET + Colors.YELLOW + "Not Paid" + Colors.RESET);
        }

        System.out.println(Colors.CYAN + Colors.BOLD + "========================================" + Colors.RESET);
    }
}


// =====================================================
// BLOOD BANK CLASS
// =====================================================

class BloodBank {

    String bloodGroup;
    int units;

    BloodBank(String bloodGroup, int units) {

        this.bloodGroup = bloodGroup;
        this.units = units;
    }

    void displayBlood() {

        String unitColor = units > 5 ? Colors.GREEN : (units > 0 ? Colors.YELLOW : Colors.RED);

        System.out.println(
                Colors.BOLD + Colors.RED + bloodGroup + Colors.RESET
                + " : "
                + unitColor + Colors.BOLD + units + " units" + Colors.RESET);
    }
}


// =====================================================
// BLOOD REQUEST CLASS
// =====================================================

class BloodRequest {

    int requestId;
    int patientId;
    String patientName;
    String bloodGroup;
    int units;
    double pricePerUnit;
    double totalAmount;
    LocalDateTime requestDateTime;
    String status;

    BloodRequest(int requestId,
                 int patientId,
                 String patientName,
                 String bloodGroup,
                 int units,
                 double pricePerUnit) {

        this.requestId = requestId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.bloodGroup = bloodGroup;
        this.units = units;
        this.pricePerUnit = pricePerUnit;
        this.totalAmount = pricePerUnit * units;
        this.requestDateTime = LocalDateTime.now();
        this.status = "Pending Payment";
    }

    void displayRequest() {

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm a", Locale.ENGLISH);

        System.out.println(Colors.BLUE + "----------------------------------------" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Request ID    : " + Colors.RESET + Colors.BRIGHT_CYAN + requestId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Blood Group   : " + Colors.RESET + Colors.RED + Colors.BOLD + bloodGroup + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Units         : " + Colors.RESET + Colors.GREEN + Colors.BOLD + units + " units" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Price / Unit  : " + Colors.RESET + "Rs." + pricePerUnit);

        System.out.println(
                Colors.BOLD + "Total Amount  : " + Colors.RESET + Colors.BRIGHT_GREEN + Colors.BOLD + "Rs." + totalAmount + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Requested On  : " + Colors.RESET + requestDateTime.format(format));

        String statusColor = status.equals("Paid") ? (Colors.GREEN + Colors.BOLD)
                : (status.equals("Cancelled") ? (Colors.RED + Colors.BOLD) : (Colors.YELLOW + Colors.BOLD));

        System.out.println(
                Colors.BOLD + "Status        : " + Colors.RESET + statusColor + status + Colors.RESET);

        System.out.println(Colors.BLUE + "----------------------------------------" + Colors.RESET);
    }
}


// =====================================================
// OTP CLASS
// =====================================================

class OTP {

    int otpCode;

    OTP() {

        // Generate 4-digit random OTP between 1000 and 9999
        this.otpCode =
                (int) (Math.random() * 9000) + 1000;
    }

    int getCode() {

        return otpCode;
    }

    boolean verify(
            int enteredCode) {

        return this.otpCode == enteredCode;
    }
}


// =====================================================
// MAIN CLASS
// =====================================================

public class HospitalManagementSystem {

    static Scanner sc =
            new Scanner(System.in);


    // =================================================
    // CONSTANTS
    // =================================================

    static final int APPOINTMENT_DURATION_MINUTES = 30;

    static final double BLOOD_UNIT_PRICE = 500.0;


    // =================================================
    // ARRAYLISTS
    // =================================================

    static ArrayList<Patient> patients =
            new ArrayList<Patient>();

    static ArrayList<Doctor> doctors =
            new ArrayList<Doctor>();

    static ArrayList<Appointment> appointments =
            new ArrayList<Appointment>();

    static ArrayList<Medicine> medicines =
            new ArrayList<Medicine>();

    static ArrayList<PharmacyOrder> pharmacyOrders =
            new ArrayList<PharmacyOrder>();

    static ArrayList<Bill> bills =
            new ArrayList<Bill>();

    static ArrayList<BloodBank> bloodBank =
            new ArrayList<BloodBank>();

    static ArrayList<BloodRequest> bloodRequests =
            new ArrayList<BloodRequest>();


    // =================================================
    // LOGGED IN PATIENT
    // =================================================

    static Patient loggedInPatient = null;


    // =================================================
    // ID COUNTERS
    // =================================================

    static int patientCounter = 1001;

    static int appointmentCounter = 1001;

    static int billCounter = 5001;

    static int orderCounter = 7001;

    static int bloodRequestCounter = 8001;


    // =================================================
    // MAIN
    // =================================================

    public static void main(String[] args) {

        loadData();

        welcomeScreen();

        sc.close();
    }


    // =================================================
    // WELCOME SCREEN
    // =================================================

    static void welcomeScreen() {

        int choice;

        do {

            System.out.println("\n");
            System.out.println(
                    Colors.CYAN + Colors.BOLD + "========================================");
            System.out.println(
                    "       WELCOME TO SPK HOSPITALS");
            System.out.println(
                    "========================================" + Colors.RESET);

            System.out.println();
            System.out.println(Colors.BOLD + "1. " + Colors.RESET + "Login");
            System.out.println(Colors.BOLD + "2. " + Colors.RESET + "Register");
            System.out.println(Colors.BOLD + "3. " + Colors.RESET + "Exit");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "========================================" + Colors.RESET);

            choice =
                    readInt(Colors.YELLOW + "Enter your choice: " + Colors.RESET);


            switch (choice) {

                case 1:

                    login();

                    break;


                case 2:

                    register();

                    break;


                case 3:

                    System.out.println(
                            "\n" + Colors.GREEN + Colors.BOLD + "Thank you for visiting SPK Hospitals! Stay Healthy." + Colors.RESET);

                    break;


                default:

                    System.out.println(
                            Colors.RED + "Invalid choice. Please choose 1, 2, or 3." + Colors.RESET);
            }

        } while (choice != 3);
    }


    // =================================================
    // REGISTER
    // =================================================

    static void register() {

        System.out.println("\n");

        System.out.println(
                Colors.CYAN + Colors.BOLD + "========================================");
        System.out.println(
                "          SPK HOSPITALS REGISTER");
        System.out.println(
                "========================================" + Colors.RESET);


        // -----------------------------
        // NAME
        // -----------------------------

        String name;

        while (true) {

            System.out.print(
                    Colors.BOLD + "Enter Name: " + Colors.RESET);

            name =
                    sc.nextLine().trim();

            if (validName(name)) {

                break;

            } else {

                System.out.println(
                        Colors.RED + "Name should contain only letters and spaces (minimum 2 characters)." + Colors.RESET);
            }
        }


        // -----------------------------
        // AGE
        // -----------------------------

        int age;

        while (true) {

            age =
                    readInt(Colors.BOLD + "Enter Age: " + Colors.RESET);

            if (age >= 1 && age <= 120) {

                break;

            } else {

                System.out.println(
                        Colors.RED + "Age must be between 1 and 120." + Colors.RESET);
            }
        }


        // -----------------------------
        // GENDER
        // -----------------------------

        String gender;

        while (true) {

            System.out.print(
                    Colors.BOLD + "Enter Gender (Male/Female/Other or M/F/O): " + Colors.RESET);

            gender =
                    sc.nextLine().trim();

            if (validGender(gender)) {

                gender =
                        normalizeGender(gender);

                break;

            } else {

                System.out.println(
                        Colors.RED + "Invalid gender. Please enter Male, Female, or Other." + Colors.RESET);
            }
        }


        // -----------------------------
        // MOBILE
        // -----------------------------

        String phone;

        while (true) {

            System.out.print(
                    Colors.BOLD + "Enter Mobile Number: " + Colors.RESET);

            phone =
                    sc.nextLine().trim();

            if (validPhone(phone)) {

                break;

            } else {

                System.out.println(
                        Colors.RED + "Mobile must contain 10 digits and start with 6, 7, 8 or 9." + Colors.RESET);
            }
        }


        // -----------------------------
        // ADDRESS
        // -----------------------------

        String address;

        while (true) {

            System.out.print(
                    Colors.BOLD + "Enter Address: " + Colors.RESET);

            address =
                    sc.nextLine().trim();

            if (address.length() > 0) {

                break;

            } else {

                System.out.println(
                        Colors.RED + "Address cannot be empty." + Colors.RESET);
            }
        }


        // -----------------------------
        // USERNAME
        // -----------------------------

        String username;

        while (true) {

            System.out.print(
                    Colors.BOLD + "Create Username (3-20 characters, letters & numbers): " + Colors.RESET);

            username =
                    sc.nextLine().trim();


            if (!validUsername(username)) {

                System.out.println(
                        Colors.RED + "Username must be 3-20 characters long and contain only letters and numbers." + Colors.RESET);

                continue;
            }


            boolean exists = false;


            for (Patient p : patients) {

                if (p.username.equalsIgnoreCase(username)) {

                    exists = true;

                    break;
                }
            }


            if (exists) {

                System.out.println(
                        Colors.RED + "Username already exists. Please choose a different username." + Colors.RESET);

            } else {

                break;
            }
        }


        // -----------------------------
        // PASSWORD
        // -----------------------------

        String password;

        while (true) {

            System.out.print(
                    Colors.BOLD + "Create Password (minimum 7 characters): " + Colors.RESET);

            password =
                    sc.nextLine();


            if (validPassword(password)) {

                break;

            } else {

                System.out.println(
                        "\n" + Colors.RED + Colors.BOLD + "Invalid password!" + Colors.RESET);

                System.out.println(
                        Colors.YELLOW + "Password requirements:" + Colors.RESET);

                System.out.println(
                        "1. Minimum 7 characters (no spaces)");

                System.out.println(
                        "2. At least one letter");

                System.out.println(
                        "3. At least one number");

                System.out.println(
                        "4. At least one special character (!@#$%^&*()-_=+[]{}|;:'\",.<>/?)");
            }
        }


        // -----------------------------
        // CREATE PATIENT
        // -----------------------------

        Patient p =
                new Patient(
                        patientCounter++,
                        name,
                        age,
                        gender,
                        phone,
                        address,
                        username,
                        password);


        patients.add(p);


        System.out.println("\n");

        System.out.println(
                Colors.GREEN + Colors.BOLD + "========================================");

        System.out.println(
                "       REGISTRATION SUCCESSFUL!");

        System.out.println(
                "========================================" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Patient ID : " + Colors.RESET + Colors.BRIGHT_CYAN + p.patientId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Username   : " + Colors.RESET + Colors.YELLOW + p.username + Colors.RESET);

        pause();
    }


    // =================================================
    // LOGIN
    // =================================================

    static void login() {

        System.out.println("\n");

        System.out.println(
                Colors.CYAN + Colors.BOLD + "========================================");

        System.out.println(
                "          SPK HOSPITALS LOGIN");

        System.out.println(
                "========================================" + Colors.RESET);


        System.out.print(
                Colors.BOLD + "Username: " + Colors.RESET);

        String username =
                sc.nextLine().trim();


        Patient found = null;

        for (Patient p : patients) {

            if (p.username.equalsIgnoreCase(username)) {

                found = p;

                break;
            }
        }


        if (found == null) {

            System.out.println(
                    "\n" + Colors.RED + Colors.BOLD + "Username not found! Please check your username or register first." + Colors.RESET);

            pause();

            return;
        }


        System.out.print(
                Colors.BOLD + "Password: " + Colors.RESET);

        String password =
                sc.nextLine();


        if (!found.password.equals(password)) {

            System.out.println(
                    "\n" + Colors.RED + Colors.BOLD + "Incorrect password! Please try again." + Colors.RESET);

            pause();

            return;
        }


        loggedInPatient =
                found;


        System.out.println(
                "\n" + Colors.GREEN + Colors.BOLD + "Login successful!" + Colors.RESET);


        System.out.println(
                Colors.BOLD + "Welcome, " + Colors.BRIGHT_GREEN + loggedInPatient.name + Colors.RESET + "!");


        patientMenu();
    }


    // =================================================
    // PATIENT MENU
    // =================================================

    static void patientMenu() {

        int choice;


        do {

            System.out.println("\n");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "========================================");

            System.out.println(
                    "             SPK HOSPITALS");

            System.out.println(
                    "========================================" + Colors.RESET);

            System.out.println(
                    Colors.BOLD + "Welcome, " + Colors.BRIGHT_GREEN + loggedInPatient.name + Colors.RESET);

            System.out.println(
                    Colors.CYAN + "----------------------------------------" + Colors.RESET);

            System.out.println(
                    Colors.BOLD + "1. " + Colors.RESET + "My Profile");

            System.out.println(
                    Colors.BOLD + "2. " + Colors.RESET + "Doctors & Appointments");

            System.out.println(
                    Colors.BOLD + "3. " + Colors.RESET + "My Appointments");

            System.out.println(
                    Colors.BOLD + "4. " + Colors.RESET + "Online Pharmacy");

            System.out.println(
                    Colors.BOLD + "5. " + Colors.RESET + "Payments & Billing");

            System.out.println(
                    Colors.BOLD + "6. " + Colors.RESET + "Blood Bank");

            System.out.println(
                    Colors.BOLD + "7. " + Colors.RESET + "Logout");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "========================================" + Colors.RESET);


            choice =
                    readInt(
                            Colors.YELLOW + "Enter your choice: " + Colors.RESET);


            switch (choice) {

                case 1:

                    myProfile();

                    break;


                case 2:

                    doctorsAndAppointments();

                    break;


                case 3:

                    myAppointments();

                    break;


                case 4:

                    onlinePharmacy();

                    break;


                case 5:

                    paymentsAndBilling();

                    break;


                case 6:

                    bloodBankMenu();

                    break;


                case 7:

                    loggedInPatient =
                            null;

                    System.out.println(
                            "\n" + Colors.GREEN + Colors.BOLD + "Logged out successfully." + Colors.RESET);

                    break;


                default:

                    System.out.println(
                            Colors.RED + "Invalid choice." + Colors.RESET);
            }

        } while (choice != 7);
    }


    // =================================================
    // MY PROFILE
    // =================================================

    static void myProfile() {

        int choice;


        do {

            loggedInPatient.displayProfile();


            System.out.println(
                    Colors.BOLD + "1. " + Colors.RESET + "Edit Profile");

            System.out.println(
                    Colors.BOLD + "2. " + Colors.RESET + "Back");


            choice =
                    readInt(
                            Colors.YELLOW + "Enter choice: " + Colors.RESET);


            switch (choice) {

                case 1:

                    editProfile();

                    break;


                case 2:

                    break;


                default:

                    System.out.println(
                            Colors.RED + "Invalid choice." + Colors.RESET);
            }

        } while (choice != 2);
    }


    // =================================================
    // EDIT PROFILE
    // =================================================

    static void editProfile() {

        int choice;


        do {

            System.out.println("\n");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "========== EDIT PROFILE ==========" + Colors.RESET);

            System.out.println(
                    Colors.BOLD + "1. " + Colors.RESET + "Edit Name");

            System.out.println(
                    Colors.BOLD + "2. " + Colors.RESET + "Edit Age");

            System.out.println(
                    Colors.BOLD + "3. " + Colors.RESET + "Edit Gender");

            System.out.println(
                    Colors.BOLD + "4. " + Colors.RESET + "Edit Mobile Number");

            System.out.println(
                    Colors.BOLD + "5. " + Colors.RESET + "Edit Address");

            System.out.println(
                    Colors.BOLD + "6. " + Colors.RESET + "Change Password");

            System.out.println(
                    Colors.BOLD + "7. " + Colors.RESET + "Back");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "===================================" + Colors.RESET);


            choice =
                    readInt(
                            Colors.YELLOW + "Enter choice: " + Colors.RESET);


            switch (choice) {

                case 1:

                    editName();

                    break;


                case 2:

                    editAge();

                    break;


                case 3:

                    editGender();

                    break;


                case 4:

                    editPhone();

                    break;


                case 5:

                    editAddress();

                    break;


                case 6:

                    editPassword();

                    break;


                case 7:

                    break;


                default:

                    System.out.println(
                            Colors.RED + "Invalid choice." + Colors.RESET);
            }

        } while (choice != 7);
    }


    // =================================================
    // EDIT NAME
    // =================================================

    static void editName() {

        while (true) {

            System.out.print(
                    Colors.BOLD + "Enter New Name: " + Colors.RESET);

            String name =
                    sc.nextLine().trim();


            if (validName(name)) {

                loggedInPatient.name =
                        name;

                System.out.println(
                        "\n" + Colors.GREEN + Colors.BOLD + "Name updated successfully." + Colors.RESET);

                break;

            } else {

                System.out.println(
                        Colors.RED + "Name should contain only letters and spaces (minimum 2 characters)." + Colors.RESET);
            }
        }
    }


    // =================================================
    // EDIT AGE
    // =================================================

    static void editAge() {

        while (true) {

            int age =
                    readInt(
                            Colors.BOLD + "Enter New Age: " + Colors.RESET);


            if (age >= 1 && age <= 120) {

                loggedInPatient.age =
                        age;

                System.out.println(
                        "\n" + Colors.GREEN + Colors.BOLD + "Age updated successfully." + Colors.RESET);

                break;

            } else {

                System.out.println(
                        Colors.RED + "Age must be between 1 and 120." + Colors.RESET);
            }
        }
    }


    // =================================================
    // EDIT GENDER
    // =================================================

    static void editGender() {

        while (true) {

            System.out.print(
                    Colors.BOLD + "Enter New Gender (Male/Female/Other or M/F/O): " + Colors.RESET);

            String gender =
                    sc.nextLine().trim();


            if (validGender(gender)) {

                loggedInPatient.gender =
                        normalizeGender(gender);

                System.out.println(
                        "\n" + Colors.GREEN + Colors.BOLD + "Gender updated successfully." + Colors.RESET);

                break;

            } else {

                System.out.println(
                        Colors.RED + "Invalid gender. Please enter Male, Female, or Other." + Colors.RESET);
            }
        }
    }


    // =================================================
    // EDIT PHONE
    // =================================================

    static void editPhone() {

        while (true) {

            System.out.print(
                    Colors.BOLD + "Enter New Mobile Number: " + Colors.RESET);

            String phone =
                    sc.nextLine().trim();


            if (validPhone(phone)) {

                loggedInPatient.phone =
                        phone;

                System.out.println(
                        "\n" + Colors.GREEN + Colors.BOLD + "Mobile number updated successfully." + Colors.RESET);

                break;

            } else {

                System.out.println(
                        Colors.RED + "Mobile must contain 10 digits and start with 6, 7, 8 or 9." + Colors.RESET);
            }
        }
    }


    // =================================================
    // EDIT ADDRESS
    // =================================================

    static void editAddress() {

        while (true) {

            System.out.print(
                    Colors.BOLD + "Enter New Address: " + Colors.RESET);

            String address =
                    sc.nextLine().trim();


            if (address.length() > 0) {

                loggedInPatient.address =
                        address;

                System.out.println(
                        "\n" + Colors.GREEN + Colors.BOLD + "Address updated successfully." + Colors.RESET);

                break;

            } else {

                System.out.println(
                        Colors.RED + "Address cannot be empty." + Colors.RESET);
            }
        }
    }


    // =================================================
    // EDIT PASSWORD
    // =================================================

static void editPassword() {

    System.out.println("\n");
    System.out.println(Colors.CYAN + Colors.BOLD + "========== CHANGE PASSWORD ==========" + Colors.RESET);

    // Ask for old password first
    System.out.print(Colors.BOLD + "Enter Old Password: " + Colors.RESET);
    String oldPassword = sc.nextLine();

    // Check old password
    if (!oldPassword.equals(loggedInPatient.password)) {

        System.out.println("\n" + Colors.RED + Colors.BOLD + "Incorrect old password!" + Colors.RESET);
        System.out.println(Colors.RED + "Password was not changed." + Colors.RESET);

        pause();
        return;
    }

    System.out.println(Colors.GREEN + "Old password verified successfully." + Colors.RESET);

    // Create new password
    while (true) {

        System.out.print(
                Colors.BOLD + "Enter New Password: " + Colors.RESET);

        String newPassword =
                sc.nextLine();

        // Don't allow same password
        if (newPassword.equals(
                loggedInPatient.password)) {

            System.out.println(
                    Colors.RED + "New password cannot be the same as old password." + Colors.RESET);

            continue;
        }

        // Validate new password
        if (validPassword(newPassword)) {

            loggedInPatient.password =
                    newPassword;

            System.out.println(
                    "\n" + Colors.GREEN + Colors.BOLD + "Password changed successfully!" + Colors.RESET);

            break;

        } else {

            System.out.println(
                    "\n" + Colors.RED + Colors.BOLD + "Invalid new password!" + Colors.RESET);

            System.out.println(
                    Colors.YELLOW + "Password requirements:" + Colors.RESET);

            System.out.println(
                    "1. Minimum 7 characters (no spaces)");

            System.out.println(
                    "2. At least one letter");

            System.out.println(
                    "3. At least one number");

            System.out.println(
                    "4. At least one special character (!@#$%^&*()-_=+[]{}|;:'\",.<>/?)");
        }
    }

    pause();
}

    // =================================================
    // DOCTORS & APPOINTMENTS
    // =================================================

    static void doctorsAndAppointments() {

        int choice;


        do {

            System.out.println("\n");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "========== DOCTORS & APPOINTMENTS ==========" + Colors.RESET);

            System.out.println(
                    Colors.BOLD + "1. " + Colors.RESET + "View Doctors");

            System.out.println(
                    Colors.BOLD + "2. " + Colors.RESET + "Book Appointment");

            System.out.println(
                    Colors.BOLD + "3. " + Colors.RESET + "Back");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "=============================================" + Colors.RESET);


            choice =
                    readInt(
                            Colors.YELLOW + "Enter choice: " + Colors.RESET);


            switch (choice) {

                case 1:

                    viewDoctors();

                    break;


                case 2:

                    bookAppointment();

                    break;


                case 3:

                    break;


                default:

                    System.out.println(
                            Colors.RED + "Invalid choice." + Colors.RESET);
            }

        } while (choice != 3);
    }


    // =================================================
    // VIEW DOCTORS
    // =================================================

    static void viewDoctors() {

        System.out.println(
                "\n" + Colors.CYAN + Colors.BOLD + "========== AVAILABLE DOCTORS ==========" + Colors.RESET);


        for (Doctor d :
                doctors) {

            d.displayDoctor();
        }


        pause();
    }


    // =================================================
    // BOOK APPOINTMENT
    // =================================================

    static void bookAppointment() {

        viewDoctors();


        int doctorId =
                readInt(
                        Colors.BOLD + "Enter Doctor ID: " + Colors.RESET);


        Doctor selectedDoctor =
                null;


        for (Doctor d :
                doctors) {

            if (d.doctorId ==
                    doctorId) {

                selectedDoctor =
                        d;

                break;
            }
        }


        if (selectedDoctor == null) {

            System.out.println(
                    "\n" + Colors.RED + Colors.BOLD + "Doctor not found." + Colors.RESET);

            pause();

            return;
        }


        // -----------------------------
        // DATE
        // -----------------------------

        String date;

        LocalDate appointmentDate;


        while (true) {

            System.out.print(
                    Colors.BOLD + "Enter Date (DD-MM-YYYY): " + Colors.RESET);

            date =
                    sc.nextLine().trim();


            try {

                DateTimeFormatter format =
                        DateTimeFormatter.ofPattern(
                                "dd-MM-yyyy", Locale.ENGLISH);


                appointmentDate =
                        LocalDate.parse(
                                date,
                                format);


                if (appointmentDate.isBefore(
                        LocalDate.now())) {

                    System.out.println(
                            Colors.RED + "Date cannot be in the past." + Colors.RESET);

                } else {

                    date =
                            appointmentDate.format(format);

                    break;
                }


            } catch (
                    DateTimeParseException e) {

                System.out.println(
                        Colors.RED + "Invalid date. Please use format DD-MM-YYYY (e.g. 25-08-2026)." + Colors.RESET);
            }
        }


        // -----------------------------
        // TIME
        // -----------------------------

        String time;

        LocalTime appointmentTime;
        LocalTime slotEndTime;


        while (true) {

            System.out.print(
                    Colors.BOLD + "Enter Time (04:00 PM / 16:00): " + Colors.RESET);


            time =
                    sc.nextLine().trim();


            appointmentTime =
                    parseTime(time);


            if (appointmentTime == null) {

                System.out.println(
                        Colors.RED + "Invalid time format! Examples: 04:00 PM, 4:00 PM, 16:00" + Colors.RESET);

                continue;
            }


            LocalDateTime appointmentDateTime =
                    LocalDateTime.of(
                            appointmentDate,
                            appointmentTime);


            if (appointmentDateTime.isBefore(
                    LocalDateTime.now())) {

                System.out.println(
                        Colors.RED + "Appointment date and time cannot be in the past." + Colors.RESET);

                continue;
            }


            slotEndTime =
                    appointmentTime.plusMinutes(APPOINTMENT_DURATION_MINUTES);


            if (appointmentTime.isBefore(
                    selectedDoctor.availableFrom)
                    ||
                    slotEndTime.isAfter(
                            selectedDoctor.availableTo)) {


                DateTimeFormatter format =
                        DateTimeFormatter.ofPattern(
                                "hh:mm a", Locale.ENGLISH);

                LocalTime latestSlot =
                        selectedDoctor.availableTo.minusMinutes(APPOINTMENT_DURATION_MINUTES);


                System.out.println(
                        Colors.RED + "Doctor is available only between "
                        + selectedDoctor.availableFrom
                                .format(format)
                        + " and "
                        + selectedDoctor.availableTo
                                .format(format) + "." + Colors.RESET);

                System.out.println(
                        Colors.YELLOW + "Each consultation takes " + APPOINTMENT_DURATION_MINUTES + " minutes. "
                        + "The latest slot you can book is " + latestSlot.format(format) + "." + Colors.RESET);

                continue;
            }


            DateTimeFormatter saveFormat =
                    DateTimeFormatter.ofPattern(
                            "hh:mm a", Locale.ENGLISH);


            time =
                    appointmentTime.format(
                            saveFormat);


            break;
        }


        // -----------------------------
        // DOUBLE BOOKING & OVERLAP CHECK
        // -----------------------------

        boolean alreadyBooked =
                false;


        for (Appointment a :
                appointments) {

            if (a.status.equals("Booked")
                    &&
                    a.date.equals(date)) {


                LocalTime existingStart =
                        parseTime(a.time);


                if (existingStart != null) {

                    LocalTime existingEnd =
                            existingStart.plusMinutes(APPOINTMENT_DURATION_MINUTES);

                    boolean overlaps =
                            appointmentTime.isBefore(existingEnd)
                            && existingStart.isBefore(slotEndTime);


                    if (overlaps) {

                        DateTimeFormatter timeFmt =
                                DateTimeFormatter.ofPattern(
                                        "hh:mm a", Locale.ENGLISH);


                        // Same doctor
                        if (a.doctorId ==
                                selectedDoctor.doctorId) {

                            System.out.println(
                                    "\n" + Colors.RED + Colors.BOLD + "Doctor already has a booked appointment from "
                                    + existingStart.format(timeFmt) + " to " + existingEnd.format(timeFmt) + "." + Colors.RESET);

                            System.out.println(
                                    Colors.YELLOW + "Please choose a different time slot (each consultation is "
                                    + APPOINTMENT_DURATION_MINUTES + " minutes)." + Colors.RESET);

                            alreadyBooked =
                                    true;

                            break;
                        }


                        // Same patient
                        if (a.patientId ==
                                loggedInPatient.patientId) {

                            System.out.println(
                                    "\n" + Colors.RED + Colors.BOLD + "You already have another appointment from "
                                    + existingStart.format(timeFmt) + " to " + existingEnd.format(timeFmt) + "." + Colors.RESET);

                            alreadyBooked =
                                    true;

                            break;
                        }
                    }
                }
            }
        }


        if (alreadyBooked) {

            pause();

            return;
        }


        // -----------------------------
        // CREATE APPOINTMENT
        // -----------------------------

        Appointment appointment =
                new Appointment(
                        appointmentCounter++,
                        loggedInPatient.patientId,
                        selectedDoctor.doctorId,
                        selectedDoctor.name,
                        date,
                        time);


        appointments.add(
                appointment);


        // -----------------------------
        // CREATE APPOINTMENT BILL
        // -----------------------------

        Bill bill =
                new Bill(
                        billCounter++,
                        loggedInPatient.patientId,
                        appointment.appointmentId,
                        "Appointment",
                        "Consultation - "
                        + selectedDoctor.name,
                        selectedDoctor.consultationFee);


        bills.add(bill);


        System.out.println("\n");

        System.out.println(
                Colors.GREEN + Colors.BOLD + "========================================");

        System.out.println(
                "       APPOINTMENT CONFIRMED");

        System.out.println(
                "========================================" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Appointment ID : " + Colors.RESET + Colors.BRIGHT_CYAN + appointment.appointmentId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Doctor         : " + Colors.RESET + Colors.GREEN + selectedDoctor.name + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Date           : " + Colors.RESET + appointment.date);

        System.out.println(
                Colors.BOLD + "Time           : " + Colors.RESET + appointment.time);

        System.out.println(
                Colors.BOLD + "Consultation   : " + Colors.RESET + Colors.BRIGHT_GREEN + "Rs." + selectedDoctor.consultationFee + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Bill ID        : " + Colors.RESET + Colors.BRIGHT_CYAN + bill.billId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Payment Status : " + Colors.RESET + Colors.YELLOW + Colors.BOLD + "Pending" + Colors.RESET);

        System.out.println(
                Colors.GREEN + Colors.BOLD + "========================================" + Colors.RESET);


        pause();
    }


    // =================================================
    // MY APPOINTMENTS
    // =================================================

    static void myAppointments() {

        System.out.println(
                "\n" + Colors.CYAN + Colors.BOLD + "========== MY APPOINTMENTS ==========" + Colors.RESET);


        boolean found =
                false;


        for (Appointment a :
                appointments) {

            if (a.patientId ==
                    loggedInPatient.patientId) {

                a.displayAppointment();

                found =
                        true;
            }
        }


        if (!found) {

            System.out.println(
                    Colors.YELLOW + "No appointments found." + Colors.RESET);
        }


        System.out.println(
                "\n" + Colors.BOLD + "1. " + Colors.RESET + "Cancel Appointment");

        System.out.println(
                Colors.BOLD + "2. " + Colors.RESET + "Back");


        int choice =
                readInt(
                        Colors.YELLOW + "Enter choice: " + Colors.RESET);


        if (choice == 1) {

            cancelAppointment();
        }
    }


    // =================================================
    // CANCEL APPOINTMENT
    // =================================================

    static void cancelAppointment() {

        int id =
                readInt(
                        Colors.BOLD + "Enter Appointment ID: " + Colors.RESET);


        boolean found =
                false;


        for (Appointment a :
                appointments) {

            if (a.appointmentId == id
                    &&
                    a.patientId ==
                            loggedInPatient.patientId) {


                if (a.status.equals(
                        "Cancelled")) {

                    System.out.println(
                            Colors.RED + "This appointment is already cancelled." + Colors.RESET);

                } else {

                    a.status =
                            "Cancelled";

                    boolean wasPaid = false;
                    double refundAmount = 0;


                    for (Bill b :
                            bills) {

                        if (b.referenceId ==
                                a.appointmentId
                                &&
                                b.billType.equals(
                                        "Appointment")) {

                            if (b.paymentStatus.equals(
                                    "Pending")) {

                                b.paymentStatus =
                                        "Cancelled";

                                break;

                            } else if (b.paymentStatus.equals(
                                    "Paid")) {

                                b.paymentStatus =
                                        "Refunded";

                                wasPaid = true;

                                refundAmount = b.amount;

                                break;
                            }
                        }
                    }


                    System.out.println(
                            "\n" + Colors.GREEN + Colors.BOLD + "Appointment cancelled successfully." + Colors.RESET);

                    if (wasPaid) {

                        System.out.println(
                                Colors.PURPLE + Colors.BOLD + "A refund of Rs."
                                + refundAmount
                                + " will be credited back to your payment method." + Colors.RESET);
                    }
                }


                found =
                        true;

                break;
            }
        }


        if (!found) {

            System.out.println(
                    Colors.RED + "Appointment ID not found." + Colors.RESET);
        }


        pause();
    }


    // =================================================
    // ONLINE PHARMACY
    // =================================================

    static void onlinePharmacy() {

        int choice;


        do {

            System.out.println("\n");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "========================================");

            System.out.println(
                    "             ONLINE PHARMACY");

            System.out.println(
                    "========================================" + Colors.RESET);

            System.out.println(
                    Colors.BOLD + "1. " + Colors.RESET + "View Medicines");

            System.out.println(
                    Colors.BOLD + "2. " + Colors.RESET + "Buy Medicine");

            System.out.println(
                    Colors.BOLD + "3. " + Colors.RESET + "My Pharmacy Orders");

            System.out.println(
                    Colors.BOLD + "4. " + Colors.RESET + "Back");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "========================================" + Colors.RESET);


            choice =
                    readInt(
                            Colors.YELLOW + "Enter choice: " + Colors.RESET);


            switch (choice) {

                case 1:

                    viewMedicines();

                    break;


                case 2:

                    buyMedicine();

                    break;


                case 3:

                    myPharmacyOrders();

                    break;


                case 4:

                    break;


                default:

                    System.out.println(
                            Colors.RED + "Invalid choice." + Colors.RESET);
            }

        } while (choice != 4);
    }


    // =================================================
    // VIEW MEDICINES
    // =================================================

    static void viewMedicines() {

        System.out.println(
                "\n" + Colors.CYAN + Colors.BOLD + "========== AVAILABLE MEDICINES ==========" + Colors.RESET);


        for (Medicine m :
                medicines) {

            m.displayMedicine();
        }


        pause();
    }


    // =================================================
    // BUY MEDICINE
    // =================================================

    static void buyMedicine() {

        viewMedicines();


        int id =
                readInt(
                        Colors.BOLD + "Enter Medicine ID: " + Colors.RESET);


        Medicine selected =
                null;


        for (Medicine m :
                medicines) {

            if (m.medicineId ==
                    id) {

                selected =
                        m;

                break;
            }
        }


        if (selected == null) {

            System.out.println(
                    "\n" + Colors.RED + Colors.BOLD + "Medicine not found." + Colors.RESET);

            pause();

            return;
        }


        if (selected.stock <= 0) {

            System.out.println(
                    "\n" + Colors.RED + Colors.BOLD + "Medicine is currently out of stock." + Colors.RESET);

            pause();

            return;
        }


        int quantity;


        while (true) {

            quantity =
                    readInt(
                            Colors.BOLD + "Enter Quantity: " + Colors.RESET);


            if (quantity > 0
                    &&
                    quantity <=
                            selected.stock) {

                break;

            } else {

                System.out.println(
                        Colors.RED + "Invalid quantity! Available stock: "
                        + selected.stock + Colors.RESET);
            }
        }


        double total =
                selected.price
                * quantity;


        System.out.println("\n");

        System.out.println(
                Colors.CYAN + Colors.BOLD + "========== ORDER SUMMARY ==========" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Medicine : " + Colors.RESET + Colors.BRIGHT_WHITE + selected.name + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Quantity : " + Colors.RESET + quantity);

        System.out.println(
                Colors.BOLD + "Price    : " + Colors.RESET + "Rs." + selected.price);

        System.out.println(
                Colors.BOLD + "Total    : " + Colors.RESET + Colors.GREEN + Colors.BOLD + "Rs." + total + Colors.RESET);

        System.out.println(
                Colors.CYAN + Colors.BOLD + "===================================" + Colors.RESET);


        System.out.println(
                Colors.BOLD + "1. " + Colors.RESET + "Confirm Order");

        System.out.println(
                Colors.BOLD + "2. " + Colors.RESET + "Cancel");


        int choice =
                readInt(
                        Colors.YELLOW + "Enter choice: " + Colors.RESET);


        if (choice != 1) {

            System.out.println(
                    "\n" + Colors.YELLOW + "Order cancelled." + Colors.RESET);

            pause();

            return;
        }


        // REDUCE STOCK

        selected.stock -=
                quantity;


        // CREATE ORDER

        PharmacyOrder order =
                new PharmacyOrder(
                        orderCounter++,
                        loggedInPatient.patientId,
                        selected.name,
                        quantity,
                        selected.price);


        pharmacyOrders.add(
                order);


        // CREATE BILL

        Bill bill =
                new Bill(
                        billCounter++,
                        loggedInPatient.patientId,
                        order.orderId,
                        "Pharmacy",
                        selected.name
                        + " x "
                        + quantity,
                        total);


        bills.add(bill);


        System.out.println("\n");

        System.out.println(
                Colors.GREEN + Colors.BOLD + "========================================");

        System.out.println(
                "       ORDER PLACED SUCCESSFULLY");

        System.out.println(
                "========================================" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Order ID : " + Colors.RESET + Colors.BRIGHT_CYAN + order.orderId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Medicine : " + Colors.RESET + Colors.BOLD + selected.name + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Quantity : " + Colors.RESET + quantity);

        System.out.println(
                Colors.BOLD + "Amount   : " + Colors.RESET + Colors.BRIGHT_GREEN + Colors.BOLD + "Rs." + total + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Bill ID  : " + Colors.RESET + Colors.BRIGHT_CYAN + bill.billId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Status   : " + Colors.RESET + Colors.YELLOW + Colors.BOLD + "Pending Payment" + Colors.RESET);

        System.out.println(
                Colors.GREEN + Colors.BOLD + "========================================" + Colors.RESET);


        pause();
    }


    // =================================================
    // PHARMACY ORDERS
    // =================================================

    static void myPharmacyOrders() {

        System.out.println(
                "\n" + Colors.CYAN + Colors.BOLD + "========== MY PHARMACY ORDERS ==========" + Colors.RESET);


        boolean found =
                false;


        for (PharmacyOrder o :
                pharmacyOrders) {

            if (o.patientId ==
                    loggedInPatient.patientId) {

                o.displayOrder();

                found =
                        true;
            }
        }


        if (!found) {

            System.out.println(
                    Colors.YELLOW + "No pharmacy orders found." + Colors.RESET);
        }


        pause();
    }


    // =================================================
    // PAYMENTS & BILLING
    // =================================================

    static void paymentsAndBilling() {

        int choice;


        do {

            System.out.println("\n");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "========================================");

            System.out.println(
                    "          PAYMENTS & BILLING");

            System.out.println(
                    "========================================" + Colors.RESET);

            System.out.println(
                    Colors.BOLD + "1. " + Colors.RESET + "Appointment Bills");

            System.out.println(
                    Colors.BOLD + "2. " + Colors.RESET + "Pharmacy Bills");

            System.out.println(
                    Colors.BOLD + "3. " + Colors.RESET + "Blood Bank Bills");

            System.out.println(
                    Colors.BOLD + "4. " + Colors.RESET + "My Bills");

            System.out.println(
                    Colors.BOLD + "5. " + Colors.RESET + "Back");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "========================================" + Colors.RESET);


            choice =
                    readInt(
                            Colors.YELLOW + "Enter choice: " + Colors.RESET);


            switch (choice) {

                case 1:

                    appointmentBills();

                    break;


                case 2:

                    pharmacyBills();

                    break;


                case 3:

                    bloodBankBills();

                    break;


                case 4:

                    myBills();

                    break;


                case 5:

                    break;


                default:

                    System.out.println(
                            Colors.RED + "Invalid choice." + Colors.RESET);
            }


        } while (choice != 5);
    }


    // =================================================
    // APPOINTMENT BILLS
    // =================================================

    static void appointmentBills() {

        System.out.println("\n");

        System.out.println(
                Colors.CYAN + Colors.BOLD + "========== APPOINTMENT BILLS ==========" + Colors.RESET);


        boolean found =
                false;


        for (Bill b :
                bills) {

            if (b.patientId ==
                    loggedInPatient.patientId
                    &&
                    b.billType.equals(
                            "Appointment")
                    &&
                    b.paymentStatus.equals(
                            "Pending")) {

                b.displayBill();

                found =
                        true;
            }
        }


        if (!found) {

            System.out.println(
                    Colors.YELLOW + "No pending appointment bills." + Colors.RESET);

            pause();

            return;
        }


        System.out.println(
                Colors.YELLOW + "\nEnter Bill ID to pay." + Colors.RESET);


        int billId =
                readInt(
                        Colors.BOLD + "Bill ID: " + Colors.RESET);


        payAppointmentBill(
                billId);
    }


    // =================================================
    // PAY APPOINTMENT BILL
    // =================================================

    static void payAppointmentBill(
            int billId) {

        Bill selectedBill =
                null;


        for (Bill b :
                bills) {

            if (b.billId == billId
                    &&
                    b.patientId ==
                            loggedInPatient.patientId
                    &&
                    b.billType.equals(
                            "Appointment")
                    &&
                    b.paymentStatus.equals(
                            "Pending")) {

                selectedBill =
                        b;

                break;
            }
        }


        if (selectedBill == null) {

            System.out.println(
                    "\n" + Colors.RED + Colors.BOLD + "Pending appointment bill not found." + Colors.RESET);

            pause();

            return;
        }


        paymentMenu(
                selectedBill);
    }


    // =================================================
    // PHARMACY BILLS
    // =================================================

    static void pharmacyBills() {

        System.out.println("\n");

        System.out.println(
                Colors.CYAN + Colors.BOLD + "========== PHARMACY BILLS ==========" + Colors.RESET);


        boolean found =
                false;


        for (Bill b :
                bills) {

            if (b.patientId ==
                    loggedInPatient.patientId
                    &&
                    b.billType.equals(
                            "Pharmacy")
                    &&
                    b.paymentStatus.equals(
                            "Pending")) {

                b.displayBill();

                found =
                        true;
            }
        }


        if (!found) {

            System.out.println(
                    Colors.YELLOW + "No pending pharmacy bills." + Colors.RESET);

            pause();

            return;
        }


        System.out.println(
                Colors.YELLOW + "\nEnter Bill ID to pay." + Colors.RESET);


        int billId =
                readInt(
                        Colors.BOLD + "Bill ID: " + Colors.RESET);


        payPharmacyBill(
                billId);
    }


    // =================================================
    // PAY PHARMACY BILL
    // =================================================

    static void payPharmacyBill(
            int billId) {

        Bill selectedBill =
                null;


        for (Bill b :
                bills) {

            if (b.billId == billId
                    &&
                    b.patientId ==
                            loggedInPatient.patientId
                    &&
                    b.billType.equals(
                            "Pharmacy")
                    &&
                    b.paymentStatus.equals(
                            "Pending")) {

                selectedBill =
                        b;

                break;
            }
        }


        if (selectedBill == null) {

            System.out.println(
                    "\n" + Colors.RED + Colors.BOLD + "Pending pharmacy bill not found." + Colors.RESET);

            pause();

            return;
        }


        paymentMenu(
                selectedBill);
    }


    // =================================================
    // BLOOD BANK BILLS
    // =================================================

    static void bloodBankBills() {

        System.out.println("\n");

        System.out.println(
                Colors.CYAN + Colors.BOLD + "========== BLOOD BANK BILLS ==========" + Colors.RESET);


        boolean found =
                false;


        for (Bill b :
                bills) {

            if (b.patientId ==
                    loggedInPatient.patientId
                    &&
                    b.billType.equals(
                            "BloodBank")
                    &&
                    b.paymentStatus.equals(
                            "Pending")) {

                b.displayBill();

                found =
                        true;
            }
        }


        if (!found) {

            System.out.println(
                    Colors.YELLOW + "No pending blood bank bills." + Colors.RESET);

            pause();

            return;
        }


        System.out.println(
                Colors.YELLOW + "\nEnter Bill ID to pay." + Colors.RESET);


        int billId =
                readInt(
                        Colors.BOLD + "Bill ID: " + Colors.RESET);


        payBloodBankBill(
                billId);
    }


    // =================================================
    // PAY BLOOD BANK BILL
    // =================================================

    static void payBloodBankBill(
            int billId) {

        Bill selectedBill =
                null;


        for (Bill b :
                bills) {

            if (b.billId == billId
                    &&
                    b.patientId ==
                            loggedInPatient.patientId
                    &&
                    b.billType.equals(
                            "BloodBank")
                    &&
                    b.paymentStatus.equals(
                            "Pending")) {

                selectedBill =
                        b;

                break;
            }
        }


        if (selectedBill == null) {

            System.out.println(
                    "\n" + Colors.RED + Colors.BOLD + "Pending blood bank bill not found." + Colors.RESET);

            pause();

            return;
        }


        paymentMenu(
                selectedBill);
    }


    // =================================================
    // PAYMENT MENU
    // =================================================

    static void paymentMenu(
            Bill bill) {

        System.out.println("\n");

        System.out.println(
                Colors.CYAN + Colors.BOLD + "========== BILL PAYMENT ==========" + Colors.RESET);


        bill.displayBill();


        System.out.println(
                "\n" + Colors.BOLD + "Select Payment Method" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "1. " + Colors.RESET + Colors.BRIGHT_CYAN + "UPI (Instant Phone Verification & OTP)" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "2. " + Colors.RESET + "Debit / Credit Card");

        if (bill.billType.equals("BloodBank")) {

            System.out.println(
                    Colors.BOLD + "3. " + Colors.RESET + "Cash");

            System.out.println(
                    Colors.BOLD + "4. " + Colors.RESET + "Cancel");


            int choice =
                    readInt(
                            Colors.YELLOW + "Enter choice: " + Colors.RESET);


            switch (choice) {

                case 1:

                    payViaUPI(
                            bill);

                    break;


                case 2:

                    processPayment(
                            bill,
                            "Card");

                    break;


                case 3:

                    processCashPayment(
                            bill);

                    break;


                case 4:

                    System.out.println(
                            "\n" + Colors.YELLOW + "Payment cancelled." + Colors.RESET);

                    break;


                default:

                    System.out.println(
                            Colors.RED + "Invalid payment method." + Colors.RESET);
            }

        } else {

            System.out.println(
                    Colors.BOLD + "3. " + Colors.RESET + "Cancel");


            int choice =
                    readInt(
                            Colors.YELLOW + "Enter choice: " + Colors.RESET);


            switch (choice) {

                case 1:

                    payViaUPI(
                            bill);

                    break;


                case 2:

                    processPayment(
                            bill,
                            "Card");

                    break;


                case 3:

                    System.out.println(
                            "\n" + Colors.YELLOW + "Payment cancelled." + Colors.RESET);

                    break;


                default:

                    System.out.println(
                            Colors.RED + "Invalid payment method." + Colors.RESET);
            }
        }


        pause();
    }


    // =================================================
    // PROCESS CASH PAYMENT (BLOOD BANK ONLY)
    // =================================================

    static void processCashPayment(
            Bill bill) {

        bill.paymentMethod = "Cash";

        System.out.println("\n");

        System.out.println(
                Colors.YELLOW + Colors.BOLD + "========================================");

        System.out.println(
                "          CASH PAYMENT SELECTED");

        System.out.println(
                "========================================" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Bill ID        : " + Colors.RESET + Colors.BRIGHT_CYAN + bill.billId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Amount Due     : " + Colors.RESET + Colors.BRIGHT_GREEN + Colors.BOLD + "Rs." + bill.amount + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Payment Method : " + Colors.RESET + bill.paymentMethod);

        System.out.println(
                Colors.BOLD + "Payment Status : " + Colors.RESET + Colors.YELLOW + Colors.BOLD + bill.paymentStatus + Colors.RESET);

        System.out.println(
                Colors.YELLOW + Colors.BOLD + "========================================" + Colors.RESET);

        System.out.println(
                "\n" + Colors.YELLOW + Colors.BOLD + ">> Your status is pending. Please pay the cash at reception and collect your receipt." + Colors.RESET);
    }


    // =================================================
    // PAY VIA UPI (MOBILE NUMBER & OTP)
    // =================================================

    static void payViaUPI(
            Bill bill) {

        System.out.println("\n");

        System.out.println(
                Colors.CYAN + Colors.BOLD + "========================================");

        System.out.println(
                "           UPI PAYMENT GATEWAY");

        System.out.println(
                "========================================" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Bill ID       : " + Colors.RESET + Colors.BRIGHT_CYAN + bill.billId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Amount to Pay : " + Colors.RESET + Colors.BRIGHT_GREEN + Colors.BOLD + "Rs." + bill.amount + Colors.RESET);

        System.out.println(
                Colors.CYAN + "----------------------------------------" + Colors.RESET);


        String mobile;

        while (true) {

            System.out.print(
                    Colors.BOLD + "Enter 10-digit Mobile Number: " + Colors.RESET);

            mobile =
                    sc.nextLine().trim();

            if (validPhone(mobile)) {

                break;

            } else {

                System.out.println(
                        Colors.RED + "Invalid mobile number! Mobile must contain 10 digits and start with 6, 7, 8 or 9." + Colors.RESET);
            }
        }


        // CREATE OTP OBJECT
        OTP otp =
                new OTP();


        System.out.println("\n" + Colors.YELLOW + Colors.BOLD + "----------------------------------------");

        System.out.println(
                ">> [SMS SIMULATION] OTP sent to +91 "
                + mobile
                + ": "
                + Colors.BRIGHT_WHITE + Colors.BOLD + otp.getCode() + Colors.YELLOW);

        System.out.println(
                "----------------------------------------" + Colors.RESET);


        int attempts = 3;

        while (attempts > 0) {

            int enteredOtp =
                    readInt(Colors.BOLD + "Enter 4-digit OTP: " + Colors.RESET);


            if (otp.verify(enteredOtp)) {

                System.out.println(
                        "\n" + Colors.GREEN + Colors.BOLD + "OTP verified successfully!" + Colors.RESET);

                processPayment(
                        bill,
                        "UPI (" + mobile + ")");

                return;

            } else {

                attempts--;

                if (attempts > 0) {

                    System.out.println(
                            Colors.RED + "Incorrect OTP! Attempts left: "
                            + attempts + Colors.RESET);

                } else {

                    System.out.println(
                            "\n" + Colors.RED + Colors.BOLD + "Payment failed! Too many incorrect OTP attempts." + Colors.RESET);
                }
            }
        }
    }


    // =================================================
    // PROCESS PAYMENT
    // =================================================

    static void processPayment(
            Bill bill,
            String method) {


        System.out.println(
                "\n" + Colors.YELLOW + "Processing payment..." + Colors.RESET);


        bill.paymentStatus =
                "Paid";

        bill.paymentMethod =
                method;

        bill.paymentDateTime =
                LocalDateTime.now();


        // If this is a pharmacy bill, update the corresponding PharmacyOrder status
        if (bill.billType.equals("Pharmacy")) {

            for (PharmacyOrder o : pharmacyOrders) {

                if (o.orderId == bill.referenceId) {

                    o.status = "Paid";

                    break;
                }
            }
        }


        // If this is a blood bank bill, update the corresponding BloodRequest status
        if (bill.billType.equals("BloodBank")) {

            for (BloodRequest br : bloodRequests) {

                if (br.requestId == bill.referenceId) {

                    br.status = "Paid";

                    break;
                }
            }
        }


        System.out.println("\n");

        System.out.println(
                Colors.GREEN + Colors.BOLD + "========================================");

        System.out.println(
                "       PAYMENT SUCCESSFUL");

        System.out.println(
                "========================================" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Bill ID        : " + Colors.RESET + Colors.BRIGHT_CYAN + bill.billId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Amount         : " + Colors.RESET + Colors.BRIGHT_GREEN + Colors.BOLD + "Rs." + bill.amount + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Payment Method : " + Colors.RESET + bill.paymentMethod);

        System.out.println(
                Colors.BOLD + "Status         : " + Colors.RESET + Colors.GREEN + Colors.BOLD + bill.paymentStatus + Colors.RESET);


        DateTimeFormatter format =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy hh:mm a", Locale.ENGLISH);


        System.out.println(
                Colors.BOLD + "Paid On        : " + Colors.RESET
                + Colors.GREEN + bill.paymentDateTime
                        .format(format) + Colors.RESET);


        System.out.println(
                Colors.GREEN + Colors.BOLD + "========================================" + Colors.RESET);

        System.out.println(
                "\n" + Colors.GREEN + "The bill has been marked as PAID." + Colors.RESET);

        System.out.println(
                "It will no longer appear in the pending bills category.");

        System.out.println(
                "You can find receipt records in " + Colors.CYAN + "My Bills" + Colors.RESET + ".");
    }


    // =================================================
    // MY BILLS
    // =================================================

    static void myBills() {

        System.out.println("\n");

        System.out.println(
                Colors.CYAN + Colors.BOLD + "========================================");

        System.out.println(
                "              MY BILLS");

        System.out.println(
                "========================================" + Colors.RESET);


        boolean found =
                false;


        for (Bill b :
                bills) {

            if (b.patientId ==
                    loggedInPatient.patientId) {

                b.displayBill();

                found =
                        true;
            }
        }


        if (!found) {

            System.out.println(
                    Colors.YELLOW + "No bills available." + Colors.RESET);
        }


        pause();
    }


    // =================================================
    // BLOOD BANK
    // =================================================

    static void bloodBankMenu() {

        int choice;


        do {

            System.out.println("\n");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "================================");

            System.out.println(
                    "          BLOOD BANK");

            System.out.println(
                    "================================" + Colors.RESET);

            System.out.println(
                    Colors.BOLD + "1. " + Colors.RESET + "Check Blood Availability");

            System.out.println(
                    Colors.BOLD + "2. " + Colors.RESET + "Request Blood");

            System.out.println(
                    Colors.BOLD + "3. " + Colors.RESET + "My Blood Requests");

            System.out.println(
                    Colors.BOLD + "4. " + Colors.RESET + "Back");

            System.out.println(
                    Colors.CYAN + Colors.BOLD + "================================" + Colors.RESET);


            choice =
                    readInt(
                            Colors.YELLOW + "Enter choice: " + Colors.RESET);


            switch (choice) {

                case 1:

                    checkBloodAvailability();

                    break;


                case 2:

                    requestBlood();

                    break;


                case 3:

                    myBloodRequests();

                    break;


                case 4:

                    break;


                default:

                    System.out.println(
                            Colors.RED + "Invalid choice." + Colors.RESET);
            }

        } while (choice != 4);
    }


    // =================================================
    // CHECK BLOOD
    // =================================================

    static void checkBloodAvailability() {

        System.out.println(
                "\n" + Colors.CYAN + Colors.BOLD + "========== BLOOD AVAILABILITY ==========" + Colors.RESET);


        for (BloodBank b :
                bloodBank) {

            b.displayBlood();
        }


        pause();
    }


    // =================================================
    // REQUEST BLOOD
    // =================================================

    static void requestBlood() {

        checkBloodAvailability();


        System.out.print(
                Colors.BOLD + "Enter Blood Group (e.g., A+, O+, B-, AB+): " + Colors.RESET);


        String group =
                sc.nextLine()
                        .trim()
                        .toUpperCase();


        int required =
                readInt(
                        Colors.BOLD + "Enter Required Units: " + Colors.RESET);


        BloodBank selected =
                null;


        for (BloodBank b :
                bloodBank) {

            if (b.bloodGroup.equalsIgnoreCase(
                    group)) {

                selected =
                        b;

                break;
            }
        }


        if (selected == null) {

            System.out.println(
                    "\n" + Colors.RED + Colors.BOLD + "Blood group not found in database." + Colors.RESET);

            pause();

            return;
        }


        if (required <= 0) {

            System.out.println(
                    "\n" + Colors.RED + "Units must be greater than zero." + Colors.RESET);

            pause();

            return;
        }


        if (selected.units < required) {

            System.out.println(
                    "\n" + Colors.RED + Colors.BOLD + "Insufficient blood units available." + Colors.RESET);

            System.out.println(
                    Colors.BOLD + "Available Units : " + Colors.RESET + Colors.YELLOW + selected.units + Colors.RESET);

            pause();

            return;
        }


        double total =
                required * BLOOD_UNIT_PRICE;


        System.out.println("\n");

        System.out.println(
                Colors.CYAN + Colors.BOLD + "========== BLOOD REQUEST SUMMARY ==========" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Blood Group   : " + Colors.RESET + Colors.RED + Colors.BOLD + selected.bloodGroup + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Required Units: " + Colors.RESET + required + " units");

        System.out.println(
                Colors.BOLD + "Price / Unit  : " + Colors.RESET + "Rs." + BLOOD_UNIT_PRICE);

        System.out.println(
                Colors.BOLD + "Total Amount  : " + Colors.RESET + Colors.GREEN + Colors.BOLD + "Rs." + total + Colors.RESET);

        System.out.println(
                Colors.CYAN + Colors.BOLD + "===========================================" + Colors.RESET);


        System.out.println(
                Colors.BOLD + "1. " + Colors.RESET + "Confirm Request");

        System.out.println(
                Colors.BOLD + "2. " + Colors.RESET + "Cancel");


        int choice =
                readInt(
                        Colors.YELLOW + "Enter choice: " + Colors.RESET);


        if (choice != 1) {

            System.out.println(
                    "\n" + Colors.YELLOW + "Blood request cancelled." + Colors.RESET);

            pause();

            return;
        }


        // DEDUCT STOCK
        selected.units -=
                required;


        // CREATE BLOOD REQUEST RECORD
        BloodRequest request =
                new BloodRequest(
                        bloodRequestCounter++,
                        loggedInPatient.patientId,
                        loggedInPatient.name,
                        selected.bloodGroup,
                        required,
                        BLOOD_UNIT_PRICE);

        bloodRequests.add(
                request);


        // CREATE BILL
        Bill bill =
                new Bill(
                        billCounter++,
                        loggedInPatient.patientId,
                        request.requestId,
                        "BloodBank",
                        "Blood Request - "
                        + selected.bloodGroup
                        + " ("
                        + required
                        + " units)",
                        total);

        bills.add(
                bill);


        System.out.println("\n");

        System.out.println(
                Colors.GREEN + Colors.BOLD + "========================================");

        System.out.println(
                "       BLOOD REQUEST APPROVED");

        System.out.println(
                "========================================" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Request ID  : " + Colors.RESET + Colors.BRIGHT_CYAN + request.requestId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Patient     : " + Colors.RESET + Colors.BRIGHT_WHITE + loggedInPatient.name + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Blood Group : " + Colors.RESET + Colors.RED + Colors.BOLD + selected.bloodGroup + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Units       : " + Colors.RESET + Colors.GREEN + Colors.BOLD + required + " units" + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Total Amount: " + Colors.RESET + Colors.BRIGHT_GREEN + Colors.BOLD + "Rs." + total + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Bill ID     : " + Colors.RESET + Colors.BRIGHT_CYAN + bill.billId + Colors.RESET);

        System.out.println(
                Colors.BOLD + "Status      : " + Colors.RESET + Colors.YELLOW + Colors.BOLD + "Pending Payment" + Colors.RESET);

        System.out.println(
                Colors.GREEN + Colors.BOLD + "========================================" + Colors.RESET);

        System.out.println(
                "\n" + Colors.YELLOW + "Please proceed to Payments & Billing -> Blood Bank Bills to complete your payment." + Colors.RESET);


        pause();
    }


    // =================================================
    // MY BLOOD REQUESTS
    // =================================================

    static void myBloodRequests() {

        System.out.println(
                "\n" + Colors.CYAN + Colors.BOLD + "========== MY BLOOD REQUESTS ==========" + Colors.RESET);


        boolean found =
                false;


        for (BloodRequest br :
                bloodRequests) {

            if (br.patientId ==
                    loggedInPatient.patientId) {

                br.displayRequest();

                found =
                        true;
            }
        }


        if (!found) {

            System.out.println(
                    Colors.YELLOW + "No blood requests found." + Colors.RESET);
        }


        pause();
    }


    // =================================================
    // TIME PARSER
    // =================================================

    static LocalTime parseTime(
            String input) {


        // 04:00 PM

        try {

            DateTimeFormatter format =
                    DateTimeFormatter.ofPattern(
                            "hh:mm a", Locale.ENGLISH);


            return LocalTime.parse(
                    input.toUpperCase(),
                    format);


        } catch (
                DateTimeParseException e) {

            // Try next format
        }


        // 4:00 PM

        try {

            DateTimeFormatter format =
                    DateTimeFormatter.ofPattern(
                            "h:mm a", Locale.ENGLISH);


            return LocalTime.parse(
                    input.toUpperCase(),
                    format);


        } catch (
                DateTimeParseException e) {

            // Try next format
        }


        // 16:00

        try {

            DateTimeFormatter format =
                    DateTimeFormatter.ofPattern(
                            "HH:mm", Locale.ENGLISH);


            return LocalTime.parse(
                    input,
                    format);


        } catch (
                DateTimeParseException e) {

            return null;
        }
    }


    // =================================================
    // NAME VALIDATION
    // =================================================

    static boolean validName(
            String name) {

        if (name == null) {
            return false;
        }

        name = name.trim();

        if (name.length() < 2) {
            return false;
        }

        // Must contain only letters and single spaces between words
        return name.matches("^[a-zA-Z]+(\\s[a-zA-Z]+)*$");
    }


    // =================================================
    // GENDER VALIDATION & NORMALIZATION
    // =================================================

    static boolean validGender(
            String gender) {

        if (gender == null) {
            return false;
        }

        String g = gender.trim().toLowerCase();

        return g.equals("male")
                || g.equals("female")
                || g.equals("other")
                || g.equals("m")
                || g.equals("f")
                || g.equals("o");
    }

    static String normalizeGender(
            String gender) {

        String g = gender.trim().toLowerCase();

        if (g.equals("m") || g.equals("male")) {
            return "Male";
        } else if (g.equals("f") || g.equals("female")) {
            return "Female";
        } else {
            return "Other";
        }
    }


    // =================================================
    // PHONE VALIDATION
    // =================================================

    static boolean validPhone(
            String phone) {

        if (phone == null) {
            return false;
        }

        phone = phone.trim();

        if (phone.length() != 10) {
            return false;
        }

        char first =
                phone.charAt(0);

        if (!(first >= '6'
                && first <= '9')) {
            return false;
        }

        for (int i = 0;
             i < phone.length();
             i++) {

            char ch =
                    phone.charAt(i);

            if (!(ch >= '0'
                    && ch <= '9')) {
                return false;
            }
        }

        return true;
    }


    // =================================================
    // USERNAME VALIDATION
    // =================================================

    static boolean validUsername(
            String username) {

        if (username == null) {
            return false;
        }

        username = username.trim();

        if (username.length() < 3 || username.length() > 20) {
            return false;
        }

        for (int i = 0;
             i < username.length();
             i++) {

            char ch =
                    username.charAt(i);

            if (!((ch >= 'A'
                    && ch <= 'Z')
                    ||
                    (ch >= 'a'
                    && ch <= 'z')
                    ||
                    (ch >= '0'
                    && ch <= '9'))) {

                return false;
            }
        }

        return true;
    }


    // =================================================
    // PASSWORD VALIDATION
    // =================================================

    static boolean validPassword(
            String password) {

        if (password == null || password.length() < 7 || password.contains(" ")) {
            return false;
        }

        boolean letter =
                false;

        boolean number =
                false;

        boolean special =
                false;

        String specialChars =
                "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

        for (int i = 0;
             i < password.length();
             i++) {

            char ch =
                    password.charAt(i);

            if ((ch >= 'A'
                    && ch <= 'Z')
                    ||
                    (ch >= 'a'
                    && ch <= 'z')) {

                letter =
                        true;

            } else if (ch >= '0'
                    && ch <= '9') {

                number =
                        true;

            } else if (specialChars.indexOf(ch) >= 0) {

                special =
                        true;
            }
        }

        return letter
                && number
                && special;
    }


    // =================================================
    // LOAD DATA
    // =================================================

    static void loadData() {


        // -----------------------------
        // DOCTORS
        // -----------------------------

        doctors.add(
                new Doctor(
                        101,
                        "Dr. Ravi Kumar",
                        "Cardiologist",
                        "10:00",
                        "14:00",
                        800));


        doctors.add(
                new Doctor(
                        102,
                        "Dr. Priya Sharma",
                        "Dermatologist",
                        "11:00",
                        "15:00",
                        600));


        doctors.add(
                new Doctor(
                        103,
                        "Dr. Arjun Reddy",
                        "General Physician",
                        "09:00",
                        "13:00",
                        500));


        doctors.add(
                new Doctor(
                        104,
                        "Dr. Sneha Rao",
                        "Neurologist",
                        "14:00",
                        "18:00",
                        1000));


        // -----------------------------
        // MEDICINES
        // -----------------------------

        medicines.add(
                new Medicine(
                        201,
                        "Paracetamol 500mg",
                        "Fever / Pain",
                        50,
                        100));


        medicines.add(
                new Medicine(
                        202,
                        "Azithromycin 500mg",
                        "Antibiotic",
                        120,
                        50));


        medicines.add(
                new Medicine(
                        203,
                        "Cetirizine 10mg",
                        "Allergy",
                        40,
                        80));


        medicines.add(
                new Medicine(
                        204,
                        "Pantoprazole 40mg",
                        "Acidity",
                        90,
                        60));


        medicines.add(
                new Medicine(
                        205,
                        "Vitamin D3",
                        "Supplement",
                        150,
                        40));


        medicines.add(
                new Medicine(
                        206,
                        "ORS",
                        "Hydration",
                        30,
                        100));


        // -----------------------------
        // BLOOD BANK
        // -----------------------------

        bloodBank.add(
                new BloodBank(
                        "A+",
                        12));


        bloodBank.add(
                new BloodBank(
                        "A-",
                        5));


        bloodBank.add(
                new BloodBank(
                        "B+",
                        10));


        bloodBank.add(
                new BloodBank(
                        "B-",
                        4));


        bloodBank.add(
                new BloodBank(
                        "O+",
                        15));


        bloodBank.add(
                new BloodBank(
                        "O-",
                        3));


        bloodBank.add(
                new BloodBank(
                        "AB+",
                        7));


        bloodBank.add(
                new BloodBank(
                        "AB-",
                        2));
    }


    // =================================================
    // INTEGER INPUT
    // =================================================

    static int readInt(
            String message) {

        while (true) {

            try {

                System.out.print(
                        message);


                return Integer.parseInt(
                        sc.nextLine().trim());


            } catch (
                    NumberFormatException e) {

                System.out.println(
                        Colors.RED + "Please enter numbers only." + Colors.RESET);
            }
        }
    }


    // =================================================
    // PAUSE
    // =================================================

    static void pause() {

        System.out.println(
                "\n" + Colors.YELLOW + "Press Enter to continue..." + Colors.RESET);

        sc.nextLine();
    }
}
