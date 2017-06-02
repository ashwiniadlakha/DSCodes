package sample.test.entity;

/**
 * Created by ashwani on 04/07/16.
 */
public class BasicResponse {
    Integer statusCode;
    String message;
    String status;
    String booking;
    Long seats;

    public long getSeats() {
		return seats;
	}

	public void setSeats(long seats) {
		this.seats = seats;
	}

	public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookingId() {
        return booking;
    }

    public void setBookingId(String bookingId) {
        this.booking = bookingId;
    }
}
