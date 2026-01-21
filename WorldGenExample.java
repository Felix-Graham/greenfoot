import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Worldy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    int width = 60;
    int height = 40;
    int AS = 6*16;
    int x = 8;  
    int y = Greenfoot.getRandomNumber(15)*16+AS+8;
    int phase = 0;
    int CopperP = 1000;
    int CoalP = 1000;
    int DiamondP = 1000;
    boolean caveGenerate = false;
    int caveTop = Greenfoot.getRandomNumber(10)+Greenfoot.getRandomNumber(5)+4;
    int caveBottom = Greenfoot.getRandomNumber(10)+caveTop+5;
    boolean mountain = false;
    public GameWorld()  
    {  
        super(60*16, 40*16, 1);
        width = getWidth()/16;
        height = getHeight()/16;
        GreenfootImage bg = getBackground();
        Color LIGHT_BLUE = new Color(153, 204, 255);
        bg.setColor(LIGHT_BLUE);
        bg.fill();
        mountainGenerate();
    }
  
    public void act()  
    {  
        if(Greenfoot.isKeyDown("r"))
        {
            removeObjects(getObjects(null));
            AS = 96;
            x = 8;  
            y = Greenfoot.getRandomNumber(20)*16+AS+8;
            phase = 0;
            CopperP = 1000;
            CoalP = 1000;
            DiamondP = 1000;
            caveGenerate = false;
            caveTop = Greenfoot.getRandomNumber(10)+Greenfoot.getRandomNumber(5)+4;
            caveBottom = Greenfoot.getRandomNumber(10)+caveTop+5;
            mountain = false;
            mountainGenerate();
        }
    }  
  
    public void generate()  
    {
        if(x<=getWidth()){  
            int randomWidth = Greenfoot.getRandomNumber(5)+4;
            for(int i=0;i+y<getHeight();i+=16)  
            {
                if(caveGenerate == false&&Greenfoot.getRandomNumber(300)==0){
                    caveTop = Greenfoot.getRandomNumber(10)+Greenfoot.getRandomNumber(5)+4;
                    caveBottom = Greenfoot.getRandomNumber(10)+caveTop+5;
                    caveGenerate = true;
                }
                if(i+y>getHeight()-16){
                    addObject(new Bedrock(), x, i+y);
                }else if(caveGenerate == true && phase>caveTop && phase<caveBottom){
                    if(Greenfoot.getRandomNumber(90)==0)
                    {
                        caveGenerate = false;
                    }
                }else if(phase==0){
                    if(Greenfoot.getRandomNumber(30)==0)
                    {
                        TreeGen("Front", x, i+y);
                    }else{
                        addObject(new Grass(), x, i+y);
                    }
                }else if(phase < randomWidth){
                    addObject(new Dirt(), x, i+y);
                }else if(Greenfoot.getRandomNumber(150)==0 || (Greenfoot.getRandomNumber(3)==0 && (CopperP==i+y||CopperP==i+y-1*16||CopperP==i+y+1*16))){
                    addObject(new CopperOre(), x, i+y);
                    if(CopperP!=i+y&&CopperP!=i+y-1*16&&CopperP!=i+y+1*16)
                        CopperP = i+y;
                }else if(Greenfoot.getRandomNumber(50)==0 || (Greenfoot.getRandomNumber(1)==0 && (CoalP==i+y||CopperP==i+y-1*16||CoalP==i+y+1*16))){
                    addObject(new CoalOre(), x, i+y);
                    if(CoalP!=i+y&&CoalP!=i+y-1*16&&CoalP!=i+y+1*16)
                        CoalP = i+y;
                }else if(i+y >= getHeight()-15*16 && (Greenfoot.getRandomNumber(600)==0 || Greenfoot.getRandomNumber(6)==0 && (DiamondP==i+y||DiamondP==i+y-1||DiamondP==i+y+1))){
                    addObject(new DiamondOre(), x, i+y);
                    if(DiamondP!=i+y&&DiamondP!=i+y-1*16&&DiamondP!=i+y+1*16)
                        DiamondP = i+y;
                }else{
                    addObject(new Stone(), x, i+y);
                }
                phase++;
            }  
            x+=16;
            phase = 0;
            int upDown;
            if(mountain==false)
            {
                upDown = Greenfoot.getRandomNumber(40);
            }else{
                upDown = Greenfoot.getRandomNumber(10);
            }
            if(upDown == 0 && y > 7*16){
                y -= 1*16;
            }else if(upDown == 1 && y < getHeight()-17*16){
                y += 1*16;
            }else if(upDown == 2 && y > 8*16){
                y -= 2*16;
            }else if(upDown == 3 && y < getHeight()-18*16){
                y += 2*16;
            }
            mountainGenerate();
        }
    }
    
    public void backgroundGenerate()  
    {  
        if(x<=getWidth()){  
            int randomWidth = Greenfoot.getRandomNumber(5)+4;
            for(int i=0;i+y<getHeight();i+=16)  
            {
                if(i+y>getHeight()-16){
                    addObject(new DarkBedrock(), x, i+y);
                }else if(phase==0)
                {
                    if(Greenfoot.getRandomNumber(30)==0)
                    {
                        TreeGen("Back", x, i+y);
                    }else{
                        addObject(new DarkGrass(), x, i+y);
                    }
                }else if(phase < randomWidth){
                    addObject(new DarkDirt(), x, i+y);
                }else if(Greenfoot.getRandomNumber(150)==0 || (Greenfoot.getRandomNumber(6)==0 && (CopperP==phase||CopperP==phase-1*16||CopperP==phase+1*16))){
                    addObject(new DarkCopperOre(), x, i+y);
                    if(CopperP!=i+y&&CopperP!=i+y-1*16&&CopperP!=i+y+1*16)
                        CopperP = i+y;
                }else if(Greenfoot.getRandomNumber(50)==0 || (Greenfoot.getRandomNumber(2)==0 && (CoalP==i+y||CoalP==i+y-1*16||CoalP==i+y+1*16))){
                    addObject(new DarkCoalOre(), x, i+y);
                    if(CoalP!=i+y&&CoalP!=i+y-1*16&&CoalP!=i+y+1*16)
                        CoalP = i+y;
                }else if(i+y >= getHeight()-15*16 && (Greenfoot.getRandomNumber(600)==0 || Greenfoot.getRandomNumber(14)==0 && (DiamondP==i+y||DiamondP==i+y-1*16||DiamondP==i+y+1*16))){
                    addObject(new DarkDiamondOre(), x, i+y);
                    if(DiamondP!=i+y&&DiamondP!=i+y-1*16&&DiamondP!=i+y+1*16)
                        DiamondP = i+y;
                }else{
                    addObject(new DarkStone(), x, i+y);
                }
                phase++;
            }
            phase = 0;
            int upDown;
            if(mountain==false)
            {
                upDown = Greenfoot.getRandomNumber(60);
            }else{
                upDown = Greenfoot.getRandomNumber(30);
            }
            if(upDown == 0 && y > 7*16){
                y -= 1*16;
            }else if(upDown == 1 && y < getHeight()-17*16){
                y += 1*16;
            }else if(upDown == 2 && y > 8*16){
                y -= 2*16;
            }else if(upDown == 3 && y < getHeight()-18*16){
                y += 2*16;
            }
            int wideThin = Greenfoot.getRandomNumber(4);
            if(wideThin == 0 && caveBottom>5){
                caveTop -= Greenfoot.getRandomNumber(2);
                caveBottom -= Greenfoot.getRandomNumber(2);
            }else if(wideThin == 1){
                caveTop += Greenfoot.getRandomNumber(2);
                caveBottom += Greenfoot.getRandomNumber(2);
            }else if(wideThin == 2 && caveBottom>5){
                caveTop -= Greenfoot.getRandomNumber(3);
                caveBottom -= Greenfoot.getRandomNumber(3);
            }else if(wideThin == 3){
                caveTop += Greenfoot.getRandomNumber(4);
                caveBottom += Greenfoot.getRandomNumber(4);
            }
            generate();
        }
    }
    
    public void mountainGenerate()
    {
        int tryForMountain;
        if(mountain==false)
        {
            tryForMountain = Greenfoot.getRandomNumber(30);
            if(tryForMountain == 0)
            {
                mountain = true;
            }
        }else{
            tryForMountain = Greenfoot.getRandomNumber(20);
            if(tryForMountain == 0)
            {
                mountain = false;
            }
        }
        backgroundGenerate();
    }
    
    public void TreeGen(String TreeG, int x, int y)
    {
        if(TreeG == "Front")
        {
                addObject(new Dirt(), x, y);
                addObject(new LiquoriceLog(), x, y-1*16);
                addObject(new LiquoriceLog(), x, y-2*16);
                addObject(new LiquoriceLog(), x, y-3*16);
                addObject(new LiquoriceLog(), x, y-4*16);
                addObject(new LightLeaves(), x, y-5*16);
                addObject(new LightLeaves(), x-1*16, y-5*16);
                addObject(new LightLeaves(), x-1*16, y-4*16);
                addObject(new LightLeaves(), x-1*16, y-3*16);
                addObject(new LightLeaves(), x-2*16, y-4*16);
                addObject(new LightLeaves(), x-2*16, y-3*16);
                addObject(new LightLeaves(), x+1*16, y-5*16);
                addObject(new LightLeaves(), x+1*16, y-4*16);
                addObject(new LightLeaves(), x+1*16, y-3*16);
                addObject(new LightLeaves(), x+2*16, y-4*16);
                addObject(new LightLeaves(), x+2*16, y-3*16);
        }
        if(TreeG == "Back")
        {
                addObject(new DarkDirt(), x, y);
                addObject(new DarkLiquoriceLog(), x, y-1*16);
                addObject(new DarkLiquoriceLog(), x, y-2*16);
                addObject(new DarkLiquoriceLog(), x, y-3*16);
                addObject(new DarkLiquoriceLog(), x, y-4*16);
                addObject(new DarkLightLeaves(), x, y-5*16);
                addObject(new DarkLightLeaves(), x-1*16, y-5*16);
                addObject(new DarkLightLeaves(), x-1*16, y-4*16);
                addObject(new DarkLightLeaves(), x-1*16, y-3*16);
                addObject(new DarkLightLeaves(), x-2*16, y-4*16);
                addObject(new DarkLightLeaves(), x-2*16, y-3*16);
                addObject(new DarkLightLeaves(), x+1*16, y-5*16);
                addObject(new DarkLightLeaves(), x+1*16, y-4*16);
                addObject(new DarkLightLeaves(), x+1*16, y-3*16);
                addObject(new DarkLightLeaves(), x+2*16, y-4*16);
                addObject(new DarkLightLeaves(), x+2*16, y-3*16);
        }
    }
}
