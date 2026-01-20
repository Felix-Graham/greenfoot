import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    

        super(600, 400, 1); // create world

        generate();
    }

    
    
    public void generate(){
        for (int i=0; i < 600; i=i+22){ // for all x
            int layers = Greenfoot.getRandomNumber(5); // determines how many blocks y
            int yPos = 389;
            for(int j=0; j<layers; j++){
            //for(int j=0; j<layers; j++){// for all y
                Dirt dirt = new Dirt(); // init dirt
                addObject(dirt, i, yPos);// new dirt
                yPos = yPos-21;
            }
            Dirt dirt = new Dirt();
            addObject(dirt, i, yPos);
            yPos = yPos-21;
            
            Grass grass = new Grass();
            addObject(grass, i, yPos);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Grass grass = new Grass();
        addObject(grass,384,219);
    }
}
