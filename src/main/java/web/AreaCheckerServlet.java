package web;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


@WebServlet("/check")
public class AreaCheckerServlet extends HttpServlet {
    private enum Quarters {
        FIRST, SECOND, THIRD, FOURTH;

        static Quarters quarter(float x, float y) {
            if (x >= 0 && y >= 0) return Quarters.FIRST;
            if (x < 0 && y >= 0) return Quarters.SECOND;
            if (x < 0 && y < 0) return Quarters.THIRD;
            return Quarters.FOURTH;
        }
    }

    @Override
    public void init() {
        ArrayList<Point> points = new ArrayList<>();
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("points", points);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Date start = new Date();
        String requestBody = readRequest(request);
        Float x = parseParam(requestBody, "x");
        Float y = parseParam(requestBody, "y");
        Float r = parseParam(requestBody, "r");
        if (x != null && y != null && r != null) {
            ServletContext servletContext = getServletContext();
            ArrayList<Point> points = (ArrayList<Point>) servletContext.getAttribute("points");
            points.add(new Point(x, y, r, checkArea(x, y, r), new Date(),  (new Date()).getTime() - start.getTime()));
            servletContext.setAttribute("points", points);
        }
    }

    private boolean checkArea(float x, float y, float r) {
        switch (Quarters.quarter(x, y)) {
            case FIRST:
                return false;
            case SECOND:
                return y < r + x;
            case THIRD:
                return x * x + y * y < (r / 2) * (r / 2);
            case FOURTH:
                return x < r && -y < r / 2;
        }
        return false;
    }

    private Float parseParam(String requestBody, String param) {
        try {
            return Float.parseFloat(requestBody.split(param + "\"\n")[1].split("\n")[0]);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private String readRequest(HttpServletRequest request) throws IOException {
        Scanner s = new Scanner(request.getInputStream());
        StringBuilder requestBody = new StringBuilder();
        while (s.hasNext()) {
            requestBody.append(s.next());
            requestBody.append("\n");
        }
        return requestBody.toString();
    }

}
