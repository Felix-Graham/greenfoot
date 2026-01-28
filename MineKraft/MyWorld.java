import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{
    public MyWorld()
    {    

        super(600, 400, 1); // create world

        generate();
        prepare();
    }

    public void randomGenerate(){
	int previousRandom;
	int initialRandom = Greenfoot.getRandomNumber(8);
	int yDir = Greenfoot.getRandomNumber(2);
	
	// random number initialised for first x column
	// thus fills column 1 to y limit initialRandom.
	// column 2 y limit is determined from a shallow random 
	// variance from initialRandom. This can be from 0->2 
	// blocks either up or down from initialRandom, as determined
	// by a further random 0/1 integer, where 0 is below and 1 is up.
	// To make the process iterable, initialRandom is 
	// converted to this new random y limit.

	// for all x: 
	// 	for all y (up to layer):

	for(int x=0; x<601;x=x+22){
	    // for all x
	}


    public void generate(){

        int xpos = 0;
        int ypos = 389; // both may indeed by useless. fuck knows
        for(int v=389; v>229; v=v-20){ // for eight y layers
            for(int w=0;w<601;w=w+22){ 
                Dirt dirt = new Dirt();
                addObject(dirt, w, v);
                xpos += 22;
                ypos -= 20;
            }
        }

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        player player = new player();
        addObject(player,334,118);
        player.setLocation(458,372);
        player.setLocation(287,203);
    }
}
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     
    private void prepare()
    {
        Grass grass = new Grass();
        addObject(grass,384,219);
    }
}
*/
