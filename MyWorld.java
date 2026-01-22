import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MyWorld extends World
{
    public MyWorld()
    {    

        super(600, 400, 1); // create world

        generate();
        prepare();
    }

    public void generate(){

        int xpos = 0;
        int ypos = 389;
        for(int v=389; v>229; v=v-20){
            for(int w=0;w<601;w=w+22){ 
                Dirt dirt = new Dirt();
                addObject(dirt, w, v);
                xpos += 22;
                //ypos -= 20;
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
