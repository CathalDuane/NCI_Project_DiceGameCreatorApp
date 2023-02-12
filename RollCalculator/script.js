// Generate a random numbers for standard dice rolls 
function generateRandomInteger(max) {
    return Math.floor(Math.random() * max) + 1;
}

let d100 = generateRandomInteger(100);
let d20 = generateRandomInteger(20);
let d12 = generateRandomInteger(12);
let d10 = generateRandomInteger(10);
let d8 = generateRandomInteger(8);
let d6 = generateRandomInteger(6);
let d4 = generateRandomInteger(4);


//clear input box
function clear(){
    document.getElementById('result').value = "";
}

//Dice Roll
function roll(value){
    document.getElementById('result').value += generateRandomInteger(value); 
}