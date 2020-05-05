
public class Player {

	private String name;
	private boolean isDryer = false;
	private boolean isRinser = false;

	public Player(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setDryer() {
		isDryer = true;

	}

	public void setRinser() {
		isRinser = true;

	}

	public boolean isRinser() {
		return isRinser;

	}

	public boolean isDryer() {
		return isDryer;

	}

	public void removeBuff() {
		if (isRinser()) {
			isRinser = false;
		}

		if (isDryer()) {
			isDryer = false;
		}
	}

}