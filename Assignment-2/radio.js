function radioaction(){
	var test1 = document.getElementsByName("test1");
	var test2 = document.getElementsByName("test2");
	var demo = document.getElementById("demo");
	var i = 0;
	var j = 0;
	
	for(i = 0 ; i < test1.length ; i++) {
	
		if(test1[i].checked){
	
			break;
		}
	}

	for(j = 0 ; j < test2.length ; j++) {
	
		if(test2[j].checked){
			
			break;
		}
	}
	
		demo.innerHTML = test1[i].value + " " + test2[j].value;
}