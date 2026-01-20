import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class player extends Actor
{
    
    public void act()
    {
        // moveset:
        if(Greenfoot.isKeyDown("a")){
            setRotation(-3);
            move(-2);
        }
        if(Greenfoot.isKeyDown("d")){
            setRotation(3);
            move(2);
        }
        
        // collision:
        Grass grass = new Grass();
        if(getObjectsAtOffset(0,5, grass) != grass){
            
        }
    }
}
