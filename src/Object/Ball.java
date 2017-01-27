package Object;

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream; 
import java.util.Locale;
//import java.lang.*;
import org.newdawn.slick.*;
import org.newdawn.slick.opengl.*;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Ball {
	/*
	 * Declaration variable
	 */
	private int posX=0;
	private int posY=0;
	private int pPosX=0;
	private int pPosY=0;
	private int directionX=0;
	private int directionY=0;
	private int velocity=0;
	private int numHit=0;
		
	private int rayon=5;	
	private int color=0;
	private String URLtexture;
	private int numberSprite=0;
	private int colorSprite=0;
	private int effect=0;
	private Texture texture;	
	private int posAreaX1,	posAreaY1,	posAreaX2,	posAreaY2;
		
	/*
	 * Declaration function
	 */
	/**
	 * 
	 * @param rayonInit
	 * @param posInitX
	 * @param posInitY
	 * @param colorInit
	 * @param pathTexture
	 */
	private Ball(int rayonInit,int posInitX, int posInitY, int colorInit,String pathTexture){
			posAreaY1=0;
			posAreaX2=100;
			posAreaY2=200;	
			posX=posInitX;
			posY=posInitY;
			pPosX=posInitX;
			pPosY=posInitY;
			rayon=rayonInit;
			color=colorInit;	
			changeSprite(0,0);
			changeTexture(pathTexture);
		}
	/**
	 * 
	 * @param rayonInit
	 * @param posInitX
	 * @param posInitY
	 * @param colorInit
	 */
	public Ball(int rayonInit,int posInitX, int posInitY, int colorInit){
		this(rayonInit, posInitX,  posInitY,  colorInit, "");
	}

	/**
	 * 
	 * @param rayonInit
	 * @param posInitX
	 * @param posInitY
	 * @param pathTexture
	 */
	public Ball(int rayonInit, int posInitX, int posInitY, String pathTexture){
		this(rayonInit, posInitX,  posInitY,  0, pathTexture);
	}
	public void setSizeAreaOfGame(int X1, int Y1, int X2, int Y2){
		posAreaX1=X1;
		posAreaY1=Y1;
		posAreaX2=X2;
		posAreaY2=Y2;
	}
	
	/**
	 * 
	 * @param numSprite
	 * @param colorSprite
	 */
	protected void changeSprite(int numSprite, int colorSprite){
		numberSprite=numSprite;
		this.colorSprite=colorSprite;
		//TODO : creer les sprites
	}	
	/**
	 * 
	 * @param path
	 */
	private void changeTexture(String path) {//throws IOException{
		if(URLtexture!=null)
			URLtexture = null;
		
		URLtexture = new String(path);	
		//TODO : charger la texture
		//TODO: retourner un bool pour confirmer le chargement de la texture		
		//texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("URLtexture"));
		 
	}

	/**
	 * 
	 * @param value
	 */
	protected void setPosX(int value){
		pPosX=posX;
		if(value<posAreaX1)
			value=posAreaX1;
		if(value>posAreaX2)
			value=posAreaX2;
		posX=value;
	}
	protected void setPosY(int value){
		pPosY=posY;
		if(value<posAreaY1)
			value=posAreaY1;
		if(value>posAreaY2)
			value=posAreaY2;
		posY=value;
	}
	/**
	 * 
	 * @param value
	 */
	private void setDirectionX(int value){
		if (directionX>value)//move vers la gauche
			setPosX(pPosX-1*velocity);
		if (directionX<value)//move vers la droite
			setPosX(pPosX+1*velocity);
		if (directionX==value)//aucun deplacement
			setPosX(pPosX);
		directionX=value;
	}
	/**
	 * 
	 * @param value
	 */
	private void setDirectionY(int value){
		if (directionY>value)//move vers la gauche
			setPosY(pPosY-1*velocity);
		if (directionY<value)//move vers la droite
			setPosY(pPosY+1*velocity);
		if (directionY==value)//aucun deplacement
			setPosY(pPosY);
		directionY=value;			
	}
	/**
	 * 
	 * @param value
	 */
	private void setDirection(int value[]){
		setDirectionX(value[0]);
		setDirectionY(value[1]);
	}
	/**
	 * 
	 * @param value
	 */
	protected void setPos(int value[]){
		setPosX(value[0]);
		setPosY(value[1]);
	}
	/**
	 * 
	 * @param value
	 */
	protected void setRayon(int value){
		rayon=value;
	}
	/**
	 * 
	 * @param value
	 */
	protected void setColor(int value){
		color=value;
	}
	
	/**
	 * 
	 * @return
	 */
	protected int getPosX(){
		return posX;
	}
	/**
	 * 
	 * @return
	 */
	protected int getPosY(){
		return posY;
	}
	/**
	 * 
	 * @return
	 */
	protected int[] getPos(){
		int value[]={posX,posY};
		return value;		
	}
	/**
	 * 
	 * @return
	 */
	protected int[] getPrevPos(){
		int value[]={pPosX,pPosY};
		return value;		
	}	
	/**
	 * 
	 * @return
	 */
	protected int[] getDirection(){
		int value[]={directionX,directionY};
		return value;		
	}
	
	/**
	 * 
	 * @return
	 */
	protected int getDirectionX(){
		return directionX;
	}
	/**
	 * 
	 * @return
	 */
	protected int getDirectionY(){
		return directionY;		
	}
	/**
	 * 
	 * @param value
	 */
	protected void setVelocity(int value){
		velocity=value;
	}
	/**
	 * 
	 * @return
	 */
	protected int getVelocity(){
		return velocity;
	}
	
/**
 * 
 * @param effectOfBall
 * @param timeToChangeMS
 */
	protected void changeState(int effectOfBall,int timeToChangeMS ){
		effect=effectOfBall;
		//TODO : prendre en compte le temps avant changement d'état
	}
	/**
	 * 
	 */
	protected void drawBall(){
	
	}
	/**
	 * 
	 * @param numEffect
	 */
	private void effectBall(int numEffect){
		//TODO : faire les effets
		switch (numEffect){
		case 0: String i="";
			break;
		case 1:
		case 2:
		case 3:
			
		}
		
		
	}

}
