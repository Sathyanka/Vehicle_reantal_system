package controls;

import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


/**
 * common methods and properties used in AHMS system.
 *
 * @author WK
 */
public class Commons {

    public Commons() {

    }
    /**
     * returns <code>dateformat</code> pattern "yyyy-MM-dd" ex: 2013-01-25
     */
    public static String DATE_STANDARD = "yyyy-MM-dd";
    //-------------------------------------------------------------
    /**
     * returns <code>dateformat</code> pattern "hh:mm:ss a" ex: 10:30:42 AM
     */
    public static String TIME_STANDARD = "hh24:mi:ss";
    //-------------------------------------------------------------
    /**
     * returns default font used in this application. Tahoma regular, size 12
     */
    public static java.awt.Font SYSTEM_FONT = new java.awt.Font("Tahoma", 0, 12);
    /**
     * returns default font used in this application. Tahoma bold, size 11
     */
    public static java.awt.Font SYSTEM_FONT_FIELDS = new java.awt.Font("Tahoma", 1, 11);
    /**
     * returns default font used in this application. Tahoma bold, size 12
     */
    public static java.awt.Font SYSTEM_FONT_TITLES = new java.awt.Font("Tahoma", 1, 12);
    //-------------------------------------------------------------
    public static java.util.Date TODAY = new java.util.Date();

    /**
     *
     * @param inDate java.util.Date
     * @param days No of days to add or subtract(-) from inDate.
     * @return - calculated date.
     */
    public java.util.Date calculateDate(java.util.Date inDate, int days) {
        int date_MaxDate = 365 * 35;
        int date_MinDate = -365 * 35;
        java.util.Date outDate = null;
        if (inDate != null) {
            if (days < date_MaxDate && days > date_MinDate) {
                try {
                    Calendar c = Calendar.getInstance();
                    c.setTime(inDate);
                    c.add(Calendar.DAY_OF_MONTH, days);
                    outDate = c.getTime();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return outDate;
    }



    public static java.util.Date calculateDate(java.util.Date inDate, int years, int months, int days) {

        java.util.Date outDate = null;
        if (inDate != null) {
            Calendar c = Calendar.getInstance();
            c.setTime(inDate);
            try {
                if (years != 0) {
                    c.add(Calendar.YEAR, years);
                    outDate = c.getTime();
                }
                if (months != 0) {
                    c.add(Calendar.MONTH, months);
                    outDate = c.getTime();
                }
                if (days != 0) {
                    c.add(Calendar.DATE, days);
                    outDate = c.getTime();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return outDate;
    }

    /**
     * Calculate difference between two dates. <code>date1</code> should be
     * greater than <code>date2</code>
     *
     * @param date1
     * @param date2
     * @return int array <br/>DMY[0]:Days, DMY[1]:Months, DMY[3]:Years
     */
    public int[] calculateDateDifference(Date date1, Date date2) {
        long diff = date1.getTime() - date2.getTime();
        int DMY[] = new int[3];

        if (diff > 86399000 && diff < 1577923200000L) {
            //assign date1 & date2 to calendar objects
            Calendar cDate1 = Calendar.getInstance();
            cDate1.setTime(date1);

            Calendar cDate2 = Calendar.getInstance();
            cDate2.setTime(date2);

            //get day,month & year seperately
            int day1 = cDate1.get(Calendar.DAY_OF_MONTH);
            int month1 = cDate1.get(Calendar.MONTH);
            int year1 = cDate1.get(Calendar.YEAR);

            while (day1 != cDate2.get(Calendar.DAY_OF_MONTH)) {
                DMY[0]++;
                cDate2.add(Calendar.DATE, 1);
            }
            while (month1 != cDate2.get(Calendar.MONTH)) {
                DMY[1]++;
                cDate2.add(Calendar.MONTH, 1);
            }
            while (year1 != cDate2.get(Calendar.YEAR)) {
                DMY[2]++;
                cDate2.add(Calendar.YEAR, 1);
            }
        } else {
        }
        return DMY;
    }

    /**
     *
     * @param dateIn java.util.Date to format
     * @param format formatting pattern
     * @return formatted date or time
     */
    public static String formattedDateTime(java.util.Date dateIn, String format) {
        String retDate = null;
        if (dateIn != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                retDate = sdf.format(dateIn);
                return retDate;
            } catch (Exception ex) {
                ex.printStackTrace();
                Logger.getLogger(Commons.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            retDate = "";
        }
        return retDate;
    }

    /**
     * converts a date in string format to a java.util.Date
     *
     * @param date
     * @return
     */
    public static java.util.Date convertString(String date) {
        java.util.Date convertedDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_STANDARD);
        try {
            convertedDate = sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Commons.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convertedDate;

    }

    /**
     * converts a date in string format to a java.util.Date
     *
     * @param date
     * @return
     */
//    public static void setUIFont(javax.swing.plaf.FontUIResource f) {
//        java.util.Enumeration keys = UIManager.getDefaults().keys();
//        while (keys.hasMoreElements()) {
//            Object key = keys.nextElement();
//            Object value = UIManager.get(key);
//            if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
//                UIManager.put(key, f);
//            }
//        }
//    }

    public static java.util.Date convertStringTotime(String date) {
        java.util.Date convertedDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        try {
            convertedDate = sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Commons.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convertedDate;

    }

    public static Image resizeImage(Image oImage, JLabel lblImage) {
        Image resizedImage = null;
        int setH = 0;
        int setW = 0;
        if (oImage != null) {

            int oWidth = oImage.getWidth(null);
            int oHeight = oImage.getHeight(null);

            if (oWidth > oHeight) {
                setW = lblImage.getWidth();
                setH = ((setW * 100 / oWidth) * oHeight / 100);
            } else {
                setH = lblImage.getHeight();
                setW = ((setH * 100 / oHeight) * oWidth / 100);
            }
            resizedImage = oImage.getScaledInstance(setW, setH, Image.SCALE_AREA_AVERAGING);
        }
        return resizedImage;
    }
//    static String[] cmbmodel = {"07 AM", "08 AM", "10 AM", "11 AM", "12 AM", "01 PM", "02 PM", "03 PM", "04 PM", "07 PM", "08 PM", "09 PM", "10 PM", "12 PM"};

    public static void main(String[] args) {
        Commons cm = new Commons();
        Date d1 = new Date();

        Date d2 = cm.calculateDate(d1, -50, 0, 0);
        long diff = d1.getTime() - d2.getTime();
        Calendar c1 = Calendar.getInstance();
        c1.setTime(d1);

        Calendar c2 = Calendar.getInstance();
        c2.setTime(d2);

        int day1 = c1.get(Calendar.DAY_OF_MONTH);
        int month1 = c1.get(Calendar.MONTH);
        int year1 = c1.get(Calendar.YEAR);

//        int day2 = c2.get(Calendar.DAY_OF_MONTH);
//        int month2 = c2.get(Calendar.MONTH);
//        int year2 = c2.get(Calendar.YEAR);
//
        int daycounter = 0;
        int monthcounter = 0;
        int yearcounter = 0;
        while (day1 != c2.get(Calendar.DAY_OF_MONTH)) {
            daycounter++;
            c2.add(Calendar.DATE, 1);

        }
        while (month1 != c2.get(Calendar.MONTH)) {
            monthcounter++;
            c2.add(Calendar.MONTH, 1);

        }
        while (year1 != c2.get(Calendar.YEAR)) {
            yearcounter++;
            c2.add(Calendar.YEAR, 1);

        }
    }

    /**
     * @param startTime
     * @param endTime
     * @return Map <PRE> Number of hours <code>"HOUR"</code>
     * Number of Minutes  <code>"MIN"</code>
     * </PRE>
     */
    public static Map timeDifference(Date startTime, Date endTime) {
        Map<String, Integer> analysisMap = new HashMap<>();
        long diff = endTime.getTime() - startTime.getTime();
        int hours = (int) (diff / (1000 * 60 * 60));
        int min = (int) (diff / (1000 * 60)) % 60;
        analysisMap.put("HOUR", hours);
        analysisMap.put("MIN", min);
        return analysisMap;
    }

    public static Map coinAnalysis(double amt) {
        double rem = amt;

        Map<String, Double> analysisMap = new HashMap<>();
        double fiveThousands = 0;
        double twoThousands = 0;
        double oneThousands = 0;
        double fiveHundreds = 0;
        double oneHundreds = 0;
        double fifty = 0;
        double twenty = 0;
        double ten = 0;
        double five = 0;
        double two = 0;
        double one = 0;
        double fity_cence = 0;
        double two_five_cence = 0;

        fiveThousands = (int) rem / 5000;
        rem = rem % 5000;
        twoThousands = (int) rem / 2000;
        rem = rem % 2000;
        oneThousands = (int) rem / 1000;
        rem = rem % 1000;
        fiveHundreds = (int) rem / 500;
        rem = rem % 500;
        oneHundreds = (int) rem / 100;
        rem = rem % 100;
        fifty = (int) rem / 50;
        rem = rem % 50;
        twenty = (int) rem / 20;
        rem = rem % 20;
        ten = (int) rem / 10;
        rem = rem % 10;
        five = (int) rem / 5;
        rem = rem % 5;
        two = (int) rem / 2;
        rem = rem % 2;
        one = (int) rem / 1;
        rem = rem % 1;
        fity_cence = (int) rem / 0.5;
        rem = rem % 0.5;
        two_five_cence = (int) rem / 0.25;
        rem = rem % 0.25;
        rem = (int) (rem * 100);

        analysisMap.put("5000", fiveThousands);
        analysisMap.put("2000", twoThousands);
        analysisMap.put("1000", oneThousands);
        analysisMap.put("500", fiveHundreds);
        analysisMap.put("100", oneHundreds);
        analysisMap.put("50", fifty);
        analysisMap.put("20", twenty);
        analysisMap.put("10", ten);
        analysisMap.put("5", five);
        analysisMap.put("2", two);
        analysisMap.put("1", one);
        analysisMap.put("0.50", fity_cence);
        analysisMap.put("0.25", two_five_cence);
        analysisMap.put("bal_cence", rem);

//        get values ex.
//        for (Map.Entry<String, Double> entrySet : analysisMap.entrySet()) {
//            String key = entrySet.getKey();
//            Double value = entrySet.getValue();
//            System.out.println(key+":"+value);
//        }
//        System.out.println("-----------------");
        return analysisMap;
    }

    public static java.util.Date convertString(String date, String format) {
        java.util.Date convertedDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            convertedDate = sdf.parse(date);
        } catch (ParseException ex) {
            Logger.getLogger(Commons.class.getName()).log(Level.SEVERE, null, ex);
        }
        return convertedDate;
    }

    public static void attachJTableFilter(final JTable table, final JTextField textfield) {
        textfield.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
                TableModel model = table.getModel();
                sorter = new TableRowSorter(model);
                table.setRowSorter(sorter);
                try {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textfield.getText()));
                } catch (Exception exp) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)"));
                }
            }

            public void removeUpdate(DocumentEvent e) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
                TableModel model = table.getModel();
                sorter = new TableRowSorter(model);
                table.setRowSorter(sorter);
                try {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textfield.getText()));
                } catch (Exception exp) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)"));
                }
            }

            public void changedUpdate(DocumentEvent e) {
                TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
                TableModel model = table.getModel();
                sorter = new TableRowSorter(model);
                table.setRowSorter(sorter);
                try {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textfield.getText()));
                } catch (Exception exp) {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)"));
                }
            }
        });

    }

}
