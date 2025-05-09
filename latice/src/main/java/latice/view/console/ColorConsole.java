package latice.view.console;

public enum ColorConsole {
	ERROR("\u001B[31m"),
	WARNING("\u001B[33m"),
	INFO("\u001B[34m"),
	SUCCESS("\u001B[32m");
	
	private final String code;
	
	ColorConsole(String string) {
		this.code = string;
	}
	
	public String getCode() {
		return code;
	}

}
