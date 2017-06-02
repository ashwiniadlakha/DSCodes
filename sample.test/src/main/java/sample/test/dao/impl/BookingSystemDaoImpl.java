package sample.test.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import sample.test.dao.BookingSystemDao;

public class BookingSystemDaoImpl implements BookingSystemDao{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	private PlatformTransactionManager transactionManager;

    public static final String STATUS_DONE = "DONE";
    public static final String STATUS_CANCEL = "CANCEL";

	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		      this.transactionManager = transactionManager;
	}

	public boolean book(String bookingId) throws Exception{
		TransactionDefinition def = new DefaultTransactionDefinition();
	    TransactionStatus status = transactionManager.getTransaction(def);
	    Long seatId = null;
	    try{
	    	try{
		    	String sql = "select seat_id from seats where is_booked=false limit 1";
	            seatId = jdbcTemplateObject.queryForLong(sql);
	    	}catch(Exception e){
	    		if(getNumberOfavailableSeats()==0l){
	    			transactionManager.rollback(status);
	    			return false;
	    		}else{
	    			System.out.println("Error in creating record, rolling back");
	    	        transactionManager.rollback(status);
	    	        throw e;
	    		}
	    	}
            String SQL = "update seats set booking_id=?,is_booked=1 where seat_id=? and is_booked=0";
            Object obj[] = {new Object(), new Object()};
            obj[0]= bookingId;
            obj[1]=seatId;
            int updateStatus = jdbcTemplateObject.update(SQL,obj);
            if(updateStatus==1){
                String sql2 = "insert into bookings(booking_id, booking_status) values(?, ?)";
                Object obj2[] = {new Object(),new Object()};
                obj2[0]= bookingId;
                obj2[1] = STATUS_DONE;
                jdbcTemplateObject.update(sql2, obj2);
                transactionManager.commit(status);
                return true;
            }else{
                transactionManager.rollback(status);
                return false;
            }
	    }catch(Exception e){
	    	System.out.println("Error in creating record, rolling back");
	        transactionManager.rollback(status);
	        throw e;
	    }
	}

    
    public long getNumberOfavailableSeats() throws Exception{
		try{
            String sql = "select count(*) from seats where is_booked=false";
            return jdbcTemplateObject.queryForLong(sql);

        }catch(Exception e){
            System.out.println("Error in creating record, rolling back");
            throw e;
        }
	}

    public boolean cancelBooking(String bookingId) throws Exception{
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        try{
            String SQL = "update seats set is_booked=0 where booking_id=? and is_booked=1";
            Object obj[] = {new Object()};
            obj[0]= bookingId;
            int updateStatus = jdbcTemplateObject.update(SQL,obj);
            if(updateStatus==1){
                String sql2 = "update bookings set booking_status='" + STATUS_CANCEL + "' where booking_id= ?";
                Object obj2[] = {new Object()};
                obj2[0]= bookingId;
                jdbcTemplateObject.update(sql2, obj2);
                transactionManager.commit(status);
                return true;
            }else{
                transactionManager.rollback(status);
                return false;
            }
        }catch(Exception e){
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }
    }
	
	
}
