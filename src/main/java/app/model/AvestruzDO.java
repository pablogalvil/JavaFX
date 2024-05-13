package app.model;

public class AvestruzDO {
	private int idAvestruz;
	private String nombre;
	private String nickGuerra;
	private int edad;
	private int altura;
	private int nivelMalaLeche;
	private int numHuevos;

	public AvestruzDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AvestruzDO(int idAvestruz, String nombre, String nickGuerra, int edad, int altura, int nivelMalaLeche,
			int numHuevos) {
		super();
		this.idAvestruz = idAvestruz;
		this.nombre = nombre;
		this.nickGuerra = nickGuerra;
		this.edad = edad;
		this.altura = altura;
		this.nivelMalaLeche = nivelMalaLeche;
		this.numHuevos = numHuevos;
	}

	/**
	 * @return the idAvestruz
	 */
	public int getIdAvestruz() {
		return idAvestruz;
	}

	/**
	 * @param idAvestruz the idAvestruz to set
	 */
	public void setIdAvestruz(int idAvestruz) {
		this.idAvestruz = idAvestruz;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nickGuerra
	 */
	public String getNickGuerra() {
		return nickGuerra;
	}

	/**
	 * @param nickGuerra the nickGuerra to set
	 */
	public void setNickGuerra(String nickGuerra) {
		this.nickGuerra = nickGuerra;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the altura
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * @param altura the altura to set
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}

	/**
	 * @return the nivelMalaLeche
	 */
	public int getNivelMalaLeche() {
		return nivelMalaLeche;
	}

	/**
	 * @param nivelMalaLeche the nivelMalaLeche to set
	 */
	public void setNivelMalaLeche(int nivelMalaLeche) {
		this.nivelMalaLeche = nivelMalaLeche;
	}

	/**
	 * @return the numHuevos
	 */
	public int getNumHuevos() {
		return numHuevos;
	}

	/**
	 * @param numHuevos the numHuevos to set
	 */
	public void setNumHuevos(int numHuevos) {
		this.numHuevos = numHuevos;
	}

	@Override
	public String toString() {
		return "AvestruzDO [idAvestruz=" + idAvestruz + ", nombre=" + nombre + ", nickGuerra=" + nickGuerra + ", edad="
				+ edad + ", altura=" + altura + ", nivelMalaLeche=" + nivelMalaLeche + ", numHuevos=" + numHuevos + "]";
	}

}
