package com.example.NotificationPublisher.exception;

public class NotificationPublisherException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8791528446713472023L;
	private final String errCode;
	private final String errDescription;

	public static final String EXCEPTION_DATA_NOT_FOUND = "exception.data.nullBody";

	public NotificationPublisherException(final String errCode, final String errDescription) {
		super(errDescription);
		this.errCode = errCode;
		this.errDescription = errDescription;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificationPublisherException [errCode=").append(errCode).append(", errDescription=").append(errDescription)
				.append(", detailedMessage=").append(getMessage()).append("]");
		return builder.toString();
		
	}

}
