var readlineSync = require('readline-sync')
var grpc = require('@grpc/grpc-js')
var protoLoader = require('@grpc/proto-loader')
var PROTOPATH = __dirname + "/proto/random_number.proto"

var packageDefinition = protoLoader.loadSync(PROTOPATH)
var calc_proto = grpc.loadPackageDefinition(packageDefinition).calc
var client = new calc_proto.calcService("0.0.0.0:40000", grpc.credentials.createInsecure())

var action = readlineSync.question(
  "What would you like to do?\n"+
  "1: add two numbers?\n"+
  "2: subtract two numbers?\n"+
  "3: divide two numbers?\n"+
  "4: multiply two numbers?\n"
)

action = parseInt(action)

if(action === 1){
var number1 = readlineSync.question("Enter first number you would like to add:")
var number2 = readlineSync.question("Enter second number you would like to add:")


try{
  client.add({number1: number1, number2: number2}, function(error, response){
  try{
    if(response.message){
      console.log(response.message);
    }else{
      console.log((response.result));
    }
  }catch(e){
    console.log("Could not connect");
  }
  })
}catch(e){
  console.log("An error has occurred.");
}
}

else if(action === 2){
var number1 = readlineSync.question("Enter first number you would like to subtract:")
var number2 = readlineSync.question("Enter second number you would like to subtract:")


try{
  client.subtract({number1: number1, number2: number2}, function(error, response){
  try{
    if(response.message){
      console.log(response.message);
    }else{
      console.log((response.result));
    }
  }catch(e){
    console.log("Could not connect");
  }
  })
}catch(e){
  console.log("An error has occurred.");
}
}


else if(action === 3){
var number1 = readlineSync.question("Enter first number you would like to divide:")
var number2 = readlineSync.question("Enter second number you would like to divide by:")


try{
  client.divide({number1: number1, number2: number2}, function(error, response){
  try{
    if(response.message){
      console.log(response.message);
    }else{
      console.log((response.result));
    }
  }catch(e){
    console.log("Could not connect");
  }
  })
}catch(e){
  console.log("An error has occurred.");
}
}


else if(action === 4){
var number1 = readlineSync.question("Enter the number you would like to multiply:")
var number2 = readlineSync.question("Enter second number you would like to multiply:")


try{
  client.multiply({number1: number1, number2: number2}, function(error, response){
    try{
    if(response.message){
      console.log(response.message);
    }else{
      console.log((response.result));
    }
  }catch(e){
    console.log("Could not connect");
  }
  })
}catch(e){
  console.log("An error has occurred.");
}
}else{
  console.log("Error: Operation not recognised");
}
