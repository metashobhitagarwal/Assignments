function mathtable() {
	
	var a;
	
	do {
		a = prompt("Enter the number for obtaining Math Table (Integers only):");
		
	}while(isNaN(a) || a===null || a==='' || (/\s/.test(a)) )
		
	a = parseInt(a);
	var statement = document.getElementById("statement");
	statement.innerHTML = "Table of "+a+" is :<br />";
	
	var str ="";
	for(var index = 1 ; index <= 10 ; index++) {
		
		str = str+""+a+" x "+index+" = "+(a*index)+"<br />";
	}
	
	var table = document.getElementById("table");
	table.innerHTML = ""+str;
}