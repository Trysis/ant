package model;

public class Vecteur {
	private double x,y;
	private double magnitude=1;
	private double cap=-1;
	//Constructeur
	public Vecteur() {
		this(0,0);
	}
	public Vecteur(Vecteur vecteur) {
		this(vecteur.getX(),vecteur.getY(),vecteur.getMagnitude(),vecteur.getCap());
	}
	public Vecteur(double magnitude) {
		this();
		this.magnitude=magnitude;
	}
	public Vecteur(double x,double y) {
		this.x=x;
		this.y=y;
	}
	public Vecteur(double x,double y,double magnitude) {
		this(x,y);
		this.magnitude=magnitude;
	}
	public Vecteur(double x,double y,double magnitude,double cap) {
		this(x,y,magnitude);
		this.cap=cap;
	}
	//Getter
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public double getMagnitude() {
		return magnitude;
	}
	public double getCap() {
		return this.cap;
	}
	//Setter
	public void setX(double x) {//Set x
		this.x=x;
	}
	public void setY(double y) {//Set y
		this.y=y;
	}
	public void setVecteur(double x,double y) {//Set x et y
		setX(x);
		setY(y);
	}
	public void setMagnitude(double valeur) {
		this.magnitude=Math.abs(valeur);
	}
	public void setCap(double valeur) {
		cap=valeur;
	}
	//Calculs numériques sur vecteur
	//Additions sur vecteurs
	public void addVecteur(double x,double y) {
		setX(this.x+x);
		setY(this.y+y);
	}
	public void addVecteur(Vecteur vecteur) {
		addVecteur(vecteur.getX(),vecteur.getY());
	}
	//Soustractions sur vecteurs
	public void subVecteur(double x,double y) {
		addVecteur(-x,-y);
	}
	public void subVecteur(Vecteur vecteur) {
		subVecteur(vecteur.getX(),vecteur.getY());
	}
	//Multiplications sur vecteurs
	public void multiplyVecteur(double x) {//Applique la multiplication sur le vecteur courant
		multiplyVecteur(x,x);
	}
	public void multiplyVecteur(double x,double y) {
		setX(this.x*x);
		setY(this.y*y);
	}
	public void multiplyVecteur(Vecteur vecteur) {//
		multiplyVecteur(vecteur.getX(),vecteur.getY());
	}
	//Image en x et y du vecteur
	public void opposateX() {//Vecteur mirroir en x
		x*=-1;
	}
	public void opposateY() {//Vecteur mirroir en y
		y*=-1;
	}
	public void opposateVecteur() {//Vecteur mirroir en x et y
		opposateX();
		opposateY();
	}
	//Normalisation (longueur==1)
	public Vecteur normaliser() {//Ramène le vecteur sur des normes (rayon =1)
		double longueur=longueurVecteur();
		double x_b=0,y_b=0;
		if(longueur!=0) {
			x_b=x/longueur;
			y_b=y/longueur;
		}
		return new Vecteur(x_b,y_b);
	}
	//Longueur 
	public double longueurVecteur() {//Longueur absolue du vecteur
		return Math.sqrt(getX()*getX()+getY()*getY());
	}
	public String toString() {
		return "["+this.getX()+";"+this.getY()+"]";
	}

}
