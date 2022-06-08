package hpn.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidationUtils {
    public static final String NAME_REGEX = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    public static final String PHONE_REGEX = "^[0][1-9][0-9]{8,9}$";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}$";
    public static final String USERNAME_REGEX = "^[A-Za-z][A-Za-z0-9_]{7,19}$";
    public static final String ADDRESS_REGEX = "^[A-Za-z][A-Za-z0-9_]{7,19}$";

    public static boolean isPasswordValid(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }

    public static boolean isNameValid(String name) {
        return Pattern.matches(NAME_REGEX, name);
    }

    public static boolean isPhoneValid(String phone) {
        return Pattern.matches(PHONE_REGEX, phone);
    }

    public static boolean isEmailValid(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    public static boolean isUsernameValid(String username) {
        return Pattern.matches(USERNAME_REGEX, username);
    }

    public static boolean isAddressValid(String address) {
        return Pattern.matches(ADDRESS_REGEX, address);
    }

    public static boolean isDateValid(String dateStr) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.BASIC_ISO_DATE;
        try {
            LocalDate.parse(convertDate(dateStr), dateFormatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public static String convertDate(String date) {
        //  23/04/2021 -> 20210423
        String[] array = date.split("/");
        String result = "";
        for (int i = array.length - 1; i >= 0; i--) {
            result += array[i];
        }
        return result;
    }


}
