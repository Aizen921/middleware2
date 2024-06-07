package com.middleware2.middleware2.interceptors;

import com.middleware2.middleware2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Arrays;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {
    private final List<Month> monthList = Arrays.asList(
            new Month(1, "Gennaio", "January", "Januar"),
            new Month(3, "Marzo", "March", "Marz"),
            new Month(5, "Maggio", "May", "Mai"),
            new Month(7, "Luglio", "July", "Juli"),
            new Month(9, "Settembre", "September", "September"),
            new Month(11, "Novembre", "November", "November")
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberHeader = request.getHeader("monthNumber");

        if (monthNumberHeader == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "MonthNumberHeader is missing");
            return false;
        }
        if (monthNumberHeader.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "MonthNumberHeader Is Empty");
            return false;
        }
        try {
            Integer monthNumber = Integer.valueOf(monthNumberHeader);
            Month month = find(monthNumber);
            if (month == null) {
                month = new Month(null, "nope", "nope", "nope");
            }
            request.setAttribute("month", month);
            response.setStatus(HttpStatus.OK.value());
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid monthNumber format");
            return false;
        }

        return true;
    }

    private Month find(Integer intValue) {
        for (Month month : monthList) {
            if (month.getMonthNumber().equals(intValue)) {
                return month;
            }
        }
        return null;
    }

}
