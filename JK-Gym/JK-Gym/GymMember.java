
/**
 * Abstract class representing a gym member with basic member information and functionality.
 * Provides base implementation for member management including attendance, loyalty points,
 * and membership status tracking.
 * @author Kushal Jamarkattel
 */
public abstract class GymMember {
    /** Unique identifier for the member */
    protected int id;
    /** Full name of the member */
    protected String name;
    /** Member's residential location */
    protected String location;
    /** Member's contact number */
    protected String phone;
    /** Member's email address */
    protected String email;
    /** Member's gender */
    protected String gender;
    /** Member's date of birth */
    protected String DOB;
    /** Date when membership started */
    protected String membershipStartDate;
    /** Number of times member attended gym */
    protected int attendance;
    /** Current membership plan */
    protected String plan;
    /** Accumulated loyalty points */
    protected double loyaltyPoints;
    /** Current status of membership */
    protected boolean activeStatus;

    /**
     * Constructor to initialize a new gym member with basic information.
     *
     * @param id Unique identifier for the member
     * @param name Full name of the member
     * @param location Member's residential location
     * @param phone Member's contact number
     * @param email Member's email address
     * @param gender Member's gender
     * @param DOB Member's date of birth
     * @param membershipStartDate Date when membership started
     */
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0;
        this.activeStatus = false;
    }

    /**
     * Upgrades the member's plan to the next tier if available.
     * Basic -> Standard -> Deluxe
     */
    public void upgradePlan() {
        if (this.plan.equals("Basic")) {
            this.plan = "Standard";
            System.out.println("Plan upgraded to Standard.");
        } else if (this.plan.equals("Standard")) {
            this.plan = "Deluxe";
            System.out.println("Plan upgraded to Deluxe.");
        } else {
            System.out.println("You are already on the highest plan (Deluxe).");
        }
    }

    /**
     * @return Member's unique identifier
     */
    public int getId() {
        return id;
    }

    /**
     * @return Member's full name
     */
    public String getName() {
        return name;
    }

    /**
     * @return Member's residential location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return Member's contact number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return Member's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return Member's gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @return Member's date of birth
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * @return Date when membership started
     */
    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    /**
     * @return Number of times member attended gym
     */
    public int getAttendance() {
        return attendance;
    }

    /**
     * @return Accumulated loyalty points
     */
    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * @return Current status of membership
     */
    public boolean isActiveStatus() {
        return activeStatus;
    }

    /**
     * @return Current membership plan
     */
    public String getPlan() {
        return plan;
    }

    /**
     * Sets the attendance count for the member
     * @param attendance New attendance count
     */
    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    /**
     * Updates the loyalty points for the member
     * @param loyaltyPoints New loyalty points value
     */
    public void setLoyaltyPoints(double loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    /**
     * Updates the member's plan
     * @param newPlan New membership plan
     */
    public void setPlan(String newPlan) {
        this.plan = newPlan;
    }

    /**
     * Abstract method to mark member's attendance
     * Implementation varies by member type
     */
    public abstract void markAttendance();

    /**
     * Activates the member's membership status
     */
        public void activateMembership() {
            this.activeStatus = true;
        }

    /**
     * Deactivates the member's membership if currently active
     */
    public void deactivateMembership() {
        if (this.activeStatus) {
            this.activeStatus = false;
        } else {
            System.out.println("The Membership is already deactivated.");
        }
    }

    /**
     * Resets member's statistics to default values
     * Sets attendance, loyalty points to 0 and deactivates membership
     */
    public void resetMember() {
        this.activeStatus = false;
        this.attendance = 0;
        this.loyaltyPoints = 0;
    }

    /**
     * Displays all member information to console
     */
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("DOB: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);
    }
}