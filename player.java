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

        // getObjectsAtOffset​(int dx, int dy, java.lang.Class<A> cls)
        if((getObjectsAtOffset(0, 20, null).size()) >= 1){
            
            
        }
            
        //}
    }
    
    
    public void collision(String dir){
        // dir as l/r/u/d
        // 1- get dir as offset val (x/y)
        // 2- reduce moveset
        
        //1:
        int offset = 0;
        switch(dir){
            case "l":
                offset = -12;
                break;
            case "r":
                offset = 12;
                break;
            case "u":
                offset = -20;
                break;
            case "d":
                offset = 20;
                break;
            default:
                offset = 0;
            }
        
        //2:
        
            
            
        }
    }

