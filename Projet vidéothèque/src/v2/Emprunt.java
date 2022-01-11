package v2;

import java.sql.Date;

public class Emprunt {
	
	Date dateDeb;
	Date dateFinLocation;
	
	public Emprunt(Date dateDeb, Date dateFinLocation) {
		super();
		this.dateDeb = dateDeb;
		this.dateFinLocation = dateFinLocation;
	}

	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	public Date getDateFinLocation() {
		return dateFinLocation;
	}

	public void setDateFinLocation(Date dateFinLocation) {
		this.dateFinLocation = dateFinLocation;
	}

	@Override
	public String toString() {
		return "Emprunt [dateDeb=" + dateDeb + ", dateFinLocation=" + dateFinLocation + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emprunt other = (Emprunt) obj;
		if (dateDeb == null) {
			if (other.dateDeb != null)
				return false;
		} else if (!dateDeb.equals(other.dateDeb))
			return false;
		if (dateFinLocation == null) {
			if (other.dateFinLocation != null)
				return false;
		} else if (!dateFinLocation.equals(other.dateFinLocation))
			return false;
		return true;
	}
	
	
	

}
