//Javier Enrique Luna Díaz 201703084
package proyectoconcurrente;
import javax.swing.*;

public class Ball extends Thread{
    private PanelBall panel;
    private MiX x;
    private MiY y;
    private int velX; //velocidad o aumento de x
    private int velY; //velocidad o aumento de y
    
    Ball(PanelBall panel, MiX x, MiY y){
        this.panel = panel;
        this.x = x;
        this.y = y;
        this.velX = 5; //La variable velocidad sirve para controlar la dirección del movimiento
        this.velY = 5;
    
    }
    
    /*public void run(){
        while (true){
            try{
                x.setX(x.getX()+5);
                y.setY(y.getY()+5);
                panel.repaint();
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }*/
    
    public void run(){
        while(true){
            dibujar(this.velX, this.velY);
            if(this.x.getX() > 510){ //Si la coordenada x va a superar los límites invertimos el movimiento
                this.setVelX(-this.getVelX());
            }
            if(this.y.getY() > 300){
                this.setVelY(-this.getVelY()); //Si la coordenada y va a superar los límites invertimos el movimiento
            }
            if(this.x.getX() < 0 ){
                this.setVelX(-this.getVelX());
            }
            if(this.y.getY() < 0 ){
                this.setVelY(-this.getVelY());
            }
        }
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
    
    public void dibujar(int velX, int velY){
        try{    
            this.x.setX(this.x.getX() + velX);
            this.y.setY(this.y.getY() + velY);
            panel.repaint();
            Thread.sleep(100);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
