

function validateName(){
    var nameregex = /^[a-zA-Z]{6,}$/    
    var name=document.Form.uname.value;
   
    if(name==""){
        alert('name cannot be empty');
        return false;
    }
    if(nameregex.test(name)==false){
        alert('Name Should be more than 6 charater');
        return false;
    }
    return true;
}


function validateDis(){

    var disregex=/^[15][0-9]$/

    var dis=document.Form.udis.value;
    if(disregex.test(dis)==false){
        alert('Enter VAlid Distance');
        return false;
    }
    return true;
}

function validateCity(){
  
    var city=document.Form.ucity.value;

    
    if(city==""){
        document.getElementById("error1").innerText=
        "City Feild Cannot be Empty";
    }else{
        document.getElementById("error1").innerText=
    "";
    }
    
    return true;
}


function load(){
	
	let summaryElem = document.getElementById('summary');
	let kms= validateDis();
	let name= validateName();
	let city = validateCity();
	
	if(kms!="" && name!="" && city!="")
	{
		let xhr = new XMLHttpRequest();
		xhr.onload = function()
		{
			let res = this.responseText;
			let resObj= JSON.parse(res)
			console.log(res);
			summaryElem.value = resObj.name + " your travel cost in " + resObj.city + " for " + resObj.kms + "kms is Rs. " + resObj.cost;
		}
		xhr.open('GET','getsummary?name='+name+'&city='+city+'&kms='+kms);
		xhr.send();
	
	}
	
	
}
