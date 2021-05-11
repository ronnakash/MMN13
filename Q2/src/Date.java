import java.util.Objects;

public class Date {
    int day;
    int month;
    int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Date date = (Date) object;
        return day == date.day && month == date.month && year == date.year;
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), day, month, year);
    }

    public boolean validDate() {
        if (day < 0) return false;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return day <= 31;
            case 2:
                return isLeapYear() ? day < 30 : day < 29;
            case 4:
            case 6:
            case 9:
            case 11:
                return day <= 30;
            default:
                throw new IllegalDateException(this);
        }
    }

    private boolean isLeapYear(){
        return (((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0));
    }

    @Override
    public String toString() {
        return "" + day +
                " " + getMonthString() +
                " " + year;
    }

    public String getMonthString(){
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        if (month < 13 && month > 0)
            return months[month-1];
        else
            return month + "(invalid)";

    }

    static class IllegalDateException extends IllegalStateException{
        Date date;
        public IllegalDateException(Date date) {
            super("Illegal date:" + date.toString()) ;
            this.date  = date;
        }

    }

}