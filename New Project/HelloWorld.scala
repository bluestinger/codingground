class Foo{}
object FooMaker{
def apply() = new Foo    
    println("new a FooMaker")
}

object Timer{
    var count = 0
    
    def currentCount(): Long = {
        count += 1
        count
    }
}

//function
object addOne extends Function1[Int,Int]{
    def apply(m:Int):Int = m +1
}

class AddOne extends (Int=>Int){
    def apply(m:Int):Int = m + 1
}

//package
//package com.twitter.example

object colorHolder{
    val BLUE = "Blue"
    val RED = "Red"
}

object HelloWorld {
   def main(args: Array[String]) {
    //对象   
    println("Timer:"+Timer.currentCount())

    val newFoo =FooMaker()
      
    //函数
    print("function_result:"+addOne(1)+'\n')
    
    //包
    //println("the color is: " + com.twitter.example.colorHolder.BLUE)

    //模式匹配
    val times = 1
    times match{
        case 1 => "one"
        case 2 => "two"
        case _ => "other number"
    }
    
    def bigger(o:Any):Any ={
        o match{
            case i:Int if i <0 =>i-1
            case i:Int => i+1
            case d:Double if d <0.0 => d - 0.1
            case text:String => text + "s"
        }
    }
    
    
    case class Calculator(brand:String, model:String)
    
    try{
        remoteCalculatorService.add(1,2)
        
    }
    catch{
        case e:ServerIsDownException => log.error(e, "the remote calculator service is unavailable. should have kept your trusty HP.")
    }
    finally{
        remoteCalculatorService.close()
    }
   }
}


