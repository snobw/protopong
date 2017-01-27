package Object;



public class Raquette {
	private int posX=0;
	private int posY=0;
	private int pPosX=0;
	private int pPosY=0;
	private int directionX=0;
	private int directionY=0;
	private int velocity=0;
	private int numHit=0;
	private int color=0;
	private String URLtexture;
//	private Texture texture;
	private int sizeW, sizeH=0;
	private int posAreaX1,	posAreaY1,	posAreaX2,	posAreaY2;
	
	/**
	 * 
	 * @param width : size (px)
	 * @param height : size (px)
	 * @param posInitX : start position on X (px)
	 * @param posInitY : start position on Y (px)
	 * @param colorInit : color of object
	 * @param pathTexture : texture of object
	 */
	private Raquette(int width, int height,int posInitX, int posInitY, int colorInit,String pathTexture){
		posAreaX1=0;
		posAreaY1=0;
		posAreaX2=100;
		posAreaY2=200;
		setPosX(posInitX);
		setPosY(posInitY);
		pPosX=posInitX;
		pPosY=posInitY;	
		setSize(width,height);
		setColor(colorInit);	
		//changeTexture(pathTexture);
	}
	
	/**
	 * 
	 * @param width
	 * @param height
	 * @param posInitX
	 * @param posInitY
	 * @param colorInit
	 */
	public Raquette(int width, int height,int posInitX, int posInitY, int colorInit){
	this( width,  height, posInitX,  posInitY,  colorInit, null);
}
	/**
	 * 
	 * @param width
	 * @param height
	 * @param posInitX
	 * @param posInitY
	 * @param pathTexture
	 */
	public Raquette(int width, int height, int posInitX, int posInitY, String pathTexture){
	this( width,  height, posInitX,  posInitY,  0, pathTexture);
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
	/**
	 * 
	 * @param value
	 */
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
	 * @param value : position a finger (px)
	 */
	public void setDirectionX(int value){
		if (directionX>value)//move vers la gauche
			setPosX(pPosX-1*velocity);
		if (directionX<value)//move vers la droite
			setPosX(pPosX+1*velocity);
		if (directionX==value)//aucun deplacement
			setPosX(pPosX);
		directionX=value;
	}
	
	/**
	 * move a raquette with a finger position
	 * @param value : position a finger (px)
	 */
	public void setDirectionY(int value){
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
	public void setDirection(int value[]){
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
	public int[] getPos(){
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
	public void setVelocity(int value){
		velocity=value*10;
	}
	/**
	 * 
	 * @return
	 */
	protected int getVelocity(){
		return velocity;
	}
	
	protected void setSize(int width, int height){
		sizeW=width;
		sizeH=height;
		//TODO : appel a la fonction private pour dessiner ou redimensionner l'objet
	}
	
	public boolean drawRaquette(){
		//TODO : dessiner si l'objet est visible lors des setPosition
		return true;
	}
	
	public void setSizeAreaOfGame(int X1, int Y1, int X2, int Y2){
		posAreaX1=X1;
		posAreaY1=Y1;
		posAreaX2=X2;
		posAreaY2=Y2;
	}
}
