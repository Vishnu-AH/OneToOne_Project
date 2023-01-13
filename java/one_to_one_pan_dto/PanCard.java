package one_to_one_pan_dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PanCard {
	@Id
	private int panId;
	private String panName;
	private String panAddress;
	
	
	@Override
	public String toString() {
		return "PanCard [panId=" + panId + ", panName=" + panName + ", panAddress=" + panAddress + "]";
	}
	public int getPanId() {
		return panId;
	}
	public void setPanId(int panId) {
		this.panId = panId;
	}
	public String getPanName() {
		return panName;
	}
	public void setPanName(String panName) {
		this.panName = panName;
	}
	public String getPanAddress() {
		return panAddress;
	}
	public void setPanAddress(String panAddress) {
		this.panAddress = panAddress;
	}
}