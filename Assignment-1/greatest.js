function greatestAmongThreeNumbers(){
	
	var demo = document.getElementById("demo");
	var a,b,c;
	
	do{
		a = prompt("Enter a value(Integer) for A : ");
	}while(isNaN(a) || a===null || a==='' || (/\s/.test(a)) );
	
	do{
		b = prompt("Enter a value(Integer) for B : ");
	}while(isNaN(b) || b===null || b==='' || (/\s/.test(b)));
	
	do{
		c = prompt("Enter a value(Integer) for C : ");
	}while(isNaN(c) || c===null || c==='' || (/\s/.test(c)));

	a = parseInt(a);
	b = parseInt(b);
	c = parseInt(c);
	
	if(a>b && a>c)
		demo.innerHTML = "A = " + a + "<br />B = " + b + "<br />C = " + c + "<br /> Result : <strong>A is greatest</strong>";
	else if(b>a && b>c)
		demo.innerHTML = "A = " + a + "<br />B = " + b + "<br />C = " + c + "<br /> Result : <strong>B is greatest</strong>";
	else if(c>a && c>b)
		demo.innerHTML = "A = " + a + "<br />B = " + b + "<br />C = " + c + "<br /> Result : <strong>C is greatest</strong>";
	else
		demo.innerHTML = "A = " + a + "<br />B = " + b + "<br />C = " + c + "<br /> Result : <strong>Either All Numbers are Equal or Two Numbers have same Max Value</strong>";
}