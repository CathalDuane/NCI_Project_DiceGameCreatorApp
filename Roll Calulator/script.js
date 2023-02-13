// Generate a random numbers for standard dice rolls 
function generateRandomInteger(max) {
    return Math.floor(Math.random() * max) + 1;
}


// //clear input box
function clear(){
    document.getElementById('result').value += 1;
}

//Add Dice Roll to input box
function roll(value){
    document.getElementById('result').value += generateRandomInteger(value); 
}

//Add value to input box
function dis(value){
    document.getElementById('result').value += value;
}

//equals function to calculate inputs
function equals(){
    var textArea = getElementById('history');
    var x = getElementById('result').value;
    //eval() evaluates the string from x
    var y = eval(x);
    clear();
    textArea.value = textArea.value + x + " = " + y + "\n";
}