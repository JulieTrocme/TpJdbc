package fr.univ_amu.iut.beans;




public class Prof{
	private int numProf;
	private String nomProf;
	private String prenomProf;
	private String adrProf;
	private String cpProf;
	private String villeProf;
	private Module matSpec;

	public Prof() {
	}

	public String getAdrProf() {
		return adrProf;
	}

	public String getCpProf() {
		return cpProf;
	}

	public Module getMatSpec() {
		return matSpec;
	}

	public String getNomProf() {
		return nomProf;
	}

	public int getNumProf() {
		return numProf;
	}

	public String getPrenomProf() {
		return prenomProf;
	}

	public String getVilleProf() {
		return villeProf;
	}

	public void setAdrProf(String adrProf) {
		this.adrProf = adrProf;
	}

	public void setCpProf(String cpProf) {
		this.cpProf = cpProf;
	}

	public void setMatSpec(Module matSpec) {
		this.matSpec = matSpec;
	}

	public void setNomProf(String nomProf) {
		this.nomProf = nomProf;
	}

	public void setNumProf(int numProf) {
		this.numProf = numProf;
	}

	public void setPrenomProf(String prenomProf) {
		this.prenomProf = prenomProf;
	}

	public void setVilleProf(String villeProf) {
		this.villeProf = villeProf;
	}

	@Override
	public String toString() {
		return "Prof [numProf=" + numProf + ", "
				+ (nomProf != null ? "nomProf=" + nomProf + ", " : "")
				+ (prenomProf != null ? "prenomProf=" + prenomProf + ", " : "")
				+ (adrProf != null ? "adrProf=" + adrProf + ", " : "")
				+ (cpProf != null ? "cpProf=" + cpProf + ", " : "")
				+ (villeProf != null ? "villeProf=" + villeProf + ", " : "")
				+ (matSpec != null ? "matSpec=" + matSpec.getCode() : "") + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Prof prof = (Prof) o;

		if (numProf != prof.numProf) return false;
		if (!nomProf.equals(prof.nomProf)) return false;
		if (!prenomProf.equals(prof.prenomProf)) return false;
		if (!adrProf.equals(prof.adrProf)) return false;
		if (!cpProf.equals(prof.cpProf)) return false;
		if (!villeProf.equals(prof.villeProf)) return false;
		return matSpec.equals(prof.matSpec);
	}

	@Override
	public int hashCode() {
		int result = numProf;
		result = 31 * result + nomProf.hashCode();
		result = 31 * result + prenomProf.hashCode();
		result = 31 * result + adrProf.hashCode();
		result = 31 * result + cpProf.hashCode();
		result = 31 * result + villeProf.hashCode();
		result = 31 * result + matSpec.hashCode();
		return result;
	}
}
