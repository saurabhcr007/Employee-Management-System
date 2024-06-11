package ltts.com.model;

public class JwtResponse {
	private String jwtTolken;
	private String username;

	public JwtResponse() {
		super();
	}

	public JwtResponse(String jwtTolken, String username) {
		super();
		this.jwtTolken = jwtTolken;
		this.username = username;
	}

	public String getJwtTolken() {
		return jwtTolken;
	}

	public void setJwtTolken(String jwtTolken) {
		this.jwtTolken = jwtTolken;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}