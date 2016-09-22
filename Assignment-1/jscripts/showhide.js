//Method to hide the text on click of a button
function hide(){
	var toggle = document.getElementById("toggle");
	var text = document.getElementById("text");
	text.style.display = "none";
	toggle.value="Show";
}

//Method to show the text on click of a button
function show(){
	var toggle = document.getElementById("toggle");
	var text = document.getElementById("text");
	text.style.display = "inline";
	toggle.value="Hide";
}

//Method to show or hide the text on click of a button
function toggle(){
	var text = document.getElementById("text");
	var toggle = document.getElementById("toggle");
	
	if(toggle.value === "Hide"){
		text.style.display = "none";
		toggle.value = "Show";
	}
	else if(toggle.value === "Show"){
		text.style.display = "inline";
		toggle.value="Hide";
	}
}
