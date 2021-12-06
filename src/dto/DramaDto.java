package dto;

public class DramaDto {
	
	private boolean next = true;

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = !next;
	}
}
