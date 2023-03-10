package controls;

import java.awt.Color;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;

/**
 * All methods for validations are contained in this class.
 *
 * @author WK
 */
public class Validations {

    public static void main(String[] args) {
    }

    /**
     * replace null String values
     *
     * @param text to check
     * @return validated text
     */
    public static String empty_String(String text) {
        String content;
        if (text != null && !text.isEmpty()) {
            content = text;
        } else {
            content = "";
        }
        return content;
    }

    //Remove null values in jTextFields
    public String Empty_textField(JTextField textField) {
        String content;
        if (textField.getText().isEmpty() || textField.getText().equals("")) {
            content = "";
        } else {
            content = textField.getText();
        }
        return content;
    }

    /**
     *
     * @param textField
     * @return true if textfield contain a text
     */
    public static boolean isTextFieldValid(JTextField textField) {
        boolean flag = false;

        if (!textField.getText().isEmpty() && !textField.getText().equals("")) {
            flag = true;
        }
        return flag;
    }

    public static boolean email(String email) {
        String pattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        boolean flag = false;
        if (email != null && !email.isEmpty()) {
            if (email.matches(pattern)) {
                flag = true;
            }
        }
        return flag;
    }

    public static boolean phoneNumber(String phone) {
        //String pattern="([0]{0,1}[1-9]{2}[-\\s][\\d]{7})|([\\d]{10})";
        String pattern = "[0]{0,1}[1-9]{2}[-\\s]{0,1}[\\d]{7}";
        boolean flag = false;
        if (phone != null && !phone.isEmpty()) {
            if (phone.matches(pattern)) {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean checknoOnlyLetters(String typeVal) {
        String pattern = "^[A-Za-z\\s\\.]*$";
        boolean flag = false;
        if (typeVal != null && !typeVal.isEmpty()) {
            if (typeVal.matches(pattern)) {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean nic(String nic) {
        //String pattern="([0]{0,1}[1-9]{2}[-\\s][\\d]{7})|([\\d]{10})";
        String pattern = "^[0-9]{9}[vVxX]$";
        boolean flag = false;
        if (nic != null && !nic.isEmpty()) {
            if (nic.matches(pattern)) {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean passport(String pass) {
        boolean valid = false;
        String pattern = "^[A-Za-z][0-9]{7}$";
        if (pass != null && !pass.isEmpty()) {
            if (pass.matches(pattern)) {
                valid = true;
            }
        }
        return valid;
    }

    /**
     *
     * @param dateIn Date to format
     * @param format Format pattern
     * @return formatted date as a String. ex:yyyy-MM-dd
     */
    public String datenow(Date dateIn, String format) {

        String retDate = null;
        try {
            //String format = "yyyy-MM-dd";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            retDate = sdf.format(dateIn);
        } catch (Exception ex) {
        }
        return retDate;
    }

    public static void notifyUser(JTextField textField, boolean valid) {
        if (valid) {
            textField.setForeground(Color.BLACK);
        } else {
            textField.setForeground(Color.red);
        }
    }

    /**
     * validates numbers with two decimals
     *
     * @param typeVal
     * @return
     */
    public static boolean isNumber_amount(String typeVal) {
        String pattern = "^[0-9]*[\\.]*[0-9]{0,2}$";
        boolean flag = false;
        if (typeVal != null && !typeVal.isEmpty()) {
            if (typeVal.matches(pattern)) {
                flag = true;
            }
        }

        return flag;
    }

    public static boolean isNumber_Int(String typeVal) {
        String pattern = "^[0-9]*$";
        boolean flag = false;
        if (typeVal != null && !typeVal.isEmpty()) {
            if (typeVal.matches(pattern)) {
                flag = true;
            }
        }

        return flag;
    }

    public static double roundNumber_withot_decimals(double value) {
        BigDecimal num = new BigDecimal(String.valueOf(value)).setScale(0, BigDecimal.ROUND_HALF_UP);
        return Double.parseDouble(num.toString());
    }

    public static double roundNumber_with_decimals(double value, int decimals) {
        BigDecimal num = new BigDecimal(String.valueOf(value)).setScale(decimals, BigDecimal.ROUND_HALF_UP);
        return Double.parseDouble(num.toString());
    }

}
