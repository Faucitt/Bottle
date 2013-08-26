package uni.me.faucitt.bottle.exceptions;

import uni.me.faucitt.bottle.Bottle;

public class BottleException extends Exception {
	
	private static final long serialVersionUID = -506562054624056192L;
	private String reason;
	
	public BottleException() {
		Bottle.bottleExceptions.add(this);
	}
	
	public BottleException(String reason) {
		Bottle.bottleExceptions.add(this);
		this.reason = reason;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
