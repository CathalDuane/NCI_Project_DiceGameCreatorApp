// Generate a random numbers for standard dice rolls 
function generateRandomInteger(max) {
    return Math.floor(Math.random() * max) + 1 + " ";
}


// //clear input box
function clearInput(){
    var getValue= document.getElementById("result");
      if (getValue.value !="") {
          getValue.value = "";
      }
}

 if (target.value== 'clear input'){
            target.value= "";
       }

//Add Dice Roll to input box
function roll(value){
    document.getElementById('result').value += generateRandomInteger(value); 

    if (value == "20") {
        document.getElementById("result").style.color = "green"
    } 

    else if (value == "10") {
        document.getElementById("result").style.color = "blue"
    }
    else if (value == "6") {
        document.getElementById("result").style.color = "orange"
    }
    else if (value == "4") {
        document.getElementById("result").style.color = "purple"
    }
}

//Add value to input box
function dis(value){
    document.getElementById('result').value += value + " ";
    document.getElementById("result").style.color = "black"
}

//equals function to calculate inputs
function equals(){
    var textArea = document.getElementById("history");
    var x = document.getElementById("result").value;
    //eval() evaluates the string from x
    var y = eval(x);
    clearInput();
    textArea.value = textArea.value + x + " = " + y + "\n";
}