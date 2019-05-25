//: TypeInferenceVsAnnotation.playground

// Type Inference (What we've seen the most of)
var name = "Michael" // name is a String variable
let numRows = 40 // numRows is an Int constant

// Type Annocation
var sum:Int = 0 // sum is an Int variable
let feetPerMeter:Double = 3.28084 // Double constant

//: You MUST use Type Annocation in two situations
// 1) Create a constant, but don't initialize it.
let minScore:Int // minScore is an Int Constant

print("Some other instruction")

minScore = 88 // Now minScore can never be changed

// 2) When you want a different type than would
//    be inferred
let middleInitial:Character = "X"
let initialValue:Float = 80.0
