package be.howest.nmct.evaluationstudents.admin;

public class ModulePunt {

	private String module;
	private double score;
	private int aantalStudiePunten = 6;

	public ModulePunt(String module, double score) {
		this.module = module;
		this.score = score;
	}

	public ModulePunt(String module, int aantalStudiePunten, double score) {
		this.module = module;
		this.score = score;
		this.aantalStudiePunten = aantalStudiePunten;
	}

	public int getAantalStudiePunten() {
		return aantalStudiePunten;
	}

	public void setAantalStudiePunten(int aantalStudiePunten) {
		this.aantalStudiePunten = aantalStudiePunten;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "ModulePunt [module=" + module + ", score=" + score + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModulePunt other = (ModulePunt) obj;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		return true;
	}

}
