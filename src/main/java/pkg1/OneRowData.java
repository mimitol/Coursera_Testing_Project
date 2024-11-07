package pkg1;

public class OneRowData {
	    String fullname, emailAddress, password;
	    String expectedResult;
	    String actualResult, FAIL_PASS;
	    int theRowNumberItCameFrom;

	    @Override
	    public String toString() {
	        return "OneRowData [fullName=" + fullname + ", emailAddress=" + emailAddress + ", password=" + password + ",expectedResult=" + expectedResult + 
	        ",  actualResult=" + actualResult + ", FAIL_PASS=" + FAIL_PASS + 
	        ", theRowNumberItCameFrom=" + theRowNumberItCameFrom + "]";
	    }
	
}
