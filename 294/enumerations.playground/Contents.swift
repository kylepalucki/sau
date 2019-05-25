//: enumerations.playground

func withOutEnum(){
    let Monday = 0
    let Tuesday = 1
    let Wednesday = 2
    let Thursday = 3
    let Friday = 4
    let Saturday = 5
    let Sunday = 6

    var appointment:Int
    appointment = Thursday
    
    var today:Int
    today = Wednesday
    if appointment == today{
        print("Get Going!")
    } else {
        print("Watch some Dr. Who")
    }
}

// Using Enumerations
enum Days {
    case Sunday
    case Monday
    case Tuesday
    case Wednesday
    case Thursday
    case Friday
    case Saturday
}

var appointment:Days
appointment = .Wednesday

var today = Days.Thursday

if appointment == today {
    print("Get Going")
}
else {
    print("Watch some GSG")
}


