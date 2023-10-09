package com.pinelabs.simulator.validator;


import com.pinelabs.simulator.util.Constants;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class CommonValidator {

    public String checkIfDateIsGreaterThanCurrentDate(String dateToBeValidated) throws ParseException {
        long millis = System.currentTimeMillis();
        Date currentDate = new Date(millis);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.US);
        Date date = format.parse(dateToBeValidated);
        return (date.equals(currentDate) || date.after(currentDate)) ? Constants.IS_VALID : Constants.DATE_SHOULD_NOT_BE_LESS_THAN_CURRENT_DATE;
    }


    public String compareStartDateAndEndDate(String startDate, String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        Date startDt = sdf.parse(startDate);
        Date endDt = sdf.parse(endDate);
        return startDt.equals(endDt) || startDt.before(endDt) ? Constants.IS_VALID : Constants.VALIDITY_END_DATE_SHOULD_NOT_BE_LESS_THAN_VALIDITY_START_DATE;
    }

}
