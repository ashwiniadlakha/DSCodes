package sample.test.controller;

import com.google.gson.Gson;
import com.mysql.jdbc.StringUtils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.test.dao.BookingSystemDao;
import sample.test.entity.BasicResponse;

import java.util.Arrays;
import java.util.UUID;

@Controller
public class TestController {

    @Autowired
    BookingSystemDao bookingSystemDao;

    Gson gson = new Gson();

    static final Logger logger = Logger.getLogger(TestController.class);

    @RequestMapping(method = RequestMethod.GET,value="seat/book")
    public ResponseEntity<String> bookSeats(HttpServletRequest request, HttpServletResponse response){
        //String seat = request.getHeader("seat");
        HttpHeaders responseHeaders = new HttpHeaders();
        String bookingId = UUID.randomUUID().toString();
        BasicResponse responseJson = new BasicResponse();
        try{
            if(bookingSystemDao.book(bookingId)){
                //Seat is booked
                responseJson.setBookingId(bookingId);
                return new ResponseEntity<String>(gson.toJson(responseJson), responseHeaders, HttpStatus.OK);
            }else{
                responseJson.setStatusCode(202);
                responseJson.setStatus("FAILURE");
                responseJson.setMessage("No Seats Found");
                return new ResponseEntity<String>(gson.toJson(responseJson), responseHeaders, HttpStatus.NOT_FOUND);
                //Seat is not booked
            }
        }catch(Exception e){
            logger.error(Arrays.toString(e.getStackTrace()));
            responseJson.setStatusCode(102);
            responseJson.setStatus("FAILURE");
            responseJson.setMessage("Internal Error");
            return new ResponseEntity<String>(gson.toJson(responseJson), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="seat/cancel/bookingIdentifier")
    public ResponseEntity<String> cancelBooking(HttpServletRequest request, HttpServletResponse response){
        String bookingId = request.getHeader("booking_id");
        HttpHeaders responseHeaders = new HttpHeaders();
        BasicResponse responseJson = new BasicResponse();
        try{
            if(bookingSystemDao.cancelBooking(bookingId)){
                responseJson.setStatus("SUCCESS");
                responseJson.setStatusCode(101);
                responseJson.setMessage("Booking cancelled");
                return new ResponseEntity<String>(gson.toJson(responseJson), responseHeaders, HttpStatus.OK);
            }else{
                responseJson.setStatusCode(204);
                responseJson.setStatus("FAILURE");
                responseJson.setMessage("No Booking Found");
                return new ResponseEntity<String>(gson.toJson(responseJson), responseHeaders, HttpStatus.OK);
            }
        }catch(Exception e){
            logger.error(Arrays.toString(e.getStackTrace()));
            responseJson.setStatusCode(102);
            responseJson.setStatus("FAILURE");
            responseJson.setMessage("Internal Error");
            return new ResponseEntity<String>(gson.toJson(responseJson), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET,value="seat")
    public ResponseEntity<String> getAvailableSeats(HttpServletRequest request, HttpServletResponse response){
        BasicResponse responseJson = new BasicResponse();
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            long seats = bookingSystemDao.getNumberOfavailableSeats();
            //logger.error("printing test logs");
            responseJson.setSeats(seats);
            return new ResponseEntity<String>(gson.toJson(responseJson), responseHeaders, HttpStatus.OK);
        }catch(Exception e){
            logger.error(Arrays.toString(e.getStackTrace()));
            responseJson.setStatusCode(102);
            responseJson.setStatus("FAILURE");
            responseJson.setMessage("Internal Error");
            return new ResponseEntity<String>(gson.toJson(responseJson), responseHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    }
