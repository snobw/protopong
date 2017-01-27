package World;
import Object.*;
import Object.Raquette;

public class World {
	private Ball[] balls=null;
	private Raquette raquette=null;
	//private Physics physics;
	private int posX1,posY1,posX2,posY2=0;
	private int sizeW,sizeH=0;
	private int gravity=0;
	private String URLtexture;
	
	/**
	 * 
	 * @param X
	 * @param Y
	 * @param H
	 * @param W
	 * @param color
	 * @param IDworld
	 */
	public World(int X1, int Y1, int X2, int Y2, int color, int IDworld){
		posX1=X1;
		posY1=Y1;
		posX2=X2;
		posY2=Y2;
		sizeW=X2-X1;
		sizeH=Y2-Y1;
		gravity=IDworld;
		raquette=null;
		balls=null;		
		//TODO : creer le vaisseau (raquette)
		//TODO : dessiner le monde
	}
	
	private void changeTexture(String path) {//throws IOException{
		if(URLtexture!=null)
			URLtexture = null;
		
		URLtexture = new String(path);	
		//TODO : charger la texture
		//TODO: retourner un bool pour confirmer le chargement de la texture		
		//texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("URLtexture"));		 
	}
	
	
	private void drawWorld(){
		//TODO : charger la texture
		//TODO : dessiner les limites
		
	}
	
	protected int numberOfBall(){
		int value=balls.length;
		return value;
	}
	
	/**
	 * 
	 * @param idBall
	 * @return
	 */
	protected boolean deleteBall(int idBall){
		int numberBall=numberOfBall();
		if(idBall<=numberBall){
			balls[idBall]=null;			
			for (int i=idBall+1; i<numberBall; i++)
			{
				balls[i-1]=balls[i];
			}
			balls[numberBall]=null;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * 
	 * @param rayonInit
	 * @param posInitX
	 * @param posInitY
	 * @param pathTexture
	 */
	protected void addBall(int rayonInit, int posInitX, int posInitY, String pathTexture){
		int numberBall=numberOfBall();
		balls[numberBall]=new Ball(rayonInit, posInitX, posInitY, pathTexture);		
	}
	/**
	 * 
	 * @param rayonInit
	 * @param posInitX
	 * @param posInitY
	 * @param colorInit
	 */
	protected void addBall(int rayonInit,int posInitX, int posInitY, int colorInit){
		int numberBall=numberOfBall();
		balls[numberBall]=new Ball(rayonInit, posInitX, posInitY, colorInit);	
	}
	/**
	 * 
	 * @param width
	 * @param height
	 * @param colorInit
	 * @return
	 */
	protected boolean addRaquette(int width, int height, int colorInit){		
		if(raquette!=null)
			return false;
		raquette=new Raquette( width,  height, sizeW/2,  sizeH/10,  colorInit);
		raquette.setSizeAreaOfGame(posX1, posY1, posX2, posY2);
		return true;
	}
	/**
	 * 
	 * @param width
	 * @param height
	 * @param pathTexture
	 * @return
	 */
	protected boolean addRaquette(int width, int height, String pathTexture){		
		if(raquette!=null)
			return false;
		raquette=new Raquette( width,  height, sizeW/2,  sizeH/10,  pathTexture);
		raquette.setSizeAreaOfGame(posX1, posY1, posX2, posY2);
		return true;
	}
	/**
	 * 
	 * @param position
	 * @return
	 */
	protected boolean moveRaquette(int position){
		if(raquette==null)return false;		
			raquette.setVelocity(gravity);
			raquette.setDirectionX(position);

			raquette.drawRaquette();
		return true;
	}

}
