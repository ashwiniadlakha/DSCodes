package sample.test.dao;

import javax.sql.DataSource;

public interface BookingSystemDao {

	void setDataSource(DataSource ds);
	
	boolean book(String bookingId) throws Exception;

    boolean cancelBooking(String bookingId) throws Exception;
	
	long getNumberOfavailableSeats() throws Exception;
}
