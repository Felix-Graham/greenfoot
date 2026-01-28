import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kirk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kirk extends Actor
{
    /**
     * Act - do whatever the Kirk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int abilityCharge = 0;
    public void act()
    {
        // Add your action code here.
	moveset();
	charge();

    }

    public void debate(){
	// add new paper object homes toward opponent
	getWorld().addObject(new Debate(),getX(),getY());

    }

    public void charge(){
	    for(int i=0; i<200; i++){
		    if(i == 199){
			    abilityCharge++;
			    i = 0;
		    }
	    }
    }

    public boolean propaganda(){
	    // returns true if active
	    // slows enemies within range
	    // check with getX (from other actor)
	    if(abilityCharge > 100){
		    if(Greenfoot.isKeyDown("e")){
			    Greenfoot.playSound("weAreCharlieKirk.mp3");
			    return true;
		    }
	    }
    }

    public void moveset(){
	// basic ass ad movement
	if(Greenfoot.isKeyDown("d"){
		turnTowards(getX()+1, getY());
		move(3);
	} if(Greenfoot.isKeyDown("a"){
		turnTowards(getX()-1, getY());
		move(3);
	}
	// dash
	int dashlimit = 50;
	if(Greenfoot.isKeyDown("q") && dashlimit==50){
		dashlimit = 0;
		setLocation(getX()+10, getY());
		while(dashlimit!=50){
			dashlimit++;
		}
	}

	if(angel() > 5 && Greenfoot.isKeyDown("space")){
		turnTowards(getX(), getY()-1);
		move(3);
		turnTowards(getX()+1, getY());
	} else if(Greenfoot.isKeyDown("space")){
		turnTowards(getX(), getY()-1);
		move(5);
		turnTowards(getX()+1, getY());
	}

	if(Greenfoot.isKeyDown("z")){
		debate();
	}
    }

    public int angel(){
	// if in air for more than ~20 ticks
	// change sprite to angel kirk 
	int airTime = 0;
	if(getY() < /* above ground*/ 50){
		airTime++;
	} else if(getY() > /*ground layer*/ 50){
		airtime = 0;
	}

	if(airTime > 20){
		// set image to angel kirk 
		// setImage(String filename)
	}
	
	return airTime;
    }
}
