package org.second.secondseminar.exception.model;

import org.second.secondseminar.exception.Error;

public class NotFoundException extends CustomException {
	public NotFoundException(Error error, String message) {
		super(error, message);
	}
}
