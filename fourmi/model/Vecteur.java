package model;

public class Vecteur {
	private double x,y;
	private double x_capped,y_capped;
	private double cap=-1;
	private boolean capped;
	//Constructeur
	public Vecteur() {
		this(0,0);
	}
	public Vecteur(Vecteur vecteur) {
		this(vecteur.getX(),vecteur.getY(),vecteur.getCap());
	}
	public Vecteur(double magnitude) {
		this();
	}
	public Vecteur(double x,double y) {
		this.x=x;
		this.y=y;
	}
	public Vecteur(double x,double y,double cap) {
		this(x,y);
		this.cap=cap;
	}
	//Getter
	public double getX() {
		return capped ? this.x_capped:this.x;
	}
	public double getY() {
		return capped ? this.y_capped:this.y;
	}
	public double getCap() {
		return this.cap;
	}
	//Setter
	public void setX(double x) {//Set x
		this.x=x;
		cap();
	}
	public void setY(double y) {//Set y
		this.y=y;
		cap();
	}
	public void setVecteur(double x,double y) {//Set x et y
		setX(x);
		setY(y);
	}
	public boolean isCapped() {
		return capped;
	}
	public void setCap(double valeur) {
		cap=valeur;
		if(cap>0)capped=true;
		else capped=false;
	}
	public void removeCap() {
		setCap(-1);
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
		double x_b=x,y_b=y;
		if(longueur!=0) {
			x_b/=longueur;
			y_b/=longueur;
		}
		System.out.println(x_b);
		return new Vecteur(x_b,y_b);
	}
	public void cap() {
		if(cap<0)return;
		Vecteur l2=normaliser();
		double l2_lenght = longueurVecteur();
		if(l2_lenght>cap) {
			x_capped=l2.x*cap;
			y_capped=l2.y*cap;
		}
	}
	//Longueur 
	public double longueurVecteur() {//Longueur absolue du vecteur
		return Math.sqrt(this.x*this.x+this.y*this.y);
	}
	public String toString() {
		return "["+this.getX()+";"+this.getY()+"]";
	}

}
