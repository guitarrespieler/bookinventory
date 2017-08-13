package model;

public class Place {
	private String room = "";
	
	private String bookCase = "";
	
	private String bookShelf = "";
	
	@Override
	public int hashCode() {
		return (room + bookCase + bookShelf).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Place)) {
			return false;
		}
		Place other = (Place) obj;
		if (bookCase == null) {
			if (other.bookCase != null) {
				return false;
			}
		} else if (!bookCase.equals(other.bookCase)) {
			return false;
		}
		if (bookShelf == null) {
			if (other.bookShelf != null) {
				return false;
			}
		} else if (!bookShelf.equals(other.bookShelf)) {
			return false;
		}
		if (room == null) {
			if (other.room != null) {
				return false;
			}
		} else if (!room.equals(other.room)) {
			return false;
		}
		return true;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getBookCase() {
		return bookCase;
	}

	public void setBookCase(String bookCase) {
		this.bookCase = bookCase;
	}

	public String getBookShelf() {
		return bookShelf;
	}

	public void setBookShelf(String bookShelf) {
		this.bookShelf = bookShelf;
	}
	
}
