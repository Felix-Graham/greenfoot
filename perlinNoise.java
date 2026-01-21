// world generation program based off of Perlin noise

public float fade(float t){
	return t*t*t*(t*(t*6.0-15.0)+10.0);
}

public float gradient(float p){
	float r = greenfoot.getRandomNumber(5)/10.0;
	if(r > 0.5){
		return 1;
	} else{
		return -1;
	}
}


public float noise(float p){
	float p0 = floor(p);
	float p1 = p0+1.0;
	float t = p - p0;
	float fade_t = fade(t);
	float g0= grad(p0);
	float g1 = grad(p1);

	return(1.0-fade_t)*g0(p-p0)+fade_t*g1*(p-p1);
}

void mainImage( out vec4 fragColor, in vec2 fragCoord ){
	final float frequency = 1.0/20.0;
	final float amplitude = 1.0/5.0;
	float n = noise(fragCoord.x*frequency)*amplitude;
	float y = 2.0*(fragCoord.y/iResolution.y)-1.0;
	vec3 color = n > y ? vec3(1.0) : vec3(0.0);
	fragColor = vec4(color, 1.0);
}
