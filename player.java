import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class player extends Actor
{
    
    public void act()
    {
        // collision:
	// each second pass dir as `d` for gravity.
	// use a basic moveset to determine dir for `l` and `r`
	// additionally use `space` to indicate `u`
	
	if(greenfoot.isKeyDown("right")){
		MoveWithCollision("r");
	}
	
	
            
    }
    
    
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

	// moveset:
	
	public void go(int rq, int obstacles){
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


    }

