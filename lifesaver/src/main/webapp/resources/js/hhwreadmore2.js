function myFunction() {
  var box = document.getElementById("box-comments");
  var btnText = document.getElementById("myBtn");
  if(box.style.display === "inline") {	
	box.style.display = "none";
    btnText.innerHTML = "Read more";
  } else {	
	box.style.display = "inline";
    btnText.innerHTML = "Read less";
  }
}
function myFunction2() {
	  var box = document.getElementById("box-comments2");
	  var btnText = document.getElementById("myBtn2");
	  if(box.style.display === "inline") {	
		box.style.display = "none";
	    btnText.innerHTML = "Read more";
	  } else {	
		box.style.display = "inline";
	    btnText.innerHTML = "Read less";
	  }
	}
function myFunction3() {
	  var box = document.getElementById("box-comments3");
	  var btnText = document.getElementById("myBtn3");
	  if(box.style.display === "inline") {	
		box.style.display = "none";
	    btnText.innerHTML = "Read more";
	  } else {	
		box.style.display = "inline";
	    btnText.innerHTML = "Read less";
	  }
	}
function categorybtn5(){
    var url = "/writeform";
    var name = "게시글작성";
    var option = "width = 1200, height = 600"
    window.open(url, name, option);
}

