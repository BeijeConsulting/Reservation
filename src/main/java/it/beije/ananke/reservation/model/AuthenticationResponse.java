package it.beije.ananke.reservation.model;

public class AuthenticationResponse {

	 private String jwtToken;
	 
	 public AuthenticationResponse() {
			super();
		}
	

	public AuthenticationResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	 
	 
}
