var grpc = require("@grpc/grpc-js")
var protoloader = require("@grpc/proto-loader")
var PROTO_PATH = __dirname + "/proto/calc.proto"
var packageDefinition = protoloader.loadSync(
  PROTO_PATH
)

var calc_proto = grpc.loadPackageDefinition(packageDefinition).calc


function add(call, callback){
try{
  var number1 = parseInt(call.request.number1)
  var number2 = parseInt(call.request.number2)

  if(!isNaN(number1) && !isNaN(number2)){
    var result = number1 + number2;
    callback(null,{
      message: undefined,
      result: result
    })
  }else{
    callback(null, {
      message: "Please specify two numbers add"
    })
  }
  }catch(e) {
    callback(null, {
      message: "An error has occurred"
    })
  }

}

function subtract(call, callback){
try{
  var number1 = parseInt(call.request.number1)
  var number2 = parseInt(call.request.number2)

  if(!isNaN(number1) && !isNaN(number2)){
    var result = number1 - number2;
    callback(null,{
      message: undefined,
      result: result
    })
  }else{
    callback(null, {
      message: "Please specify two numbers subtract"
    })
  }
  }catch(e) {
    callback(null, {
      message: "An error has occurred"
    })
  }

}
function multiply(call, callback){
try{
  var number1 = parseInt(call.request.number1)
  var number2 = parseInt(call.request.number2)

  if(!isNaN(number1) && !isNaN(number2)){
    var result = number1 * number2;
    callback(null,{
      message: undefined,
      result: result
    })
  }else{
    callback(null, {
      message: "Please specify two numbers that you want to multiply"
    })
  }
  }catch(e) {
    callback(null, {
      message: "An error has occurred"
    })
  }

}
function divide(call, callback){
try{
  var number1 = parseInt(call.request.number1)
  var number2 = parseInt(call.request.number2)

  if(number2 === 0){
    callback(null, {
      message: "You cannot divide by 0"
    })
  }

  else if(!isNaN(number1) && !isNaN(number2)){
    var result = number1 / number2;
    callback(null,{
      message: undefined,
      result: result
    })
  }else{
    callback(null, {
      message: "Please specify two numbers that you want to divide:"
    })
  }
  }catch(e) {
    callback(null, {
      message: "An error has occurred"
    })
  }

}

var server = new grpc.Server()
server.addService(calc_proto.calcService.service, {
  add: add,
  subtract: subtract,
  multiply: multiply,
  divide: divide
})
server.bindAsync("0.0.0.0:40000", grpc.ServerCredentials.createInsecure(), function(){
  server.start()
})