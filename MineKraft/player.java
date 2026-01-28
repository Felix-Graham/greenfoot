import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class player extends Actor
{
    
    
    public void gravity(){
        // if underneath is nothing then fall by 1
        if(getObjectsAtOffset(0, 20, null).size() < 1 || getY() > 100 ){
            setLocation(getX(), (getY()+1));        
        } else{
        }
    }
    
    public int collideDown(){
        if(getObjectsAtOffset(0, 20, null).size() == 0){
            return 1;
        } else{
            return -1;
        }
    }
    
    public int collideLeft(){
        if(getObjectsAtOffset(-20, 0, null).size() == 0){
            return 1;
        } else{
            return -1;
        }
    }
    
    public int collideRight(){
        if(getObjectsAtOffset(20, 0, null).size() == 0){
            return 1;
        } else{
            return -1;
        }
    }
    
    public int collideUp(){
        if(getObjectsAtOffset(0, -20, null).size() == 0){
            return 1;
        } else{
            return -1;
        }
    }
    
    public void moveset(){
        if(Greenfoot.isKeyDown("d") && collideRight() == 1){
            move(1);
        } else if(Greenfoot.isKeyDown("a") && collideLeft() == 1){
            move(-1);
	} if(Greenfoot.isKeyDown("space") && collideUp() == 1 && getObjectsAtOffset(0, 20, null).size() == 1){ // and player is on ground.
            setLocation(getX(), (getY()-100));
        }
    }
    
    public void mine(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null && mouse.getButton() == 1){
            MyWorld world = (MyWorld) getWorld();
            if(Greenfoot.getMouseInfo().getActor() != this){
                world.removeObject(Greenfoot.getMouseInfo().getActor());
            }
        }
    }
    
    public void place(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null && mouse.getButton() == 3){
            Dirt dirt = new Dirt();
            MyWorld world = (MyWorld) getWorld();
            world.addObject(dirt, mouse.getX(), mouse.getY());
            
    }
}
   
    
    public void act(){
        if(collideDown() == 1){
            gravity();
        }
        moveset();
        mine();
        place();
    }}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 /*   
    
    public void MoveWithCollision(String dir){
        // dir as l/r/u/d
        // 1- get dir as offset val (x/y)
        // 2- offer reduced moveset
    // 3- gravity. (lore accurate)
        
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
                offset = 20;
            }
        
        //2:
         // if there is object to adjecent to attempted move:
         // then block move in that direction 
    int obstacles = getObjectsAtOffset(0, offset, null).size();
}}
    // moveset:
    
        /*public void go(int rq, int obstacles){
            // where rq is integer 0/1 for query is moving right
            
            if(obstacles = 0){
                if(rq == 1){
                    move(1);
                } else{
                    move(-1);
                }
            }
            }

        go(1, obstaces);


    }}
*/
